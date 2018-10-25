<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon"
	href="https://static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico">
<link rel="mask-icon" type=""
	href="https://static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111">
<title>화장품 사이트</title>

<style>
@import url(https://fonts.googleapis.com/css?family=Lato);

body {
	margin: 0;
}
.nav04 {
}
nav {
	position: relative;
	display:flex;
	flex-direction:column;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	padding: 300px 0;
	box-sizing: border-box;
}

.nav04 {
	background: linear-gradient(90deg, #E0EBFF, #3CAEFF);
}

nav::before {
	position: absolute;
	top: 15%;
	left: 0;
	width: 100%;
	color: #000000;
	font: 800 60px/1 'Lato', sans-serif;
	text-align: center;
}

.nav04::before {
	content: '너는 화장품 뭐쓰니?';
}

/* common */
nav ul {

	position: relative;
	margin: 0;
	padding: 0;
	list-style: none;
}

nav ul::after {
	display: block;
	clear: both;
	content: '';
}

nav ul li {
	position: relative;
	float: left;
	border: 2px solid #fff;
}

nav ul li:not (:first-child ) {
	border-left: none;
}

nav ul li:hover {
	background-color: rgba(255, 255, 255, .3);
}

nav ul li a {
	display: inline-block;
	padding: 1em 4em;
	color: #fff;
	font: 400 18px/1 'Lato', sans-serif;
	text-align: center;
	text-decoration: none;
	white-space: nowrap;
}

nav ul ul {
	position: absolute;
	top: 100%;
	left: -2px;
}

nav ul ul li {
	float: none;
	margin: 0;
}

nav ul ul li:not (:first-child ) {
	border: 2px solid #fff;
	border-top: none;
}

nav ul ul ul {
	position: absolute;
	top: -2px;
	left: 100%;
}

.nav04 ul ul {
	visibility: hidden;
	opacity: 0;
	transition: .2s ease-in-out;
	transform: translateY(10px);
}

.nav04 ul ul ul {
	transform: translateX(-20px) translateY(0);
}

.nav04 ul li:hover>ul {
	visibility: visible;
	opacity: 1;
	transform: translateY(0);
}

.nav04 ul ul li:hover>ul {
	transform: translateX(0) translateY(0);
}

#s1{
height: 40px;
width: 400px;
border: 1px solid #1b5ac2;
display:block;
background: #ffffff;
}
#s1 input{
font-size: 16px;
width: 325px;
padding: 10px;
border: 0px; 
outline: none;
float: left;
}

#s1 button{
width: 50px;
height: 100%;
border: 0px;
background: #1b5ac2;
outline: none;
float: right;
color: #ffffff
}
#s2 {
margin-top : 80px;
}
</style>

<script>
	window.console = window.console || function(t) {
	};
</script>
</head>
<body>


	<nav class="nav04">
		
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="./img/bab64a6afd9e430f8b42f4bcf75d54fe.jpg" alt="Los Angeles" style="width:673px;
      height: 448px;">
      
    </div>

    <div class="item">
      <img src="./img/BAR_2016_09_BE_skin-care-물만난화장품_008-2-e1478675638571.jpg" alt="Chicago" style="width:673px;
      height: 448px;">
    </div>

    <div class="item">
      <img src="./img/f9132badaf15c4917ac778425a03418b.jpg" alt="New York" style="width:673px;
      height: 448px;">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
	<div id="s1">
		<script>
		  (function() {
		    var cx = '001536022639118881476:moufnwk8lvk';
		    var gcse = document.createElement('script');
		    gcse.type = 'text/javascript';
		    gcse.async = true;
		    gcse.src = 'https://cse.google.com/cse.js?cx=' + cx;
		    var s = document.getElementsByTagName('script')[0];
		    s.parentNode.insertBefore(gcse, s);
		  })();
		</script>
		<gcse:search>
		</gcse:search><p>
		
		
		
		
	</div>
	
	<div>
		<ul id="s2">
		
			<li><a href="Event.do?action=list">이벤트</a>
					<ul>
					
					<li><a href="#">진행중인 이벤트 </a>
						<ul>
						
						</ul></li>
					<li><a href="#">완료 된 이벤트 </a>
						<ul>
							
						</ul></li>
				</ul></li>
	
			<li><a href="Cosmetics.do?action=all_list">화장품</a>
				<ul>
					<li><a href="#"> 국내 브랜드</a>
					<ul>
							<li><a href="#">이니스프리</a></li>
							<li><a href="#">에뛰드하우스</a></li>
							<li><a href="#">더페이스샵</a></li>
							<li><a href="#">미샤</a></li>
							<li><a href="#">아리따움</a></li>
						</ul></li>
					
					<li><a href="#"> 외국 브랜드 </a>
					<ul>
							<li><a href="#">맥</a></li>
							<li><a href="#">입생로랑</a></li>
							<li><a href="#">입생로랑</a></li>
							<li><a href="#">Dior </a></li>
							<li><a href="#">바비브라운</a></li>
						</ul></li>
				
				</ul></li>
			<li><a href="Board.do?action=list">게시판</a>
				<ul>
					<li><a href="Board.do?action=list">자유 게시판</a></li>
				
					
				</ul></li>
			<li><a href="Tips.do?action=tips_list">TIP</a>
				<ul>
					
					<li><a href="Tips.do?action=tips_list">TIP</a><ul>	
						</ul></li>
				
				</ul>
			</li>
		
		</ul>
		</div>
	</nav>
	
</body>
</html>