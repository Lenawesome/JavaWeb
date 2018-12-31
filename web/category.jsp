

<%@page import="model.Genre"%>
<%@page import="java.util.List"%>
<%@page import="model.NovelDao"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
%>
<!DOCTYPE html>
<html>
    <head>
        <title> Trang chủ </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/category.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
             function myFunction() {
              var x = document.getElementById("top");
              if (x.className === "top") {
                x.className += " responsive";
              } else {
                x.className = "top";
              }
            }
        </script>
    </head>
    
    <body>
        <div id="top" class="top">
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
                         <a class="menu-button" href="javascritp:void(0)" onclick="myFunction()">Menu</a>
        </div>
                        <%
                            if(session.getAttribute("userName")!=null){
                        %>
                        <div id="welcome">Xin chào <%=session.getAttribute("userName")%></div>
                        <%}%>
        <div class="main-content"> 
            <div id="section-1">
                <div id="left">
                    <%List<Genre> genre = (List<Genre>) request.getAttribute("genre");%>
                    <div class="title-list">*TRUYỆN <%=genre.get(0).getName().toUpperCase() %>*</a></div>
                    <div class="list">
                        <%
                            List<Novel> novels = (List<Novel>)request.getAttribute("listNovel");
                            for(int i=0; i < novels.size();i++){
                        %>
                        <div class="item">
                            <a class="show tooltip" href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                                <img src=<%=novels.get(i).getImgLink()%> class="image" alt="<%=novels.get(i).getName()%>">
                                <span class="text showdescription"><b>Tác giả:<br></b><%=novels.get(i).getAuthor()%><b><br>Rating:<br></b><%=novels.get(i).getRating()%></span>
                                <div class="info-wraper"> <p class="name"><%=novels.get(i).getName() %> </p>
                                    <p class="book-info"><b>Tác giả:<br></b><%=novels.get(i).getAuthor()%><b><br>Rating:<br></b><%=novels.get(i).getRating()%></p>
                                </div>
                                
                            </a>
                        </div>
                        <%}%>
                    </div>
                </div>
                <div class="genre-description"><%=genre.get(0).getDescription()%></div>
                <div id="right">
                    <div class="title-list">*THỂ LOẠI TRUYỆN*</div>
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
            <button id="button-top" onclick="backtop()">Về đầu trang</button>
        <script type="text/javascript">
            window.onscroll = function(){
                scroll()
            };
            function scroll(){
                if(document.body.scrollTop > 20||document.documentElement.scrollTop >20){
                    document.getElementById('button-top').style.display = "block";
                }else{
                    document.getElementById('button-top').style.display = "none";

                }
            }
            function backtop(){
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            }
            
        </script>
    </body>
</html>
<%
    session.removeAttribute("point");
%>