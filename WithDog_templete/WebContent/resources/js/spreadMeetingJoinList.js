function showList(){
	var joinList = "#JoinList";

	if($(joinList).is(":visible")){
		$(joinList).slideUp();
	}else{
		$(joinList).slideDown();
	}
};