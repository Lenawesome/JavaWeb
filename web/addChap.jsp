<%@page import="model.Novel"%>
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if(session.getAttribute("adminName")==null){
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <title> Thêm chương </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/adminAddNovel.css">
    </head>
    <body>
        
        <div id="top" class="top">
            <div id="mix-menu">
                <ul>
                    <li>
                        <a href="<%=request.getContextPath()%>/Control?page=logout">
                            Đăng xuất
                        </a>
                    </li>
                    <li>
                        <a href="">Quản lý truyện</a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/AdminControl?page=addNovel">Thêm truyện</a></li>
                            <li><a href="<%=request.getContextPath()%>/AdminControl?page=listNovel">Sửa và xóa truyện</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/AdminControl?page=chapManagement">Quản lý chương</a>
                    </li>
                    <li>
                        <a href="">Quản lý thể loại</a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/AdminControl?page=addGenre">Thêm thể loại</a></li>
                            <li><a href="<%=request.getContextPath()%>/AdminControl?page=listGenre">Sửa và xóa thể loại</a></li>
                        </ul>
                    </li>
                   <li>
                        <a href="<%=request.getContextPath()%>/AdminControl?page=userManagement">Quản lý người dùng</a>
                    </li>
                </ul>
            </div>
        </div>
                    
        <div class="main-content">
            <div id="form-container">
                
                    <%if(session.getAttribute("succes")!=null){
                             if(session.getAttribute("succes").equals("false")){      
                    %>
                    <div id="caution">Số thứ tự chương đã tồn tại!!!</div>
                    <%}}%>
                    <%
                        List<Novel> novels = (List<Novel>)request.getAttribute("listNovel");
                    %>
                    <div id="title">Thêm chương cho <%=novels.get(0).getName()%></div>
                    <form action="them-chuong" method="post">
                        <div id="label">Số thứ tự chương</div>
                        <input type="number" name="numbChap" min="1" max="3000"required >
                        <div id="label">Tên chương</div>
                        <input type="text" name="name" required >
                        <div id="label">Nội dung chương</div>
                        <textarea required id="comment" name="content" rows="7" ></textarea><br>
                        <input type="hidden" name="novelId" value="<%=novels.get(0).getId()%>">
                        <input type="submit" value="Thêm chương">
                    </form>                    
            </div>

        </div>
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>
<%
    session.removeAttribute("succes");
    session.removeAttribute("troll");
%>