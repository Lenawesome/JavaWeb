package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Novel;
import model.NovelDao;

@WebServlet(name = "ControlServlet", urlPatterns = {"/Control"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String page = request.getParameter("page");
            page = page.toLowerCase();
            
            switch(page){
                case "home":
                    request.getRequestDispatcher("home").forward(request, response);
                    break;
                case "login":
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                case "register":
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    break;
                case "view-info":
                    String id= request.getParameter("id");
                    if(id!=null){
                        request.setAttribute("id", request.getParameter("id"));
                        request.getRequestDispatcher("thong-tin").forward(request, response);
                    }else{
                        response.sendRedirect("error.jsp");
                    }
                    break;
                case "category":
                    request.setAttribute("genre", request.getParameter("genre"));
                    request.getRequestDispatcher("the-loai").forward(request, response);
                    break;
                case "search":
                    break;
                default:
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            }
//        if(param.equals("login")){
//            forward(request, response, "/login.jsp");
//        }else if(param.equals("register")){
//            forward(request, response, "/register.jsp");
//        }else if(param.equals("logout")){
//            forward(request, response, "/index.jsp");
//        }else if(param.equals("book-info")){
//            forward(request, response, "/index.jsp");
//        }else if(param.equals("read")){
//            forward(request, response, "/index.jsp");
//        }
        } 
    }