function showList(flag){
	var joinList = "#dailyJoinList" + flag;

	if($(joinList).is(":visible")){
		$(joinList).slideUp();
	}else{
		$(joinList).slideDown();
	}
};