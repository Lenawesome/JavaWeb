
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

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
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/novelInfo.css">
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
                    <input id="submit-button" type="submit" value="Search" >
                </form>
            </div>
        </div>
        <div class="main-content">

            <div class="section-1">
                <div class="title-list">Thông tin truyện</a></div>
                <div class="left">
                    <%
                        List<Novel> novels2= (List<Novel>) request.getAttribute("listNovelById");
                        for(int i=0; i < novels2.size();i++){
                    %>
                    <div class="novel">
                        <img src=<%=novels2.get(i).getImgLink()%> class="image" alt="<%=novels2.get(i).getName()%>">
                        <div class="novel-info"><b>Tác giả:</b> <%=novels.get(i).getAuthor()%></div>
                        <div class="novel-info"><b>Tình trạng:</b> <%=novels.get(i).getStatus()%></div>
                        <div class="novel-info"><b>Thể loại: </b><%=novels.get(i).getCategories()%></div>
                    </div>
                </div>
                <div class="middle">
                    <div class="novel-name"><%=novels.get(i).getName()%></div>
                    <div class="novel-description">
                        <%=novels.get(i).getDescription()%>
                    </div>
                </div>
                <%}%>
                <div class="right">
                    <div class="title-list">Truyện cùng tác giả</div>
                    <div class="related-novel">
                        <%
                            List<Novel> listNovelByAuthor = (List<Novel>)request.getAttribute("listNovelByAuthor");
                            for(int j=0; j<listNovelByAuthor.size();j++){
                        %>
                        <a href="<%=request.getContextPath()%>/Control?page=view-info&id=<%=listNovelByAuthor.get(j).getId()%>">
                            <%=listNovelByAuthor.get(j).getName()%><br>
                        </a>
                        <%}%>
                    </div>
                </div>
            </div>
            <div class="section-2">
                <div class="title-list">Danh sách chương</div>            
                <div class="chap-list">
                     <%
                        List<Chap> listChaps = (List<Chap>)request.getAttribute("listChap");
                        for(int j=0; j<listChaps.size();j++){
                    %>
                    <a href="<%=request.getContextPath()%>/Control?page=chap-info&id=<%=listChaps.get(j).getId()%>">
                        <%=listChaps.get(j).getName()%><br>
                    </a>
                    <%}%>
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
<%}
else{
    response.sendRedirect("error.jsp");
}
%>