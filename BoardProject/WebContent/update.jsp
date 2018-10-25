<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 Page</title>

<!-- css 파일 분리 -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<style>
body {
	background: #FFFFFF;
	font-family: 'Roboto', sans-serif;
	color: #333;
	line-height: 22px;
	position: absolute;
	left: 0;
	right: 0;
	margin-left: auto;
	margin-right: auto;
	width: 700px;
	margin-top: 30px;
}

h1, h2, h3, h4, h5, h6 {
	font-family: 'Roboto Condensed', sans-serif;
	font-weight: 400;
	color: #111;
	margin-top: 5px;
	margin-bottom: 5px;
}

h1, h2, h3 {
	text-transform: uppercase;
}

input.upload {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 12px;
	cursor: pointer;
	opacity: 1;
	filter: alpha(opacity = 1);
}

.form-inline .form-group {
	margin-left: 0;
	margin-right: 0;
}

.control-label {
	color: #333333;
}
</style>


</head>


<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<section>
					<h1 class="entry-title">
						<span>Update</span>
					</h1>
					<hr>
					<form action="Customer.do?action=update" class="form-horizontal" method="post" name="signup"
						id="signup">
						<div class="form-group">
							<label class="control-label col-sm-3"> 이메일 <span
								class="text-danger">*</span></label>
							<div class="col-md-8 col-sm-9">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope"></i></span> 
										<jsp:useBean id="userid" class="java.lang.String" scope="session"/>
										<input type="email" required="required" class="form-control" name="email"
										id="emailid" placeholder="이메일 주소를 작성주세요." value="<%=userid %>" readonly/>
								</div>
								<small> Your Id is being used for ensuring the security
									of your account, authorization and access recovery. </small>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3"> 비밀번호 <span
								class="text-danger">*</span></label>
							<div class="col-md-5 col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										required="required" class="form-control" name="password"
										id="password" placeholder="비밀번호를 입력해주세요." value="">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3"> 비밀번호 확인 <span
								class="text-danger">*</span></label>
							<div class="col-md-5 col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input type="password"
										required="required" class="form-control" name="cpassword"
										id="cpassword" placeholder="위의 비밀번호를 다시 입력해주세요." value="">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3"> 이름 <span
								class="text-danger">*</span></label>
							<div class="col-md-8 col-sm-9">
								<input type="text" class="form-control" name="name"
									id="mem_name" placeholder="" value="${Info.getName() }" readonly/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3"> 생년월일 <span
								class="text-danger">*</span></label>
							<div class="col-xs-8">
								<div class="form-inline">

									<div class="form-group">
										<select name="yyyy" class="form-control">
											<option value="0">연도</option>
											<option value="1955">1955</option>
											<option value="1956">1956</option>
											<option value="1957">1957</option>
											<option value="1958">1958</option>
											<option value="1959">1959</option>
											<option value="1960">1960</option>
											<option value="1961">1961</option>
											<option value="1962">1962</option>
											<option value="1963">1963</option>
											<option value="1964">1964</option>
											<option value="1965">1965</option>
											<option value="1966">1966</option>
											<option value="1967">1967</option>
											<option value="1968">1968</option>
											<option value="1969">1969</option>
											<option value="1970">1970</option>
											<option value="1971">1971</option>
											<option value="1972">1972</option>
											<option value="1973">1973</option>
											<option value="1974">1974</option>
											<option value="1975">1975</option>
											<option value="1976">1976</option>
											<option value="1977">1977</option>
											<option value="1978">1978</option>
											<option value="1979">1979</option>
											<option value="1980">1980</option>
											<option value="1981">1981</option>
											<option value="1982">1982</option>
											<option value="1983">1983</option>
											<option value="1984">1984</option>
											<option value="1985">1985</option>
											<option value="1986">1986</option>
											<option value="1987">1987</option>
											<option value="1988">1988</option>
											<option value="1989">1989</option>
											<option value="1990">1990</option>
											<option value="1991">1991</option>
											<option value="1992">1992</option>
											<option value="1993">1993</option>
											<option value="1994">1994</option>
											<option value="1995">1995</option>
											<option value="1996">1996</option>
											<option value="1997">1997</option>
											<option value="1998">1998</option>
											<option value="1999">1999</option>
											<option value="2000">2000</option>
											<option value="2001">2001</option>
											<option value="2002">2002</option>
											<option value="2003">2003</option>
											<option value="2004">2004</option>
											<option value="2005">2005</option>
											<option value="2006">2006</option>
										</select>
									</div>

									<div class="form-group">
										<select name="mm" class="form-control">
											<option value="">월</option>
											<option value="01">1</option>
											<option value="02">2</option>
											<option value="03">3</option>
											<option value="04">4</option>
											<option value="05">5</option>
											<option value="06">6</option>
											<option value="07">7</option>
											<option value="08">8</option>
											<option value="09">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
										</select>
									</div>

									<div class="form-group">
										<select name="dd" class="form-control">
											<option value="">일</option>
											<option value="01">1</option>
											<option value="02">2</option>
											<option value="03">3</option>
											<option value="04">4</option>
											<option value="05">5</option>
											<option value="06">6</option>
											<option value="07">7</option>
											<option value="08">8</option>
											<option value="09">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
										</select>
									</div>


								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3"> 성별 <span
								class="text-danger">*</span></label>
							<div class="col-md-8 col-sm-9">
								<label> <input name="gender" type="radio" value="Male"
									checked> 남성
								</label>     <label> <input name="gender" type="radio"
									value="Female"> 여성
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3"> 휴대폰 번호 <span
								class="text-danger">*</span></label>
							<div class="col-md-5 col-sm-8">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-phone"></i></span> <input type="text"
										class="form-control" name="telnum" id="contactnum"
										placeholder="휴대폰 번호를 입력해주세요." value="">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3"> 프로필 사진 <br> <small>(optional)</small></label>
							<div class="col-md-5 col-sm-8">
								<div class="input-group">
									<span class="input-group-addon" id="file_upload"><i
										class="glyphicon glyphicon-upload"></i></span> <input type="file"
										name="file_nm" id="file_nm" class="form-control upload"
										placeholder="" aria-describedby="file_upload">
								</div>
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-offset-3 col-md-8 col-sm-9">
								<span class="text-muted"><span class="label label-danger">Note:-</span>
									By clicking Sign Up, you agree to our <a href="#">Terms</a> and
									that you have read our <a href="#">Policy</a>, including our <a
									href="#">Cookie Use</a>.</span>
							</div>
						</div>



						<div class="form-group">
							<div class="col-xs-offset-3 col-xs-10">
								<input type="button" onClick="history.back();" value="이전으로"
									class="btn btn-primary"> <input type="reset"
									name="reset" value="다시입력" class="btn btn-primary"> <input
									name="Submit" type="submit" value="수정완료"
									class="btn btn-primary">

							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</body>
</html>