var comments = {};
var name,
    comment,
    date,
    click = 0;

function getComments(){
  click++;
  name = $("#name").val();
  comment = $("#review").val();
  date = Date();
  showComments(name, date, comment);
  $(".append").append(
    '<div class="section' + click + '">'  + '<div class="row"> <div class="name">' + "jakook" + '</div>' + '<div class="comment">' + comments.comment + '</div>' + '<div class="date">' + comments.commentDate + '</div>' + '</div>' + '</div>' + '</div>');
      $('html, body').scrollTop( $(document).height());
  $(".section" + click).hide().show("slow");
}

function showComments(user, date, comment){
  comments = {
    userName: user,
    commentDate: date,
    comment: comment,
  }
}
