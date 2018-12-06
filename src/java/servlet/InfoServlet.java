/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.ArrayList;
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
import javax.servlet.http.HttpSession;
import model.Chap;
import model.ChapDao;
import model.Comment;
import model.CommentDao;
import model.Genre;
import model.GenreDao;
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
            String id = (String)request.getAttribute("id");
            int limit = 0;
            if(request.getAttribute("limit")==null){
                limit = 2;
                request.setAttribute("limit", limit);
                System.out.println(limit);
            }else{
                limit = (int)request.getAttribute("limit");
                System.out.println(limit);
            }
            List<Novel> listNovelById = NovelDao.listBy("id", id);
            List<Novel> listNovelByAuthor = new ArrayList<>();
            List<Genre> listGenre = GenreDao.listGenreByIdNovel(id);
            List<Genre> listAllGenres = GenreDao.listAllGenres();
            String strGenre = "";
            for(int i =0; i<listGenre.size();i++){
                if(i==listGenre.size()-1)
                    strGenre+=listGenre.get(i).getName();
                else
                    strGenre+=(listGenre.get(i).getName()+",");
            }
            List<Chap> listChap = ChapDao.listChap("novel_id",id);
            List<Comment> listComment = CommentDao.listCommentNovel(id,limit);
            listNovelByAuthor = NovelDao.listBy("author", listNovelById.get(0).getAuthor());
            for(int i =0; i < listNovelByAuthor.size();i++){
                if(listNovelByAuthor.get(i).getId()==Integer.parseInt(id)){
                    listNovelByAuthor.remove(i);
                }
            }
                if(!listNovelById.isEmpty()){
                    request.setAttribute("listComments", listComment);
                    request.setAttribute("listNovelById",listNovelById);
                    request.setAttribute("listChap",listChap);
                    request.setAttribute("listNovelByAuthor", listNovelByAuthor);
                    request.setAttribute("listGenre", listGenre);
                    request.setAttribute("listAllGenres", listAllGenres);
                    request.setAttribute("strGenre", strGenre);
                    request.getRequestDispatcher("novelInfo.jsp").forward(request, response);
                }
        }

    }
