window.addEventListener("resize", resized);
function resized() {
    const mainTag = document.querySelector('main');
    const dummy = document.querySelector('.dummy');
    const body = document.body;
    let bodyRect = body.getBoundingClientRect(),
        elemRect = dummy.getBoundingClientRect(),
        offset = elemRect.top - bodyRect.top;
    if (mainTag.style.height < offset) {
        mainTag.style.height = offset + 'px';
    }
}
resized();