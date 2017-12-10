var spotList = new Array();

function markMultipleSpot(spots) {
	spotList = JSON.parse(spots);
}

$(document).ready(function(){
	  var map = new naver.maps.Map("map", {
	        zoom: 2,
	        center: new naver.maps.LatLng(36.2253017, 127.6460516),
	        zoomControl: true,
	        zoomControlOptions: {
	            position: naver.maps.Position.TOP_LEFT,
	            style: naver.maps.ZoomControlStyle.SMALL
	        }
	    });
	  var markers = [];
	  $.each(spotList, function(index, item){
	  naver.maps.Service.geocode({address: item.spotLocation}, function(status, response) {
	      if (status !== naver.maps.Service.Status.OK) {
	          return alert(item.spotLocation + '의 검색 결과가 없거나 기타 네트워크 에러');
	      }
	      var result = response.result;
	      var latlng = new naver.maps.Point(result.items[0].point.x, result.items[0].point.y);
	      var marker = new naver.maps.Marker({
              position: latlng
          });
	      markers.push(marker);	
	
	    var htmlMarker1 = {
	            content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url(resources/img/cluster-marker-1.png);background-size:contain;"></div>',
	            size: N.Size(40, 40),
	            anchor: N.Point(20, 20)
	        },
	        htmlMarker2 = {
	            content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url(resources/img/cluster-marker-2.png);background-size:contain;"></div>',
	            size: N.Size(40, 40),
	            anchor: N.Point(20, 20)
	        },
	        htmlMarker3 = {
	            content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url(resources/img/cluster-marker-3.png);background-size:contain;"></div>',
	            size: N.Size(40, 40),
	            anchor: N.Point(20, 20)
	        },
	        htmlMarker4 = {
	            content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url(resources/img/cluster-marker-4.png);background-size:contain;"></div>',
	            size: N.Size(40, 40),
	            anchor: N.Point(20, 20)
	        }, 
	        htmlMarker5 = {
	            content: '<div style="cursor:pointer;width:40px;height:40px;line-height:42px;font-size:10px;color:white;text-align:center;font-weight:bold;background:url(resources/img/cluster-marker-5.png);background-size:contain;"></div>',
	            size: N.Size(40, 40),
	            anchor: N.Point(20, 20)
	        };
	    var markerClustering = new MarkerClustering({
	        minClusterSize: 2,
	        maxZoom: 8,
	        map: map,
	        markers: markers,
	        disableClickZoom: false,
	        gridSize: 120,
	        icons: [htmlMarker1, htmlMarker2, htmlMarker3, htmlMarker4, htmlMarker5],
	        indexGenerator: [10, 100, 200, 500, 1000],
	        stylingFunction: function(clusterMarker, count) {
	            $(clusterMarker.getElement()).find('div:first-child').text(count);
	        }
	    });
	  
	      naver.maps.Event.addListener(marker, "click", function(e) {
	        if (infowindow.getMap()) {
	            infowindow.close();
	        } else {
	            infowindow.open(map, marker);
	        }
	      });
	
	      var infowindow = new naver.maps.InfoWindow({  
	          content: '<h4>'+item.spotName+'</h4><h4>'+item.spotLocation+'</h4><a href="spotDetail.do?spotId='+item.spotId+'" class="btn btn-comm">상세 보기</a>'
	      		});
	 });
  });
})