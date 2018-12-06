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
import model.AdminNovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "DeleteNovelServlet", urlPatterns = {"/xoa-truyen"})
public class DeleteNovelServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id = (String)request.getAttribute("id");
       AdminNovelDao.deleteNovel(id);
       response.sendRedirect("AdminControl?page=listNovel");
    }

 
}
