var spotList = new Array();

function markMultipleSpot(spots) {
	spotList = JSON.parse(spots);
}

$(document).ready(function(){
	var map = new naver.maps.Map('map');  

	  $.each(spotList, function(index, item){
	  naver.maps.Service.geocode({address: item.spotLocation}, function(status, response) {
	      if (status !== naver.maps.Service.Status.OK) {
	          return alert(item.spotLocation + '의 검색 결과가 없거나 기타 네트워크 에러');
	      }
	      var result = response.result;
	      // 검색 결과 갯수: result.total
	      // 첫번째 결과 결과 주소: result.items[0].address
	      // 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
	      var myaddr = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	      map.setCenter(myaddr);// 검색된 좌표로 지도 이동
	      map.setZoom(3); 
	      // 마커 표시
	      var marker = new naver.maps.Marker({
	        position: myaddr,
	        map: map
	      });
	      // 마커 클릭 이벤트 처리
	      naver.maps.Event.addListener(marker, "click", function(e) {
	        if (infowindow.getMap()) {
	            infowindow.close();
	        } else {
	            infowindow.open(map, marker);
	        }
	      });
	      // 마크 클릭시 인포윈도우 오픈
	      var infowindow = new naver.maps.InfoWindow({  
	          content: '<h4>'+item.spotName+'</h4><h4>'+item.spotLocation+'</h4><a href="spotDetail.do?spotId='+item.spotId+'"><button class="btn btn-primary">상세 보기</button></a>'
	      		});
	  		});
		   })
	});