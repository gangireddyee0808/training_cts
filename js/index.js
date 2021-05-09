
//$(document).ready(function(){
//$("p").css("color","orange"); 
//$("p").addClass('add-color');
//});

$(() => {
    /* hides the content
    $('#hide').click(() => {
        //$("P").addClass('add-color');
        $("P").hide();
    })
    //Shows the content 
    $('#show').click(() => {
        $("P").show();
    })*/
    //display or hide content with single button
    $('button').click(() => {
        $("P").toggle();
    })
});