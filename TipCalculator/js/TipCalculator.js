function calTip() {
    var subtotal = document.getElementById("subtotal").value;
    var tip = document.getElementById("tip").value;

    subtotal = parseFloat(subtotal);
    tip = parseFloat(tip);

    if (isNaN(subtotal) || isNaN(tip)){
        alert("Subtotal or Tip must be a number");
        return;
    }

    var total = subtotal + (subtotal * tip) / 100;

    var result = document.getElementById("result");
    result.innerHTML = "$" + total;
}
