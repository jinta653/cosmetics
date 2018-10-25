<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
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
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">화장품</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Board.do?action=list">게시판</a>
					</li>
					<li class="nav-item mx-0 mx-lg-1">
						<a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Tips.do?action=tips_list">Tips</a>
					</li>
					<ul>
						<jsp:useBean id="userid" class="java.lang.String" scope="session"/>
			               <li style="font-weight: bold;"><a href=""><%=userid%></a></li>
			               <li><a href="Customer.do?action=logout">로그아웃</a></li>
			            
					</ul>
				</ul>
			</div>
			
		</div>
	</nav>
	<header class="masthead text-black text-center">
	<h5>게시판</h5>
		
	
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr height="5"><td width="5"></td></tr>
		<tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
		<td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
		<td width="73">번호</td>
		<td width="25">종류</td>
		<td width="379">제목</td>
		<td width="73">작성자</td>
		<td width="164">작성일</td>
		<td width="58">조회수</td>
		<td width="7"><img src="img/table_right.gif" width="5" height="30" /></td>
		</tr>
		
		<c:forEach items="${tips_resultList}" var="t">
		
				
		<tr height="80" align="center">
			<td>&nbsp;</td>
			<td>${t.tips_num}</td>
			<td>${t.tips_kind}</td>
			<td align="left"><a href="Tips.do?action=tips_view&num=${t.tips_num}">${t.tips_title}</a></td>
			<td align="center">${t.tips_writer}</td>
			<td align="center">${t.tips_regdate}</td>
			<td align="center">${t.tips_rate+1}</td>
			<td>&nbsp;</td>
		</tr>
  		<tr height="1" bgcolor="#D2D2D2"><td colspan="10"></td></tr>

		</c:forEach>
		
		
		
		<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
		
		
		<tr height="1" bgcolor="#82B5DF"><td colspan="6" width="752"></td></tr>
		
		<tr><td colspan="6">  
		<center>
        <c:if test="${pageIsPrev}">
            <a href="Tips.do?action=tips_list&page=${pageStart - 1}">prev</a>
        </c:if>
        <c:forEach var="page" begin="${pageStart}" end="${pageEnd}">
            <a href="Tips.do?action=tips_list&page=${page}">[${page}] </a>
        </c:forEach>
        <c:if test="${pageIsNext}">
            <a href="Tips.do?action=tips_list&page=${pageEnd + 1}">next</a>
        </c:if>
    </center>
		
		
		</td></tr>
		

	</table>
	</header>
	게시물 갯수 : ${tips_resultList.size()} <br>
	<a href="TipsInsert.jsp">게시물 등록</a>

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