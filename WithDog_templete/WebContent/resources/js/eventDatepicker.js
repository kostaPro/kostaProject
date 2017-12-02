$(function() {
    $( "#eventOpenDate" ).datepicker({
    	minDate : 0
    });
    $( "#eventCloseDate" ).datepicker({
    	minDate : 0
    });
    
    $("#datepicker").datepicker({ 
    	minDate : 0,
    	format : 'yyyy-mm-dd'
    });
});
