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
import model.Genre;
import model.GenreDao;
import model.Novel;
import model.NovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/tim-kiem"})
public class SearchServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Genre> listGenre = GenreDao.listAllGenres();
        String searchInput = request.getParameter("search-input");
        String optionInput = request.getParameter("option-input");
        List<Novel> listNovelBySearching = NovelDao.listNovelBySearching(optionInput, searchInput);
        if(listNovelBySearching.size()==0){
            System.out.println("0");
        }
        request.setAttribute("resultList", listNovelBySearching);
        request.setAttribute("listGenre", listGenre);
        request.getRequestDispatcher("searchList.jsp").forward(request, response);
    }
}
