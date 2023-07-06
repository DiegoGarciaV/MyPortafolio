document.addEventListener("DOMContentLoaded", loadedContent);

function loadedContent() {
    const introContent = document.querySelector("#intro-content-layer");
    const introContentHeight = introContent.offsetHeight;
    console.log(introContentHeight);
    introContent.style.left = '-' + introContentHeight / 2 + 'px';

    const headerSize = document.querySelector("header").offsetHeight;

    const containers = document.querySelectorAll(".page-container");
    containers.forEach((item) => {
        item.style.paddingTop = (headerSize)+ "px";
    });
    const carroContent = document.querySelector("#habilities .container");
    const carroContentItem = carroContent.querySelector(".col-4 #habilities-carrousel");

    const carroContentHeight = carroContent.clientHeight;
    const carroContentItemHeight = carroContentItem.clientHeight;

    carroContentItem.style.top = (carroContentHeight - carroContentItemHeight) / 4 + "px";

}
