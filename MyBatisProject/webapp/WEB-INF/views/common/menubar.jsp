<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	    
    <style>
        .login-area a{
            text-decoration: none;
            color:black;
            font-size: 12px;
        }
        .nav-area{
            background-color: black;
            color: white;
            height: 50px;
        }
        .menu{
            display: table-cell;
            width: 250px;
            height: 50px;
            vertical-align: middle;
            font-size: 20px;
            font-weight: bold;
        }
        .menu:hover {
            background-color: gray;
            cursor: pointer;
        }
        .outer{
            width: 900px;
            color:white;
            background-color: black;
            margin: auto;
            margin-top: 50px;
            padding: auto;
            padding-bottom: 50px;
        }
    
    </style>
    </head>
    <body>
    <c:if test="${not empty alertMsg}">
         <script>
            alert("${alertMsg}");
         </script>
      
         <c:remove var="alertMsg"/>
    </c:if>
      
        <h1 align="center">Mybatis !!</h1>
        <br>
        <div class="login-area" align="right">
        <!-- 로그인 전 -->
        <c:choose>
        	<c:when test="${empty loginUser }">
        	
            <form action="login.me" method="post">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="userId" required></td>
                        <td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="userPwd" id="" required></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <a href="enrollForm.me">회원가입</a>
                            <a href="">아이디/비밀번호 찾기</a>
                        </td>
                    </tr>
                </table>
            </form>
            </c:when>
            <c:otherwise>
            <br>
            <!--로그인 후-->
            <div>
                <table>
                    <tr>
                        <td colspan="2">${sessionScope.loginUser.userName}님 환영합니다.</td>
                    </tr>
                    <tr>
                        <td><a href="">마이페이지</a> | </td>
                        <td><a href="logout.me">로그아웃</a></td>
                    </tr>
                </table>
            </div>
            </c:otherwise>
        </c:choose>
        </div>
            
        <br>
    
        <div class="nav-area" align="center">
            <div class="menu">HOME</div>
            <div class="menu">공지사항</div>
            <div class="menu" onclick="location.href='list.bo?currentPage=1'">게시판</div>
            <div class="menu">ETC</div>
        </div>
    
    </body>
    
    </html>
    
    
    
    
    
    
    
    
    
    
    
  
  





  
    
    
    
    