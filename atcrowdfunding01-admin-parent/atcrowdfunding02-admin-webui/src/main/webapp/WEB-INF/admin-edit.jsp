<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="/WEB-INF/include-head.jsp"%>
<body>
	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
					<li><a href="admin/to/main/page.html">首页</a></li>
					<li><a href="admin/get/page.html">数据列表</a></li>
					<li class="active">更新</li>
				</ol>
				<div class="panel panel-default">
					<div class="panel-heading">
						表单数据
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<form role="form" action="admin/update.html" method="post">
							<input type="hidden" name="id" value="${requestScope.admin.id }"/>
							<input type="hidden" name="pageNum" value="${param.pageNum }"/>
							<input type="hidden" name="keyword" value="${param.keyword}"/>
							<p>${requestScope.exception.message }</p>
							<div class="form-group">
								<label for="exampleInputPassword1">登陆账号</label> <input
									type="text" name="loginAcct" value="${requestScope.admin.loginAcct }" class="form-control"
									id="exampleInputPassword1" placeholder="请输入登陆账号">
							</div>
							<!-- 
							<div class="form-group">
								<label for="exampleInputPassword1">登录密码</label> <input
									type="text" name="userPswd" class="form-control"
									id="exampleInputPassword1" placeholder="请输入登录密码">
							</div>
							 -->
							<div class="form-group">
								<label for="exampleInputPassword1">用户昵称</label> <input
									type="text" name="userName" value="${requestScope.admin.userName }" class="form-control"
									id="exampleInputPassword1" placeholder="请输入用户昵称">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">邮箱地址</label> <input type="email"
									name="email" value="${requestScope.admin.email }" class="form-control" id="exampleInputEmail1"
									placeholder="请输入邮箱地址">
								<p class="help-block label label-warning">请输入合法的邮箱地址, 格式为：
									xxxx@xxxx.com</p>
							</div>
							<button type="submit" class="btn btn-success">
								<i class="glyphicon glyphicon-edit"></i> 更新
							</button>
							<button type="resert" class="btn btn-danger">
								<i class="glyphicon glyphicon-refresh"></i> 重置
							</button>
						</form>
					</div>
				</div>
			</div>
		
		</div>
	</div>
</body>
</html>
