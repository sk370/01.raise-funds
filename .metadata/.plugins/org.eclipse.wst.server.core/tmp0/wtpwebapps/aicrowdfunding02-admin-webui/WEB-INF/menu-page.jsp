<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="/WEB-INF/include-head.jsp"%>
<link rel="stylesheet" href="ztree/zTreeStyle.css"/>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="crowd/my-menu.js"></script>
<script type="text/javascript">
$(function(){
	var setting = {//1.ztree的初始化数据，存放ztree的设置
		view: {
			"addDiyDom": myAddDom,//修改图标
			"addHoverDom": myAddHoverDom,//鼠标移入显示操作图标
			"removeHoverDom": myRemoveHoverDom,//鼠标移除隐藏操作图标
			
		},
		"data": {			//禁用点击跳转
			"key": {
			"url": "maomi"
			}
		}
	}
	
	var zNodes = [];//2. 页面数据
	$.ajax({
		"url" : "menu/get/whole/tree.json",
		"type" : "post",
		"dataType" : "json",
		"success" : function(response) {
			var result = response.result
			if (result == "SUCCESS") {
				layer.msg("操作成功")
				zNodes = response.data
				$.fn.zTree.init($("#treeDemo"), setting, zNodes)//3. 在页面初始化树形结构
			}
			if (result == "FAILED") {
				layer.msg("获取失败，" + response.message)
			}
		},
		"error" : function(response) {
			layer.msg(response.status + "，说明信息：" + response.statusText)
		}
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
						<ul id="treeDemo" class="ztree">
						
						
						
						
						
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
