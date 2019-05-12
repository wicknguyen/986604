var timer = null;
function makeBiggerDecoration() {
    if (timer == null) {
        timer = setInterval(increaseFontSize, 500);
    } else {
        clearInterval(timer);
        timer = null;
    }
}

function increaseFontSize() {
    var textField = document.getElementById("textField");
    var fontSize = window.getComputedStyle(textField).getPropertyValue('font-size');
    var currentFontSize = parseInt(fontSize);
    currentFontSize += 2;
    textField.style.fontSize = currentFontSize + 'pt';
}

function blingEvent() {
    var cbBling = document.getElementById("cbBling");
    var textField = document.getElementById("textField");
    if (cbBling.checked) {
        textField.className = "bling-affect";
        document.body.className = "background-dollar";
    } else {
        textField.className = "";
        document.body.className = "";
    }
}

function processMalkovitch() {
    var textField = document.getElementById("textField");
    var text = textField.value.split(" ");
    for (let i = 0; i < text.length; i++) {
        if (text[i].length > 5) {
            text[i] = "Malkovitch";
        }
    }
    textField.value = combineValue(text).trim();
}

function processIgpayAtinlay() {
    var textField = document.getElementById("textField");
    var text = textField.value.split(" ");
    var ayWord = "ay";
    for (let i = 0; i < text.length; i++) {
        var string = text[i].trim();
        if (startWithVowel(string)) {
            text[i] += ayWord;
        } else {
            var position = vowelPosition(string);
            if (position > 0) {
                let cluster = string.slice(position, string.length).toLowerCase();
                let consonantCluster = string.slice(0, position).toLowerCase();
                text[i] = cluster.slice(0, 1).toUpperCase() + cluster.slice(1, cluster.length) + consonantCluster + ayWord;
            }
        }
    }
    textField.value = combineValue(text).trim();
}

function combineValue(str) {
    var result = "";
    for (let i = 0; i < str.length; i++) {
        result += str[i] + " ";
    }
    return result;
}

function vowelPosition(str) {
    const vowels = "aeiou";
    for (let i = 0; i < str.length; i++) {
         if (str.charAt(i) && vowels.includes(str.charAt(i))) {
             return i;
         }
    }
    return -1;
}

function startWithVowel(str) {
    const vowels = "aeiou";
    if (str.charAt(0) && vowels.includes(str.charAt(0))) {
            return true;
    }
    return false;
}


function addEventHandler() {
    // Add event for Btn
    var btnDecoration = document.getElementById("btnDecoration");
    btnDecoration.onclick = makeBiggerDecoration;

    // Add event for checkbox
    var cbBling = document.getElementById("cbBling");
    cbBling.onchange = blingEvent;

    // Btn Malkovitch
    var btnMalkovitch = document.getElementById("btnMalkovitch");
    btnMalkovitch.onclick = processMalkovitch;

    // Btn IgpayAtinlay
    var btnIgpayAtinlay = document.getElementById("btnIgpayAtinlay");
    btnIgpayAtinlay.onclick = processIgpayAtinlay;
}



window.onload = addEventHandler;

