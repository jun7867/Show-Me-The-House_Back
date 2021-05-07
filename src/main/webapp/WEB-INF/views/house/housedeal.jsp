<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>상품 목록 조회</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js" defer></script>
<script src="js/housedeal.js" defer></script>
<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#searchBtn").click(function() {
			
			if($("#word").val() == "") {
				alert("모든 목록 조회!!");
			} 
			$("#frm").attr("action", "${root}/room/list").submit();
		});

		
		
		$(".page-item").click(function() {
			$("#pg").val(($(this).attr("data-pg")));
			$("#pageform").attr("action", "${root}/room/list").submit();
		});

	});
</script>

</head>
<body>
	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/mainhome.jpeg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div style="padding: 50px 0 30px;"></div>
				</div>
			</div>
		</div>
	</header>

	<div style="margin-left: 30px;">
		<div class="form-inline">
			<select name="menu" class="form-control mr-1">
				<option selected>선택</option>
				<option value="">서울시</option>
				<option value="">인천시</option>
			</select> <select name="menu" class="form-control mr-1">
				<option selected>선택</option>
				<option value="">도봉구</option>
				<option value="">도봉구</option>
			</select> <select name="menu" class="form-control mr-1">
				<option selected>선택</option>
				<option value="">쌍문동</option>
				<option value="">쌍문동</option>
			</select>
		</div>
	</div>
	<!-- 체크박스 -->
	<div class="form-check-inline" style="margin-left: 30px;">
		<label class="form-check-label"> <input type="checkbox"
			class="form-check-input" value="" checked>All
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label"> <input type="checkbox"
			class="form-check-input" value="">아파트매매
		</label>
	</div>
	<div class="form-check-inline">
		<label class="form-check-label"> <input type="checkbox"
			class="form-check-input" value="">주택매매
		</label>
	</div>

	<!-- 감섹 칭  -->

	<!-- 컨텐츠 넣는 곳 -->
	<div class="col-12">
		<div class="form-row">
			<div class="col-12 col-md-10 mb-2 mb-md-0">
				<input type="email" class="form-control form-control-lg"
					placeholder="지역 또는 단지명을 입력하세요.">
			</div>
			<div class="col-2 col-md-2">
				<button type="submit" class="btn btn-block btn-primary">검색</button>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8">
				<!-- Embedded Google Map -->
				<iframe style="width: 100%; height: 1000px; border: 0;"
					src="http://maps.google.com/maps?hl=en&amp;ie=UTF8&amp;ll=37.0625,-95.677068&amp;spn=56.506174,79.013672&amp;t=m&amp;z=4&amp;output=embed"></iframe>
			</div>
			<div class="col-sm-4" id="housedeal__des" style="cursor: pointer;"
				onClick="location.href='houseview.html'">
				<h2>거래 정보</h2>
				<ul class="list-group" style="overflow-y: scroll; height: 1000px;">
					<li class="list-group-item">
						<div class="housedeal__p">
							<h4>E편한 세상</h4>
							<p>거래금액: 52,200</p>
							<p>전용면적: 84,200</p>
							<p>거래구분: 아파트매매</p>
							<p>거래일자: 2019.12.16</p>
						</div>
					</li>
					<li class="list-group-item">
						<div class="housedeal__p">
							<h4>스타필드</h4>
							<p>거래금액: 52,200</p>
							<p>전용면적: 44,200</p>
							<p>거래구분: 주택 매매</p>
							<p>거래일자: 2019.12.16</p>
						</div>
					</li>
					<li class="list-group-item">
						<div class="housedeal__p">
							<h4>강남 아파트</h4>
							<p>거래금액: 52,200</p>
							<p>전용면적: 84,200</p>
							<p>거래구분: 아파트매매</p>
							<p>거래일자: 2019.12.16</p>
						</div>
					</li>
					<li class="list-group-item">
						<div class="housedeal__p">
							<h4>강남 아파트</h4>
							<p>거래금액: 52,200</p>
							<p>전용면적: 84,200</p>
							<p>거래구분: 아파트매매</p>
							<p>거래일자: 2019.12.16</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
	  <h2>아파트 실거래 내역</h2>
	  <form class="form-inline"	id='frm' method="get" action="">
	  	  <input type='hidden' name='pg' id='pg' value="1">
		  <select name='key' id='key'>
		  	<option value='all'>--선택하세요--</option>
		  	<option value='dong'>동네</option>
		  	<option value='AptName'>아파트 이름</option>
		  </select>
		  <input type="text"  class="form-control" placeholder="Enter search word" id="word"  name='word'>
		  <button id="searchBtn" class="btn btn-primary">검색</button>
	  </form>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>아파트 번호</th>
	        <th>동네명</th>
	        <th>동네 지번</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:choose>
	    	<c:when test="${empty houses}">
	    		<tr><td colspan="3">조회할 상품 목록이 없습니다.</td>
	    	</c:when>
	    	<c:otherwise>
	    		<c:forEach var="housedeal" items="${houses}">
	    			<tr>
	    			<td>${housedeal.no} ${housedeal.aptName}</td>
	    			<td><a href="${root}/room/list?&no=${housedeal.no}">${housedeal.dong}</a></td>
	    			<td>${housedeal.jibun}</td>
	    		</c:forEach>
	    	</c:otherwise>
	    </c:choose>
	    </tbody>
	    <tfoot>
	    	<tr><th colspan='3' align='center'>${bean.pageLink}</th></tr>
	    </tfoot>
	  </table>
	</div> 

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>
