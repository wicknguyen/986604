/*jshint esversion: 6 */
/* globals $ */
$(document).ready(function () {
    var win = true;
    var gameStarted = false;

    let startEvent = function () {
        if (!gameStarted) {
            gameStarted = true;
        } else {
            gameStarted = false;
            win = true;
        }
    };

    let removeLoseWarning = function () {
        $("#maze .boundary").removeClass("youlose");
    };

    let addLoseWarning = function () {
        $("#maze .boundary").addClass("youlose");
    };

    let loseWarning = function () {
        if (gameStarted) {
            addLoseWarning();
            win = false;
        }
    };

    let endGame = function () {
        if(!gameStarted) {
            return;
        }
        if (win) {
            $("#status").text("You win!:]");
            gameStarted = false;
            win = true;
        } else {
            $("#status").text("You lose!!!");
            gameStarted = false;
            win = false;
        }

    };

    $("#start").click(startEvent);
    $("#end").mouseover(endGame);
    $("#maze .boundary").mouseover(loseWarning);
    $("#maze .boundary").mouseout(removeLoseWarning);
    $("#maze").mouseleave(loseWarning);
});

