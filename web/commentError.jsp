<%-- 
    Document   : commentError
    Created on : Dec 4, 2018, 10:46:30 PM
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/commentError.css">
        <title>Thông báo</title>
    </head>
    <body>
        <div class="main-content">
            <div class="container">
                <h1>Bạn cần đăng nhập mới có thể bình luận!</h1>
                <a href="<%=request.getContextPath() %>/Control?page=login">Tới trang đăng nhập</a><br>
                <a href="<%=request.getContextPath() %>/Control?page=register">Không có tài khoản?</a><br>
                <a href="<%=request.getContextPath() %>/Control?page=home">Về trang chủ</a><br>
            </div>
        </div>
    </body>
</html>
