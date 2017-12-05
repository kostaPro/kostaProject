$(function() {
    $( "#eventOpenDate" ).datepicker({
    	minDate : 0,
    	format : 'yyyy-mm-dd'
    });
    $( "#eventCloseDate" ).datepicker({
    	minDate : 0,
    	format : 'yyyy-mm-dd'
    });
    
    $("#datepicker").datepicker({ 
    	minDate : 0,
    	format : 'yyyy-mm-dd'
    });
});
