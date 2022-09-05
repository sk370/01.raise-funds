<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="${pageContext.request.scheme }://${ pageContext.request.serverName}:${ pageContext.request.serverPort}${ pageContext.request.contextPath}/"/>
<script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn1").click(function(){
			$.ajax({
				"url": "send/array.html",
				"type": "post",
				"data": {
					"array": [5, 8, 12]
				},
				"dataType": "text",
				"success": function(response){
					alert(response);
				},
				"error": function(response){
					alert(response);
				}
			})
		});
		$("#btn2").click(function(){
			layer.msg("layer弹框")
		});
	});
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/test/ssm.html">测试ssm整合</a>
	<button id="btn1">send [5,8,12]One</button>
	
	<button id="btn2">layer弹框</button>
	
${pageContext.request.scheme }://${ pageContext.request.serverName}:${ pageContext.request.serverPort}${ pageContext.request.contextPath}/

${requestScope.servletName }

	
</body>
</html>