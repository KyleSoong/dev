<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<base href="<%=basePath %>" >
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
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/modernizr-2.8.3.min.js"></script>
<style>
.register-form label{ font-weight:300; font-size:14px; width:100%; max-width:315px; float:left; margin-bottom:57px}
.register-form label+label{ float:left }
.register-form label+label+div+label{ float:none; max-width:100%; margin-bottom:43px}
.register-form label span{ color:#fb5353}
.register-form label input,.contact-form label textarea{ background-color:inherit; border:none; border-bottom:1px solid #eeeeee; display:block; width:100%; padding:0 10px; outline:none}
.register-form label input:focus,.contact-form label textarea:focus{ border-bottom-color:#404040}
.register-form input[type="submit"]{ border:none; outline:none; cursor:pointer; text-align:center; display:inline-block; font-size:14px; text-transform:uppercase; letter-spacing:1px; color:#FFF; line-height:47px; background-color:#fb5353; padding:0 29px}
.register-form input[type="submit"]:hover{ background-color:#222222}
.register-form label textarea { background-color: inherit; border: none; border-bottom: 1px solid #eeeeee; display: block; width: 100%; padding: 0 10px; outline: none;
</style>
</head>
<body>
<main class="main-wrapper-inner" id="container">
	<div class="container">
		<div class="wrapper-inner">
			<!-- map -->
	<!-- <div class="map-wrapper">
		<div id="surabaya"></div>
	</div> -->
	<!-- map -->
	<!-- contact -->
	<div class="contact-wrapper">
		<!-- left -->
		<div class="inner-left">
			<p class="phone">
				<a href="tel:8197654321"> <%=basePath%></a>
			</p>
			<p class="email">
				<a href="mailto:songkh@live.com">songkh@live.com</a>
			</p>
		</div>
		<!-- left -->
		
		<!-- right -->
		<div class="inner-right">
			<header>
				<h4>Join Us!</h4>
			</header>
			<!-- contact-form -->
					<div class="register-form">
						<div id="message"></div>
						<form method="post" action="javascript:void(0)" name="cform" id="rform">
							<label>Whats your name <span>*</span> 
								<input name="name" id="name" type="text">
							</label>
							<label>Whats your email<span>*</span>
								<input name="email" id="email" type="text">
							</label>
							<label>Whats your password<span>*</span>
								<input name="password" id="password" type="password">
							</label>
							<label>Repeat your password<span>*</span>
								<input name="repassword" id="repassword" type="password">
							</label>	
							<div class="clearfix"></div>
							<label>Introduce yourself 
								<textarea name="comments" id="comments" cols="" rows=""></textarea>
							</label>
							<div class="clearfix"></div>
								<input class="register" name="" type="submit" value="Go Register">
							<div id="simple-msg"></div>
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
		console.info($("#comments").val());
		if($("#name").val() == "" || $("#email").val()=="" || $("#password").val() ==""){
			return false;
		}
	
		if($("#password").val() == $("#repassword").val()){
			return true;
		}else return false;
	}
	$(document).ready(function(){
		$(".register").click(function(){
			if(chkInfo()){
				$.post("<%=basePath%>/doRegister",$("#rform").serialize() ,function(result){
					console.info(result.message);
		    	},"json");
			}
			
		});
	
	})
	
	
</script>
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/plugins.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/assets/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>/resources/js/maps.js"></script> --%>
<script type="text/javascript" src="<%=basePath%>/resources/js/custom.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.contact.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.nicescroll.min.js"></script>

</body>
</html>