/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Chap;
import model.ChapDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "ChapServlet", urlPatterns = {"/noi-dung-chuong"})
public class ChapServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = (String)request.getAttribute("chapId");
            ChapDao chapDao = new ChapDao();
            List<Chap> chaps = chapDao.listChap("id", id);
            request.setAttribute("listChap", chaps);
            request.getRequestDispatcher("chapContent.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChapServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChapServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
