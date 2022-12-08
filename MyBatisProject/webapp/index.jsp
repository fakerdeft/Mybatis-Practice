<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 index...</h1>
	
	<!-- 
		* 프레임워크
		-개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 틀
		- 소프트웨어 개발에 공통으로 사용되는 라이브러리/개발도구/인터페이스 등등
		
		* 프레임워크의 필요성
		-현재 웹 프로그래밍 규모가 커지고 있고 거대하고 복잡한 규모의 프로젝트를 완성 시키기 위해서는 많은 인력이 필요.
		-그 개발자들이 "통일성" 있게 빠르고 안정적으로 개발하기에 프레임워크가 좋은 성과를 내고 있다.
		-즉, 생산성 향상에 큰 도움이 된다.
		
		* 프레임워크 특징
		-자유롭게 설계하고 코딩하는게 아니라 프레임워크가 제공하는 가이드대로 설계하고 코딩해야한다.
		-개발할 수 있는 범위가 정해져있음.
		-개발자를 위한 다양한 도구/ 플러그인들이 지원된다.
	
		*프레임워크의 장단점
		- 장점: 개발시간 단축, 오류로부터 자유로워진다.
	 	- 단점: 너무 의존하다보면 개발능력이 떨어져 프레임워크 없이 개발하는 것에 어려움이 생길 수 있음.
	 		프레임워크를 습득하는데 까지 시간이 걸린다.
	 	
	 	*프레임워크의 종류
	 	-영속성 프레임워크: 데이터 관련한 (CRUD) 기능들을 편리하게 작업할 수 있도록 하는 프레임워크 ex)mybatis
	 	-자바 프레임워크: 웹 애플리케이션에 초점을 맞춰 필요한 요소들을 모듈화하여 제공하는 프레임워크 ex)spring
	 	-화면구현 프레임워크: Front-end를 보다 쉽게 구현할 수 있게 틀을 제공해주는 프레임워크 ex)bootstrap
	 	-기능 및 지원 프레임워크: 특정 기능이나 업무 수행에 도움을 주는 기능을 제공해주는 프레임워크 ex)log4j
	 	
	 -->
	 
	 <!-- 인덱스 파일이 로딩되면 main으로 포워딩할 수 있게 작업 -->
	 <jsp:forward page="WEB-INF/views/main.jsp"/>
	 
	 
	 
</body>
</html>

























