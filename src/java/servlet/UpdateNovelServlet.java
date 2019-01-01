/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AdminNovelDao;
import model.Novel;
import model.NovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "UpdateNovelServlet", urlPatterns = {"/sua-truyen"})
public class UpdateNovelServlet extends HttpServlet {

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String rating = request.getParameter("rating");
        String id = request.getParameter("id");
        List<Novel> listNovel = NovelDao.listBy("id", id);
        String checkrating = new String(""+listNovel.get(0).getRating()+"");
        HttpSession session = request.getSession();
        if(!listNovel.get(0).getName().equals(name)){
            if(AdminNovelDao.novelNameCheck(name.trim().toLowerCase())){
                AdminNovelDao.updateNovel(name, author, image, description,status,id);
                response.sendRedirect("AdminControl?page=listNovel");
            }else{
                session.setAttribute("succes", "false");
                response.sendRedirect("AdminControl?page=updateNovel&id="+id);
            }
            
        }else{
            if(listNovel.get(0).getAuthor().equals(author)&&listNovel.get(0).getImgLink().equals(image)
                    &&listNovel.get(0).getDescription().equals(description)&&listNovel.get(0).getStatus().equals(status)){
                session.setAttribute("troll","true");
                response.sendRedirect("AdminControl?page=updateNovel&id="+id);
            }else{
                AdminNovelDao.updateNovel(name, author, image, description,status,id);
                response.sendRedirect("AdminControl?page=listNovel");
            }
        }
        
    }

   
}
