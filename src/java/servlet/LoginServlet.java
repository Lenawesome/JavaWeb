/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Genre;
import model.GenreDao;
import model.Novel;
import model.NovelDao;
import model.UserDao;


@WebServlet(name = "LoginServlet", urlPatterns = {"/dang-nhap"})
public class LoginServlet extends HttpServlet {

  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        if(UserDao.check(userName, password)){
            session.setAttribute("userName", userName);
            response.sendRedirect("Control?page=home");
            
            
        }
    }


}
