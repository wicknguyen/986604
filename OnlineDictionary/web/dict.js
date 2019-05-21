$(document).ready(function () {
    let bodyheight = $(window).height()-20;
    $("body").css('height',bodyheight);
    $("#container").css('height',bodyheight - $("header").height());
    $("#result").css('height', $("#container").height() - $("#lookup-form").height() - $("#validation").height());
    $("#waiting").css('height', $("#result").height());
    $("#waiting img").css('margin-top', ($("#result").height()/2 - $("#waiting img").height()/2));
    $("#waiting").hide();

    $(document).ajaxStart(function () {
        $("#waiting").show();
    }).ajaxStop(function () {
        $("#waiting").hide();
    });


    $("#btnLookup").click(function () {
        $.get("dict",
            {lookup: $("#dict-input").val()}
        ).done(function(data) {
            let words = JSON.parse(data);
            let result = "";
            let count = 1;
            for (word of words) {
                result += "<p>" + count++ + ". "+ word.word + " (" + word.wordtype + ") :: " + word.definition;
            }
            if (result) {
                $("#result-content").html(result);
            } else {
                $("#result-content").text("There is no definition for this word!");
            }
        }).fail(function () {
            $("#result-content").text("An error occurred...");
        });
    });
});
