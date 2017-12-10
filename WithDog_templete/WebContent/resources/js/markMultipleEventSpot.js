function markMultipleEventSpot(events) {
	var eventList = JSON.parse(events);

	var map = new naver.maps.Map('map');

	$.each(eventList, function(index, value) {
		naver.maps.Service.geocode({
			address : value.eventSpot
		}, function(status, response) {
			if (status != naver.maps.Service.Status.OK) {
				return alert(value.eventSpot + 'Can`t Found / NetworkError');
			}

			var result = response.result;

			var markPoint = new naver.maps.Point(result.items[0].point.x,
					result.items[0].point.y);
			map.setCenter(markPoint);

			var marker = new naver.maps.Marker({
				position : markPoint,
				map : map
			});

			naver.maps.Event.addListener(marker, "click", function(e) {
				if (infowindow.getMap()) {
					infowindow.close();
				} else {
					infowindow.open(map, marker);
				}
			});
			
			var infowindow = new naver.maps.InfoWindow({  
		          content: '<h4>'+value.eventName+'</h4><h4>'+value.eventSpot+'</h4><a href="eventDetail.do?eventId='+value.eventId+'" class="btn btn-comm">상세 보기</a>'
		      		});
		});
	});

}
