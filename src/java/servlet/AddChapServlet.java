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
import model.ChapDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "AddChapServlet", urlPatterns = {"/them-chuong"})
public class AddChapServlet extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        int numbChap = Integer.parseInt(request.getParameter("numbChap"));
        int novelId = Integer.parseInt(request.getParameter("novelId"));
        
        HttpSession session = request.getSession();
        if(ChapDao.numbChapCheck(numbChap)){
            ChapDao.addChap(novelId, numbChap, name, content);
            response.sendRedirect("AdminControl?page=listChap&id="+novelId);
        }else{
            session.setAttribute("succes", "false");
            response.sendRedirect("AdminControl?page=addChap&id="+novelId);
        }
        
    }


}
