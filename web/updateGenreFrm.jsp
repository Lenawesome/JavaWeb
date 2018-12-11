

<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page import="model.Genre"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if(session.getAttribute("adminName")==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <title> Quản lý thể loại </title>
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
                    <div id="caution">Tên thể loại đã tồn tại!!!</div>
                    <%}}else if(session.getAttribute("troll")!=null){
                             if(session.getAttribute("troll").equals("true")){      
                    %>
                    <div id="caution">Chưa có mục nào được sửa!!!</div>
                    <%}}%>
                    <%
                        List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");
                    %>
                    <div id="title">Sửa thể loại</div>
                    <form action="sua-genre" method="post">
                        <div id="label">Tên thể loại</div>
                        <input type="text" name="name" value="<%=listGenre.get(0).getName()%>" required >
                        <div id="label">Mô tả thể loại </div>
                        <textarea required id="comment" name="description" rows="3" ><%=listGenre.get(0).getDescription()%></textarea><br>
                        <input type="hidden" name="id" value="<%=listGenre.get(0).getId()%>">
                        <input type="submit" value="Sửa thể loại">
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