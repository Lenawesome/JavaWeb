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
import model.Novel;
import model.NovelDao;

/**
 *
 * @author MyPC
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<Novel> hotList = NovelDao.listNovelHot();
            List<Novel> finishedList = NovelDao.listBy("status","Full");
            if(hotList.isEmpty()||finishedList.isEmpty()){
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }else{
                request.setAttribute("hotList", hotList);
                request.setAttribute("finishedList", finishedList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } 
    }


