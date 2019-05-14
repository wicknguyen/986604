var rudyTimer = (function () {
    function delayMsg2() {
        document.getElementById("demo").innerHTML += "Ruby!";
    }

    setInterval(delayMsg2, 2000);
});

