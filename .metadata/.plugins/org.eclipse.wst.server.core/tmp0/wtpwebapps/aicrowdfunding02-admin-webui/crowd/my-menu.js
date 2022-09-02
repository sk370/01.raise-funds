/**
 * 给ztree生成的树形结构，更换图标
 */
// treeId 树形结构的根结点
// treeNode 当前正在生成的节点
function myAddDom(treeId, treeNode) {
	console.log(treeId)
	console.log(treeNode)
	//class="glyphicon-check"
	var spanId = treeNode.tId + "_ico"// 获取ztree的图标id

	$("#" + spanId)
		.removeClass()//移除默认的class
		.addClass(treeNode.icon)//更换为数据库的图标
}
//鼠标移入显示操作图标
function myAddHoverDom(treeId, treeNode) {
	var btnGroupId = treeNode.tId + "_btnGrp"//hover后出现元素的根节点id
	var aId = treeNode.tId + "_a"// 获取生成的树形菜单的a标签id
	
	if($("#" + btnGroupId).length > 0){//防止添加多个span
		return;
	}
	
	// 3种按钮的 HTML 标签
	var addBtn = `
		<a id=${treeNode.id} class="btn btn-info dropdown-toggle btn-xs" style="margin-left:6px;padding-top:0px;padding:0 4px;" href="#" title="添加子节点">
			<i class="fa fa-fw fa-plus rbg"></i>
		</a>
	`
	
	var removeBtn = `
		<a id=${treeNode.id} class="btn btn-info dropdown-toggle btn-xs" style="margin-left:6px;padding-top:0px;padding:0 4px;" href="#" title="移除节点">
			<i class="fa fa-fw fa-times rbg"></i>
		</a>
	`
	
	var editBtn = `
		<a id=${treeNode.id} class="btn btn-info dropdown-toggle btn-xs" style="margin-left:6px;padding-top:0px;padding:0 4px;" href="#" title="修改节点">
			<i class="fa fa-fw fa-edit rbg"></i>
		</a>
	`
	var span = "";
	
	var level = treeNode.level
	
	if(level == 0){
		span = addBtn
	}
	if(level == 1){
		span = addBtn + "\n" + editBtn
		var length = treeNode.children.length
		if(length != 0){
			span += "\n" + removeBtn
		}
	}
	if(level == 2){
		span = editBtn + "\n" + removeBtn
	}
	
	$("#" + aId).after(`<span id=${btnGroupId}>${span}</span>`)
}
//鼠标移除隐藏操作图标
function myRemoveHoverDom(treeId, treeNode) {
	
	var btnGroupId = treeNode.tId + "_btnGrp"//hover后出现元素的根节点id
	$("#" + btnGroupId).remove();//移除当前节点

}