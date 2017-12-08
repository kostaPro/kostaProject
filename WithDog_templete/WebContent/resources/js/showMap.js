$(document).ready(function(){
	var map = new naver.maps.Map('map');  
	var addr = $("#spotAddress").val();
	
	console.log(addr);
	
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

})


