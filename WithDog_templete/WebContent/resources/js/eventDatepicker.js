$(document).ready(function() {
    $( "#eventOpenDate" ).datepicker({
    	minDate : 0,
    	dateformat : 'yyyy-mm-dd'
    });
    $( "#eventCloseDate" ).datepicker({
    	minDate : 0,
    	dateformat : 'yyyy-mm-dd'
    });
    
    $("#datepicker").datepicker({ 
    	minDate : 0,
    	dateformat : 'yyyy-mm-dd'
    });
});
