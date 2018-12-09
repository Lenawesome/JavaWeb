/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chap;
import model.ChapDao;
import model.Novel;
import model.NovelDao;
import model.User;
import model.UserDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "AdminSearch", urlPatterns = {"/admin-search"})
public class AdminSearch extends HttpServlet {

 



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = request.getParameter("from");
        String searchInput = request.getParameter("input-novel");
        List<Novel> novels = null;
        switch(page){
            case "listNovelChap":
                novels = (List<Novel>) NovelDao.listNovelBySearching("name", searchInput);
                request.setAttribute("novels", novels);
                request.getRequestDispatcher("listNovelChap.jsp").forward(request, response);
                break;
            case "listNovel" :
                novels = (List<Novel>) NovelDao.listNovelBySearching("name", searchInput);
                request.setAttribute("novels", novels);
                request.getRequestDispatcher("listNovel.jsp").forward(request, response);
                break;
            case "listUser" :
                List<User> users = UserDao.listUserBySearching(request.getParameter("input-user"));
                request.setAttribute("users", users);
                request.getRequestDispatcher("listUser.jsp").forward(request, response);
                break;
            case "listChap" :
                List<Chap> chaps = null;
                if(request.getParameter("option-input").equals("name")){
                    chaps = (List<Chap>) ChapDao.listChapBySearch(request.getParameter("search-input"));
                }else{
                     chaps = (List<Chap>) ChapDao.listChap("numb_chap", request.getParameter("search-input"));
                }
                request.setAttribute("chaps", chaps);
                request.getRequestDispatcher("listChap.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("AdminControl?page=addNovel");
        }
    }
}
