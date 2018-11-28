package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.NovelDao;
import model.Novel;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=kiem-hiep\">Kiếm hiệp</a></li>\n");
      out.write("                            \n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=tien-hiep\">Tiên hiệp</a></li>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=hai-huoc\">Hài hước</a></li>\n");
      out.write("                            <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=truyen-ma\">Truyện ma</a></li>\n");
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
      out.write("                <form class=\"search-form\" action=\"/tim-kiem\" method=\"get\">\n");
      out.write("                    <input name=\"search-input\"required id=\"search-box-input\" type=\"text\" placeholder=\"Tìm truyện, tác giả...\">\n");
      out.write("                    <select name=\"option-input\"id=\"dropdown-list\">\n");
      out.write("                        <option value=\"Tác giả\">Tác giả</option>\n");
      out.write("                        <option value=\"Tên Truyện\">Tên Truyện</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input id=\"submit-button\" type=\"submit\" value=\"Search\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"main-content\">\n");
      out.write("            <div id=\"section-1\">\n");
      out.write("                <div class=\"title-list\"><a href=\"#\">Truyện hot</a></div>\n");
      out.write("                <div class=\"list\">\n");
      out.write("                     ");

                        NovelDao novelDao = new NovelDao();
                        List<Novel> novels = novelDao.listNovel();
                        for(int i=0; i < 12;i++){
                            
                    
      out.write("\n");
      out.write("                    <div class=\"item\">\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath() );
      out.write("/Control?page=view-info&id=");
      out.print(novels.get(i).getId());
      out.write("\">\n");
      out.write("                            <img src=");
      out.print(novels.get(i).getImgLink());
      out.write(" class=\"img-reponsive\" alt=\"");
      out.print(novels.get(i).getName());
      out.write("\">\n");
      out.write("                            <div class=\"book-name\"> ");
      out.print(novels.get(i).getName() );
      out.write(" </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"main2-wraper\">\n");
      out.write("                <div id=\"left\">\n");
      out.write("                    <div id=\"finished-book-list\">\n");
      out.write("                        <div class=\"title-list\"><a href=\"\">Truyện hoàn thành</a></div>\n");
      out.write("                        <div class=\"list2\">\n");
      out.write("                                 ");

                        List<Novel> novels2= novelDao.finishedList();
                        for(int i=0; i < novels2.size();i++){
                            
                    
      out.write("\n");
      out.write("                            <div class=\"item\">\n");
      out.write("                                <a href=\"");
      out.print(request.getContextPath() );
      out.write("/Control?page=view-info&id=");
      out.print(novels2.get(i).getId());
      out.write("\">\n");
      out.write("                                    <img src=");
      out.print(novels2.get(i).getImgLink());
      out.write(" class=\"img-reponsive\" alt=\"");
      out.print(novels2.get(i).getName());
      out.write("\">\n");
      out.write("                                    <div class=\"book-name\"> ");
      out.print(novels2.get(i).getName() );
      out.write(" </div>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"right\">\n");
      out.write("                    <div class=\"title-list\">Thể loại</div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=kiem-hiep\">Kiếm hiệp</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=tien-hiep\">Tiên hiệp</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=hai-huoc\">Hài hước</a></li>\n");
      out.write("                        <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/Control?page=category&genre=truyen-ma\">Truyện ma</a></li>\n");
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
