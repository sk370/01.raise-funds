/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.81
 * Generated at: 2022-09-02 10:33:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002dmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/include-nav.jsp", Long.valueOf(1662010078965L));
    _jspx_dependants.put("/WEB-INF/include-head.jsp", Long.valueOf(1662010004964L));
    _jspx_dependants.put("/WEB-INF/include-sidebar.jsp", Long.valueOf(1662114763637L));
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
  }

  public void _jspDestroy() {
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
      out.write("				<h1 class=\"page-header\">控制面板</h1>\r\n");
      out.write("				<div class=\"row placeholders\">\r\n");
      out.write("					<div class=\"col-xs-6 col-sm-3 placeholder\">\r\n");
      out.write("						<img data-src=\"holder.js/200x200/auto/sky\" class=\"img-responsive\"\r\n");
      out.write("							alt=\"Generic placeholder thumbnail\">\r\n");
      out.write("						<h4>Label</h4>\r\n");
      out.write("						<span class=\"text-muted\">Something else</span>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-xs-6 col-sm-3 placeholder\">\r\n");
      out.write("						<img data-src=\"holder.js/200x200/auto/vine\" class=\"img-responsive\"\r\n");
      out.write("							alt=\"Generic placeholder thumbnail\">\r\n");
      out.write("						<h4>Label</h4>\r\n");
      out.write("						<span class=\"text-muted\">Something else</span>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-xs-6 col-sm-3 placeholder\">\r\n");
      out.write("						<img data-src=\"holder.js/200x200/auto/sky\" class=\"img-responsive\"\r\n");
      out.write("							alt=\"Generic placeholder thumbnail\">\r\n");
      out.write("						<h4>Label</h4>\r\n");
      out.write("						<span class=\"text-muted\">Something else</span>\r\n");
      out.write("					</div>\r\n");
      out.write("					<div class=\"col-xs-6 col-sm-3 placeholder\">\r\n");
      out.write("						<img data-src=\"holder.js/200x200/auto/vine\" class=\"img-responsive\"\r\n");
      out.write("							alt=\"Generic placeholder thumbnail\">\r\n");
      out.write("						<h4>Label</h4>\r\n");
      out.write("						<span class=\"text-muted\">Something else</span>\r\n");
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
}
