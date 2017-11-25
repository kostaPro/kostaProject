// 이미지 정보들을 담을 배열
var sel_files = [];

$(document).ready(function() {
	$("#input_imgs").on("change", handleImgFileSelect);
});

function fileUploadAction() {
	console.log("fileUploadAction");
	$("#input_imgs").trigger('click');
}

function handleImgFileSelect(e) {

	// 이미지 정보들을 초기화
	sel_files = [];
	$(".imgs_wrap").empty();

	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	var index = 0;

	var x = document.getElementById("input_imgs");
	var txt = "";
	if ('files' in x) {
		if (x.files.length > 3) {
			alert("파일 개수가 초과되었습니다.");
			document.getElementById("input_imgs").value = "";
			return;
		}
	}

	filesArr
			.forEach(function(f) {
				if (!f.type.match("image.*")) {
					alert("확장자는 이미지 확장자만 가능합니다.");
					document.getElementById("input_imgs").value = "";
					return;
				}
			
				sel_files.push(f);

				var reader = new FileReader();
				reader.onload = function(e) {
					var html = "<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("
							+ index
							+ ")\" id=\"img_id_"
							+ index
							+ "\"><img src=\""
							+ e.target.result
							+ "\" data-file='"
							+ f.name
							+ "' class='selProductFile' title='Click to remove'></a>";
					$(".imgs_wrap").append(html);
					index++;
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
