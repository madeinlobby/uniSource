const mainTag = document.querySelector('main');
if(mainTag.style.height < window.innerHeight) {
    mainTag.style.height = window.innerHeight + 'px';
}
window.addEventListener("resize", function () {
    if(mainTag.style.height < window.innerHeight) {
        mainTag.style.height = window.innerHeight + 'px';
    }
});

