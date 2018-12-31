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
import javax.servlet.http.HttpSession;
import model.Genre;
import model.GenreDao;
import model.Novel;
import model.NovelDao;

@WebServlet(name = "ControlServlet", urlPatterns = {"/Control"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String page = request.getParameter("page");
            page = page.toLowerCase();
            request.setCharacterEncoding("UTF-8");
            List<Genre> listGenre = GenreDao.listAllGenres();
            switch(page){
                case "home":
                    request.setAttribute("listGenre", listGenre);
                    request.getRequestDispatcher("home").forward(request, response);
                    break;
                case "logout":
                    
                    request.getRequestDispatcher("logout").forward(request, response);
                    break;
                case "login":
                    
                    request.setAttribute("listGenre", listGenre);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                case "register":
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    break;
                case "view-info":
                    
                    String novelId = request.getParameter("id");
                    session.setAttribute("novelId", ""+novelId);
                    if(novelId!=null){
                        request.setAttribute("id", novelId);
                        request.setAttribute("listGenre", listGenre);
                        request.getRequestDispatcher("thong-tin").forward(request, response);
                    }else{
                        response.sendRedirect("error.jsp");
                    }
                    break;
                case "chap-info":
                    String chapId = request.getParameter("id");
                    if(chapId!=null){
                        request.setAttribute("chapId", chapId);
                        request.setAttribute("listGenre", listGenre);
                        request.getRequestDispatcher("noi-dung-chuong").forward(request, response);
                    }
                    break;
                case "category":
                    request.setAttribute("id", request.getParameter("id"));
                    request.setAttribute("listGenre", listGenre);
                    request.getRequestDispatcher("the-loai").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } 
    }