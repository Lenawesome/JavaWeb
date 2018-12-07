/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AdminGenreDao;
import model.AdminNovelDao;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddGenreServlet", urlPatterns = {"/them-genre"})
public class AddGenreServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        HttpSession session = request.getSession();
        if(AdminGenreDao.genreNameCheck(name.trim().toLowerCase())){
            AdminGenreDao.addGenre(name, description);
            session.setAttribute("succes", "true");
            response.sendRedirect("AdminControl?page=addGenre");
        }else{
            session.setAttribute("succes", "false");
            response.sendRedirect("AdminControl?page=addGenre");
        }
        
    }
}
