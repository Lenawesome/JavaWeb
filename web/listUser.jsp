

<%@page import="model.User"%>
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
        <title> Danh sách người dùng </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
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
                            <%
                                List<User> users = (List<User>)request.getAttribute("users");
                            %>
        <div class="main-content">
            <div class="search-admin">
                <form action="admin-search" method="get">
                    <input name="input-user" required type="text" placeholder="Tìm tài khoản,...">
                    <input name="from" type="hidden" value="listUser">
                    <input type="submit" value="Tìm kiếm">
                </form>
            </div>
            
            <div id="table-container">
                  
                <div id="table-name">Danh sách người dùng</div>
                <table>
                    <thead>
                        <th>Tên tài khoản</th>
                        <th>Mật khẩu</th>
                        <th>Thao tác</th>
                    </thead>
                    <%
                    for(int i=0;i<users.size();i++){
                    %>
                    <tr>
                        <td><%=users.get(i).getName()%></td>
                        <td><%=users.get(i).getPass()%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/AdminControl?page=updateUser&userName=<%=users.get(i).getName()%>">Sửa</a>|
                            <a href="<%=request.getContextPath()%>/AdminControl?page=deleteUser&userName=<%=users.get(i).getName()%>">Xóa</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>


