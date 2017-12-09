function addSpotPop_click() {
	var searchLayer = $('#searchSpot_btn').attr('href');
	var $search = $(searchLayer);
	var isDim = $search.prev().hasClass('dimBg');
	
	isDim ? $('.dim-layer').fadeOut() : $el.fadeOut();
	
	var $addLayer = $('#addSpotPop').attr('href');
	add_popup($addLayer);
}

function add_popup(el) {

	var $el = $(el); // 레이어의 id를 $el 변수에 저장
	var isDim = $el.prev().hasClass('addLayerBg'); // dimmed 레이어를 감지하기 위한 boolean
	// 변수

	isDim ? $('.add-layer').fadeIn() : $el.fadeIn();

	var $elWidth = ~~($el.outerWidth()), $elHeight = ~~($el.outerHeight()), docWidth = $(
			document).width(), docHeight = $(document).height();

	// 화면의 중앙에 레이어를 띄운다.
	if ($elHeight < docHeight || $elWidth < docWidth) {
		$el.css({
			marginTop : -$elHeight / 2,
			marginLeft : -$elWidth / 2
		})
	} else {
		$el.css({
			top : 0,
			left : 0
		});
	}

	$el.find('a.btn-popupClose').click(function() {
		isDim ? $('.add-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가
		// 닫힌다.
		return false;
	});

}

function addSpot(){
	var spotName = $("input[name='spotName']").val();
	var spotType = $("input:radio[name=spotType]:checked").val();
	var spotLocation = $("input[name='spotLocation']").val();
	
	var spotData = {
			spotName : spotName,
			spotType : spotType,
			spotLocation : spotLocation
	};
	
	$.ajax({
		url:"addSpot.do",
		dataType:"json",
		type:"post",
		data: spotData,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var spot = data.spot;
			
			$('#resultLocation').focus();
			$('#resultLocation').val(spot.spotLocation);
			$('#spotId').val(spot.spotId);
			
		},
		error : function(error){
			console.log(error);
		}
	});
}
