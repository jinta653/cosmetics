<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    
   
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  	
  	<script type="text/javascript" src="SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
	    //전역변수선언
	    var tips_editor_object = [];
	     
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: tips_editor_object,
	        elPlaceHolder: "tips_smarteditor",
	        sSkinURI: "SE2/SmartEditor2Skin.html", 
	        htParams : {
	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseToolbar : true,             
	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseVerticalResizer : true,     
	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseModeChanger : true, 
	        }
	    });
	     
	    //전송버튼 클릭이벤트
	    $("#tips_savebutton").click(function(){
	        //id가 smarteditor인 textarea에 에디터에서 대입
	        tips_editor_object.getById["tips_smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	         
	        //폼 submit
	        self.window.alert("입력한 글을 저장하였습니다.")
	        $("#tips_frm").submit();
	    })
	})
	</script>
  	
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
	
	<header class="masthead text-black text-center">
		<div align="center">
		
		<form id="tips_frm" action="Tips.do" method="post">
			<input type="hidden" name="action" value="tips_insert"/>
			<table>
				<tr>
				<td>
					<table>
						<tr>
							<div align="center">
								<h4>- 팁 작성 -</h4><hr>
							</div>
						</tr>
					</table>
					
					<table>
						<tr>
						<td>&nbsp;</td>	
						<td align="center">종류 :</td>
						<td><select name="tips_kind">
							<option value="요청">요청</option>
							<option value="답변">답변</option>
						</select></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						
						<tr>
						<td>&nbsp;</td>	
						<td align="center">제목 :</td>
						<td><input type="text"  name="tips_title" size="100" maxlength="100"></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						
						<tr>
						<td>&nbsp;</td>
						<td align="center">이름 : </td>
						<td><input type="text" value="<%=userid%>" name="tips_writer" size="100" maxlength="100" readonly/>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						
						<tr>
						<td>&nbsp;</td>
						<td align="center">내용</td>
						<td><textarea id="tips_smarteditor" name="tips_content" rows="10" cols="100" style="width:766px; height:412px;"0></textarea></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
						
						<tr align="center">
						<td>&nbsp;</td>
						<td colspan="2"><input type="button" id="tips_savebutton" value="저장"/>
						&nbsp;
						<input type="reset" value="취소"></td>
						<td>&nbsp;</td>
						</tr>
						
					</table>
				</td>
				</tr>
			</table>
		</form>
		</div>
	</header>
</body>
</html>