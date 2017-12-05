
function searchPopBtn_click(){
	var $href = $('#searchSpot_btn').attr('href');
	layer_popup($href);
	
	var address = $('#eventLocation').val();
	$('#locationBox').val(address);
	
	$.ajax({
		type: "GET",
		url: "/searchSpot.do?spotLocation="+address,
		dataTyle:"json",
		success:function(data){
			alert(data.spotName);
//			insertData(1,data.spotName);
		},
		error:function(error){
			alert(error);
		}
		
	});
	
//	function insertData(idx,data){
//		$("table > tbody > tr:nth-child("+idx+") >  td:nth-child(2)").html(data);
//	}
}

function searchSpotBtn_click(){
	
}

function layer_popup(el) {

	var $el = $(el); //레이어의 id를 $el 변수에 저장
	var isDim = $el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수

	isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

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
		isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
		return false;
	});

	$('.layer .dimBg').click(function() {
		$('.dim-layer').fadeOut();
		return false;
	});

}
