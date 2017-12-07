function searchingAddress() {
			new daum.Postcode(
					{

						hideMapBtn : true,
						hideEngBtn : true,
						autoClose: true,

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

							var location = document
									.getElementById('spotLocation').value
									.split(' ');

						}
					}).open({
				q : document.getElementById('spotLocation').value
			});
		}