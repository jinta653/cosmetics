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
				  
				
				</div>
        </div>
        
        <div class="col-md-10 col-md-offset-2 main" style="background-color: #0000ff0f; right: 15px;">
            <div class="row">
            <div class="col-md-4"style="padding-top: 10px; padding-bottom: 10px;">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
			  <ol class="carousel-indicators">
			    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			  </ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="./cosmetics/img/${result.img_name}" alt="첫번째 슬라이드" width="500" height="500">
			    </div>
			    <div class="carousel-item">
			      <img src="./cosmetics/img//${result.img_name}" alt="두번째 슬라이드" width="500" height="500">
			    </div>
			    <div class="carousel-item">
			      <img src="./cosmetics/img//${result.img_name}" alt="세번째 슬라이드" width="500" height="500">
			    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon"></span>
			    <span class="sr-only">이전</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon"></span>
			    <span class="sr-only">다음</span>
			  </a>
			</div>
			</div>
            <div class="col-md-4">
            	<br>
	            <div class="text-left" style="margin-top: 20px; margin-bottom: 20px;">
				<h5>이름 : ${result.name}</h5>
				</div>
				<br>
	            <div class="text-left" style="margin-top: 20px; margin-bottom: 20px;">
				<h5>용량 : ${result.capacity}</h5>
				</div>
				<br>
	            <div class="text-left" style="margin-top: 20px; margin-bottom: 20px;">
				<h5>가격 : ${result.price}</h5>
				</div>
				<br>
	            <div class="text-left" style="margin-top: 20px; margin-bottom: 80px;">
				<h5>설명 : ${result.explain}</h5>
				</div>
				<br>
	            <div class="text-right" style="margin-top: 20px; margin-bottom: 20px;">
				<button class="btn btn-default btn-lg" onclick="window.open('${result.link}')">이동</button>
				<button class="btn btn-default btn-lg">구매</button>
				</div>
            </div>
            <div class="col-md-4" style="padding-top: 10px;padding-bottom: 10px;">
            
            	<c:forEach items="${cmtList}" var="c">
			
				<table>
				<tr height="40" align="center">
					<td>&nbsp;</td>
					<td width="100">작성자</td>
					<td width="310">${c.contents}</td>
					<td width="200">${c.regdate}</td>
					<td width="45">삭제</td>
					<td>&nbsp;</td>
				</tr>
				
	  			<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
				</table>
				</c:forEach>
				<hr>
            
	            <form action="Cosmetics.do?action=cmt_insert" method="post">
					<input type="hidden" name="num" value="${result.cos_num }">
					<textarea class="form-control" name="contents"></textarea>
					<br>
					<button type="submit" class="btn btn-default">댓글 입력</button>
				</form>	
            </div>
            </div>
        </div>
      </div>
    </div>
	
	
	
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