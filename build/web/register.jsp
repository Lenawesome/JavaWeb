<%-- 
    Document   : register
    Created on : Nov 25, 2018, 10:20:59 PM
    Author     : MyPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/register.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trang đăng ký</title>
    </head>
    <script type="text/javascript">
        function display(){
            var succes = "<%=session.getAttribute("succes")%>";
            var valid = "<%=session.getAttribute("valid")%>";
            var retypedPassword = "<%=session.getAttribute("retypedPassword")%>";
            var user = "<%=session.getAttribute("user")%>";
            var password = "<%=session.getAttribute("password")%>";
            document.getElementById('succes').style.display="none";
            document.getElementById('valid').style.display="none";
            document.getElementById('user').style.display="none";
            document.getElementById('retyped').style.display="none";
            document.getElementById('pass').style.display="none";
            if(succes!=="null"){
                document.getElementById('succes').style.display="block";
            }
            if(valid !== "null"){
                document.getElementById('valid').style.display="block";
            }
            if(retypedPassword !== "null"){
                document.getElementById('retyped').style.display="block";
            }
            if(user !== "null"){
                document.getElementById('user').style.display="block";
            }
            if(password !== "null"){
                document.getElementById('pass').style.display="block";
            }
            
        }
        window.onload = display;
    </script>
    <body>
        <div class="main-content">
            <div id="login-box">
                <div id="form-container">
                    
                    <div class="caution" id="succes">Đăng ký thành công</div>
                    <div class="caution" id="retyped">Mật khẩu không khớp</div>
                    <div class="caution" id="pass">Mật khẩu không hợp lệ</div>
                    <div class="caution" id="user">Tên tài khoản không hợp lệ</div>
                    <div class="caution" id="valid">Tên tài khoản đã tồn tại</div>
                    <div id="title">Đăng ký</div>
                    <form action="dang-ky" method="post">
                        <input type="text" name="username" placeholder="Tên tài khoản: " required>
                        <div class="caution">(Tên tài khoản it nhất 5 ký tự và không gồm ký tự đặc biệt)</div>
                        <input type="password" name="password" placeholder="Mật khẩu" required>
                        <div class="caution">(Mật khẩu ít nhất 5 ký tự )</div>
                        <input type="password" name="retyped-password" placeholder="Nhập lại mật khẩu" required>
                        <input type="submit" value="Đăng ký">
                        <a href="<%=request.getContextPath() %>/Control?page=home">Quay lại trang chủ?</a><br>
                        <a href="<%=request.getContextPath() %>/Control?page=login">Tới trang đăng nhập</a><br>
                    </form>                    
                </div>
            </div>
        </div>
    </body>
</html>
<%
    session.removeAttribute("succes");
    session.removeAttribute("valid");
    session.removeAttribute("retypedPassword");
    session.removeAttribute("user");
    session.removeAttribute("password");
%>