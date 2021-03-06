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
	    //全域変数宣言
	    var editor_object = [];
	     
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: editor_object,
	        elPlaceHolder: "smarteditor",
	        sSkinURI: "SE2/SmartEditor2Skin.html", 
	        htParams : {
	            // ツールバーを使用（o,x） (true:使用/ false:使用しない)
	            bUseToolbar : true,             
	            // 入力窓のサイズチョジョルパを使用（o,x） (true:使用/ false:使用しない)
	            bUseVerticalResizer : true,     
	            // モードタブ(Editor | HTML | TEXT) 使用 （o,x） (true:使用/ false:使用しない )
	            bUseModeChanger : true, 
	        }
	    });
	     
	    //送信ボタンクリックイベント
	    $("#savebutton").click(function(){
	        //idが smarteditorの textareaにエディターで代入
	        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // この部分に、エディタ validation 検証
	         
	        //フォーム submit
	        self.window.alert("입력한 글을 저장하였습니다.")
	        $("#frm").submit();
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
		
		<form id="frm" action="Board.do" method="post">
			<input type="hidden" name="action" value="insert"/>
			<table>
				<tr>
				<td>
					<table>
						<tr>
							<div align="center">
								<h4>- 게시물 작성 -</h4><hr>
							</div>
						</tr>
					</table>
					
					<table>
						<tr>
						<td>&nbsp;</td>
						<td align="center">ID :</td>
						<td><input type="hidden" value="<%=userid%>" name="writer" size="100" maxlength="100"><%=userid%></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						
						<tr>
						<td>&nbsp;</td>	
						<td align="center">제목 :</td>
						<td><input type="text" name="title" size="100" maxlength="100"></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						
						<tr>
						<td>&nbsp;</td>
						<td align="center">내용</td>
						<td><textarea name="content" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"0></textarea></td>
						<td>&nbsp;</td>
						</tr>
						
						<tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
						<tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
						
						<tr align="center">
						<td>&nbsp;</td>
						<td colspan="2"><input type="button" id="savebutton" value="저장"/>
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