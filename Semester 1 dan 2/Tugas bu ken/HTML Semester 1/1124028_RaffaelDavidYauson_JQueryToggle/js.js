//Nomor 1
$(document).ready(function() {
    $(".A").click(function() {
        $(".one").slideToggle('slow' , function(){
        });
    });

    $(".B").click(function() {
        $(".two").slideToggle('slow' , function(){
        });
    });

    $(".C").click(function() {
        $(".three").slideToggle('slow' , function(){
        });
    });

    $(".D").click(function() {
        $(".four").slideToggle('slow' , function(){
        });
    });
});

// nomor 2
$(document).ready(function() {
    $("#p1").click(function() {
        $(".one").fadeToggle('slow' , function(){
        });
    });
});

$(document).ready(function() {
    $("#p2").click(function() {
        $(".two").fadeToggle('slow' , function(){
        });
    });
});

$(document).ready(function() {
    $("#p3").click(function() {
        $(".three").fadeToggle('slow' , function(){
        });
    });
});

$(document).ready(function() {
    $("#p4").click(function() {
        $(".four").fadeToggle('slow' , function(){
        });
    });
});