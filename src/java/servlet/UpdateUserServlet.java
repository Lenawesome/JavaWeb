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
import model.AdminNovelDao;
import model.Novel;
import model.NovelDao;
import model.User;
import model.UserDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/sua-tai-khoan"})
public class UpdateUserServlet extends HttpServlet {

  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
       
        List<User> listUser = UserDao.findUser(name);
        HttpSession session = request.getSession();
        if(!listUser.get(0).getName().equals(name)){
            if(UserDao.registerCheck(name.trim().toLowerCase())){
                UserDao.updateUser(name, pass);
                response.sendRedirect("AdminControl?page=userManagement");
            }else{
                session.setAttribute("succes", "false");
                response.sendRedirect("AdminControl?page=updateUser&userName="+name);
            }
            
        }else{
            if(listUser.get(0).getPass().equals(pass)){
                session.setAttribute("troll","true");
                response.sendRedirect("AdminControl?page=updateUser&userName="+name);
            }else{
                UserDao.updateUser(name, pass);
                response.sendRedirect("AdminControl?page=userManagement");
            }
        }
    }
 
}
