<%-- 
    Document   : login
    Created on : Nov 25, 2018, 10:20:09 PM
    Author     : MyPC
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
        <title>Trang đăng nhập</title>
    </head>
   
    <body>
        
        <form action="them" method="post">
            UserName: <input id="text" type="text" name="username" required>
            Password: <input type="password" name="password" required>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
