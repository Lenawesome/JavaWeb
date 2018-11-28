package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.NovelDao;
import model.Novel;

public final class category_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> Trang chủ </title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"top\">\n");
      out.write("            <div id=\"mix-menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/Control?page=home\">Trang chủ</a></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Thể loại</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"#\">Kiếm hiệp</a></li>\n");
      out.write("                            <li><a href=\"#\">Tiên hiệp</a></li>\n");
      out.write("                            <li><a href=\"#\">Hài hước</a></li>\n");
      out.write("                            <li><a href=\"#\">Truyện ma</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Thành viên</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/Control?page=login\">Đăng nhập</a></li>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/Control?page=register\">Đăng ký</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"search-form\">\n");
      out.write("                    <input id=\"search-box-input\" type=\"text\" placeholder=\"Tìm truyện, tác giả...\">\n");
      out.write("                    <select id=\"dropdown-list\">\n");
      out.write("                        <option value=\"Tác giả\">Tác giả</option>\n");
      out.write("                        <option value=\"Tên Truyện\">Tên Truyện</option>\n");
      out.write("                    </select>\n");
      out.write("                    <button id=\"search-box-button\" >Search</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div id=\"main2-wraper\">\n");
      out.write("                <div id=\"left\">\n");
      out.write("                    <div id=\"finished-book-list\">\n");
      out.write("                        <div class=\"title-list\"><a href=\"\">Truyện ");
      out.print(request.getAttribute("category") );
      out.write(" </a></div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"list\">\n");
      out.write("                            <div class=\"item-top-2\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <img src=\"./images/Linh Vũ Thiên Hạ.jpg\" class=\"img-reponsive\" alt=\"Linh Vũ Thiên Hạ\">\n");
      out.write("                                    <div class=\"book-name\">Linh vũ thiên hạ</div>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"right\">\n");
      out.write("                    <div class=\"title-list\">Thể loại</div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Kiếm hiệp</a></li>\n");
      out.write("                        <li><a href=\"#\">Tiên hiệp</a></li>\n");
      out.write("                        <li><a href=\"#\">Hài hước</a></li>\n");
      out.write("                        <li><a href=\"#\">Truyện ma</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <div id=\"footer-data\">\n");
      out.write("                <a href=\"#top\">@2018 By Team 5</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
