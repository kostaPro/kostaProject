// 이미지 정보들을 담을 배열
var sel_files = [];
var petImage;

$(document).ready(function() {
		
	$("#pImage").on("change", readURL);

});

function readURL(e) {

	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	filesArr.forEach(function(f) {
				if (!f.type.match("image.*")) {
					alert("확장자는 이미지 확장자만 가능합니다.");
					return;
				}
			
				petImage = f;

				var reader = new FileReader();
				reader.onload = function(e) {
					$("#pet_image").attr('src',e.target.result);
				}
				reader.readAsDataURL(f);
			});
}




function deleteImageAction(index) {
	console.log("index : " + index);
	sel_files.splice(index, 1);

	var img_id = "#img_id_" + index;
	$(img_id).remove();

	document.getElementById("input_imgs").value = "";


	console.log(sel_files);
}

$("[name=title]").attr("required", true);
$("[name=content]").attr("required", true);
