
<%@page import="java.util.Date"%>
<%@page import="model.Comment"%>
<%@page import="model.Genre"%>
<%@page import="model.Chap"%>
<%@page import="java.util.List"%>
<%@page import="model.Novel"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%
    List<Novel> novels = (List<Novel>) request.getAttribute("listNovelById");
    List<Chap> listChaps = (List<Chap>) request.getAttribute("listChap");
    List<Genre> listAllGenres = (List<Genre>)request.getAttribute("listAllGenres");
    String strGenre = (String) request.getAttribute("strGenre");
    List<Comment> listComments = (List<Comment>) request.getAttribute("listComments");
    if(novels!=null){
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=novels.get(0).getName()%></title>
        <script type="text/javascript">
            function disabled(){
                var userName = "<%=(String)session.getAttribute("userName")%>";
                var x = document.getElementById("login");
                var y = document.getElementById("logout");
                x.style.display = "block";
                y.style.display = "none";
                if(userName!=="null"){
                    x.style.display = "none";
                    y.style.display = "block";
                }
            }
            window.onload = disabled;
        </script>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/novelInfo.css">
    </head>
    <body>
        <div id="top">
            <div id="mix-menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/Control?page=home">Trang chủ</a></li>
                    <li>
                        <a href="#">Thể loại</a>
                        <ul>
                            <%
                                for(int i = 0;i <listAllGenres.size();i++){
                            %>
                            <li><a href="<%=request.getContextPath()%>/Control?page=category&id=<%=listAllGenres.get(i).getId()%>">
                                    <%=listAllGenres.get(i).getName()%>
                                </a>
                            </li>
                            <%}%>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Thành viên</a>
                        <ul>
                            <li id="login"><a href="<%=request.getContextPath() %>/Control?page=login">Đăng nhập</a></li>
                            <li><a href="<%=request.getContextPath() %>/Control?page=register">Đăng ký</a></li>
                            <li id="logout"><a href="<%=request.getContextPath() %>/Control?page=logout">Đăng xuất</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="search-form" action="tim-kiem" method="post">
                    <input name="search-input"required id="search-box-input" type="text" placeholder="Tìm truyện, tác giả...">
                    <select name="option-input"id="dropdown-list">
                        <option value="name">Tên truyện</option>
                        <option value="author">Tác giả</option>
                    </select>
                    <input id="submit-button" type="submit" value="Search">
                </form>
            </div>
        </div>
                        <%
                            if(session.getAttribute("userName")!=null){
                        %>
                        <div id="welcome">Xin chào <%=session.getAttribute("userName")%></div>
                        <%}%>
        <div class="main-content">

            <div class="section-1">
                <div class="title-list">Thông tin truyện</a></div>
                <div class="left">
                    <%
                        
                        for(int i=0; i < novels.size();i++){
                    %>
                    <div class="novel">
                        <img src=<%=novels.get(i).getImgLink()%> class="image" alt="<%=novels.get(i).getName()%>">
                        <div class="novel-info"><b>Tác giả:</b> <%=novels.get(i).getAuthor()%></div>
                        <div class="novel-info"><b>Tình trạng:</b> <%=novels.get(i).getStatus()%></div>
                        <div class="novel-info"><b>Thể loại: </b><%=strGenre%></div>
                      
                    </div>
                </div>
                <div class="middle">
                    <div class="novel-name"><%=novels.get(i).getName()%></div>
                    <div class="novel-description">
                        <%=novels.get(i).getDescription()%>
                    </div>
                </div>
                <%}%>
                <div class="right">
                    <div class="title-list">Truyện cùng tác giả</div>
                    <div class="related-novel">
                        <%
                            List<Novel> listNovelByAuthor = (List<Novel>)request.getAttribute("listNovelByAuthor");
                            for(int j=0; j<listNovelByAuthor.size();j++){
                        %>
                        <a href="<%=request.getContextPath()%>/Control?page=view-info&id=<%=listNovelByAuthor.get(j).getId()%>">
                            <%=listNovelByAuthor.get(j).getName()%><br>
                        </a>
                        <%}%>
                    </div>
                </div>
            </div>
            <div class="section-2">
                <div class="title-list">Danh sách chương</div>            
                <div class="chap-list">
                     <%
                        for(int j=0; j<listChaps.size();j++){
                    %>
                    <a href="<%=request.getContextPath()%>/Control?page=chap-info&id=<%=listChaps.get(j).getId()%>">
                        <%=listChaps.get(j).getName()%><br>
                    </a>
                    <%}%>
                </div>          
            </div>            
            <div class="section-3">
                <div class="title-list">Bình luận truyện</div>
                <div class="user-input">
                    <form action="dang-binh-luan" method="post">
                        <textarea required id="comment" name="comment" rows="2" placeholder="Thêm bình luận..."></textarea><br>
                        <input type="hidden" name="idNovel" value="<%=novels.get(0).getId()%>">
                        <input type="submit" value="Đăng">
                    </form>
                </div>
                <div class="comment-list">
                    <%
                        for(int i=0; i <listComments.size();i++){
                    %>
                    <div class="comment">
                        <div class="content"><%=listComments.get(i).getUserName()%>: <%=listComments.get(i).getContent()%></div>
                        <div class="time"><%=listComments.get(i).getTime()%></div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        
        
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
    </body>
</html>
<%}
else{
    response.sendRedirect("error.jsp");
}
%>