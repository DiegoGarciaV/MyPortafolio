let app = angular.module("amortizacionApp", []);

app.controller("controlador", function ($scope) {

    const page = $scope;
    let dollarUSLocale = Intl.NumberFormat('en-US');

    page.creditData = {

        amount: 2400000.0,
        rate: 6.0,
        iva: true,
        steps: 180,
        freq: 12,
        payment: 0,
        totPay: 0.0,
        totPayAmount: 0.0,
        totInt: 0.0,
        totIVA: 0.0
    };


    page.creditTable = [];

    page.calculateCredit = () => {

        const n = page.creditData.steps;

        const t = page.creditData.rate / 100;

        const q = page.creditData.freq;

        const appIVA = (page.creditData.iva ? 7 / 6 : 1);

        const a = (1 + ((t / q) * appIVA));

        const f = (a ** n) * ((a - 1) / ((a ** n) - 1));

        const pago = page.creditData.amount * f;
        page.creditData.payment = moneyFormat(pago);
        console.log(f);

        let i;
        let Mi = page.creditData.amount * 1.0;
        let iva = 0, intr = 0, tot = 0;
        page.creditTable = [];

        tot = 0.0;
        iva = 0.0;
        intr = 0.0

        for (i = 0; i < n; i++) {

            intr += Mi * (a - 1);
            let restante = Mi * a - pago;
            const payment = {
                "paymentNum": i+1,
                "current": moneyFormat(Mi),
                "interest": moneyFormat(Mi * (a - 1)),
                "IVA": moneyFormat(Mi * (t / q * (appIVA - 1))),
                "capital": moneyFormat(pago - Mi * (a - 1)),
                "payment": moneyFormat(pago),
                "remaining": moneyFormat(restante < 0.01 ? 0 : restante),
            };

            page.creditTable.push(payment);
            Mi = restante;
            iva += 1*(Mi * (t / q * (appIVA - 1))).toFixed(2);
            tot += 1*pago.toFixed(2);
        }

        console.log("iva total: %f\n", iva);
        console.log("interes totales: %f\n", intr);
        console.log("pago total: %f\n\n\n\n", tot);

        page.creditData.totPay = moneyFormat(tot);
        page.creditData.totPayAmount = tot*1.0;
        page.creditData.totInt = moneyFormat(intr);
        page.creditData.totIVA = moneyFormat(iva);
        if(page.creditData.totPayAmount/page.creditData.amount-1 < 0.2)
            page.creditData.interestShare = 'text-success';
        else if(page.creditData.totPayAmount/page.creditData.amount-1 < 0.45)
            page.creditData.interestShare = 'text-warning'; 
        else
            page.creditData.interestShare = 'text-danger';

        page.drawAmounts();


    };

    page.drawAmounts = () => {

        const amortizacion = document.getElementById('grafica-amortizacion');
        const capital = document.getElementById('grafica-capital');
        if (amortizacion.getContext) {
            const mort_ctx = amortizacion.getContext('2d');
            const capital_ctx = capital.getContext('2d');

            const drawAreaHeigh = amortizacion.getAttribute("height").replace("px","");
            const drawAreaWidth = amortizacion.getAttribute("width").replace("px","");
            const stepLong = drawAreaWidth/page.creditData.steps*0.8;
            const scaleY = page.creditData.amount*1.0;

            const axisX = drawAreaHeigh*0.1;
            const axisY = drawAreaWidth*0.1;

            amortizacion.width = amortizacion.width;
            capital.width = capital.width;

            printAxis(mort_ctx,axisY,axisX,page.creditData.steps,page.creditTable[0].current);
            printAxis(capital_ctx,axisY,axisX,page.creditData.steps,page.creditTable[0].payment);
            
            capital_ctx.font = "30px Arial";
            capital_ctx.fillText("Capital", 3*axisY, 9.5*axisX);
            capital_ctx.fillText("Intereses", 6*axisY, 9.5*axisX);

            capital_ctx.fillStyle = 'rgb(112, 121, 211)';
            capital_ctx.fillRect(4*axisY, 9.25*axisX,20,20);

            capital_ctx.fillStyle = 'rgb(9, 9, 103)';
            capital_ctx.fillRect(7*axisY, 9.25*axisX,20,20);

            const paymentAmount = (page.creditData.payment.replace("$","").replaceAll(",",""))*1.0;
            
            mort_ctx.beginPath();
            mort_ctx.moveTo(axisY, drawAreaHeigh*0.1-2);
            let x1 = 0, y1 = 0;

            x1 = axisY;
            y1 = drawAreaHeigh*(0.1);
            page.creditTable.forEach((element,index) => {

                const remaining = (element.remaining.replace("$","").replaceAll(",",""))*1.0;
                mort_ctx.fillStyle = 'rgb(112, 121, 211)';
                x1 = axisY + (index + 1)*stepLong;
                y1 = drawAreaHeigh*(0.9 -(remaining/scaleY)*0.8);
                
                mort_ctx.fillStyle = 'rgb(9, 9, 103)';
                mort_ctx.strokeStyle = 'rgb(112, 121, 211)';
                const exp = Math.floor(page.creditData.steps/60)+1;
                const sz = [20,17,14,11,8,5]
                mort_ctx.lineWidth = sz[exp]/2;
                

                mort_ctx.lineTo(x1,y1);
                mort_ctx.stroke();
                mort_ctx.fillRect(x1-sz[exp]/2,y1-sz[exp]/2,sz[exp],sz[exp]);
                mort_ctx.beginPath();
                mort_ctx.moveTo(x1,y1);

                const interest = (element.interest.replace("$","").replaceAll(",",""))*1.0;
                capital_ctx.fillStyle = 'rgb(9, 9, 103)';
                capital_ctx.fillRect(axisY + (index)*stepLong,drawAreaHeigh*(0.1)-2,stepLong/1.5,drawAreaHeigh*(interest/paymentAmount)*0.8);
                capital_ctx.fillStyle = 'rgb(112, 121, 211)';
                capital_ctx.fillRect(axisY + (index)*stepLong,drawAreaHeigh*(0.1 +(interest/paymentAmount)*0.8)-2,stepLong/1.5,drawAreaHeigh*(1-interest/paymentAmount)*0.8);
            });
           

            
        }
    };


    const printAxis = (canva_context, axisY, axisX,n,M) => {

        canva_context.beginPath();
        canva_context.moveTo(axisY, axisX*0.5);
        canva_context.lineTo(axisY, axisX*9);
        canva_context.stroke();

        let i;
        for(i=9;i>=1;i-=2)
        {
            canva_context.beginPath();
            canva_context.moveTo(axisY, axisX*i);
            canva_context.lineTo(axisY*9.5, axisX*i);
            canva_context.stroke();
        }

        printScale(canva_context,axisY,axisX,n,M);
        
    };

    const printScale = (canva_context, axisY, axisX, n, M) => {

        canva_context.font = "30px Arial";
        canva_context.fillText(0, axisY, 9.5*axisX);

        canva_context.fillText(n, 9*axisY, 9.5*axisX);

        canva_context.fillText(M, 30, axisX);
        
    };

    const moneyFormat = (amount) => '$ ' + dollarUSLocale.format(amount.toFixed(2));
    function pot(a, n) {
        if (n == 0)
            return 1;

        return a * pot(a, n - 1);

    }


    page.calculateCredit();

    page.exportTableToExcel = (filename = '') => {

        let downloadLink;
        const dataType = 'application/vnd.ms-excel';
        const tableSelect = document.getElementById("tabla-amortizacion-body");
        const tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
        
        filename = filename?filename+'.xls':'excel_data.xls';
        downloadLink = document.createElement("a");
        document.body.appendChild(downloadLink);
        
        if(navigator.msSaveOrOpenBlob){
            let blob = new Blob(['ufeff', tableHTML], {
                type: dataType
            });
            navigator.msSaveOrOpenBlob( blob, filename);
        }
        else
        {
            downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
            downloadLink.download = filename;

            downloadLink.click();
        }
    }

});