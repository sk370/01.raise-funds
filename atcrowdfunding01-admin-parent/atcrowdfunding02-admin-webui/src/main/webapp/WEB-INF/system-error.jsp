<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<base
	href="${pageContext.request.scheme }://${ pageContext.request.serverName}:${ pageContext.request.serverPort}${ pageContext.request.contextPath}/" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="index.html" style="font-size: 32px;">尚筹网-创意产品众筹平台</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<h2 class="form-signin-heading" style="text-align:center">
			<i class="glyphicon glyphicon-log-in"></i> 尚筹网系统消息
		</h2>
		<!--  exception来源于com.atguigu.crowd.mvc.config.CrowdExceptionResolver.java -->
		<h3 style="text-align:center">${ requestScope.exception.message }</h3>
		<button style="width: 150px;margin: 50px auto" class="btn btn-lg btn-success btn-block">点我返回</button>
	</div>
	<script src="jquery/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script>
	$(function(){
		$("button").click(function(){
			window.history.back();
		})	
	})
	</script>
</body>
</html>