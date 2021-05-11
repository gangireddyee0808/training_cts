// hands on 3

$('.chapter-title').click(function() {
    $(this).nextAll().toggle();
});
$("p").mousemove(function(event) {
    var x = event.pageX - $(this).offset().left;
    var y = event.pageY - $(this).offset().top;
    console.log("X-cordinate " + x + "Y-cordinate" + y);
});