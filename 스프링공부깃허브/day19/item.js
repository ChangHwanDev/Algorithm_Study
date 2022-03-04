function itemClickHandler(event) {
    let target = event.target
    while(target.classList.contains('item') == false) {
        target = target.parentNode
    }
    console.log(target)
    location.href = '/product/view/' + target.dataset.id
}