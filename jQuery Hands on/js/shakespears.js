$(() => {
    
    //Hans on 1
    $('#selected-plays > li > ul > li')
    .addClass('special');
    $('td:nth-child(3)')
    .addClass("year");
    $('td:contains(Tragedy)')
    .eq(0)
    .parent()
    .addClass('special');

        //hands on 2 practise 
            $('li > a')
            .nextAll()
            .addClass('afterlink');
    });