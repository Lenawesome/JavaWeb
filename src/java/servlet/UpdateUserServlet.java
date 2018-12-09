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
import model.Chap;
import model.ChapDao;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String updateUserName = request.getParameter("name");
        String pass = request.getParameter("pass");
        String userName = request.getParameter("userName");
        List<User> users = UserDao.findUser(userName);
        HttpSession session = request.getSession();
        if(users!=null){
            if(userName.equals(updateUserName)
                    &&users.get(0).getPass().equals(pass)){
                session.setAttribute("troll","true");
                request.setAttribute("users", users);
                response.sendRedirect("AdminControl?page=updateUser&userName="+userName);
            }else{
                
//                UserDao.updateUser(updateUserName,pass,userName);
//                response.sendRedirect("AdminControl?page=userManagement");
                if(lengthCheck(updateUserName)&&specialCharCheck(updateUserName)){
                    if(lengthCheck(pass)){
                        if(UserDao.adminCheck(updateUserName)&&UserDao.registerCheck(updateUserName.toLowerCase())){
                            UserDao.updateUser(updateUserName, pass,userName);
                            session.setAttribute("succes", "true");
                            response.sendRedirect("AdminControl?page=userManagement");
                        }else{
                            session.setAttribute("valid", "false");
                            response.sendRedirect("AdminControl?page=updateUser&userName="+userName);
                        }
                    }else{
                        session.setAttribute("password", false);
                        response.sendRedirect("AdminControl?page=updateUser&userName="+userName);
                    }
                }else{
                    session.setAttribute("user", "false");
                    response.sendRedirect("AdminControl?page=updateUser&userName="+userName);
                }
            }
        }
    }
    
    private boolean lengthCheck(String str) {
        return str.length() >= 5;
    }
    private boolean specialCharCheck(String str){
        for(int i =0; i< str.length();i++){
            if(!characterCheck(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    private boolean characterCheck(Character c){
        if(c >= '0' && c<='9'){
            return true;
        }else if(c >= 'a' && c <= 'z'){
            return true;
        }else if(c >= 'A' && c <= 'Z'){
            return true;
        }
        return false;
    }
}
