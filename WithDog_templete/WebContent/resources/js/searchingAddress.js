var map;

$(document).ready(function(){
	map = new naver.maps.Map('map');  
})

function searchingAddress() {
	new daum.Postcode(
			{

				hideMapBtn : true,
				hideEngBtn : true,
				autoClose : true,

				oncomplete : function(data) {

					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 주소 정보를 해당 필드에 넣는다.
					if (data.autoJibunAddress) {
						document.getElementById('spotLocation').value = data.autoJibunAddress;
					} else {
						document.getElementById('spotLocation').value = data.jibunAddress;
					}

					// 커서를 상세주소 필드로 이동한다.
					document.getElementById('spotLocation').focus();
					markingOnMap();

				}
			}).open({
		q : document.getElementById('spotLocation').value
	});
}

function markingOnMap(){
	var addr = $("#spotLocation").val();  // 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)

	naver.maps.Service.geocode({address: addr}, function(status, response) {
	    if (status !== naver.maps.Service.Status.OK) {
	        return alert(addr + '의 검색 결과가 없거나 기타 네트워크 에러');
	    }
	    var result = response.result;
	    // 검색 결과 갯수: result.total
	    // 첫번째 결과 결과 주소: result.items[0].address
	    // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
	    var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	    map.setCenter(myaddr); // 검색된 좌표로 지도 이동
	    // 마커 표시
	    var marker = new naver.maps.Marker({
	      position: myaddr,
	      map: map
	    });
	    
	})
}