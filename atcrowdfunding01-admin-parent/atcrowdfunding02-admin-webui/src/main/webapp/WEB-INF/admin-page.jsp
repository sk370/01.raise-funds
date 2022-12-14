<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="css/pagination.css" />
<script src="jquery/jquery.pagination.js"></script>
<script type="text/javascript">
	$(function(){
		// 调用专门的函数初始化分页导航条
		initPagination();
	});
	// 声明一个函数用于初始化 Pagination
	function initPagination() {
		// 总记录数
		var totalRecord = ${requestScope.pageInfo.total};
		// 声明 Pagination 的属性
		var properties = {
			num_edge_entries: 3, // 边缘页数
			num_display_entries: 3, // 主体页数
			callback: pageSelectCallback, // 点击“翻页”按钮之后的操作
			current_page: ${requestScope.pageInfo.pageNum-1}, // 当前页，该js插件页数从0开始，pageNum 从1开始，必须-1后才可以赋值
			prev_text: "上一页",
			next_text: "下一页",
			items_per_page:${requestScope.pageInfo.pageSize} // 每页显示多少条
		};
		
		// 生成导航条
		$("#Pagination").pagination(totalRecord, properties);
	}
	
	// pageIndex 是用户在页面上点击的页码数值
	function pageSelectCallback(pageIndex, jQuery) {
		// pageIndex 是当前页页码的索引，相对于 pageNum 来说， pageIndex 比 pageNum 小 1
		var pageNum = pageIndex + 1;
		// 执行页面跳转也就是实现“翻页”
		window.location.href = "admin/get/page.html?pageNum="+pageNum + "&keyword=${param.keyword}" ;
		// 取消当前超链接的默认行为
		return false;
	}
</script>
<body>
	<%@ include file="/WEB-INF/include-nav.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/WEB-INF/include-sidebar.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form action="admin/get/page.html" method="post" class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input class="form-control has-success" type="text" name="keyword" value="${param.keyword }" placeholder="请输入名称/邮箱任一条件">
								</div>
							</div>
							<button type="submit" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<a type="button" class="btn btn-primary"
							style="float: right;" href="admin/to/add/page.html">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</a>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input type="checkbox"></th>
										<th>账号</th>
										<th>名称</th>
										<th>邮箱地址</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${empty requestScope.pageInfo.list }">
										<tr>
											<td colspan="6" align="center">抱歉，!没有查到您要的数据！</td>
										</tr>
									</c:if>

									<c:if test="${!empty requestScope.pageInfo.list }">
										<c:forEach items="${requestScope.pageInfo.list }" var="admin"
											varStatus="myStatus">
											<tr>
												<td>${myStatus.count }</td>
												<td><input type="checkbox"></td>
												<td>${admin.loginAcct }</td>
												<td>${admin.userName }</td>
												<td>${admin.email }</td>
												<td>
													<a href="assign/to/assign/role/page.html?adminId=${admin.id}&pageNum=${requestScope.pageInfo.pageNum}&keyword=${param.keyword}" class="btn btn-success btn-xs" title="设置角色">
														<i class=" glyphicon glyphicon-check"></i>
													</a>
													<a href="admin/to/edit/page.html?adminId=${admin.id}&pageNum=${requestScope.pageInfo.pageNum}&keyword=${param.keyword}" type="button" class="btn btn-primary btn-xs" title="修改信息">
														<i class=" glyphicon glyphicon-pencil"></i>
													</a>
													<!-- 这里不能使用param.pageNum，因为第一页、查询页码只有1一页展示的时候路径没有pageNum参数 -->
													<a href="admin/remove/${admin.id}/${requestScope.pageInfo.pageNum}/${param.keyword}.html" type="button" class="btn btn-danger btn-xs" title="删除角色">
														<i class=" glyphicon glyphicon-remove"></i>
													</a>
												</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<div id="Pagination" class="pagination"></div>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
