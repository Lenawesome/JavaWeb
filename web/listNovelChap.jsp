

<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Danh sách truyện </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <div id="top">
            <div id="mix-menu">
                <ul>
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
                            <li><a href="">Thêm thể loại</a></li>
                            <li><a href="">Sửa thể loại</a></li>
                            <li><a href="">Xóa thể loại</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="">Quản lý người dùng</a>
                        <ul>
                            <li><a href="">Thêm nguyời dùng</a></li>
                            <li><a href="">Xóa người dùng</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
                            <%
                                List<Novel> novels = (List<Novel>)request.getAttribute("novels");
                            %>
        <div class="main-content">
            <div id="table-container">
                <div id="table-name">Danh sách truyện</div>
                <table>
                    <thead>
                        <th>ID</th>
                        <th>Tên truyện</th>
                        <th>Tên tác giả</th>
                        <th>Trạng thái</th>
                        <th>Thao tác</th>
                    </thead>
                    <%
                    for(int i=0;i<novels.size();i++){
                    %>
                    <tr>
                        <td><%=novels.get(i).getId()%></td>
                        <td><%=novels.get(i).getName()%></td>
                        <td><%=novels.get(i).getAuthor()%></td>
                        <td><%=novels.get(i).getStatus()%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/AdminControl?page=listChap&id=<%=novels.get(i).getId()%>">Sửa, xóa chương</a>|
                            <a href="<%=request.getContextPath()%>/AdminControl?page=addChap&id=<%=novels.get(i).getId()%>">Thêm chương</a>
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

