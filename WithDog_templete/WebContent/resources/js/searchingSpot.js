function searchPopBtn_click() {
	var $href = $('#searchSpot_btn').attr('href');
	layer_popup($href);

	var address = $('#resultLocation').val();
	$('#locationBox').val(address);

	if (address != "") {
		searchSpot(address);
	}
}

function addSpotPop_click() {
	var $href = $('#addSpotPop').attr('href');
	layer_popup($href);
}

function searchBtn_click() {

	var address = $('#locationBox').val();

	if (address != "") {
		searchSpot(address);
	}
}

function searchSpot(address) {
	$.ajax({
		type : "GET",
		url : "/WithDog_templete/searchSpot.do?spotLocation=" + address,
		dataTyle : "xml",
		success : function(data) {
			var spotList = $(data).find("spot");
			var listLen = spotList.length;
			$("#spotData > tr").remove();

			if (listLen) {
				var spot = "";
				$(spotList).each(
						function() {
							var spotLocation = $(this).find("spotLocation").text();
							var spotName = $(this).find("spotName").text();
							var spotType = $(this).find("spotType").text();
							var spotId = $(this).find("spotId").text();
							
							spot = '<tr>'
								+ '<td class="text-center">'+spotName+'</td>' 
								+ '<td class="text-center">'+spotLocation+'</td>'
								+ '<td class="text-center">'+spotType+'</td>' + 
							'</tr>';

							$("#spotData").append(spot).click(function(event){
								choiceSpot(spotId,spotLocation);
							});
						});
			} else {
				var dataForm = '<tr>'
						+ '<th colspan="3 " class="text-center">장소가 존재하지 않습니다.'
						+ '</th>' + '</tr>';
				$("#spotData").append(dataForm);
			}
		},
		error : function(error) {
			alert(error);
		}

	});
}

function choiceSpot(spotId, address){
	var href = $('#searchSpot_btn').attr('href');
	var $popup = $(href);
	var isDim = $popup.prev().hasClass('dimBg');
	
	isDim ? $('.dim-layer').fadeOut() : $el.fadeOut();
	
	$('#resultLocation').val(address);
	$('#spotId').val(spotId);
}
function layer_popup(el) {

	var $el = $(el); // 레이어의 id를 $el 변수에 저장
	var isDim = $el.prev().hasClass('dimBg'); // dimmed 레이어를 감지하기 위한 boolean
	// 변수

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
		isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가
		// 닫힌다.
		return false;
	});

	$('.layer .dimBg').click(function() {
		$('.dim-layer').fadeOut();
		return false;
	});

}
