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
		
		if($("#pwForm").submit(function(){
			if($("#pw").val() !== $("#pw2").val()){
				alert("비밀번호가 다릅니다.");
				$("#pw").val("").focus();
				$("#pw2").val("");
				return false;
			}else if ($("#pw").val().length < 8) {
				alert("비밀번호는 8자 이상으로 설정해야 합니다.");
				$("#pw").val("").focus();
				return false;
			}else if($.trim($("#pw").val()) !== $("#pw").val()){
				alert("공백은 입력이 불가능합니다.");
				return false;
			}else {
				alert("비밀번호가 변경되었습니다.");
			}
		}));
		if($("#wdForm").submit(function(){
			if(!confirm("정말 탈퇴하시겠습니까")){
				return false;
			}
		}));
		
		if($("#wdForm").submit(function(){
			if(!confirm("탈퇴완료가 완료되었습니다. 사용해주셔서 감사합니다.")){
				return false;
			}
		}));
	})
</script>
<title>마이페이지</title>
</head>
<body>
	<div class="w3-content w3-container w3-margin-top">
		<div class="w3-container w3-card-4">
			<div class="w3-center w3-large w3-margin-top">
				<h3>My Page</h3>
			</div>
			
				<br>
			
				<form id="wdForm" action="../member/withdrawal.do" method="post">	
						<label>Name</label>
						<input class="w3-input" type="name" name="email" required>
					</p>
					<p>
						<label>Password</label>
						<input class="w3-input" type="password"  name="password" required>
					</p>
					<p class= "w3-center">
						<button type="submit" id="withdrawalBtn" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round"> 회원탈퇴</button>  
					
					</p>
					</form>
			</div>
		</div>

</body>
</html>