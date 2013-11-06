package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tache_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head> \n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"resources/css/jquery/ui-lightness/jquery-ui-1.8.6.custom.css\" />\n");
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"resources/css/jqgrid/ui.jqgrid.css\" />\n");
      out.write(" <script type=\"text/javascript\" src=\"resources/js/jquery/jquery-1.4.4.min.js\"></script>\n");
      out.write(" <script type=\"text/javascript\" src=\"resources/js/jquery/jquery-ui-1.8.6.custom.min.js\"></script> \n");
      out.write(" <script type=\"text/javascript\" src=\"resources/js/jqgrid/grid.locale-en.js\" ></script>\n");
      out.write(" <script type=\"text/javascript\" src=\"resources/js/jqgrid/jquery.jqGrid.min.js\"></script>\n");
      out.write("\n");
      out.write("<script src=\"resources/js/jqgrid_tache.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- Aller Ã  la gestion des tÃ¢ches -->\n");
      out.write("\t<a href=\"./taches\" class=\"rLink\" tabindex=\"3\">Go to timesheet</a></label><label>\n");
      out.write("\n");
      out.write("\t<!-- Affichage de toutes les tÃ¢ches et de leur gestion-->\n");
      out.write("\t<div id=\"jqgrid\">\n");
      out.write(" <table id=\"grid\"></table>\n");
      out.write(" <div id=\"pager\"></div>\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("</div>\n");
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
