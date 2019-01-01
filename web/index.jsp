
<%@page import="model.Genre"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
        <%
            List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
            if(request.getAttribute("hotList")== null || request.getAttribute("finishedList")==null){
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        %>
<!DOCTYPE html>
<html>
    <head>
        <title> Trang chủ </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
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
            <div class="section-1">
                <div class="title-list">*Truyện hot*</div>
                
                     <%
                        List<Novel> novels = (List<Novel>)request.getAttribute("hotList");
                        for(int i=0; i < 6;i++){
                            
                    %>
                    <div class="item"  >
                        <a class="show tooltip" href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels.get(i).getId()%>">
                            <img src=<%=novels.get(i).getImgLink()%> class="image" alt="<%=novels.get(i).getName()%>">
                            <span class="text showdescription"><b>Tác giả:<br></b><%=novels.get(i).getAuthor()%><b><br>Rating:<br></b><%=novels.get(i).getRating()%></span> 
                            <div class="book-name"> <%=novels.get(i).getName() %> </div>
                        </a>
                    </div>
                    <%}%>
            </div>
            <div class="section-2">
                <div class="left">
                    <div class="title-list">*Truyện hoàn thành*</div>
                             <%
                    List<Novel> novels2= (List<Novel>) request.getAttribute("finishedList");
                    for(int i=0; i < 9;i++){

                %>
                        <div class="item">
                            <a class="show tooltip" href="<%=request.getContextPath() %>/Control?page=view-info&id=<%=novels2.get(i).getId()%>">
                                <img src=<%=novels2.get(i).getImgLink()%> class="image" alt="<%=novels2.get(i).getName()%>">
                                <span class="text showdescription"><b>Tác giả:<br></b><%=novels2.get(i).getAuthor()%><b><br>Rating:<br></b><%=novels2.get(i).getRating()%></span> 
                                <div class="book-name"> <%=novels2.get(i).getName() %> </div>
                            </a>
                        </div>
                        <%}%>
                </div>
                <div class="right">
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
        <div >
                <a href="https://docs.google.com/forms/d/1EviWngyve5IE1tuxVpodrQUK2IViXpRTirRnrahY_ZY/edit"  title="Góp ý" rel="nofollow" class="tooltip mail" target="_blank">
                    <img src="./images/mail.PNG" style="margin: 7px 5px 5px 5px ">
                    <span class="text left-tooltip">Góp ý</span> 
                </a>
        </div>
                        <button id="button-top" onclick="backtop()" title=" về đầu trang">Về đầu trang</button>
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
<%   session.removeAttribute("novelId");
    session.removeAttribute("point");
%>