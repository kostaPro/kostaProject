$(document).ready(function() {
    $( "#eventOpenDate" ).datepicker({
    	minDate : 0,
    	dateFormat: 'yy-mm-dd'
    });
    $( "#eventCloseDate" ).datepicker({
    	minDate : 0,
    	dateFormat: 'yy-mm-dd'
    });
    
    $("#datepicker").datepicker({ 
    	minDate : 0,
    	dateFormat: 'mm/dd/yy'
    });
});
