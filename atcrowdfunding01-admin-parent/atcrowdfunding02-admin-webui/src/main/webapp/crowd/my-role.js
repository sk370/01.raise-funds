/**
 * 配合ajax请求展示分页数据，以及显示删除模态框
 */
 
 window.roleIdArray = [];
 
// 生成分页
function generatePage() {
	var pageInfo = getPageIfoRemote();//获取数据
	fillTableBody(pageInfo);//填充表格
}

// 获取后台数据
function getPageIfoRemote() {
	var ajaxResult = $.ajax({
		"url": "role/get/page/info.json",
		"type": "post",
		"data": {
			//这样的数据格式还是form表单形式
			"pageNum": window.pageNum,
			"pageSize": window.pageSize,
			"keyword": window.keyword
		},
		"async": false,
		"dataType": "json"
	})
	console.log(ajaxResult)
	var statusCode = ajaxResult.status

	if (statusCode != 200) {
		layer.msg("服务器端程序调用失败，响应状态码=" + statusCode + "，说明信息：" + ajaxResult.statusText)
		return null
	}

	var resultEntity = ajaxResult.responseJSON

	var result = resultEntity.result//判断后台封装的ResultEntity实体类对象的信息

	if (result == "FAILD") {
		layer.msg(resultEntity.message)//message是ResultEntity封装的数据
		return null
	}

	var pageInfo = resultEntity.data

	return pageInfo
}

// 用后台数据填充表格
function fillTableBody(pageInfo) {
	
	$("#rolePageBody").empty()
	$("Pagination").empty()//无检索数据不显示导航条
	
	if (pageInfo == null || pageInfo == undefined || pageInfo.list == null || pageInfo.list.length == 0) {
		$("#rolePageBody").append("<tr><td colspan='4' align='center'>抱歉，当前无相应数据！</td></tr>")
		return
	}

	var tr = ""
	for (var i = 0; i < pageInfo.list.length; i++) {
		var role = pageInfo.list[i]
		var roleId = role.id
		var roleName = role.name
		var numberId = i + 1

		tr += `
			<tr>
				<td>${numberId}</td>
				<td><input id=${roleId} class="itemBox" type="checkbox"></td>
				<td>${roleName}</td>
				<td>
					<button type="button" class="btn btn-success btn-xs">
						<i class=" glyphicon glyphicon-check"></i>
					</button>
					<button id=${roleId} type="button" class="btn btn-primary btn-xs editRoleButton">
						<i class=" glyphicon glyphicon-pencil deleteRoleButton"></i>
					</button>
					<button id=${roleId} type="button" class="btn btn-danger btn-xs deleteRoleButton">
						<i class=" glyphicon glyphicon-remove"></i>
					</button>
				</td>
			</tr>
		`
	}
	$("#rolePageBody").append(tr)

	//初始化分页条
	generateNavigator(pageInfo)
}
// 用后台数据填充分页条
function generateNavigator(pageInfo) {
	// 总记录数	
	var totalRecord = pageInfo.total
	// 声明 Pagination 的属性
	var properties = {
		num_edge_entries: 3, // 边缘页数
		num_display_entries: 3, // 主体页数
		callback: paginationCallBack, // 点击“翻页”按钮之后的操作
		current_page: pageInfo.pageNum - 1, // 当前页，该js插件页数从0开始，pageNum 从1开始，必须-1后才可以赋值
		prev_text: "上一页",
		next_text: "下一页",
		items_per_page: pageInfo.pageSize // 每页显示多少条
	};
	
	// 方法生成导航条
	$("#Pagination").pagination(totalRecord, properties);
}

// 执行翻页
function paginationCallBack(pageIndex, jQuery) {
	window.pageNum = pageIndex + 1
	generatePage()//调用role-page.js的方法
	$("#selectAll").prop("checked", false)
	return false
}


// 删除的模态框
function showConfirmModal(roleArray){
	
	$("roleNameSpan").empty()
	
	$("#confirmModal").modal("show")
	
	for(var i = 0; i < roleArray.length; i++){
		var role = roleArray[i]
		var roleName = role.roleName
		var roleId = role.roleId
		window.roleIdArray.push(roleId)
		
		$("#roleNameSpan").append(roleName)
	}
}