/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chap;
import model.ChapDao;
import model.Genre;
import model.GenreDao;
import model.Novel;
import model.NovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "AdminControlServlet", urlPatterns = {"/AdminControl"})
public class AdminControlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String page = request.getParameter("page");
            List<Novel> novels = NovelDao.listNovel();
            List<Genre> genres = GenreDao.listAllGenres();
            
            switch(page){
                case "addNovel":
                    request.getRequestDispatcher("adminAddNovel.jsp").forward(request, response);
                    break;
                case "listNovel":
                    request.setAttribute("novels", novels);
                    request.getRequestDispatcher("listNovel.jsp").forward(request, response);
                    break;
                case "updateNovel":
                    request.setAttribute("listNovel", NovelDao.listBy("id", request.getParameter("id")));
                    request.getRequestDispatcher("updateNovelFrm.jsp").forward(request, response);
                    break;
                case "deleteNovel":
                    request.setAttribute("id", request.getParameter("id"));
                    request.getRequestDispatcher("xoa-truyen").forward(request, response);
                    break;
                case "chapManagement":
                    request.setAttribute("novels", novels);
                    request.getRequestDispatcher("listNovelChap.jsp").forward(request, response);
                    break;
                case "listChap":
                    request.setAttribute("chaps", ChapDao.listChap("novel_id", request.getParameter("id")));
                    request.getRequestDispatcher("listChap.jsp").forward(request, response);
                    break;
                case "updateChap":
                    request.setAttribute("chaps", ChapDao.listChap("id", request.getParameter("id")));
                    request.getRequestDispatcher("updateChapFrm.jsp").forward(request, response);
                    break;
                case "deleteChap":
                    request.setAttribute("chaps", ChapDao.listChap("novel_id", request.getParameter("id")));
                    request.setAttribute("id", request.getParameter("id"));
                    request.getRequestDispatcher("xoa-chuong").forward(request, response);
                    break;
                case "addChap":
                    request.setAttribute("listNovel", NovelDao.listBy("id", request.getParameter("id")));
                    request.getRequestDispatcher("addChap.jsp").forward(request, response);
                    break;
                   
                 case"updateGenre":
                    request.setAttribute("listGenre", GenreDao.listBy("id", request.getParameter("id")));
                    request.getRequestDispatcher("updateGenreFrm.jsp").forward(request, response);
                    break;
                case "addGenre":
                    request.getRequestDispatcher("adminAddGenre.jsp").forward(request, response);
                    break;
                
                case "listGenre":
                    request.setAttribute("genres", genres);
                    request.getRequestDispatcher("listGenre.jsp").forward(request, response);
                    break;
                
                case "deleteGenre":
                    request.setAttribute("id", request.getParameter("id"));
                    request.getRequestDispatcher("xoa-genre").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } 
    }
