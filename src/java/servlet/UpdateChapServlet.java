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

/**
 *
 * @author MyPC
 */
@WebServlet(name = "UpdateChapServlet", urlPatterns = {"/sua-chuong"})
public class UpdateChapServlet extends HttpServlet {

  
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        List<Chap> chaps = ChapDao.listChap("id", id);
        if(!chaps.isEmpty()){
            HttpSession session = request.getSession();
                if(chaps.get(0).getName().equals(name)
                        &&chaps.get(0).getContent().equals(content)){
                    session.setAttribute("troll","true");
                    response.sendRedirect("AdminControl?page=updateChap&id="+id);
                }else{
                    ChapDao.updateChap(name, content, id);
                    response.sendRedirect("AdminControl?page=listChap&id="+request.getParameter("idNovel"));
                }
        }else{
            response.sendRedirect("adminAddNovel.jsp");
        }
        }
    }
