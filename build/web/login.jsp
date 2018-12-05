<%-- 
    Document   : login
    Created on : Nov 25, 2018, 10:20:09 PM
    Author     : MyPC
--%>

<%@page import="model.Genre"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%List<Genre> listGenre = (List<Genre>)request.getAttribute("listGenre");%>
<!DOCTYPE html>
<html>
    <head>
        <title> Đăng nhập </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        
    </head>
    <body>
        
        <div class="main-content">
            <div id="login-box">
                <div id="form-container">
                    <%if(session.getAttribute("isValid")!=null){
                        if(session.getAttribute("isValid").equals("false")){
                    %>
                    <div id="caution">Sai tên tài khoản hoặc mật khẩu</div>
                    <%}}%>
                <div id="title">Đăng nhập</div>
                    <form action="dang-nhap" method="post">
                        <input type="text" name="username" placeholder="Tên tài khoản: " required>
                        <input type="password" name="password" placeholder="Mật khẩu" required>
                        <input type="submit" value="Login">
                        <a href="<%=request.getContextPath() %>/Control?page=register">Không có tài khoản?</a><br>
                        <a href="<%=request.getContextPath() %>/Control?page=home">Quay lại trang chủ?</a>
                    </form>                    
                </div>
            </div>
        </div>
    </body>
</html>
