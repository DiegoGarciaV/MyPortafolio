<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es" ng-app="amortizacionApp">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Tabla de amortización
    </title>


    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">

    <script type="text/javascript" src="js/tools/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="js/tools/angular.js"></script>
    <script type="text/javascript" src="js/tools/angular-route.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>

    <script type="text/javascript" src="js/modulos/amortizacion/index.js"></script>
    <script type="text/javascript" src="js/modulos/amortizacion/app.js"></script>
    <link rel="stylesheet" href="css/amortizacion.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald:wght@300&family=Quicksand&display=swap"
        rel="stylesheet">
</head>

<body ng-controller="controlador">
    <header>
        <nav class="navbar navbar-expand-lg ">

            <div class="collapse navbar-collapse" id="navigator">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html">Inicio</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#">ES <img class="lang-ico" src="img/ES.png" alt="languaje"></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <div class="page-container">
        <div class="container">
            <h2>Simulación de crédito</h2>
            <div class="row">
                <div class="col-3">
                    <h3>Datos del crédito</h3>

                    <form>
                        <div class="mb-4">
                            <label for="amount-input" class="form-label">Monto total</label>
                            <input type="number" min="0.0" step="any" class="form-control" id="amount-input"
                                aria-describedby="amount" ng-model="creditData.amount"
                                ng-change="calculateCredit()">
                        </div>


                        <div class="mb-1 row">
                            <label for="rate-input" class="col-sm-6 col-form-label">Tasa de interes anual</label>
                            <div class="col-sm-6">
                                <input type="number" min="0.0" step="0.01" class="form-control" id="rate-input"
                                    aria-describedby="rate-input" ng-model="creditData.rate"
                                    ng-change="calculateCredit()">
                            </div>
                        </div>

                        <div class="mb-4 row">
                            <label for="iva-input" class="col-sm-6 col-form-label"></label>
                            <div class="col-sm-6">
                                <input type="checkbox" class="form-check-input" id="iva-input" ng-model="creditData.iva"
                                    ng-change="calculateCredit()">
                                <label class="form-check-label" for="iva-input">+ IVA</label>
                            </div>
                        </div>

                        <div class="mb-4 row">

                            <label for="freq-input" class="form-label">Frecuencia</label>
                            <div class="col-sm-6">
                                <input type="range" min="1" max="52" step="1" class="form-range" id="freq-input"
                                    aria-describedby="freq" ng-model="creditData.freq" ng-change="calculateCredit()">
                            </div>

                            <div class="col-sm-6">
                                <input type="number" min="1" max="52" step="1" class="form-control input-val"
                                    id="freq-input-val" aria-describedby="freq" ng-model="creditData.freq"
                                    ng-change="calculateCredit()">
                            </div>
                        </div>




                        <div class="mb-4 row">

                            <label for="steps-input" class="form-label">Numero de plazos</label>
                            <div class="col-sm-6">
                                <input type="range" min="1" max="480" step="1" class="form-range" id="steps-input"
                                    aria-describedby="amount" ng-model="creditData.steps" ng-change="calculateCredit()">
                            </div>

                            <div class="col-sm-6">
                                <input type="number" min="1" max="480" step="1" class="form-control input-val"
                                    id="steps-input-val" aria-describedby="steps" ng-model="creditData.steps"
                                    ng-change="calculateCredit()">
                            </div>
                        </div>



                        <div class="mt-4">
                            <button type="button" id="simular-btn" class="btn btn-1"
                                ng-click="calculateCredit()">Calcular</button>
                        </div>

                    </form>

                </div>
                <div class="col-9">
                    <div id="graficas-carrousel" class="carousel slide carousel-dark slide" data-bs-ride="carousel" data-bs-interval="false">
                        
                        <div class="carousel-inner">

                            <div class="carousel-item active" data-bs-interval="false">
                                <div class="container pb-5 canvaSize" height="820px" width="1920px">
                                    <h3 class="text-center mb-5">Resumen de crédito</h3>
                                    <div class="row justify-content-around">
                                        <div class="col-3"> 
                                            <p>Parcialidad</p>
                                        </div>
                                        <div class="col-3">
                                            <p>{{creditData.payment}}</p>
                                        </div>

                                    </div>

                                    <div class="row justify-content-around">
                                        <div class="col-3"> 
                                            <p>Pago total</p>
                                        </div>
                                        <div class="col-3">
                                            <p>{{creditData.totPay}}</p>
                                            </div>


                                    </div>

                                    <div class="row justify-content-around">
                                        <div class="col-3"> 
                                            <p>Total de intereses</p>
                                        </div>
                                        <div class="col-3">
                                            <p>{{creditData.totInt}}</p>
                                            <p class="{{creditData.interestShare}}">+ {{((creditData.totPayAmount/creditData.amount-1)*100).toFixed(2)}}%</p>
                                        </div>

                                    </div>
                                    
                                    <div class="row justify-content-around">
                                        <div class="col-3"> 
                                            <p>Total de IVA de intereses</p>
                                        </div>
                                        <div class="col-3">
                                            <p>{{creditData.totIVA}}</p>
                                        </div>

                                    </div>

                                </div>
                            </div>

                            <div class="carousel-item" data-bs-interval="false">
                                <div class="container">
                                    <h3 class="text-center">Amortización de crédito</h3>
                                    <canvas id="grafica-amortizacion" width="1920px" height="820px"></canvas>
                                </div>
                            </div>
                            <div class="carousel-item" data-bs-interval="false">
                                <div class="container">
                                    <h3 class="text-center">Capital vs Intereses</h3>
                                    <canvas id="grafica-capital" width="1920px" height="820px"></canvas>
                                </div>
                            </div>
                            
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#graficas-carrousel"
                            data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#graficas-carrousel"
                            data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
            <div class="row text-center mt-5">
                <div class="col-12">
                    <a  href="#tabla-amortizacion-header">
                        <button type="button" id="show-table-btn" class="btn btn-1">
                            Mostrar tabla de amortización
                        </button>
                    </a>
                    
                </div>
            </div>
        </div>
    </div>

    <div class="page-container">
        <div class="table-container">
            <table class="table-header" id="tabla-amortizacion-header"
                aria-describedby="Encabezado de tabla de amortizacion">
                <thead>
                    <tr>
                        <th>No. Pago</th>
                        <th>Saldo insoluto</th>
                        <th>Abono</th>
                        <th>Intereses del periodo (+IVA)</th>
                        <th>IVA de intereses</th>
                        <th>Capital</th>
                        <th>Saldo final del periodo</th>
                    </tr>
                </thead>
            </table>
            <table class="table-body" id="tabla-amortizacion-body" aria-describedby="Tabla de amortizacion">

                <thead style="display: none;">
                    <tr>
                        <th>No. Pago</th>
                        <th>Saldo insoluto</th>
                        <th>Abono</th>
                        <th>Intereses del periodo (+IVA)</th>
                        <th>IVA de intereses</th>
                        <th>Capital</th>
                        <th>Saldo final del periodo</th>
                    </tr>
                </thead>

                <tbody>
                    <tr ng-repeat="item in creditTable" class="py-4">
                        <td>{{item.paymentNum}}</td>
                        <td>{{item.current}}</td>
                        <td>{{item.payment}}</td>
                        <td>{{item.interest}}</td>
                        <td>{{item.IVA}}</td>
                        <td>{{item.capital}}</td>
                        <td>{{item.remaining}}</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="row text-center mb-3">
            <div class="col-12">
                <button type="button" id="show-table-btn" class="btn btn-1" ng-click="exportTableToExcel('Amortizacion')">
                    Descargar tabla
                </button>
            </div>
        </div>

    </div>
</body>

</html>