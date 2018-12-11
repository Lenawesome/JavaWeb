

<%@page import="model.Chap"%>
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
        <title> Quản lý chương </title>
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
                                List<Chap> chaps = (List<Chap>)request.getAttribute("chaps");
                                session.setAttribute("chaps", request.getAttribute("chaps"));
                            %>
        <div class="main-content">
            <div class="search-admin">
                <form action="admin-search" method="get" >
                    <input name="search-input"required type="text" placeholder="Tìm chương,...">
                    <select name="option-input"class="dropdown-list">
                        <option value="numb">STT</option>
                        <option value="name">Tên chương</option>
                    </select>
                    <input type="hidden" name="from" value="listChap">
                    <input type="submit" value="Search">
                </form>
            </div>
            
            <div id="table-container">
                <div id="table-name">Danh sách chuơng</div>
                <table>
                    <thead>
                        <th>STT </th>
                        <th>Tên chương </th>
                        <th>Thao tác</th>
                    </thead>
                    <%
                    for(int i=0;i<chaps.size();i++){
                    %>
                    <tr>
                        <td><%=chaps.get(i).getChap_numb()%></td>
                        <td><%=chaps.get(i).getName()%></td>
                        <td>
                            <a href="<%=request.getContextPath()%>/AdminControl?page=updateChap&id=<%=chaps.get(i).getId()%>">Sửa</a>|
                            <a href="<%=request.getContextPath()%>/AdminControl?page=deleteChap&id=<%=chaps.get(i).getId()%>">Xóa</a>
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
