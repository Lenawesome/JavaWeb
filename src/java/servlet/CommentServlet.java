/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CommentDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "addComment", urlPatterns = {"/dang-binh-luan"})
public class CommentServlet extends HttpServlet {

   

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("userName");
        int idNovel = Integer.parseInt(request.getParameter("idNovel"));
        if(userName!=null){
            String comment = request.getParameter("comment");
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            String date = df.format(new Date());
            CommentDao.addComment(userName, comment, date, idNovel);
            response.sendRedirect("Control?page=view-info&id="+request.getParameter("idNovel"));
        }else{
//            session.setAttribute("novelId", ""+idNovel);
            response.sendRedirect("commentError.jsp");
        }
    }

}
