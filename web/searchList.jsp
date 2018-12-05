

<%@page import="model.Genre"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
%>
<!DOCTYPE html>
<html>
    <head>
        <title> Tìm kiếm </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/searchList.css">
        <script type="text/javascript">
            function disabled(){
                var userName = "<%=(String)session.getAttribute("userName")%>";
                var x = document.getElementById("login");
                var y = document.getElementById("logout");
                x.style.display = "block";
                y.style.display = "none";
                if(userName!=="null"){
                    x.style.display = "none";
                    y.style.display = "block";
                }
            }
            window.onload = disabled;
        </script>
    </head>
    <body>
        <div id="top">
            <div id="mix-menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/Control?page=home">Trang chủ</a></li>
                    <li>
                        <a href="#">Thể loại</a>
                        <ul>
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
                            <li id="login"><a href="<%=request.getContextPath() %>/Control?page=login">Đăng nhập</a></li>
                            <li><a href="<%=request.getContextPath() %>/Control?page=register">Đăng ký</a></li>
                            <li id="logout"><a href="<%=request.getContextPath() %>/Control?page=logout">Đăng xuất</a></li>
                        </ul>
                    </li>
                </ul>
                     <form class="search-form" action="tim-kiem" method="post">
                        <input name="search-input"required id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                        <select name="option-input"id="dropdown-list">
                            <option value="name">Tên Truyện</option>
                            <option value="author">Tác giả</option>
                        </select>
                        <input id="submit-button" type="submit" value="Search">
                    </form>
            </div>
        </div>
                        <%
                            if(session.getAttribute("userName")!=null){
                        %>
                        <div id="welcome">Xin chào <%=session.getAttribute("userName")%></div>
                        <%}%>
        <div class="main-content"> 
            <div id="section-1">
                <div id="left">
                    <div class="title-list">Tìm kiếm theo <%=request.getAttribute("optionInput")%> với từ khóa 
                        "<%=request.getAttribute("searchInput")%>"
                    </div>
                    <div class="list">
                        <%
                            List<Novel> novels = (List<Novel>)request.getAttribute("resultList");
                            for(int i=0; i < novels.size();i++){
                        %>
                            <div class="item">
                                <a href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                                    <img src=<%=novels.get(i).getImgLink()%> class="image" alt="<%=novels.get(i).getName()%>">
                                    <div class="book-name"> <%=novels.get(i).getName() %> </div>
                                </a>
                            </div>
                        <%}%>
                    </div>
                </div>
                <div class="right">
                    <div class="title-list">THỂ LOẠI TRUYỆN</div>
                    <div class="list">
                        <ul>
                                                        <%
                                    for(int i = 0;i <listGenre.size();i++){
                                %>
                                <li>
                                    <a href="<%=request.getContextPath()%>/Control?page=category&id=<%=listGenre.get(i).getId()%>">
                                        <%=listGenre.get(i).getName()%>
                                    </a>
                                </li>
                                <%}%>
                        </ul>
                    </div>
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
