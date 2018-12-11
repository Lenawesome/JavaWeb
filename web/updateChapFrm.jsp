<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
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
        <title> Quản lý chương </title>
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
                
                    <%if(session.getAttribute("troll")!=null){
                             if(session.getAttribute("troll").equals("true")){      
                    %>
                    <div id="caution">Chưa có mục nào được sửa!!!</div>
                    <%}}%>
                    <%
                        List<Chap> chaps = (List<Chap>)request.getAttribute("chaps");
                    %>
                    <div id="title">Sửa chương</div>
                    <form action="sua-chuong" method="post">
                        <div id="label">Tên chương</div>
                        <input type="text" name="name" value="<%=chaps.get(0).getName()%>" required >
                        <div id="label">Nội dung chương</div>
                        <textarea required id="comment" name="content" rows="7" ><%=chaps.get(0).getContent()%></textarea><br>
                        <input type="hidden" name="id" value="<%=chaps.get(0).getId()%>">
                        <input type="hidden" name="idNovel" value="<%=chaps.get(0).getId_novel()%>">
                        <input type="submit" value="Sửa chương">
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