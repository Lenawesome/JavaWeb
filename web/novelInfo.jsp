
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
    String count = (String)request.getAttribute("count");
    if(novels!=null){
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/novelInfo.css">
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
             function myFunction() {
              var x = document.getElementById("top");
              if (x.className === "top") {
                x.className += " responsive";
              } else {
                x.className = "top";
              }
            }
            window.onload = disabled;
        </script>
    </head>
    <body>
        <div id="top" class="top">
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
                        <a class="menu-button" href="javascritp:void(0)" onclick="myFunction()">Menu</a>
        </div>
                        <%
                            if(session.getAttribute("userName")!=null){
                        %>
                        <div id="welcome">Xin chào <%=session.getAttribute("userName")%></div>
                        <%}%>
        <div class="main-content">

            <div class="section-1">
                <div class="title-list">*Thông tin truyện*</a></div>
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
                    <div class="rating">
                            <span><b id="star-b">Đánh giá truyện:</b></span>
                                <%
                                if (novels.get(0).getRating()<0.25) {
                                %>
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                    }
                                if(novels.get(0).getRating()>=0.25&&novels.get(0).getRating()<0.75){
                                    %>
                                <img src="./images/star-half-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                    }
                                 if (novels.get(0).getRating()>=0.75&&novels.get(0).getRating()<1.25) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=1.25&&novels.get(0).getRating()<1.75) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-half-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=1.75&&novels.get(0).getRating()<2.25) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-off-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=2.25&&novels.get(0).getRating()<2.75) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-half-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=2.75&&novels.get(0).getRating()<3.25) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-off-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=3.25&&novels.get(0).getRating()<3.75) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-half-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=3.75&&novels.get(0).getRating()<4.25) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png" />
                                <img src="./images/star-off-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=4.25&&novels.get(0).getRating()<4.75) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png" />
                                <img src="./images/star-half-big.png"  />
                                <%
                                }
                                if (novels.get(0).getRating()>=4.75) {
                                  %>
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png"  />
                                <img src="./images/star-on-big.png" />
                                <img src="./images/star-on-big.png"  />
                                <%
                                }
                                %>
                                <span><b id="star-b">~~~<b id="point"><%=novels.get(0).getRating()%></b>/5~~~với tổng <%=count%> đánh giá</b></span>
                        </div>
                       
                    <%
                            if((session.getAttribute("userName")!=null)&&(session.getAttribute("point")==null)){
                                
                        %>
                        
                        <div>
                            <form class="rating" action="danh-gia" method="post"><span><b id="star-b">Bạn chưa đánh giá truyện này:</b></span>
                                <label for="submit1" ><img class="rate" id="btnUp1"  src="./images/star-off-big.png" title="Chán"  onmouseover="change1() " onmouseout="changeback1()"/></label>
                                <input id="submit1" class="hidden" type="submit" name="star" value="1"/>
                                <label for="submit2" ><img  class="rate" id="btnUp2"  src="./images/star-off-big.png" title="Hơi chán" onmouseover="change1(),change2()" onmouseout="changeback2(),changeback1()"/></label>
                                <input id="submit2" class="hidden" type="submit" name="star" value="2" />
                                <label for="submit3" ><img class="rate" id="btnUp3"  src="./images/star-off-big.png" title="Tạm được"  onmouseover="change1(),change2(),change3()" onmouseout="changeback3(),changeback2(),changeback1()"/></label>
                                <input id="submit3" class="hidden" type="submit" name="star" value="3"/>
                                <label for="submit4" ><img class="rate" id="btnUp4" src="./images/star-off-big.png" title="Hay phết" onmouseover="change1(),change2(),change3(),change4()" onmouseout="changeback4(),changeback3(),changeback2(),changeback1()"/></label>
                                <input id="submit4" class="hidden" type="submit" name="star" value="4" />
                                <label for="submit5" ><img class="rate" id="btnUp5"  src="./images/star-off-big.png" title="Tuyệt vời"  onmouseover="change1(),change2(),change3(),change4(),change5()" onmouseout="changeback5(),changeback4(),changeback3(),changeback2(),changeback1()"/></label>
                                <input id="submit5" class="hidden" type="submit" name="star" value="5"/>
                                <em id="star-hiden"></em>
                            </form>
                            
                        </div>
                        
                        <%}if (session.getAttribute("point")!=null) {%>
                        <div class="rating">
                            <span><b id="star-b">Bạn đã đánh giá truyện này:~~~<b id="point"><%=session.getAttribute("point")%></b>/5 điểm~~~</b></span>
                        </div>
                                
                        <%}%>
                    <div class="novel-name"><%=novels.get(i).getName()%></div>
                    <div class="novel-description">
                        <%=novels.get(i).getDescription()%>
                    </div>
                </div>
                <%}%>
                <div class="right">
                    <div class="title-list">*Truyện cùng tác giả*</div>
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
                        Chap <%=listChaps.get(j).getChap_numb()%>: <%=listChaps.get(j).getName()%><br>
                    </a>
                    <%}%>
                </div>          
            </div>            
            <div class="section-3">
                <div class="title-list">*Bình luận truyện*</div>
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
                <form action="them-binh-luan" method="post">
                    <input type="hidden" value="2" name="add">
                        <input type="hidden" name="idNovel" value="<%=novels.get(0).getId()%>">
                        <input type="submit" id="load-comments"value="Tải thêm bình luận">
                </form>
                
            </div>
        </div>
        
        
        <div id="footer">
            <div id="footer-data">
                <a href="#top">@2018 By Team 5</a>
            </div>
        </div>
                        <button id="button-top" onclick="backtop()">Về đầu trang</button>
        <script type="text/javascript">
            window.onscroll = function(){
                scroll()
            };
            function scroll(){
                if(document.body.scrollTop > 20||document.documentElement.scrollTop >20){
                    document.getElementById('button-top').style.display = "block";
                }else{
                    document.getElementById('button-top').style.display = "none";

                }
            }
            function backtop(){
                document.body.scrollTop = 0;
                document.documentElement.scrollTop = 0;
            }
