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

/**
 *
 * @author MyPC
 */
@WebServlet(name = "LoadCommentServlet", urlPatterns = {"/them-binh-luan"})
public class LoadCommentServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int limit = Integer.parseInt(request.getParameter("add"));
        limit = limit+2;
        request.setAttribute("limit", limit);
        String idNovel = request.getParameter("idNovel");
        request.getRequestDispatcher("Control?page=view-info&id="+idNovel).forward(request, response);
    }

}
