/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.81
 * Generated at: 2022-09-02 10:54:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002dpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/include-nav.jsp", Long.valueOf(1662010078965L));
    _jspx_dependants.put("/WEB-INF/include-head.jsp", Long.valueOf(1662010004964L));
    _jspx_dependants.put("/WEB-INF/include-sidebar.jsp", Long.valueOf(1662114763637L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1659432110219L));
    _jspx_dependants.put("jar:file:/D:/PracticalExercise/99.Practise/01.raise-funds/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/aicrowdfunding02-admin-webui/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<base\r\n");
      out.write("	href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.scheme }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(':');
      out.write('/');
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.serverName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(':');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.serverPort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("<style>\r\n");
      out.write(".tree li {\r\n");
      out.write("	list-style-type: none;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-closed {\r\n");
      out.write("	height: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-expanded {\r\n");
      out.write("	height: auto;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"jquery/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"script/docs.min.js\"></script>\r\n");
      out.write("<script src=\"layer/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function() {\r\n");
      out.write("		$(\".list-group-item\").click(function() {\r\n");
      out.write("			if ($(this).find(\"ul\")) {\r\n");
      out.write("				$(this).toggleClass(\"tree-closed\");\r\n");
      out.write("				if ($(this).hasClass(\"tree-closed\")) {\r\n");
      out.write("					$(\"ul\", this).hide(\"fast\");\r\n");
      out.write("				} else {\r\n");
      out.write("					$(\"ul\", this).show(\"fast\");\r\n");
      out.write("				}\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/pagination.css\" />\r\n");
      out.write("<script src=\"jquery/jquery.pagination.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function(){\r\n");
      out.write("		// 调用专门的函数初始化分页导航条\r\n");
      out.write("		initPagination();\r\n");
      out.write("	});\r\n");
      out.write("	// 声明一个函数用于初始化 Pagination\r\n");
      out.write("	function initPagination() {\r\n");
      out.write("		// 总记录数\r\n");
      out.write("		var totalRecord = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.pageInfo.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("		// 声明 Pagination 的属性\r\n");
      out.write("		var properties = {\r\n");
      out.write("			num_edge_entries: 3, // 边缘页数\r\n");
      out.write("			num_display_entries: 3, // 主体页数\r\n");
      out.write("			callback: pageSelectCallback, // 点击“翻页”按钮之后的操作\r\n");
      out.write("			current_page: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.pageInfo.pageNum-1}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(", // 当前页，该js插件页数从0开始，pageNum 从1开始，必须-1后才可以赋值\r\n");
      out.write("			prev_text: \"上一页\",\r\n");
      out.write("			next_text: \"下一页\",\r\n");
      out.write("			items_per_page:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.pageInfo.pageSize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" // 每页显示多少条\r\n");
      out.write("		};\r\n");
      out.write("		\r\n");
      out.write("		// 生成导航条\r\n");
      out.write("		$(\"#Pagination\").pagination(totalRecord, properties);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// pageIndex 是用户在页面上点击的页码数值\r\n");
      out.write("	function pageSelectCallback(pageIndex, jQuery) {\r\n");
      out.write("		// pageIndex 是当前页页码的索引，相对于 pageNum 来说， pageIndex 比 pageNum 小 1\r\n");
      out.write("		var pageNum = pageIndex + 1;\r\n");
      out.write("		// 执行页面跳转也就是实现“翻页”\r\n");
      out.write("		window.location.href = \"admin/get/page.html?pageNum=\"+pageNum + \"&keyword=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.keyword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" ;\r\n");
      out.write("		// 取消当前超链接的默认行为\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<div class=\"navbar-header\">\r\n");
      out.write("			<div>\r\n");
      out.write("				<a class=\"navbar-brand\" style=\"font-size: 32px;\" href=\"#\">众筹平台 -\r\n");
      out.write("					控制面板</a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li style=\"padding-top: 8px;\">\r\n");
      out.write("					<div class=\"btn-group\">\r\n");
      out.write("						<button type=\"button\"\r\n");
      out.write("							class=\"btn btn-default btn-success dropdown-toggle\"\r\n");
      out.write("							data-toggle=\"dropdown\">\r\n");
      out.write("							<i class=\"glyphicon glyphicon-user\"></i>\r\n");
      out.write("							");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginAdmin.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" <span class=\"caret\"></span>\r\n");
      out.write("						</button>\r\n");
      out.write("						<ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("							<li><a href=\"#\"><i class=\"glyphicon glyphicon-cog\"></i>\r\n");
      out.write("									个人设置</a></li>\r\n");
      out.write("							<li><a href=\"#\"><i class=\"glyphicon glyphicon-comment\"></i>\r\n");
      out.write("									消息</a></li>\r\n");
      out.write("							<li class=\"divider\"></li>\r\n");
      out.write("							<li><a href=\"admin/to/login/page.html\"><i\r\n");
      out.write("									class=\"glyphicon glyphicon-off\"></i> 退出系统</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</div>\r\n");
      out.write("				</li>\r\n");
      out.write("				<li style=\"margin-left: 10px; padding-top: 8px;\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-default btn-danger\">\r\n");
      out.write("						<span class=\"glyphicon glyphicon-question-sign\"></span> 帮助\r\n");
      out.write("					</button>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			<form class=\"navbar-form navbar-right\">\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" placeholder=\"查询\">\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("	<div class=\"container-fluid\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("<div class=\"col-sm-3 col-md-2 sidebar\">\r\n");
      out.write("	<div class=\"tree\">\r\n");
      out.write("		<ul style=\"padding-left: 0px;\" class=\"list-group\">\r\n");
      out.write("			<li class=\"list-group-item tree-closed\"><a href=\"main.html\"><i\r\n");
      out.write("					class=\"glyphicon glyphicon-dashboard\"></i> 控制面板</a></li>\r\n");
      out.write("			<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("					class=\"glyphicon glyphicon glyphicon-tasks\"></i> 权限管理 <span\r\n");
      out.write("					class=\"badge\" style=\"float: right\">3</span></span>\r\n");
      out.write("				<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"admin/get/page.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-user\"></i> 用户维护</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"role/to/main/page.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-king\"></i> 角色维护</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"menu/to/page.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-lock\"></i> 菜单维护</a></li>\r\n");
      out.write("				</ul></li>\r\n");
      out.write("			<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("					class=\"glyphicon glyphicon-ok\"></i> 业务审核 <span class=\"badge\"\r\n");
      out.write("					style=\"float: right\">3</span></span>\r\n");
      out.write("				<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"auth_cert.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-check\"></i> 实名认证审核</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"auth_adv.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-check\"></i> 广告审核</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"auth_project.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-check\"></i> 项目审核</a></li>\r\n");
      out.write("				</ul></li>\r\n");
      out.write("			<li class=\"list-group-item tree-closed\"><span><i\r\n");
      out.write("					class=\"glyphicon glyphicon-th-large\"></i> 业务管理 <span class=\"badge\"\r\n");
      out.write("					style=\"float: right\">7</span></span>\r\n");
      out.write("				<ul style=\"margin-top: 10px; display: none;\">\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"cert.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-picture\"></i> 资质维护</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"type.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-equalizer\"></i> 分类管理</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"process.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-random\"></i> 流程管理</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"advertisement.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-hdd\"></i> 广告管理</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"message.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-comment\"></i> 消息模板</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"project_type.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-list\"></i> 项目分类</a></li>\r\n");
      out.write("					<li style=\"height: 30px;\"><a href=\"tag.html\"><i\r\n");
      out.write("							class=\"glyphicon glyphicon-tags\"></i> 项目标签</a></li>\r\n");
      out.write("				</ul></li>\r\n");
      out.write("			<li class=\"list-group-item tree-closed\"><a href=\"param.html\"><i\r\n");
      out.write("					class=\"glyphicon glyphicon-list-alt\"></i> 参数管理</a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("			<div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\r\n");
      out.write("				<div class=\"panel panel-default\">\r\n");
      out.write("					<div class=\"panel-heading\">\r\n");
      out.write("						<h3 class=\"panel-title\">\r\n");
      out.write("							<i class=\"glyphicon glyphicon-th\"></i> 数据列表\r\n");
      out.write("						</h3>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"panel-body\">\r\n");
      out.write("						<form action=\"admin/get/page.html\" method=\"post\" class=\"form-inline\" role=\"form\" style=\"float: left;\">\r\n");
      out.write("							<div class=\"form-group has-feedback\">\r\n");
      out.write("								<div class=\"input-group\">\r\n");
      out.write("									<div class=\"input-group-addon\">查询条件</div>\r\n");
      out.write("									<input class=\"form-control has-success\" type=\"text\" name=\"keyword\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.keyword }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"请输入名称/邮箱任一条件\">\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<button type=\"submit\" class=\"btn btn-warning\">\r\n");
      out.write("								<i class=\"glyphicon glyphicon-search\"></i> 查询\r\n");
      out.write("							</button>\r\n");
      out.write("						</form>\r\n");
      out.write("						<button type=\"button\" class=\"btn btn-danger\"\r\n");
      out.write("							style=\"float: right; margin-left: 10px;\">\r\n");
      out.write("							<i class=\" glyphicon glyphicon-remove\"></i> 删除\r\n");
      out.write("						</button>\r\n");
      out.write("						<a type=\"button\" class=\"btn btn-primary\"\r\n");
      out.write("							style=\"float: right;\" href=\"admin/to/add/page.html\">\r\n");
      out.write("							<i class=\"glyphicon glyphicon-plus\"></i> 新增\r\n");
      out.write("						</a>\r\n");
      out.write("						<br>\r\n");
      out.write("						<hr style=\"clear: both;\">\r\n");
      out.write("						<div class=\"table-responsive\">\r\n");
      out.write("							<table class=\"table  table-bordered\">\r\n");
      out.write("								<thead>\r\n");
      out.write("									<tr>\r\n");
      out.write("										<th width=\"30\">#</th>\r\n");
      out.write("										<th width=\"30\"><input type=\"checkbox\"></th>\r\n");
      out.write("										<th>账号</th>\r\n");
      out.write("										<th>名称</th>\r\n");
      out.write("										<th>邮箱地址</th>\r\n");
      out.write("										<th width=\"100\">操作</th>\r\n");
      out.write("									</tr>\r\n");
      out.write("								</thead>\r\n");
      out.write("								<tbody>\r\n");
      out.write("									");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("									");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("								</tbody>\r\n");
      out.write("								<tfoot>\r\n");
      out.write("									<tr>\r\n");
      out.write("										<td colspan=\"6\" align=\"center\">\r\n");
      out.write("											<div id=\"Pagination\" class=\"pagination\"></div>\r\n");
      out.write("										</td>\r\n");
      out.write("									</tr>\r\n");
      out.write("								</tfoot>\r\n");
      out.write("							</table>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/admin-page.jsp(90,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty requestScope.pageInfo.list }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("										<tr>\r\n");
          out.write("											<td colspan=\"6\" align=\"center\">抱歉，!没有查到您要的数据！</td>\r\n");
          out.write("										</tr>\r\n");
          out.write("									");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /WEB-INF/admin-page.jsp(96,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty requestScope.pageInfo.list }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("										");
          if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("									");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /WEB-INF/admin-page.jsp(97,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/admin-page.jsp(97,10) '${requestScope.pageInfo.list }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${requestScope.pageInfo.list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/admin-page.jsp(97,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("admin");
      // /WEB-INF/admin-page.jsp(97,10) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVarStatus("myStatus");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("											<tr>\r\n");
            out.write("												<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${myStatus.count }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("												<td><input type=\"checkbox\"></td>\r\n");
            out.write("												<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.loginAcct }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("												<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("												<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("												<td>\r\n");
            out.write("													<a href=\"\" class=\"btn btn-success btn-xs\">\r\n");
            out.write("														<i class=\" glyphicon glyphicon-check\"></i>\r\n");
            out.write("													</a>\r\n");
            out.write("													<a href=\"admin/to/edit/page.html?adminId=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("&pageNum=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.pageInfo.pageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("&keyword=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.keyword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" type=\"button\" class=\"btn btn-primary btn-xs\">\r\n");
            out.write("														<i class=\" glyphicon glyphicon-pencil\"></i>\r\n");
            out.write("													</a>\r\n");
            out.write("													<!-- 这里不能使用param.pageNum，因为第一页、查询页码只有1一页展示的时候路径没有pageNum参数 -->\r\n");
            out.write("													<a href=\"admin/remove/");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('/');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.pageInfo.pageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('/');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.keyword}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(".html\" type=\"button\" class=\"btn btn-danger btn-xs\">\r\n");
            out.write("														<i class=\" glyphicon glyphicon-remove\"></i>\r\n");
            out.write("													</a>\r\n");
            out.write("												</td>\r\n");
            out.write("											</tr>\r\n");
            out.write("										");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}