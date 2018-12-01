
<%@page import="model.Genre"%>
<%@page import="java.util.List"%>
<%@page import="model.NovelDao"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
            if(request.getAttribute("hotList")==null || request.getAttribute("finishedList")==null){
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        %>
<!DOCTYPE html>
<html>
    <head>
        <title> Trang chủ </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
    </head>
    <body>
        <div id="top">
            <div id="mix-menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/Control?page=home">Trang chủ</a></li>
                    <li>
                        <a href="#">Thể loại</a>
                        <ul>
<!--                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=kiem-hiep">Kiếm hiệp</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=tien-hiep">Tiên hiệp</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=hai-huoc">Hài hước</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=kinh-di">Kinh Dị</a></li>
                            
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=di-gioi">Dị Giới</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=huyen-huyen">Huyền huyễn</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=do-thi">Đô Thị</a></li>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&genre=truyen-ma">Ngôn Tình</a></li>-->
                            <%
                                for(int i = 0;i <listGenre.size();i++){
                            %>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&id=<%=listGenre.get(i).getId()%>">
                                    <%=listGenre.get(i).getName()%>
                                </a>
                            </li>
                            <%}%>
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
                <form class="search-form" action="/tim-kiem" method="get">
                    <input name="search-input"required id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                    <select name="option-input"id="dropdown-list">
                        <option value="Tác giả">Tác giả</option>
                        <option value="Tên Truyện">Tên Truyện</option>
                    </select>
                    <input id="submit-button" type="submit" value="Search">
                </form>
            </div>
        </div>
        <div class="main-content">
            <div class="section-1">
                <div class="title-list">Truyện hot</div>
                
                     <%
                        List<Novel> novels = (List<Novel>)request.getAttribute("hotList");
                        for(int i=0; i < 10;i++){
                            
                    %>
                    <div class="item">
                        <a href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                            <img src=<%=novels.get(i).getImgLink()%> class="image" alt="<%=novels.get(i).getName()%>">
                            <div class="book-name"> <%=novels.get(i).getName() %> </div>
                        </a>
                    </div>
                    <%}%>
            </div>
            <div class="section-2">
                <div class="left">
                    <div class="title-list">Truyện hoàn thành</div>
                             <%
                    List<Novel> novels2= (List<Novel>) request.getAttribute("finishedList");
                    for(int i=0; i < 10;i++){

                %>
                        <div class="item">
                            <a href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels2.get(i).getId()%>">
                                <img src=<%=novels2.get(i).getImgLink()%> class="image" alt="<%=novels2.get(i).getName()%>">
                                <div class="book-name"> <%=novels2.get(i).getName() %> </div>
                            </a>
                        </div>
                        <%}%>
                </div>
                <div class="right">
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
