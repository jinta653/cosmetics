<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(function(){
		if(${msg ne null}){
			alert('${msg}');
		};
		
	
		
</script>
<title>My Page</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>My Page</h3>
			</div>
			<div>
				<form id="myForm" action="Customer.do?action=search" method="post">
					<p>
						<label>Email</label> 
						<jsp:useBean id="userid" class="java.lang.String" scope="session"/>
						<input class="w3-input" type="text" id="email" name="email" value="<%=userid %>" readonly/> 
					</p>
					<p>
						<label>Password</label> 
						<input class="w3-input" type="password" id="password" name="password" value="" required> 
					</p>
					<p class="w3-center">
						<input type="submit" value="회원정보 변경" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" onclick="location='mypage2.jsp'">
					
					</p>
				</form>
				
				<form id="myForm" action="Customer.do?action=delete" method="post">
					<p>
						<label>Email</label> 
						<jsp:useBean id="userid2" class="java.lang.String" scope="session"/>
						<input class="w3-input" type="text" id="email" name="email" value="<%=userid %>" readonly/> 
					</p>
					<p>
						<label>Password</label> 
						<input class="w3-input" type="password" id="password" name="password" value="" required> 
					</p>
					<p class="w3-center">
						<input type="submit" value="회원 탈퇴" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round" onclick="location='mypage2.jsp'">
					
					</p>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>

