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
import model.AdminNovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "AddNovelServlet", urlPatterns = {"/them-truyen"})
public class AddNovelServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        HttpSession session = request.getSession();
        if(AdminNovelDao.novelNameCheck(name.trim().toLowerCase())){
            AdminNovelDao.addNovel(name, author, image, description, status);
            session.setAttribute("succes", "true");
            response.sendRedirect("AdminControl?page=addNovel");
        }else{
            session.setAttribute("succes", "false");
            response.sendRedirect("AdminControl?page=addNovel");
        }
        
    }
}
