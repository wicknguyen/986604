"use strict";
var index = 0;
var timer = null;
var speed = 250;

function startAnimation() {
    setTimer(speed);
    disableStartButton(true);
}

function stopAnimation() {
    index = 0;
    resetTimer();
    disableStartButton(false);
}

function extractAnimation() {
    let asciiAnimation = ANIMATIONS[getElementById("animation").value];
    let animationArr = asciiAnimation.split("=====\n");
    if (index >= animationArr.length) {
        index = 0;
    }
    getElementById("textBox").value = animationArr[index];
    index++;

}

function disableStartButton(isBtnStartDisabled) {
    getElementById("btnStart").disabled = isBtnStartDisabled;
    getElementById("btnStop").disabled = !isBtnStartDisabled;
}

function changeAnimation() {
    getElementById("textBox").value = ANIMATIONS[getElementById("animation").value];
}

function changeSize() {
    let size = getElementById("size").value;
    getElementById("textBox").style.fontSize = size;
}

function resetTimer() {
    clearInterval(timer);
    timer = null;
}

function setTimer(timeout) {
    timer = setInterval(extractAnimation, timeout);
}

function changeSpeed() {
    if (timer === null) {
        return;
    }
    resetTimer();
    if (!!getElementById("speed").checked) {
        speed = 50;
    } else {
        speed = 250;
    }
    setTimer(speed);
}

function getElementById(elementId) {
    return document.getElementById(elementId);
}


function addEventHandler() {
    disableStartButton(false);
    getElementById("btnStart").onclick = startAnimation;
    getElementById("animation").onchange = changeAnimation;
    getElementById("size").onchange = changeSize;
    getElementById("speed").onchange = changeSpeed;
    getElementById("btnStop").onclick = stopAnimation;
}

window.onload = addEventHandler;
