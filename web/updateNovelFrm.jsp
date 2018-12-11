

<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
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
        <title> Sửa truyện </title>
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
                    <div id="caution">Tên truyện đã tồn tại!!!</div>
                    <%}}else if(session.getAttribute("troll")!=null){
                             if(session.getAttribute("troll").equals("true")){      
                    %>
                    <div id="caution">Chưa có mục nào được sửa!!!</div>
                    <%}}%>
                    <%
                        List<Novel> listNovel = (List<Novel>)request.getAttribute("listNovel");
                    %>
                    <div id="title">Sửa truyện</div>
                    <form action="sua-truyen" method="post">
                        <div id="label">Tên truyện</div>
                        <input type="text" name="name" value="<%=listNovel.get(0).getName()%>" required >
                        <div id="label">Tên tác giả</div>
                        <input type="text" name="author" value="<%=listNovel.get(0).getAuthor()%>" required>
                        <div id="label">Đường dẫn ảnh</div>
                        <input type="text" name="image" value="<%=listNovel.get(0).getImgLink()%>" required>
                        <div id="label">Mô tả</div>
                        <textarea required id="comment" name="description" rows="3" ><%=listNovel.get(0).getDescription()%></textarea><br>
                        <div id="label">Rating</div>
                        <input type="number" min="1" max="10" name="rating" value="<%=listNovel.get(0).getRating()%>" required>
                        <div id="label">Trạng thái</div>
                        <input type="text" name="status" value="<%=listNovel.get(0).getStatus()%>" required>
                        <input type="hidden" name="id" value="<%=listNovel.get(0).getId()%>">
                        <input type="submit" value="Sửa truyện">
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