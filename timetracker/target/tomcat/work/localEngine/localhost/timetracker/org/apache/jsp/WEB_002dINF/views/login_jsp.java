package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n");
      out.write("  \"http://www.w3.org/TR/html4/strict.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/reset.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/structure.css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form class=\"box login\" action=\"./login\" method=\"GET\">\n");
      out.write("\t<fieldset class=\"boxBody\">\n");
      out.write("\t  <label>Username</label>\n");
      out.write("\t  <input type=\"text\" id=\"login\" name=\"login\" tabindex=\"1\" placeholder=\"Login\" required>\n");
      out.write("\t  <label>Password</label>\n");
      out.write("\t  <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" tabindex=\"2\" required>\n");
      out.write("\t</fieldset>\n");
      out.write("\t<footer>\n");
      out.write("\t\t<label><a href=\"./taches\" class=\"rLink\" tabindex=\"3\">Go to task management</a><br/>\n");
      out.write("\t\t<a href=\"./affectations\" class=\"rLink\" tabindex=\"4\">Go to affectation management</a></label><label></label>\n");
      out.write("\t  <input type=\"submit\" class=\"btnLogin\" value=\"Login\" tabindex=\"5\">\n");
      out.write("\t</footer>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
