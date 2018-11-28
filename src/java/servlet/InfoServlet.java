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
import model.Novel;
import model.NovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "InfoServlet", urlPatterns = {"/thong-tin"})
public class InfoServlet extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = (String)request.getAttribute("id");
            NovelDao novelDao = new NovelDao();
            ChapDao chapDao = new ChapDao();
            List<Novel> listNovelById = novelDao.listBy("id", id);
            List<Chap> listChap = chapDao.listChap();
            if(listNovelById!=null){
                if(!listNovelById.isEmpty()){
                    request.setAttribute("listNovelById",listNovelById);
                    request.setAttribute("listChap",listChap);
                    request.getRequestDispatcher("novelInfo.jsp").forward(request, response);
                    
                }
            }else{
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
