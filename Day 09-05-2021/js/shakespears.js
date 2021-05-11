$(() => { 
    $('#selected-plays > li ') .addClass('horizontal');
    $('#selected-plays') .addClass('display'); 
    
    $('#selected-plays li:not(.horizontal)') .addClass('sub-level'); 
    //adding style for the tr even elements 
    //$('tr:even').addClass('alt');
    $('tr:nth-child(odd)').addClass('alt');
    //highlighting the element based on text
    //$('td:contains(Henry)').addClass('highlight');

    $('a[href^="mailto:"]') .addClass('mailto'); 
    $('a[href$=".pdf"]') .addClass('pdflink');

    //highlights only the next td element .....
    //$('td:contains(Henry)') .next() .addClass('highlight');

    //highlights all td elements in that row other than contains string.....
    //$('td:contains(Henry)') .nextAll() .addClass('highlight');

    //highlights only the previous td element if no previous element is found in that row no text is highlighted.....
    //$('td:contains(Henry)') .prev() .addClass('highlight');

    //highlights all previous td elements in that row other than contains string.....
    //$('td:contains(1596)') .prevAll() .addClass('highlight');


    // for highlight only the necessary elements 
    //$('td:contains(Henry)').parent().find('td:eq(0)') .addClass('highlight').end().find('td:eq(2)') .addClass('highlight');

    $('td:contains(Henry)') .nextAll() .addBack() .addClass('highlight');

});


