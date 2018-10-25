<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Insert title here</title>
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
		<div align="center">
			<table width="50%">
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">글번호 : </td>
				<td width="200">${tips_result.tips_num }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">종류 : </td>
				<td width="200">${tips_result.tips_kind }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">조회수 :</td>
				<td width="319">${tips_result.tips_rate+1 }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">이름 :</td>
				<td width="319">${tips_result.tips_writer }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">작성일 :</td>
				<td width="319">${tips_result.tips_regdate }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0">&nbsp;</td>
				<td align="center" width="76">제목 :</td>
				<td width="319">${tips_result.tips_title }</td>
				<td width="0">&nbsp;</td>
				</tr>
				
				<tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
				
				<tr>
				<td width="0"></td>
				<td width="400" colspan="2" height="400">${tips_result.tips_content }
				</tr>
				     
				<tr align="center"> 
					<td width="0">&nbsp;</td> 
					<td colspan="2" width="399">
					<input type=button value="글쓰기" OnClick="window.location='TipsInsert.html'"> 
					<input type=button value="목록" OnClick="window.location='Tips.do?action=tips_list'"> 
					<input type=button value="수정"> 
					<input type=button value="삭제"> <p>
					<td width="0">&nbsp;</td>
				</tr>
			</table>
				
				<form action="Tips.do?action=tips_cmt_insert" method="post">
					   <input type="hidden" name="num" value="${tips_result.tips_num }">
					    <div class="col-5">
					 	   <textarea class="form-control" name="tips_contents"></textarea><p>
					    </div>
				  		<button type="submit" class="btn btn-default">댓글 입력</button>
			   	</form>	
						 
			<table width="40%" cellpadding="0" cellspacing="0" border="0">
				<c:forEach items="${tips_cmtList}" var="t">
			
					
				<tr height="40" align="center">
					<td>&nbsp;</td>
					<td align="center">작성자</td>
					<td align="center">${t.tips_contents}</td>
					<td align="center">${t.tips_regdate}</td>
					<td align="center">삭제</td>
					<td>&nbsp;</td>
				</tr>
				
	  			<tr height="1" bgcolor="#D2D2D2"><td colspan="6"></td></tr>
	
				</c:forEach>	
									
			</table>
			
		</div>
	</header>


</body>
</html>