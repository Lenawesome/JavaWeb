/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/dang-ky"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String retypedPassword = request.getParameter("retyped-password");
        HttpSession session = request.getSession();
        if(lengthCheck(userName)&&specialCharCheck(userName)){
            if(lengthCheck(password)){
                if(password.equals(retypedPassword)){
                    if(UserDao.adminCheck(userName)&&UserDao.registerCheck(userName.toLowerCase())){
                        UserDao.addUser(userName, password);
                        session.setAttribute("succes", "true");
                    }else{
                        session.setAttribute("valid", "false");
                    }
                }else{
                    session.setAttribute("retypedPassword", "false");
                }
            }else{
                session.setAttribute("password", false);
            }
        }else{
            session.setAttribute("user", "false");
        }
        response.sendRedirect("Control?page=register");
    }

    private boolean lengthCheck(String str) {
        if(str.length()<5){
            return false;
        }
        return true;
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
