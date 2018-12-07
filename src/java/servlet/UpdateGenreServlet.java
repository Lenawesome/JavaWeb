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
import javax.servlet.http.HttpSession;
import model.AdminGenreDao;
import model.Chap;
import model.ChapDao;
import model.Genre;
import model.GenreDao;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditChapServlet", urlPatterns = {"/sua-genre"})
public class UpdateGenreServlet extends HttpServlet {

    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String id = request.getParameter("id");
        List<Genre> listGenre = GenreDao.listBy("id", id);
        HttpSession session = request.getSession();
        if(!listGenre.get(0).getName().equals(name)){
            if(AdminGenreDao.genreNameCheck(name.trim().toLowerCase())){
                AdminGenreDao.updateGenre(name, description, id);
                response.sendRedirect("AdminControl?page=listGenre");
            }else{
                session.setAttribute("succes", "false");
                response.sendRedirect("AdminControl?page=updateGenre&id="+id);
            }
            
        }else{
            if(listGenre.get(0).getName().equals(name)&&listGenre.get(0).getDescription().equals(description)){
                session.setAttribute("troll","true");
                response.sendRedirect("AdminControl?page=updateGenre&id="+id);
            }else{
                AdminGenreDao.updateGenre(name, description, id);
                response.sendRedirect("AdminControl?page=listGenre");
            }
        }

    }

    
}
