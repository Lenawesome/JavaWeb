

<%@page import="java.util.List"%>
<%@page import="model.NovelDao"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <div id="top">
            <div id="mix-menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/Control?page=home">Trang chủ</a></li>
                    <li>
                        <a href="#">Thể loại</a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=kiem-hiep">Kiếm hiệp</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=tien-hiep">Tiên hiệp</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=hai-huoc">Hài hước</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=truyen-ma">Truyện ma</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Thành viên</a>
                        <ul>
                            <li><a href="<%=request.getContextPath() %>/Control?page=login">Đăng nhập</a></li>
                            <li><a href="<%=request.getContextPath() %>/Control?page=register">Đăng ký</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="search-form">
                    <input id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                    <select id="dropdown-list">
                        <option value="Tác giả">Tác giả</option>
                        <option value="Tên Truyện">Tên Truyện</option>
                    </select>
                    <button id="search-box-button" >Search</button>
                </form>
            </div>
        </div>
        <div id="novel-info">
            <div class="title-list">Thông tin truyện</div>
            <div class="section-1">
                <div class="list">
                     <%
                        NovelDao novelDao = new NovelDao();
                        List<Novel> novels = novelDao.listNovel();
                        if(novels.isEmpty()){
                            out.print("Khong tim thay truyen");
                        }else{
                            for(int i=0; i < novels.size();i++){
                    %>
                    <div class="item">
                        <a href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                            <img src=<%=novels.get(i).getImgLink()%> class="img-reponsive" alt="<%=novels.get(i).getName()%>">
                            <div class="book-name"> <%=novels.get(i).getName() %> </div>
                        </a>
                    </div>
                    <%}}%>
                </div>
        </div> 
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>
