
<%@page import="model.Genre"%>
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%
    
    List<Chap> listChap = (List<Chap>) request.getAttribute("listChap");
    List<Chap> chaps = (List<Chap>) request.getAttribute("chap");
    List<Novel> novels = (List<Novel>) request.getAttribute("listNovels");
    List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title></title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/chapContent.css">
    </head>
    <script type="text/javascript">
        function disabled() {
            var previous = "<%=(String)request.getAttribute("previous")%>";
            var next = "<%=(String)request.getAttribute("next")%>";
            var buttons = document.getElementsByClassName("previous");
            var nextbuttons = document.getElementsByClassName("next");
            var userName = "<%=(String)session.getAttribute("userName")%>";
                var x = document.getElementById("login");
                var y = document.getElementById("logout");
                x.style.display = "block";
                y.style.display = "none";
                if(userName!=="null"){
                    x.style.display = "none";
                    y.style.display = "block";
                }
            if(previous==="off"){
                for(var i=0;i<buttons.length;i++){
                    buttons[i].disabled="true";
                }
            }
            if(next==="off"){
                for(var i=0;i<nextbuttons.length;i++){
                    nextbuttons[i].disabled="true";
                }
            }
        }
         function myFunction() {
              var x = document.getElementById("top");
              if (x.className === "top") {
                x.className += " responsive";
              } else {
                x.className = "top";
              }
            }
        window.onload = disabled;
    </script>
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
                <form class="search-form" action="/tim-kiem" method="post">
                    <input name="search-input"required id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                    <select name="option-input"id="dropdown-list">
                        <option value="Tên Truyện">Tên Truyện</option>
                        <option value="Tác giả">Tác giả</option>
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
            <div class="chap-info">
                <div class="novel-name"><%=novels.get(0).getName()%></div>
                <div class="chap-name">Chap <%=chaps.get(0).getChap_numb()%>: <%=chaps.get(0).getName()%></div>
            </div>
            <div class="button-group" name="button-group">
                <input class="previous" onclick="window.location.
                            href='<%=request.getContextPath()%>/Control?page=chap-info&id=<%=request.getAttribute("previousChapId")%>'"
                            type="button" value="Chương trước">
                <select  class="drop-down" onchange="location = this.value">
                    <option disabled selected > -- Chọn chương -- </option>
                    <%
                        for(int i=0; i < listChap.size();i++){
                    %>
                    <option class="<%=listChap.get(i).getName()%>"value="<%=request.getContextPath()%>/Control?page=chap-info&id=<%=listChap.get(i).getId()%>">
                        <%=listChap.get(i).getName()%>
                    </option>
                    <%}%>
                </select>
                <input class="next" onclick="window.location.
                            href='<%=request.getContextPath()%>/Control?page=chap-info&id=<%=request.getAttribute("nextChapId")%>'"
                            type="button" value="Chương sau">
            </div>
            <div class="chap-content">
                  <%=chaps.get(0).getContent()%>              
            </div>
                        <div class="button-group" name="button-group">
                <input class="previous" onclick="window.location.
                            href='<%=request.getContextPath()%>/Control?page=chap-info&id=<%=request.getAttribute("previousChapId")%>'"
                            type="button" value="Chương trước">
                <select  class="drop-down" onchange="location = this.value">
                    <option disabled selected value> -- Chọn chương -- </option>
                    <%
                        for(int i=0; i < listChap.size();i++){
                    %>
                    <option class="<%=listChap.get(i).getName()%>"value="<%=request.getContextPath()%>/Control?page=chap-info&id=<%=listChap.get(i).getId()%>">
                        <%=listChap.get(i).getName()%>
                    </option>
                    <%}%>
                </select>
                <input class="next" onclick="window.location.
                            href='<%=request.getContextPath()%>/Control?page=chap-info&id=<%=request.getAttribute("nextChapId")%>'"
                            type="button" value="Chương sau">
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

