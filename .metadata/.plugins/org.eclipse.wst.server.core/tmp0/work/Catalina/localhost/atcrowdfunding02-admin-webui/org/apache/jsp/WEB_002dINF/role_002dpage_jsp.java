/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.81
 * Generated at: 2022-09-02 08:27:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_002dpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/include-nav.jsp", Long.valueOf(1662010078965L));
    _jspx_dependants.put("/WEB-INF/modal-role-confirm.jsp", Long.valueOf(1662103928694L));
    _jspx_dependants.put("/WEB-INF/include-head.jsp", Long.valueOf(1662010004964L));
    _jspx_dependants.put("/WEB-INF/include-sidebar.jsp", Long.valueOf(1662084929121L));
    _jspx_dependants.put("/WEB-INF/modal-role-add.jsp", Long.valueOf(1662092458488L));
    _jspx_dependants.put("/WEB-INF/modal-role-edit.jsp", Long.valueOf(1662098325703L));
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
      out.write("<html lang=\"GB18030\">\r\n");
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
      out.write("<script type=\"text/javascript\" src=\"crowd/my-role.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	$(function() {\r\n");
      out.write("		// 1.分页的初始化数据\r\n");
      out.write("		window.pageNum = 1\r\n");
      out.write("		window.pageSize = 5\r\n");
      out.write("		window.keyword = \"\"\r\n");
      out.write("\r\n");
      out.write("		generatePage();//调用my-role.js的方法\r\n");
      out.write("\r\n");
      out.write("		//搜索功能\r\n");
      out.write("		$(\"#searchBtn\").click(function() {\r\n");
      out.write("			window.keyword = $(\"#keywordInput\").val()\r\n");
      out.write("			console.log(window.keyword)\r\n");
      out.write("			generatePage()\r\n");
      out.write("		})\r\n");
      out.write("\r\n");
      out.write("		//新增的模态框\r\n");
      out.write("		$(\"#showAddButton\").click(function() {\r\n");
      out.write("			$(\"#addModal\").modal(\"show\")//显示模态框\r\n");
      out.write("			$(\"#saveRole\").val(\"\")//清理模态框数据\r\n");
      out.write("			\r\n");
      out.write("			// 保存操作\r\n");
      out.write("			$(\"#saveRoleBtn\").click(function() {\r\n");
      out.write("				var roleName = $.trim($(\"#saveRole\").val())\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					\"url\" : \"role/save.json\",\r\n");
      out.write("					\"type\" : \"post\",\r\n");
      out.write("					\"data\" : {\r\n");
      out.write("						\"name\" : roleName\r\n");
      out.write("					},\r\n");
      out.write("					\"dataType\" : \"json\",\r\n");
      out.write("					\"success\" : function(response) {\r\n");
      out.write("						var result = response.result\r\n");
      out.write("						if (result == \"SUCCESS\") {\r\n");
      out.write("							layer.msg(\"操作成功\")\r\n");
      out.write("	\r\n");
      out.write("							window.pageNum = 9999//将页码定位到最后一页\r\n");
      out.write("							generatePage()//重新加载页面\r\n");
      out.write("						}\r\n");
      out.write("						if (result == \"FAILED\") {\r\n");
      out.write("							layer.msg(\"操作失败，\" + response.message)\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					\"error\" : function(response) {\r\n");
      out.write("						layer.msg(response.status + \"，说明信息：\" + response.statusText)\r\n");
      out.write("					}\r\n");
      out.write("				})\r\n");
      out.write("				$(\"#addModal\").modal(\"hide\")//关闭模态框\r\n");
      out.write("			})\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		//更新的模态框(动态生成的editButton翻页后事件会失效)\r\n");
      out.write("		//$(\".editRoleButton\").click(function() {			\r\n");
      out.write("		//})\r\n");
      out.write("		\r\n");
      out.write("		//更新的模态框——使用jquery\r\n");
      out.write("		$(\"#rolePageBody\").on(\"click\", \".editRoleButton\", function(){\r\n");
      out.write("			$(\"#editModal\").modal(\"show\")\r\n");
      out.write("			var roleName = $(this).parent().prev().text()\r\n");
      out.write("			var roleId = this.id\r\n");
      out.write("			$(\"#roleName\").val(roleName)//模态框回显数据\r\n");
      out.write("			//更新操作\r\n");
      out.write("			$(\"#updateRoleBtn\").click(function() {\r\n");
      out.write("				roleName = $.trim($(\"#roleName\").val())\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					\"url\" : \"role/update.json\",\r\n");
      out.write("					\"type\" : \"post\",\r\n");
      out.write("					\"data\" : {\r\n");
      out.write("						\"name\" : roleName,\r\n");
      out.write("						\"id\": roleId\r\n");
      out.write("					},\r\n");
      out.write("					\"dataType\" : \"json\",\r\n");
      out.write("					\"success\" : function(response) {\r\n");
      out.write("						var result = response.result\r\n");
      out.write("						if (result == \"SUCCESS\") {\r\n");
      out.write("							layer.msg(\"操作成功\")\r\n");
      out.write("	\r\n");
      out.write("							//window.keyword = roleName\r\n");
      out.write("							generatePage()//重新加载页面\r\n");
      out.write("						}\r\n");
      out.write("						if (result == \"FAILED\") {\r\n");
      out.write("							layer.msg(\"操作失败，\" + response.message)\r\n");
      out.write("						}\r\n");
      out.write("					},\r\n");
      out.write("					\"error\" : function(response) {\r\n");
      out.write("						layer.msg(response.status + \"，说明信息：\" + response.statusText)\r\n");
      out.write("					}\r\n");
      out.write("				})\r\n");
      out.write("				$(\"#editModal\").modal(\"hide\")//关闭模态框\r\n");
      out.write("			})\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		// 单个删除\r\n");
      out.write("		$(\"#rolePageBody\").on(\"click\", \".deleteRoleButton\", function(){\r\n");
      out.write("			\r\n");
      out.write("			var roleArray = [{\r\n");
      out.write("				roleId: this.id,\r\n");
      out.write("				roleName: $(this).parent().prev().text()\r\n");
      out.write("			}]\r\n");
      out.write("			showConfirmModal(roleArray)//打开删除的模态框\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		//批量删除\r\n");
      out.write("		$(\"#batchDeleteButton\").click(function(){\r\n");
      out.write("			\r\n");
      out.write("			var roleArray =[]\r\n");
      out.write("			\r\n");
      out.write("			$(\".itemBox:checked\").each(function(){\r\n");
      out.write("				var roleId  = this.id\r\n");
      out.write("				var roleName = $(this).parent().next().text()\r\n");
      out.write("				roleArray.push({\r\n");
      out.write("					\"roleId\": roleId,\r\n");
      out.write("					\"roleName\": roleName\r\n");
      out.write("				})\r\n");
      out.write("			})\r\n");
      out.write("			\r\n");
      out.write("			if(roleArray.length == 0){\r\n");
      out.write("				layer.msg(\"请至少选择一个要删除的数据\")\r\n");
      out.write("				return\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			showConfirmModal(roleArray)//打开删除的模态框\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		//删除时的确认按钮功能\r\n");
      out.write("		$(\"#batchDeleteBtn\").click(function(){\r\n");
      out.write("			\r\n");
      out.write("			var requestBody = JSON.stringify(window.roleIdArray)\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				\"url\" : \"role/remove/by/roleId/array.json\",\r\n");
      out.write("				\"type\" : \"post\",\r\n");
      out.write("				\"data\" : requestBody,\r\n");
      out.write("				\"contentType\": \"application/json;charset=UTF-8\",\r\n");
      out.write("				\"dataType\" : \"json\",\r\n");
      out.write("				\"success\" : function(response) {\r\n");
      out.write("					var result = response.result\r\n");
      out.write("					if (result == \"SUCCESS\") {\r\n");
      out.write("						layer.msg(\"操作成功\")\r\n");
      out.write("						generatePage()//重新加载页面\r\n");
      out.write("					}\r\n");
      out.write("					if (result == \"FAILED\") {\r\n");
      out.write("						layer.msg(\"操作失败，\" + response.message)\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				\"error\" : function(response) {\r\n");
      out.write("					layer.msg(response.status + \"，说明信息：\" + response.statusText)\r\n");
      out.write("				}\r\n");
      out.write("			})\r\n");
      out.write("			$(\"#confirmModal\").modal(\"hide\")\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		//全选全不选——总框够了则所有分框也勾了\r\n");
      out.write("		$(\"#selectAll\").click(function(){\r\n");
      out.write("			var currentStatus = this.checked\r\n");
      out.write("			$(\".itemBox\").prop(\"checked\", currentStatus)\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		//全选全不选——分框全勾了则总框也够了\r\n");
      out.write("		$(\"#rolePageBody\").on(\"click\", \".itemBox\", function(){\r\n");
      out.write("			var checkedBoxCount = $(\".itemBox:checked\").length\r\n");
      out.write("			var totalBoxCount = $(\".itemBox\").length\r\n");
      out.write("			$(\"#selectAll\").prop(\"checked\", checkedBoxCount == totalBoxCount)\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	})\r\n");
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
      out.write("					<li style=\"height: 30px;\"><a href=\"permission.html\"><i\r\n");
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
      out.write("						<form class=\"form-inline\" role=\"form\" style=\"float: left;\">\r\n");
      out.write("							<div class=\"form-group has-feedback\">\r\n");
      out.write("								<div class=\"input-group\">\r\n");
      out.write("									<div class=\"input-group-addon\">查询条件</div>\r\n");
      out.write("									<input id=\"keywordInput\" class=\"form-control has-success\"\r\n");
      out.write("										type=\"text\" value=\"\" placeholder=\"请输入查询条件\">\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<button id=\"searchBtn\" type=\"button\" class=\"btn btn-warning\">\r\n");
      out.write("								<i class=\"glyphicon glyphicon-search\"></i> 查询\r\n");
      out.write("							</button>\r\n");
      out.write("						</form>\r\n");
      out.write("						<button id=\"batchDeleteButton\" type=\"button\" class=\"btn btn-danger\"\r\n");
      out.write("							style=\"float: right; margin-left: 10px;\">\r\n");
      out.write("							<i class=\" glyphicon glyphicon-remove\"></i> 删除\r\n");
      out.write("						</button>\r\n");
      out.write("						<button id=\"showAddButton\" type=\"button\" class=\"btn btn-primary\"\r\n");
      out.write("							style=\"float: right;\">\r\n");
      out.write("							<i class=\"glyphicon glyphicon-plus\"></i> 新增\r\n");
      out.write("						</button>\r\n");
      out.write("						<br>\r\n");
      out.write("						<hr style=\"clear: both;\">\r\n");
      out.write("						<div class=\"table-responsive\">\r\n");
      out.write("							<table class=\"table  table-bordered\">\r\n");
      out.write("								<thead>\r\n");
      out.write("									<tr>\r\n");
      out.write("										<th width=\"30\">#</th>\r\n");
      out.write("										<th width=\"30\"><input id=\"selectAll\" type=\"checkbox\"></th>\r\n");
      out.write("										<th>名称</th>\r\n");
      out.write("										<th width=\"100\">操作</th>\r\n");
      out.write("									</tr>\r\n");
      out.write("								</thead>\r\n");
      out.write("								<tbody id=\"rolePageBody\">\r\n");
      out.write("								</tbody>\r\n");
      out.write("								<tfoot>\r\n");
      out.write("									<!--\r\n");
      out.write("									<tr>\r\n");
      out.write("										<td colspan=\"6\" align=\"center\">\r\n");
      out.write("											<ul class=\"pagination\">\r\n");
      out.write("												<li class=\"disabled\"><a href=\"#\">上一页</a></li>\r\n");
      out.write("												<li class=\"active\"><a href=\"#\">1 <span\r\n");
      out.write("														class=\"sr-only\">(current)</span></a></li>\r\n");
      out.write("												<li><a href=\"#\">2</a></li>\r\n");
      out.write("												<li><a href=\"#\">3</a></li>\r\n");
      out.write("												<li><a href=\"#\">4</a></li>\r\n");
      out.write("												<li><a href=\"#\">5</a></li>\r\n");
      out.write("												<li><a href=\"#\">下一页</a></li>\r\n");
      out.write("											</ul>\r\n");
      out.write("										</td>\r\n");
      out.write("									</tr>\r\n");
      out.write("									-->\r\n");
      out.write("									<tr>\r\n");
      out.write("										<td colspan=\"4\" align=\"center\">\r\n");
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
      out.write("	");
      out.write("\r\n");
      out.write("<div id=\"addModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("	<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("		<div class=\"modal-content\">\r\n");
      out.write("			<div class=\"modal-header\">\r\n");
      out.write("				<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("					<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("				</button>\r\n");
      out.write("				<h4 class=\"modal-title\">新增角色</h4>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-body\">\r\n");
      out.write("				<form class=\"form-signin\" role=\"form\">\r\n");
      out.write("					<div class=\"form-group has-success has-feedback\">\r\n");
      out.write("						<input type=\"text\" name=\"roleName\" class=\"form-control\"\r\n");
      out.write("							id=\"saveRole\" placeholder=\"请输入角色名称\" autofocus>\r\n");
      out.write("					</div>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-footer\">\r\n");
      out.write("				<button id=\"saveRoleBtn\" type=\"button\" class=\"btn btn-primary\">保 存</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<div id=\"editModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("	<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("		<div class=\"modal-content\">\r\n");
      out.write("			<div class=\"modal-header\">\r\n");
      out.write("				<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n");
      out.write("					aria-label=\"Close\">\r\n");
      out.write("					<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("				</button>\r\n");
      out.write("				<h4 class=\"modal-title\">修改角色</h4>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-body\">\r\n");
      out.write("				<form class=\"form-signin\" role=\"form\">\r\n");
      out.write("					<div class=\"form-group has-success has-feedback\">\r\n");
      out.write("						<input type=\"text\" id=\"roleName\" name=\"roleName\" class=\"form-control\"\r\n");
      out.write("							placeholder=\"请输入角色名称\" autofocus>\r\n");
      out.write("					</div>\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-footer\">\r\n");
      out.write("				<button id=\"updateRoleBtn\" type=\"button\" class=\"btn btn-success\">更新\r\n");
      out.write("				</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("<div id=\"confirmModal\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("	<div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("		<div class=\"modal-content\">\r\n");
      out.write("			<div class=\"modal-header\">\r\n");
      out.write("				<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("					<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("				</button>\r\n");
      out.write("				<h4 class=\"modal-title\">请确认是否删除下列角色：</h4>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-body\">\r\n");
      out.write("				<span id=\"roleNameSpan\"></span>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"modal-footer\">\r\n");
      out.write("				<button id=\"batchDeleteBtn\" type=\"button\" class=\"btn btn-primary\">取确认删除</button>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
