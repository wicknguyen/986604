/*jshint esversion: 6 */
/* globals $ */
$(document).ready(function () {
    let blankTilePos = 15;

    let calculateX = function(position) {
        return ((position % 4) * 100);
    }

    let calculateY = function(position) {
        return (Math.floor(position / 4) * 100);
    }

    let canMoved = function(element) {
        let x = parseInt($(element).css('left'));
        let y = parseInt($(element).css('top'));
        let distanceX = Math.abs(x - calculateX(blankTilePos));
        let distanceY = Math.abs(y - calculateY(blankTilePos));

        return distanceX === 100 && distanceY === 0
            || distanceX === 0 && distanceY === 100;
    }

    let moveTile = function(element) {
        if (canMoved(element)) {
            let tmp = blankTilePos;
            blankTilePos = parseInt($(element).attr('id'));
            $(element).css('left', calculateX(tmp) + 'px');
            $(element).css('top', calculateY(tmp) + 'px');
            $(element).attr('id', tmp);
        }
    }

    let setBackground = function(divElement, index) {
        $(divElement).css('background-image', 'url("./images/background.jpg")');
        $(divElement).css('background-position', -calculateX(index) + 'px ' + (-calculateY(index)) + 'px');
    }

    let arrangeTile = function(divElement, index) {
        // calculate x and y for this piece
        let x = calculateX(index);
        let y = calculateY(index);
        // set basic style and background
        $(divElement).css('left', x + 'px');
        $(divElement).css('top', y + 'px');
        $(divElement).text(index);
        $(divElement).attr('id', index);
    }

    let init = function() {
        // initialize each piece
        $("#puzzlearea div").each(function (index) {
            $(this).addClass("puzzlepiece");
            arrangeTile(this, index);
            setBackground(this, index);
        });

        // Hover event
        $("#puzzlearea div").hover(function () {
            if (canMoved(this)) {
                $(this).addClass("movablepiece");
            }
        }, function () {
            $(this).removeClass("movablepiece");
        });

        $("#puzzlearea div").click(function () {
            moveTile(this);
        });

        $("#shufflebutton").click(function () {
            blankTilePos = 15;
            $("#puzzlearea div").each(function (index) {
                arrangeTile(this, index);
            });
            let random = parseInt(Math.random() * 15);
            for (let i = 0; i < 3 * random; i++) {
                $("#puzzlearea div").each(function (index) {
                    moveTile(this);
                });
            }
        });
    };

    init();
});

