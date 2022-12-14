<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="GB18030">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="css/pagination.css" />
<script src="jquery/jquery.pagination.js"></script>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="crowd/my-role.js"></script>

<script>
	$(function() {
		// 1.分页的初始化数据
		window.pageNum = 1
		window.pageSize = 5
		window.keyword = ""

		generatePage();//调用my-role.js的方法

		//搜索功能
		$("#searchBtn").click(function() {
			window.keyword = $("#keywordInput").val()
			console.log(window.keyword)
			generatePage()
		})

		//新增的模态框
		$("#showAddButton").click(function() {
			$("#addModal").modal("show")//显示模态框
			$("#saveRole").val("")//清理模态框数据
			
			// 保存操作
			$("#saveRoleBtn").click(function() {
				var roleName = $.trim($("#saveRole").val())
				$.ajax({
					"url" : "role/save.json",
					"type" : "post",
					"data" : {
						"name" : roleName
					},
					"dataType" : "json",
					"success" : function(response) {
						var result = response.result
						if (result == "SUCCESS") {
							layer.msg("操作成功")
	
							window.pageNum = 9999//将页码定位到最后一页
							generatePage()//重新加载页面
						}
						if (result == "FAILED") {
							layer.msg("操作失败，" + response.message)
						}
					},
					"error" : function(response) {
						layer.msg(response.status + "，说明信息：" + response.statusText)
					}
				})
				$("#addModal").modal("hide")//关闭模态框
			})
		})
		
		//更新的模态框(动态生成的editButton翻页后事件会失效)
		//$(".editRoleButton").click(function() {			
		//})
		
		//更新的模态框——使用jquery
		$("#rolePageBody").on("click", ".editRoleButton", function(){
			$("#editModal").modal("show")
			var roleName = $(this).parent().prev().text()
			var roleId = this.id
			$("#roleName").val(roleName)//模态框回显数据
			//更新操作
			$("#updateRoleBtn").click(function() {
				roleName = $.trim($("#roleName").val())
				$.ajax({
					"url" : "role/update.json",
					"type" : "post",
					"data" : {
						"name" : roleName,
						"id": roleId
					},
					"dataType" : "json",
					"success" : function(response) {
						var result = response.result
						if (result == "SUCCESS") {
							layer.msg("操作成功")
	
							//window.keyword = roleName
							generatePage()//重新加载页面
						}
						if (result == "FAILED") {
							layer.msg("操作失败，" + response.message)
						}
					},
					"error" : function(response) {
						layer.msg(response.status + "，说明信息：" + response.statusText)
					}
				})
				$("#editModal").modal("hide")//关闭模态框
			})
		})
		
		// 单个删除
		$("#rolePageBody").on("click", ".deleteRoleButton", function(){
			
			var roleArray = [{
				roleId: this.id,
				roleName: $(this).parent().prev().text()
			}]
			showConfirmModal(roleArray)//打开删除的模态框
		})
		
		//批量删除
		$("#batchDeleteButton").click(function(){
			
			var roleArray =[]
			
			$(".itemBox:checked").each(function(){
				var roleId  = this.id
				var roleName = $(this).parent().next().text()
				roleArray.push({
					"roleId": roleId,
					"roleName": roleName
				})
			})
			
			if(roleArray.length == 0){
				layer.msg("请至少选择一个要删除的数据")
				return
			}
			
			showConfirmModal(roleArray)//打开删除的模态框
		})
		
		
		//删除时的确认按钮功能
		$("#deleteBtn").click(function(){
			
			var requestBody = JSON.stringify(window.roleIdArray)
			
			$.ajax({
				"url" : "role/remove/by/roleId/array.json",
				"type" : "post",
				"data" : requestBody,
				"contentType": "application/json;charset=UTF-8",
				"dataType" : "json",
				"success" : function(response) {
					var result = response.result
					if (result == "SUCCESS") {
						layer.msg("操作成功")
						generatePage()//重新加载页面
					}
					if (result == "FAILED") {
						layer.msg("操作失败，" + response.message)
					}
				},
				"error" : function(response) {
					layer.msg(response.status + "，说明信息：" + response.statusText)
				}
			})
			$("#confirmModal").modal("hide")
		})
		
		//全选全不选——总框够了则所有分框也勾了
		$("#selectAll").click(function(){
			var currentStatus = this.checked
			$(".itemBox").prop("checked", currentStatus)
		})
		
		//全选全不选——分框全勾了则总框也够了
		$("#rolePageBody").on("click", ".itemBox", function(){
			var checkedBoxCount = $(".itemBox:checked").length
			var totalBoxCount = $(".itemBox").length
			$("#selectAll").prop("checked", checkedBoxCount == totalBoxCount)
		})
		
		//分配权限的模态框
		$("#rolePageBody").on("click", ".checkButton", function(){
			window.roleId = this.id//获取当前点击元素的roleId，用于查询对应权限，在模态框显示权限
			$("#assignModal").modal("show")
			fillAuthTree();//调用方法生成分配权限模态框中全选的树形结构
		})
		
		//更新权限——给模态框按钮添加点击事件
		$("#assignBtn").click(function(){
			var authIdArray = []//存放已勾选的节点id
			//调用ztreobj的方法，获取被勾选的节点
			var zTreeObj = $.fn.zTree.getZTreeObj("authTreeDemo")
			var checkedNodes = zTreeObj.getCheckedNodes();
			
			for(var i = 0; i < checkedNodes.length; i++){
				var authId = checkedNodes[i].id
				authIdArray.push(authId)
			}
			
			var requestBody = {
					"authIdArray":authIdArray,
					"roleId":[window.roleId]//[]表示转为数组结构，主要是为了服务器接收数据类型能尽量统一
			}
			requestBody = JSON.stringify(requestBody)
			$.ajax({
				"url" : "assign/do/role/assign/auth.json",
				"type" : "post",
				"data" : requestBody,
				"contentType": "application/json;charset=UTF-8",
				"dataType" : "json",
				"success" : function(response) {
					var result = response.result
					if (result == "SUCCESS") {
						layer.msg("操作成功")
						generatePage()//重新加载页面
					}
					if (result == "FAILED") {
						layer.msg("操作失败，" + response.message)
					}
				},
				"error" : function(response) {
					layer.msg(response.status + "，说明信息：" + response.statusText)
				}
			})
			$("#assignModal").modal("hide")
		})
		
		
	})
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
						<form class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input id="keywordInput" class="form-control has-success"
										type="text" value="" placeholder="请输入查询条件">
								</div>
							</div>
							<button id="searchBtn" type="button" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button id="batchDeleteButton" type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<button id="showAddButton" type="button" class="btn btn-primary"
							style="float: right;">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input id="selectAll" type="checkbox"></th>
										<th>名称</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody id="rolePageBody">
								</tbody>
								<tfoot>
									<!--
									<tr>
										<td colspan="6" align="center">
											<ul class="pagination">
												<li class="disabled"><a href="#">上一页</a></li>
												<li class="active"><a href="#">1 <span
														class="sr-only">(current)</span></a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#">下一页</a></li>
											</ul>
										</td>
									</tr>
									-->
									<tr>
										<td colspan="4" align="center">
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
	<%@include file="/WEB-INF/modal-role-add.jsp"%>
	<%@include file="/WEB-INF/modal-role-edit.jsp"%>
	<%@include file="/WEB-INF/modal-role-confirm.jsp"%>
	<%@include file="/WEB-INF/modal-role-assign-auth.jsp" %>
</body>
</html>
