<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="${root}/">Happy House</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="${root}/">홈</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${root}/">해피하우스</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="${root}/">공지사항</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/house/list?pg=1&key=&word=">주택 실거래</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/">주변
						탐방</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/">관심
						지역</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/"
					data-toggle="modal" data-target="#favoriteAdd">관심 지역 등록</a></li>
			</ul>
		</div>
		
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${empty userinfo}">
						<li class="nav-item"><a class="nav-link"
							href="${root}/user/login" id="login">로그인</a></li>
						<li class="nav-item" id="signUp"><a class="nav-link"
							href="${root}/mvsignup">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item" id="logout"><a class="nav-link"
							href="${root}/user/logout">로그아웃</a></li>
						<li class="nav-item" id="mypage"><a class="nav-link"
							href="${root}/">마이 페이지</a></li>
					</c:otherwise>
				</c:choose>
				
				<li class="nav-item" id="adminpage" style=""><a
					class="nav-link" href="${root}/user/list">회원 정보 페이지</a></li>
			</ul>
		</div>
	</div>
</nav>

