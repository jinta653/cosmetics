<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>보드</title>

    <!-- Bootstrap core CSS -->
    <link href="Source/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="Source/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="Source/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="Source/css/freelancer.min.css" rel="stylesheet">
</head>
<body>
   <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
		<div class="container">
		
		<a class="navbar-brand js-scroll-trigger" href="main.jsp">너 화장품 뭐쓰니?</a>
			<button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" 
			type="button" 
			data-toggle="collapse" 
			data-target="#navbarResponsive" 
			aria-controls="navbarResponsive" 
			aria-expanded="false" 
			aria-label="Toggle navigation">
			<i class="fa fa-bars"></i>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Event.do?action=list">event</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Cosmetics.do?action=all_list">화장품</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Board.do?action=list">게시판</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Tips.do?action=tips_list">Tips</a>
					</li>
					<ul>
						<jsp:useBean id="userid" class="java.lang.String" scope="session"/>
			               <li style="font-weight: bold;"><a href="mypage.jsp"><%=userid%></a></li>
			               <li><a href="Customer.do?action=logout">로그아웃</a></li>
			            
					</ul>
				</ul>
			</div>
			
		</div>
	</nav>   

   <section class="portfolio" id="portfolio" style="margin-top: 50px;">
   
   
      <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">EVENT</h2>
        <hr class="star-dark mb-5">
        <div class="row">
          
          <c:forEach items="${resultList }" var="e">
          
             <div class="col-md-6 col-lg-4">
            <a class="d-block mx-auto" href="Event.do?action=view&num=${e.num}">
              <img class="img-fluid" src="./event/img/${e.img_filename}" alt="" style="width:500px;
      height: 300px; margin-top: 30px;">
            </a>
            ${e.event_start } - ${e.event_end }
          </div>
          
          </c:forEach>
                    
        </div>
      </div>
    </section>
   
   
   <!-- Bootstrap core JavaScript -->
    <script src="Source/vendor/jquery/jquery.min.js"></script>
    <script src="Source/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="Source/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="Source/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="Source/js/jqBootstrapValidation.js"></script>
    <script src="Source/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="Source/js/freelancer.min.js"></script>
   
   
</body>
</html>