function change1(){ 
document.getElementById("btnUp1").src= "./images/star-on-big.png"; 
document.getElementById("star-hiden").innerHTML="~~Chán~~";
} 
function change2(){ 
document.getElementById("btnUp2").src= "./images/star-on-big.png";
document.getElementById("star-hiden").innerHTML="~~Hơi chán~~";
} 
function change3(){ 
document.getElementById("btnUp3").src= "./images/star-on-big.png";
document.getElementById("star-hiden").innerHTML="~~Tạm được~~";
} function change4(){ 
document.getElementById("btnUp4").src= "./images/star-on-big.png";
document.getElementById("star-hiden").innerHTML="~~Hay đó~~";
} 
function change5(){ 
document.getElementById("btnUp5").src= "./images/star-on-big.png";
document.getElementById("star-hiden").innerHTML="~~Tuyệt vời~~";
}
function changeback1(){ 
document.getElementById("btnUp1").src= "./images/star-off-big.png";
document.getElementById("star-hiden").innerHTML="";
} 
function changeback2(){ 
document.getElementById("btnUp2").src= "./images/star-off-big.png";
document.getElementById("star-hiden").innerHTML="";
} 
function changeback3(){ 
document.getElementById("btnUp3").src= "./images/star-off-big.png";
document.getElementById("star-hiden").innerHTML="";
} 
function changeback4(){ 
document.getElementById("btnUp4").src= "./images/star-off-big.png";
document.getElementById("star-hiden").innerHTML="";
} 
function changeback5(){ 
document.getElementById("btnUp5").src= "./images/star-off-big.png";
document.getElementById("star-hiden").innerHTML="";
} 
            
        </script>
    </body>
</html>
<%}
else{
    response.sendRedirect("error.jsp");
}
session.removeAttribute("point");
%>