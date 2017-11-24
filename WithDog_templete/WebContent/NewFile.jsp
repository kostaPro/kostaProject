<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Movie review widget concept #dailyui</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.min.css'>

      <link rel="stylesheet" href="resources/css/reviewStyle.css">

  
</head>

<body>
    <div class="section">
      
      <div class="reviews">
        <h3>Leave a comment
          <input class="form-control" id="name" type="text" placeholder="Name" name="name"/>
          <textarea class="form-control" id="review" type="text" rows="4" cols="40" placeholder="Your review goes here"></textarea>
          <button class="btn btn-primary" type="button" onclick="getComments()">Submit</button>
        </h3>
      </div>
    </div>
    <div class="append"></div>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script>

    <script  src="resources/js/index.js"></script>

</body>
</html>
    