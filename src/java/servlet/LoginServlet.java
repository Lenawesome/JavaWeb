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
import model.AdminDao;
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
        if(session.getAttribute("userName")==null){
            if(UserDao.loginCheck(userName, password)){
                if(session.getAttribute("novelId")!=null){
                    String id = (String)session.getAttribute("novelId");
                    session.removeAttribute("novelId");
                    session.setAttribute("userName", userName);
                    response.sendRedirect("Control?page=view-info&id="+id);
                }else{
                    session.setAttribute("userName", userName);
                    response.sendRedirect("Control?page=home");
                }
            }else if(AdminDao.loginAdminCheck(userName, password)){
                session.setAttribute("userName", userName);
                response.sendRedirect("AdminControl?page=addNovel");
            }else{
                session.setAttribute("isValid", "false");
                response.sendRedirect("Control?page=login");
            }
        }else{
            response.sendRedirect("error.jsp");
        }
    }


}
