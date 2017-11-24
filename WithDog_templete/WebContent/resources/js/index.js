var movieInfo = {};
var comments = {};
var thumbs = [];
var name,
    comment,
    date,
    click = 0;

function createMovie(title, date, actors, studio, director){
  movieInfo = {
    title: title,
    releaseDate: "Release: " + date,
    actors: "Starring: " + actors,
    studio: "Studio: " + studio,
    director: "Director: " + director
  }  
}

function getComments(){
  click++;
  name = $("#name").val();
  comment = $("#review").val();
  date = Date();
  showComments(name, date, comment);
  $(".append").append(
    '<div class="section' + click + '">'  + '<div class="msg-content">' + '<div class="avatar"><i class="fa fa-user-circle"></i></div>'+'<div class="name">' + comments.userName + '</div>' + '<div class="date">' + comments.commentDate + '</div>' + '<div class="comment">' + comments.comment + '</div>' + '</div>' + '</div>');
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

$('body').append(moment().tz("Europe/London").format('HH:mm'));

createMovie("Wonder Woman", 2017, "Gal Gadot", "Warner Bros.", "Patty Jenkins");

//getComments(name, date, comment);
//console.log(comments.comment);
//console.log(movieInfo.actors);
$(".title").text(movieInfo.title);
$(".release").text(movieInfo.releaseDate);
$(".studio").text(movieInfo.studio);
$(".starring").text(movieInfo.actors);
$(".director").text(movieInfo.director);