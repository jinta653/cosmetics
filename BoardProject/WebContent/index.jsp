<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
	<title> Login </title>

	<link rel="stylesheet" href="Source/css/style.css">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,300'>

	<!--[if lt IE 9]>
		<script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

</head>

<body>
	
	<div id="login">
	
	<img src="img/logo.jpg" style="width: 500px; hight: 200px;">
	
		<br><br>
		<h1><strong>Welcome.</strong> 로그인 해주세요.</h1>
		<br><br>

		<form action="Customer.do?action=login" method="post">

			<fieldset>

				<p><input type="text" required value="" placeholder="E-Mail" name="email"></p> <!-- JS because of IE support; better: placeholder="Username" -->
			
				<p><input type="password" required value="" placeholder="Password" name="password"></p> <!-- JS because of IE support; better: placeholder="Password" -->

				
				<div>
					<input type="submit" value="로그인"  style="margin: 20px 5px"> <!-- onclick="location.href='MainHomePage.html'"> -->
					<input type="submit" value="회원가입" style="margin: 20px 5px" onclick="location='Register2.html'">
				</div>


			</fieldset>

		</form>
		

	</div> <!-- end login -->

</body>
</html>
  
  


