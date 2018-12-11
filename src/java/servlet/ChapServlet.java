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
@WebServlet(name = "ChapServlet", urlPatterns = {"/noi-dung-chuong"})
public class ChapServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String chapId = (String)request.getAttribute("chapId");
            String next = "off",previous="off";
            List<Chap> chaps = ChapDao.listChap("id", chapId);
            if(!chaps.isEmpty()){
                
                List<Novel> novels = NovelDao.listBy("id", ""+chaps.get(0).getId_novel());
                List<Chap> listChap = ChapDao.listChap("novel_id",""+chaps.get(0).getId_novel());

                if(chaps.get(0).getChap_numb()!=1){
                    previous="";
                }
                if(chaps.get(0).getChap_numb()!=listChap.size()){
                    next="";
                }
                for(int i =0;i <listChap.size();i++){
                    if(listChap.get(i).getChap_numb()==(chaps.get(0).getChap_numb())+1){
                        request.setAttribute("nextChapId", listChap.get(i).getId());
                    }
                    if(listChap.get(i).getChap_numb()==(chaps.get(0).getChap_numb()-1))
                        request.setAttribute("previousChapId", listChap.get(i).getId());
                }
                request.setAttribute("next", next);
                request.setAttribute("previous", previous);
                request.setAttribute("chap", chaps);
                request.setAttribute("listChap", listChap);
                request.setAttribute("listNovels", novels);
                request.getRequestDispatcher("chapContent.jsp").forward(request, response);
            }else{
                 response.sendRedirect("error.jsp");
            }
        }
    }
