/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-29 15:39:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Transaction_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Transaction Page</title>\r\n");
      out.write("<style>\r\n");
      out.write("\tbody{\r\n");
      out.write("\tbackground-color : rgba(0,0,0,0.2);\r\n");
      out.write("\tfont-family : verdana;\r\n");
      out.write("\tcolor : white;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\theader {\r\n");
      out.write("\twidth : 100 %;\r\n");
      out.write("\tbackground-color : grey;\r\n");
      out.write("\tcolor : white;\r\n");
      out.write("\tborder-radius : 20px;\r\n");
      out.write("\tpadding : 15px;\r\n");
      out.write("\ttext-align : center;\r\n");
      out.write("}\r\n");
      out.write("\tsection{\r\n");
      out.write("\tbackground-color : rgba(0,0,0,0.5);\r\n");
      out.write("\twidth : 40%;\r\n");
      out.write("\theight :420px;\r\n");
      out.write("\tmargin-left : 30%;\r\n");
      out.write("\tpadding : 4px;\r\n");
      out.write("\tborder : 2px solid black;\r\n");
      out.write("\tborder-radius : 20px;\r\n");
      out.write("\tbox-shadow : 10px 10px 8px 10px #888888;\r\n");
      out.write("\tfont-size : 20px;\r\n");
      out.write("\ttext-align : center;\r\n");
      out.write("}\r\n");
      out.write("#sender, #receiver,#amount{\r\n");
      out.write("\theight : 40px;\r\n");
      out.write("\twidth : 90%;\r\n");
      out.write("\ttext-align : center;\r\n");
      out.write("\tfont-size : 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".head{\r\n");
      out.write("\tfont-size : 30px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("section form label {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#submit{\r\n");
      out.write(" \twidth : 50%;\r\n");
      out.write(" \tmargin-left :8%;\r\n");
      out.write("\t height : 50px;\r\n");
      out.write(" \tbackground-color:green;\r\n");
      out.write(" \tborder : 2px solid black;\r\n");
      out.write(" \tborder-radius : 20px;\r\n");
      out.write(" \tcolor : white;\r\n");
      out.write(" \tfont-size : 25px;\r\n");
      out.write(" \ttext-align : center;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t#error{\r\n");
      out.write("\tfont-size : 20px;\r\n");
      out.write("\ttext-align : center;\r\n");
      out.write("\tcolor : red;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\t\t<h1>Transaction Processing Window</h1>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("<section>\r\n");
      out.write("\t<div class = \"head\">Transaction Script</div>\r\n");
      out.write("\t<hr />\r\n");
      out.write("\t<form action = \"/transaction.bnk\" method = \"Post\">\r\n");
      out.write("\t<label for = \"sender\">From: <input type = \"text\" name = \"sender\" id = \"sender\" placeholder = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" value = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" readonly = \"readonly\" /></label>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t\r\n");
      out.write("\t<label for = \"receiver\">Receiver </label>\r\n");
      out.write("\t<select name = \"receiver\" id = \"receiver\">\r\n");
      out.write("\t<option value = \"UserName1\">UserName1</option>\r\n");
      out.write("\t<option value = \"UserName2\">UserName2</option>\r\n");
      out.write("\t<option value = \"UserName4\">UserName4</option>\r\n");
      out.write("\t<option value = \"UserName5\">UserName5</option>\r\n");
      out.write("\t<option value = \"UserName6\">UserName6</option>\r\n");
      out.write("\t\r\n");
      out.write("\t</select>\r\n");
      out.write("\t\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t\r\n");
      out.write("\t<label for = \"amount\">Amount: <input type = \"number\" name = \"amount\" id = \"amount\" placeholder = 0 min = \"100\" max = \"5000\" /></label>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<input id = \"submit\" type = \"submit\"  value = \"Send Money\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t</form>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<br />\r\n");
      out.write("<div id=\"error\"><p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ErrorMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<a href = \"/userpage.bnk\">Go Back to User Page</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}