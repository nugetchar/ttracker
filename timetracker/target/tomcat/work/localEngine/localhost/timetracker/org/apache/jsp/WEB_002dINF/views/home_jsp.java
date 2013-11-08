package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n");
      out.write("  \"http://www.w3.org/TR/html4/strict.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\"\n");
      out.write("\thref=\"resources/css/jquery/ui-lightness/jquery-ui-1.8.6.custom.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\"\n");
      out.write("\thref=\"resources/css/jqgrid/ui.jqgrid.css\" />\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"resources/js/jquery/jquery-1.4.4.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"resources/js/jquery/jquery-ui-1.8.6.custom.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"resources/js/jqgrid/grid.locale-en.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"resources/js/jqgrid/jquery.jqGrid.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"resources/css/structure.css\" />\n");
      out.write("\n");
      out.write("<script src=\"resources/js/jqgrid_timesheet.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"resources/js/script_print_pdf.js\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<a href=\"./taches\" class=\"rLink\">Go to task management</a>\n");
      out.write("\t<br />\n");
      out.write("\t<a href=\"./affectations\" class=\"rLink\">Go to affectation management</a>\n");
      out.write("\t<!-- Affichage de la feuille de temps-->\n");
      out.write("\t<div id=\"jqgrid\">\n");
      out.write("\t\t<table id=\"grid\"></table>\n");
      out.write("\t\t<div id=\"pager\"></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div id=\"print\">\n");
      out.write("\t\t<input type=\"button\" class=\"btnLogin\" value=\"Print PDF\" tabindex=\"5\">\n");
      out.write("\t</div>\n");
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
