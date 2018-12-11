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
import model.AdminGenreDao;
import model.Chap;
import model.ChapDao;
import model.Genre;
import model.GenreDao;
import model.Novel;
import model.NovelDao;
import model.User;
import model.UserDao;

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
            List<User> users = UserDao.listUsers();
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
                    if( !NovelDao.listBy("id", request.getParameter("id")).isEmpty()){
                        request.getRequestDispatcher("updateNovelFrm.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                    break;
                case "deleteNovel":
                    request.setAttribute("id", request.getParameter("id"));
                    request.getRequestDispatcher("xoa-truyen").forward(request, response);
                    break;
                case "chapManagement":
                    request.setAttribute("novels", novels);
                    request.getRequestDispatcher("listNovelChap.jsp").forward(request, response);
                    break;
                case "userManagement":
                    request.setAttribute("users", users);
                    request.getRequestDispatcher("listUser.jsp").forward(request, response);
                    break;
                case "updateUser":
                    request.setAttribute("users", UserDao.findUser(request.getParameter("userName")));
                    if(!UserDao.findUser(request.getParameter("userName")).isEmpty()){
                        request.getRequestDispatcher("updateUserFrm.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                    break;
                case "deleteUser":
                    UserDao.deleteUser(request.getParameter("userName"));
                    request.getRequestDispatcher("AdminControl?page=userManagement").forward(request, response);
                    break;
                case "listChap":
                    request.setAttribute("chaps", ChapDao.listChap("novel_id", request.getParameter("id")));
                    if( !ChapDao.listChap("novel_id", request.getParameter("id")).isEmpty()){
                        request.getRequestDispatcher("listChap.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                    break;
                case "updateChap":
                    request.setAttribute("chaps", ChapDao.listChap("id", request.getParameter("id")));
                    if( !ChapDao.listChap("novel_id", request.getParameter("id")).isEmpty()){
                        request.getRequestDispatcher("updateChapFrm.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                   
                    break;
                case "deleteChap":
                    request.setAttribute("chaps", ChapDao.listChap("novel_id", request.getParameter("id")));
                      if( !ChapDao.listChap("novel_id", request.getParameter("id")).isEmpty()){
                        request.setAttribute("id", request.getParameter("id"));
                        request.getRequestDispatcher("xoa-chuong").forward(request, response);
                      }else{
                          response.sendRedirect("adminAddNovel.jsp");
                      }
                    break;
                case "addChap":
                    request.setAttribute("listNovel", NovelDao.listBy("id", request.getParameter("id")));
                    if(!NovelDao.listBy("id", request.getParameter("id")).isEmpty()){
                        request.getRequestDispatcher("addChap.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                    break;
                   
                 case"updateGenre":
                    request.setAttribute("listGenre", GenreDao.listBy("id", request.getParameter("id")));
                    if(!GenreDao.listBy("id", request.getParameter("id")).isEmpty()){
                        request.getRequestDispatcher("updateGenreFrm.jsp").forward(request, response);
                    }else{
                        response.sendRedirect("adminAddNovel.jsp");
                    }
                    break;
                case "addGenre":
                    request.getRequestDispatcher("adminAddGenre.jsp").forward(request, response);
                    break;
                
                case "listGenre":
                    request.setAttribute("genres", genres);
                    request.getRequestDispatcher("listGenre.jsp").forward(request, response);
                    break;
                
                case "deleteGenre":
                    AdminGenreDao.deleteGenre(request.getParameter("id"));
                    request.getRequestDispatcher("AdminControl?page=listGenre").forward(request, response);
//                    request.setAttribute("listGenre", GenreDao.listBy("id", request.getParameter("id")));
//                    request.setAttribute("id",request.getParameter("id"));
//                    request.getRequestDispatcher("xoa-genre").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } 
    }
