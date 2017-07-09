<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="no-js"  lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
<link type="image/x-icon" rel="shortcut icon" href="<%=basePath%>/resources/images/favicon.ico">
<title>:: Picxa | Register ::</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/resources/css/assets/normalize.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>/resources/css/assets/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>/resources/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>/resources/css/main.css">
<link type="text/css" rel="stylesheet" href="<%=basePath%>/resources/css/responsive.css">
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/modernizr-2.8.3.min.js"></script>
<style>
<%-- .main-wrapper-inner,.register-wrapper::before {background:url("<%=basePath%>/resources/images/details-image-3.jpg") 0 / cover fixed; --%>
</style>
</head>

<body>
<main class="main-wrapper-inner" id="container">
 	<div class="container">
	<div class="wrapper-inner">
	<div class="register-wrapper"  id="reg" style="display:block" >
		<div class="inner-right">
			<header>
				<h3>Join Us!</h3>
			</header>
			<div class="register-form" id="reg">
				<form method="post" action="javascript:void(0)" name="rform" id="rform">
					<label>Whats your name <span>*</span> 
						<input name="name" type="text">
					</label>
					<label>Whats your email <span>*</span>
						<input name="email" type="text">
					</label>
					<label>Whats your password <span>*</span>
						<input name="password1" type="password">
					</label>
					<label>Repeat your password <span>*</span>
						<input name="password2" type="password">
					</label>	
					<!-- <div class="clearfix"></div>
					<label>Introduce yourself 
						<textarea name="comments" id="comments" cols="" rows=""></textarea>
					</label> -->
					<div class="clearfix"></div>
						<input class="register" name="" type="submit" value="Go Register">
						<input class="button" type="button" value="Go Login" onclick="changePage()">
					<div id="simple-msg" class="simple-msg" style="color: red;"></div>
				</form>
			</div>
		</div>
	</div>
		<div class="register-wrapper" id="login" style="display:none" >
		<div class="inner-right">
			<header>
				<h3>Login</h3>
			</header>
			<div class="register-form">
				<form method="post" action="javascript:void(0)" name="lform" id="lform">
					<label>Whats your account
						<input name="identifier" id="identifier" type="text">
					</label>
			
					<label>Whats your password
						<input name="credential" id="credential" type="password">
					</label>
					<!-- <div class="clearfix"></div>
					<label>Introduce yourself 
						<textarea name="comments" id="comments" cols="" rows=""></textarea>
					</label> -->
					<div class="clearfix"></div>
						<input class="login" name="" type="submit" value="Login">
						<input class="button" type="button" value="Go Register" onclick="changePage()">
					<div id="simple-msg" class="simple-msg" style="color: red;"></div>
				</form>
			</div>
		</div>
	</div>
	</div>
	</div>
</main>

<!-- footer -->
<jsp:include page="footer.jsp" />
<!-- footer -->

<script	src="<%=basePath%>/resources/js/jquery.min.js"></script>
<script>
	window.jQuery || document.write('<script src="<%=basePath%>/resources/js/assets/jquery.min.js"><\/script>');
	function chkInfo(){
		if($("input[name='name']").val() == "" ){
			$(".simple-msg:visible").html("*[name] cannot be null*");
			return false;
		}
		if($("input[name='email']").val()==""){
			$(".simple-msg:visible").html("*[email] cannot be null*");
			return false;
		}
		if($("input[name='password1']").val() ==""){
			$(".simple-msg:visible").html("*[password] cannot be null*");
			return false;
		}else if($("input[name='password1']").val() != $("input[name='password2']").val()){
			$(".simple-msg:visible").html("*two passwords are different*");
			return false;
		}else{
			return true;
		}
	}
	function chkLoginInfo(){
		if($("#identifier").val() == "" ){
			$(".simple-msg:visible").html("*please input your account*");
			return false;
		}
		if($("#credential").val()==""){
			$(".simple-msg:visible").html("*please input your password*");
			return false;
		}
		return true;
	}
	$(document).ready(function(){
		changePage();
		$(".register").click(function(){
			$(".simple-msg:visible").html("");
			if(chkInfo()){
				$.post("<%=basePath%>/doRegister",
						{"name":$("input[name='name']").val(),"email":$("input[name='email']").val(),"password":$("input[name='password1']").val()} ,
						function(result){
							$(".simple-msg:visible").html(result.message);
		    	},"json");
			}
			
		});
		$(".login").click(function(){
			if(chkLoginInfo()){
				$.post("<%=basePath%>/doLogin",
						$("#lform").serialize() ,
						function(result){
							console.info(result.message);					
							$(".simple-msg:visible").html(result.message);
		    	},"json");
			}
			
		});
	})
	function changePage(){
		if($("#reg").css('display') == "none"){
			$("#reg").css('display','block'); 
			$("#login").css('display','none');
		}else{
			$("#login").css('display','block');
			$("#reg").css('display','none');
		}
	}
	
</script>
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/plugins.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/custom.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.contact.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.nicescroll.min.js"></script>

</body>

</html>