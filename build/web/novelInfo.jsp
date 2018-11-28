
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Novel> novels = (List<Novel>) request.getAttribute("listNovelById");
    List<Chap> chaps = (List<Chap>) request.getAttribute("listChap");
    if(novels!=null){
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
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
                    <%
                        
                        for(int i = 0; i <novels.size(); i++){
                        
                    %>
                <div class="item">
                    <img src="<%=novels.get(i).getImgLink()%>" class="img-reponsive" alt="<%=novels.get(i).getName()%>">
                    <div class="novel-name"> <%=novels.get(i).getName() %> </div>
                    <div class="novel-author">Tác giả: <%=novels.get(i).getAuthor()%></div>
                    <div class="novel-status">Tình trạng: <%=novels.get(i).getStatus()%></div>
                    <div class="novel-status">Thể loại: <%=novels.get(i).getCategories()%></div>
                </div>
                <%}%>
                <div class="info-right"></div>
            </div>
                <%
                    for(int i=0; i <chaps.size();i++){
                %>
                <div class="list-chapter">
                    <a href="<%=request.getContextPath() %>/Control?page=chap-info&id=<%=chaps.get(i).getId()%>">
                        <%=chaps.get(i).getName()%>
                    </a>
                </div>
                <%}%>
        </div> 
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>
<%}
else{
    response.sendRedirect("error.jsp");
}
%>