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
	<div class="container-fluid"></div>
	<header class="masthead text-black text-center">
	<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  
				  <div class="panel panel-default">
				  <c:forEach items="${cblist}" var="cb">
				  
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h5 class="panel-title">
				        <a data-toggle="collapse" data-parent="#_accordion" href="#_${cb.cobrn_num }" aria-expanded="true" aria-controls="collapseOne">
				             ${cb.cobrn_name }
				        </a>
				      </h5>
				    </div>
				    <div id="_${cb.cobrn_num }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				      <div class="panel-body">
				      <c:forEach items="${cbkHash[cb.cobrn_num]}" var="cbk">
				      <a href="Cosmetics.do?action=brand_kind&cobrn_num=${cb.cobrn_num}&cokin_num=${cbk.cokin_num}">${cbk.cokin_name}</a><br>
				      </c:forEach>
				      </div>
				    </div>
				    <hr>
				   </c:forEach>
				  </div>
				  
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingThree">
				      <h5 class="panel-title">
				        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				          아는 브랜드 없음
				        </a>
				      </h5>
				    </div>
				    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
				      <div class="panel-body">
				      파운데이션<br>
				      	스킨<br>
				      	로션<br>
				      </div>
				    </div>
				  </div>
				</div>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" 
        style="background-color: #0000ff0f;
        right: 15px;">
             <c:forEach items="${result }" var="c">
             <div class="row">
			      <div class="col-md-3"style="
				    padding-left: 0px;
				    padding-right: 0px;
					">
			        <img class="img-fluid" src="./cosmetics/img/${c.img_name}" style="
				    margin-bottom: 10px;
				    margin-top: 10px;
				    margin-left:10px;
				    margin-right:10px;
				    width: 200px;
				    height:180px;
				    ">
			      </div>
			      <div class="col-md-9"style="
				    padding-bottom: 10px;
				    padding-top: 10px;">
				    	<br>
				      <input type="hidden" value="${c.cos_num}">
				      <div class="col-md-12 text-left"><a href="Cosmetics.do?action=view&num=${c.cos_num}"><h5>${c.name }</h5></a><br></div>
				      <div class="col-md-12 text-left"><h5>설명 : ${c.explain }</h5><br></div>
				      <div class="col-md-12	 text-right"><h5>용량 : ${c.capacity}</h5><h5>가격 : ${c.price }</h5></div>
			      </div>
			    </div>
				<hr>
			</c:forEach>
        </div>
      </div>
    </div>
			
			
	</header>
	
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