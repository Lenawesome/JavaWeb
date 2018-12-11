/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Novel;
import model.NovelDao;
import model.Genre;
import model.GenreDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "CategoryServlet", urlPatterns = {"/the-loai"})
public class CategoryServlet extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String genreId = (String)request.getAttribute("id");
            List<Genre> genre = GenreDao.listGenreByIdGenre(genreId);
            if(!genre.isEmpty()){
                List<Novel> novels = NovelDao.listNovelByGenreId(genreId);
                request.setAttribute("listNovel", novels);
                request.setAttribute("genre", genre);
                request.getRequestDispatcher("category.jsp").forward(request, response);
            }else{
                response.sendRedirect("error.jsp");
            }
        
    }

}
