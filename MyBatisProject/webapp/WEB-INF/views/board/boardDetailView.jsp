<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#detail-area{
		border:1px solid white;
	}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>	
	<div class="outer">
	<br>
	<h1 align="center">게시글 상세 조회</h1>
		<table id=detail-area align="center" border="1">
			<tr>
				<th width="70">게시글 번호</th>
				<th width="70">${b.boardNo }</th>
				<th width="70">제목</th>
				<th width="350">${b.boardTitle }</th>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${b.boardWriter }</td>
				<th>작성일</th>
				<td>${b.createDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td colspan="3">${b.count }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<p style="height:200px; white-space:pre;">${b.boardContent }</p>
				</td>
			</tr>
		</table>
	<br><br>
		<div id="reply-area">
			<table align="center" border="1">
				<thead>
				<tr>
				<c:if test="${not empty loginUser}">
					<td width="100">댓글작성</td>
					<td width="400"><textarea id="replyContent" rows="3" cols="50" style="resize: none"></textarea></td>
					<td width="100"><button onclick="insertReply();">등록</button></td>
				</c:if>
				<c:if test="${empty loginUser}">
					<td width="100"></td>
					<td width="400"></td>
					<td width="100"></td>
				</c:if>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td>작성일</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script>
			$(function() {
				selectReplyList();
				
				//1초마다 갱신
				setInterval(selectReplyList, 1000);
			});
			
			function insertReply() {
				$.ajax({
					url: "rinsert.bo",
					data: {
						bno: ${b.boardNo},
						content: $("#replyContent").val()
					},
					type: "post",
					success: function(result){
						if(result > 0) {
							console.log("댓글작성 성공");
							selectReplyList(); //댓글목록 갱신
							$("#replyContent").val("");
						} else {
							console.log("댓글작성 실패");
						}
					},
					error: function(){
						console.log("통신 실패");
					}
				});
			}
			
			function selectReplyList() {
				$.ajax({
					url: "rlist.bo",
					data: {bno: ${b.boardNo}},
					success: function(list) {
						var str = "";
						for(var i in list) {
							str += "<tr>"
									+ "<td>"+list[i].replyWriter+"</td>"
									+ "<td>"+list[i].replyContent+"</td>"
									+ "<td>"+list[i].createDate+"</td>"
									+ "</tr>";
						}
						$("#reply-area tbody").html(str);
					},
					error: function() {
						console.log("통신 실패");
					}
				});
			}
		</script>
	
<br><br><br><br><br><br><br><br><br><br>
</body>
</html>


















