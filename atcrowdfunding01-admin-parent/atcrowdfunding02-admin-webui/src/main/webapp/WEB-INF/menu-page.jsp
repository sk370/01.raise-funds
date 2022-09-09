<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="crowd/my-menu.js"></script>
<script type="text/javascript">
$(function(){
	
	generateTree()//生成树形结构
	
	//1.1添加结构的模态框
	$("#treeDemo").on("click", ".addBtn", function(){
		window.pid = this.id//当前节点的id为新增节点的父节点
		$("#menuAddModal").modal("show")
		$("#menuResetBtn").click()//重置表单——用于请求空上次数据
		return false//禁用a连接默认行为
	})
	//1.2 添加结构的功能
	$("#menuSaveBtn").click(function(){
					
		var name = $("#menuAddModal [name=name]").val()
		var url = $("#menuAddModal [name=url]").val()
		var icon = $("#menuAddModal [name=icon]:checked").val()
		
		$.ajax({
			"url": "menu/save.json",
			"type": "post",
			"data": {
				"pid": window.pid,
				"name": name,
				"url": url,
				"icon": icon
			},
			"dataType": "json",
			"success": function(response){
				var result = response.result
				if(result == "SUCCESS"){
					layer.msg("操作成功")
					$("#menuAddModal").modal("hide")
					generateTree()//生成树形结构
				}
				if(result == "FAILD"){
					layer.msg("操作失败" + response.message)
				}
			},
			"error": function(resopnse){
				layer.msg(response.status + " " + response.message)
			}
		})
	})
	
	//2.1 修改结构的模态框
	$("#treeDemo").on("click", ".editBtn", function(){
		window.id = this.id//当前节点的id
		$("#menuEditModal").modal("show")
		
		var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo")//获取zTreeObj对象
		var key = "id"//节点的属性名
		var value = window.id
		var currentNode = zTreeObj.getNodeByParam(key, value)//调用zTreeObj的getNodeByParam方法，根据id获取节点数据
		
		//回显表单
		$("#menuEditModal [name=name]").val(currentNode.name)
		$("#menuEditModal [name=url]").val(currentNode.url)
		$("#menuEditModal [name=icon]").val([currentNode.icon])
		
		return false//禁用a连接默认行为
	})
	//2.2 更新模态框内容
	$("#menuEditBtn").click(function(){
					
		var name = $("#menuEditModal [name=name]").val()
		var url = $("#menuEditModal [name=url]").val()
		var icon = $("#menuEditModal [name=icon]:checked").val()
		
		$.ajax({
			"url": "menu/update.json",
			"type": "post",
			"data": {
				"id": window.id,
				"name": name,
				"url": url,
				"icon": icon
			},
			"dataType": "json",
			"success": function(response){
				var result = response.result
				if(result == "SUCCESS"){
					layer.msg("操作成功")
					$("#menuEditModal").modal("hide")
					generateTree()//生成树形结构
				}
				if(result == "FAILD"){
					layer.msg("操作失败" + response.message)
				}
			},
			"error": function(resopnse){
				layer.msg(response.status + " " + response.message)
			}
		})
	})
	
	//3.1 删除结构的模态框
	$("#treeDemo").on("click", ".removeBtn", function(){
		window.id = this.id//当前节点的id
		$("#menuConfirmModal").modal("show")
		
		var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo")//获取zTreeObj对象
		var key = "id"//节点的属性名
		var value = window.id
		var currentNode = zTreeObj.getNodeByParam(key, value)//调用zTreeObj的getNodeByParam方法，根据id获取节点数据

		//回显要删除的信息
		$("#removeNodeSpan").html("【<i class='" + currentNode.icon + "'></i>" + currentNode.name + "】")
		
		return false//禁用a连接默认行为
	})
	
	//3.3 删除请求
	$("#confirmBtn").click(function(){		
		$.ajax({
			"url": "menu/delete.json",
			"type": "post",
			"data": {
				"id": window.id
			},
			"dataType": "json",
			"success": function(response){
				var result = response.result
				if(result == "SUCCESS"){
					layer.msg("操作成功")
					$("#menuConfirmModal").modal("hide")
					generateTree()//生成树形结构
				}
				if(result == "FAILD"){
					layer.msg("操作失败" + response.message)
				}
			},
			"error": function(resopnse){
				layer.msg(response.status + " " + response.message)
			}
		})
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
						<i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
						<div style="float: right; cursor: pointer;" data-toggle="modal"
							data-target="#myModal">
							<i class="glyphicon glyphicon-question-sign"></i>
						</div>
					</div>
					<div class="panel-body">
						<!-- 树形菜单 -->
						<ul id="treeDemo" class="ztree">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/modal-menu-add.jsp" %>
	<%@include file="/WEB-INF/modal-menu-confirm.jsp" %>
	<%@include file="/WEB-INF/modal-menu-edit.jsp" %>
</body>
</html>
