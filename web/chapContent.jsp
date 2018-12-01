
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    List<Chap> listChap = (List<Chap>) request.getAttribute("listChap");
    List<Chap> chaps = (List<Chap>) request.getAttribute("chap");
    List<Novel> novels = (List<Novel>) request.getAttribute("listNovels");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            var options = document.getElementsByClassName("<%=chaps.get(0).getName()%>");
            for(var i = 0; i< options.length;i++)
                   options[i].selected="true";
        }
        window.onload = disabled;
    </script>
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
            <div class="chap-info">
                <div class="novel-name"><%=novels.get(0).getName()%></div>
                <div class="chap-name"><%=chaps.get(0).getName()%></div>
            </div>
            <div class="button-group" name="button-group">
                <input class="previous" onclick="window.location.
                            href='<%=request.getContextPath()%>/Control?page=chap-info&id=<%=request.getAttribute("previousChapId")%>'"
                            type="button" value="Chương trước">
                <select  class="drop-down" onchange="location = this.value">
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
    </body>
</html>

