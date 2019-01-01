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
import model.RatingDao;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RatingServlet", urlPatterns = {"/danh-gia"})
public class RatingServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idNovel = (String)session.getAttribute("novelId");
        int point = Integer.parseInt(request.getParameter("star"));
        String userName = (String)session.getAttribute("userName");
        RatingDao.addRating(point, idNovel, userName);
        float rating = RatingDao.avgRating(idNovel);
        int count = RatingDao.countRating(idNovel);
        RatingDao.updateRating(idNovel, rating);
        response.sendRedirect("Control?page=view-info&id="+idNovel);
    }

   

}
