<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Happy house</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center">
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<!-- Page Header -->
<header class="masthead"
	style="background-image: url('img/mainhome.jpeg')">
	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="site-heading">
					<h1>Happy House</h1>
					<span class="subheading"></span>
					<form>
						<div class="form-row">
							<div class="col-12 col-md-10 mb-2 mb-md-0">
								<input type="email" class="form-control form-control-lg"
									placeholder="지역 또는 단지명을 입력하세요.">
							</div>
							<div class="col-12 col-md-2">
								<button type="submit" class="btn btn-block btn-primary">검색</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</header>
		<!-- Main Content -->
		<div class="container">
			<div class="row">
				<h2 class="post-title">추천 거래 정보</h2>
			</div>
			<div class="row">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque sequi
								doloribus.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque sequi
								doloribus totam ut praesentium aut.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque sequi
								doloribus.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque sequi
								doloribus totam ut praesentium aut.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<img class="card-img-top" src="https://placehold.it/300x200"
							alt="">
						<div class="card-body">
							<h4 class="card-title">월세 5000/20</h4>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente esse necessitatibus neque.</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary">Find Out More!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>