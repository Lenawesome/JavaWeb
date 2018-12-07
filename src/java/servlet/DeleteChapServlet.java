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
import javax.servlet.http.HttpSession;
import model.Chap;
import model.ChapDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "DeleteChapServlet", urlPatterns = {"/xoa-chuong"})
public class DeleteChapServlet extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       String id = (String)request.getAttribute("id");
       List<Chap> chaps = (List<Chap>)session.getAttribute("chaps");
       ChapDao.deleteChap(id);
       session.removeAttribute("chaps");
       response.sendRedirect("AdminControl?page=listChap&id="+chaps.get(0).getId_novel());
    }

    

}
