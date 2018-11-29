

<%@page import="java.util.List"%>
<%@page import="model.NovelDao"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Trang chủ </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
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
                <form class="search-form" action="search" method="get">
                    <input required id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                    <select id="dropdown-list">
                        <option value="Tác giả">Tác giả</option>
                        <option value="Tên Truyện">Tên Truyện</option>
                    </select>
                    <input id="submit-button" type="submit" value="Search">
                </form>
            </div>
        </div>
            <div id="section-2">
                <div id="left">
                    <div id="finished-book-list">
                        <div class="title-list"><a href="">Truyện <%=request.getAttribute("genre") %> </a></div>
                        
                         <div class="list">
                     <%
                        NovelDao novelDao = new NovelDao();
                        List<Novel> novels = novelDao.listNovel();
                        for(int i=0; i < 12;i++){
                    %>
                    <div class="item">
                        <a href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                            <img src=<%=novels.get(i).getImgLink()%> class="img-reponsive" alt="<%=novels.get(i).getName()%>">
                            <div class="book-name"> <%=novels.get(i).getName() %> </div>
                        </a>
                    </div>
                    <%}%>
                </div>
                    </div>
                </div>
                <div id="right">
                    <div class="title-list">Thể loại</div>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=kiem-hiep">Kiếm hiệp</a></li>
                        <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=tien-hiep">Tiên hiệp</a></li>
                        <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=hai-huoc">Hài hước</a></li>
                        <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=truyen-ma">Truyện ma</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>

<!--            <div id="main2-wraper">
                <div id="left">
                    <div id="finished-book-list">
                        <div class="title-list"><a href="">Truyện <%=request.getAttribute("genre") %> </a></div>
                        
                        <div class="list">
                            <div class="item-top-2">
                                <a href="#">
                                    <img src="./images/Linh Vũ Thiên Hạ.jpg" class="img-reponsive" alt="Linh Vũ Thiên Hạ">
                                    <div class="book-name">Linh vũ thiên hạ</div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="right">
                    <div class="title-list">Thể loại</div>
                    <ul>
                        <li><a href="#">Kiếm hiệp</a></li>
                        <li><a href="#">Tiên hiệp</a></li>
                        <li><a href="#">Hài hước</a></li>
                        <li><a href="#">Truyện ma</a></li>
                    </ul>
                </div>
            </div>-->
 

