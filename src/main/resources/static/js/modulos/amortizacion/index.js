document.addEventListener("DOMContentLoaded", loadedContent);
let maxContainersize = 0;

function loadedContent() {

    const headerSize = document.querySelector("header").offsetHeight;
    const containers = document.querySelectorAll(".page-container");
    containers.forEach((item) => {
        item.style.paddingTop = (headerSize)+ "px";
    });

    
    const myCarousel = document.getElementById('graficas-carrousel');

    myCarousel.addEventListener('slid.bs.carousel', function () {
        if(maxContainersize < this.offsetHeight)
            maxContainersize = this.offsetHeight;
        else
        {
            this.style.height = maxContainersize + "px";
        }
    });
    
}
