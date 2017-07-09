<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<footer class="footer">
<h3>Stay connected with us</h3>
<div class="container footer-bot">
	<div class="row">
		<!-- logo -->
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
			<img src="<%=basePath%>/resources/images/footer-logo.png" alt="Picxa" title="Picxa" />
			<p class="copy-right">&copy; Reserved Picxa inc 2016.</p>
		</div>
		<!-- logo -->
		<!-- address -->
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 padding-top">
			<address>
				<p>200 Broadway Av</p>
				<p>West Beach SA 5024 Australia</p>
			</address>
		</div>
		<!-- address -->
		<!-- email -->
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 padding-top">
			<p>E-mail</p>
			<p>
				<a href="mailto:songkh@live.com">songkh@live.com</a>
			</p>
		</div>
		<!-- email -->
		<!-- social -->
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 padding-top">
			<ul class="social">
				<li><a href="javascript:void(0)"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
				<li><a href="javascript:void(0)"><i class="fa fa-flickr" aria-hidden="true"></i></a></li>
				<li><a href="javascript:void(0)"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
				<li><a href="javascript:void(0)"><i class="fa fa-tripadvisor" aria-hidden="true"></i></a></li>
				<li><a href="javascript:void(0)"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
				<li><a href="javascript:void(0)"><i class="fa fa-delicious" aria-hidden="true"></i></a></li>
			</ul>
			<p class="made-by">
				Made with by <i class="fa fa-heart" aria-hidden="true"></i> 
				<a href="http:///" target="_blank">Designstub</a>
			<p>
		</div>
		<!-- social -->
		</div>
	</div>
</footer>
</html>