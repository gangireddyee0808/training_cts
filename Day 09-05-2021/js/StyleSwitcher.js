$(() => { 
    $('#switcher-large') 
    .on('click', () => { 
        $('body').addClass('large'); 
    }); 
});

$(() => { 
    // brings back to default 
    $('#switcher-default') 
    .on('click', () => { 
        $('body') 
        .removeClass('narrow') 
        .removeClass('large'); 
        $('#switcher button') 
        .removeClass('selected'); 
        $(this) 
        .addClass('selected');
    }); 

    // removes larger class and activate narrow class
    $('#switcher-narrow') 
    .on('click', () => { 
        $('body') 
        .addClass('narrow') 
        .removeClass('large'); 
        $('#switcher button') 
        .removeClass('selected'); 
        $(this) 
        .addClass('selected');
    }); 

    //  removes narrow class and activate larger class
    $('#switcher-large') 
    .on('click', () => { 
        $('body') 
        .removeClass('narrow')
        .addClass('large'); 
        $('#switcher button') 
        .removeClass('selected'); 
        $(this) 
        .addClass('selected');
    }); 
    
    $('#switcher h3')
        .hover(function() {
            $(this).addClass('hover');
        }, function() {
            $(this).removeClass('hover');
        });
    $('#switcher')
        .click(function(event) {
            $('#switcher button').toggleClass('hidden');
        });
     $('#switcher h3')  //This block is used, when you want to toggle the hidden when you click on heading
         .click(function() {
             $(this)
                 .siblings('button')
                 .toggleClass('hidden');
        });


})