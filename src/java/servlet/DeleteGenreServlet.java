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
import model.AdminGenreDao;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DeleteChapServlet", urlPatterns = {"/xoa-genre"})
public class DeleteGenreServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id = (String)request.getAttribute("id");
       AdminGenreDao.deleteGenre(id);
       response.sendRedirect("AdminControl?page=listGenre");
    }

 
}