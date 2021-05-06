<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<script src="js/main.js"></script>
<script defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJbB62ROqMY8zYaObopG8mXy2BqSwESBk&callback=initMap&libraries=&v=weekly"></script>

<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script type="text/javascript">
		var key = "";
		
		function search(){
			var value = document.getElementById("dataInput").value;
			document.getElementById("houseSearch").action = "<%=root%>/main.do?action=search&key=" + key + "&value=" + value;
			document.getElementById("houseSearch").submit();			
		}
		
		function changeKey(str){
			console.log(str);
			if(str == 'all'){
				document.getElementById("searchStandard").value = "전체";
			} else if(str == 'dong'){
				document.getElementById("searchStandard").value = "동 별 검색";
			} else if (str == 'AptName'){
				document.getElementById("searchStandard").value = "아파트 별 검색";
			}
			key = str;
		}
		
		
		function loginfunc() {
			if(!$('#loginModal #loginID').val()){
				alert('아이디를 입력하세요')
				return;
			}
			if(!$('#loginModal #loginPassword').val()){
				alert('비밀번호를 입력하세요')
				return;
			}
			document.getElementById("loginform").action = "<%=root%>/main.do";
			document.getElementById("loginform").submit();
			
		}


		function joinfunc() {
			if(!$('#joinModal #usrID').val()){
				alert('아이디를 입력하세요')
				return;
			}
			if(!$('#joinModal #usrPassword').val()){
				alert('비밀번호를 입력하세요')
				return;
			}
			if(!$('#joinModal #usrPasswordCheck').val()){
				alert('비밀번호 확인를 입력하세요')
				return;
			}
			if(!$('#joinModal #usrName').val()){
				alert('이름를 입력하세요')
				return;
			}
			
			if($('#joinModal #usrPassword').val() != $('#joinModal #usrPasswordCheck').val()){
				alert('비밀번호가 일치하지 않습니다.')
				return;
			}
			document.getElementById("joinform").action = "<%=root%>/main.do";
			document.getElementById("joinform").submit();
			
		}
		
		function updateMember(){
			if(!$('#personUpdateModal #puID').val()){
				alert('아이디를 입력하세요')
				return;
			}
			if(!$('#personUpdateModal #puPassword').val()){
				alert('비밀번호를 입력하세요')
				return;
			}
			if(!$('#personUpdateModal #puPasswordCheck').val()){
				alert('비밀번호 확인를 입력하세요')
				return;
			}
			if(!$('#personUpdateModal #puName').val()){
				alert('이름를 입력하세요')
				return;
			}
			
			if($('#personUpdateModal #puPassword').val() != $('#personUpdateModal #puPasswordCheck').val()){
				alert('비밀번호가 일치하지 않습니다.')
				return;
			}
			document.getElementById("updateform").action = "<%=root%>/main.do";
			document.getElementById("updateform").submit();
		}
		
		function deleteMember(){
			if(!$('#personDeleteModal #pdID').val()){
				alert('아이디를 입력하세요')
				return;
			}
			if(!$('#personDeleteModal #pdPassword').val()){
				alert('비밀번호를 입력하세요')
				return;
			}
			if(!$('#personDeleteModal #pdPasswordCheck').val()){
				alert('비밀번호 확인를 입력하세요')
				return;
			}
			
			if($('#personDeleteModal #pdPassword').val() != $('#personDeleteModal #pdPasswordCheck').val()){
				alert('비밀번호가 일치하지 않습니다.')
				return;
			}
			document.getElementById("deleteform").action = "<%=root%>/main.do";
			document.getElementById("deleteform").submit();
		}
		function addFavorite(){
			if(!$('#favoriteUpdateModal #favdong').val()){
				alert('이름를 입력하세요')
				return;
			}
			document.getElementById("addfavoriteform").action = "<%=root%>/main.do";
			document.getElementById("addfavoriteform").submit();
		}
		
	</script>
<style>
#map {
	height: 100%;
}

#searchStandard {
	text-align: center;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<!-- Login start-->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container justify-content-end">
			<!-- Links -->
			<ul class="navbar-nav" id="header">
				<c:choose>
					<c:when test="${empty userinfo}">
						<li class="nav-item"><a class="nav-link loginX" href="#"
							data-toggle="modal" data-target="#loginModal">로그인</a></li>
						<li class="nav-item"><a class="nav-link loginX" href="#"
							data-toggle="modal" data-target="#joinModal">회원가입</a></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link loginO" id="logout"
							href="<%=root%>/main.do?action=logout" name="logout">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link loginO"
							onclick=updateMainSite(1)
							href="<%=root%>/main.do?action=listmember">${userinfo.userid}님</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="#">사이트맵</a></li>
				<li class="nav-item"><a class="nav-link" href="#">웹페이지 소개</a></li>
				<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
			</ul>
		</div>
	</nav>
	<!-- Login end -->
	<!-- Logo start -->
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1 onclick=updateMainSite(0)>Happy Home</h1>
	</div>
	<!-- Logo end -->

	<!-- Main Content start -->

	<c:if test="${empty move}">
		<div class="container" id="showData" style="display: none">
			<!-- topMenu start-->
			<nav class="navbar navbar-expand-sm bg-light justify-content-center">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<%=root%>/main.do?action=search" id="home-table">실거래가</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						id="store-table">동네업종</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						id="air-table">대기오염</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						id="hospital-table">코로나 검사</a></li>
				</ul>
			</nav>
			<br>
			<!-- topMenu end -->
			<div class="row">
				<!-- Right Content start -->
				<div class="col-sm-12">
					<!-- 현재 클릭한 제목 -->
					<div class="jumbotron bg-white text-center"
						style="margin-bottom: 0">
						<h1 id="search-title">실거래가</h1>
					</div>
					<div id="map" style="height: 500px"></div>

					<!-- 검색 창 -->
					<form id="houseSearch" method="post" action="">

						<div class="row mt-3">
							<div class="col-sm-3 text-right">
								<div class="dropdown">
									<button type="button"
										class="btn btn-primary dropdown-toggle btn-block"
										data-toggle="dropdown" id="searchStdName">검색 기준</button>
									<div class="dropdown-menu" id="dropdown-menu">
										<a class="dropdown-item searchStd"
											href="javascript:changeKey('all');">전체</a> <a
											class="dropdown-item searchStd"
											href="javascript:changeKey('dong');">동</a> <a
											class="dropdown-item searchStd"
											href="javascript:changeKey('AptName');">아파트</a>
									</div>
								</div>
							</div>
							<div class="col-sm-2">
								<input type="text" id="searchStandard" value="전체" readonly><br>
							</div>
							<div class="col-sm-4">
								<input type="text" class="form-control w-100" id="dataInput"
									placholder="내용을 입력하세요">
							</div>
							<div class="col-sm-2 text-left">
								<button type="button" class="btn btn-primary btn-block"
									onclick="javascript:search();">검색</button>
							</div>

						</div>
					</form>
					<!-- 테이블 -->

					<div class="text-center mt-3">
						<c:choose>
							<c:when test="${empty houselist}">
								<div class="jumbotron">
									<h1>검색된 데이터가 없습니다.</h1>
								</div>
							</c:when>
							<c:otherwise>
								<table class="table table-striped" id="mainTable">
									<thead>
										<tr>
											<th>번호</th>
											<th>아파트이름</th>
											<th>동</th>
											<th>건축년도</th>
											<th>거래량</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='house' items='${houselist}'>
											<tr>
												<td>${house.no}</td>
												<td>${house.aptName}</td>
												<td>${house.dong}</td>
												<td>${house.buildYear}</td>
												<td>${house.dealAmount}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!-- 검색 화면 -->
				<!-- 테이블 -->
				<!-- Right Content end -->
			</div>

		</div>
	</c:if>
	<!-- Main Content end -->

	<!-- -------------------수정 부분 끝-------------------------- -->

	<!-- 공지사항 start-->
	<div class="container" id="mainInfo">
		<div class="jumbotron text-center bg-white"
			style="margin-bottom: 0; height: 200px">
			<h3>공지사항</h3>
		</div>
		<!-- 게시글 목록 -->
		<div id="post-main">
			<form id="postSearch" method="post" action="">
				<div class="row mt-3">
					<div class="col-sm-2">
						<button type="button" class="btn btn-primary newPost">글쓰기</button>
					</div>
					<div class="col-sm-5"></div>
					<div class="col-sm-2 text-right">
						<div class="dropdown">
							<button type="button"
								class="btn btn-outline-primary dropdown-toggle"
								data-toggle="dropdown">검색 방법</button>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#">아이디</a> <a
									class="dropdown-item" href="#">번호</a>
							</div>
						</div>
					</div>

					<div class="col-sm-2">
						<input type="text" class="form-control" id="usr">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary">검색</button>
					</div>
				</div>
			</form>
			<div class="mt-3">
				<c:if test="${not empty postlist}">
					<table class="table" id="table">
						<thead>
							<tr>
								<th style="width: 10%">글 번호</th>
								<th style="width: 50%">제목</th>
								<th style="width: 20%">작성자</th>
								<th style="width: 10%">조회수</th>
								<th style="width: 10%">작성일</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</c:if>
				<c:if test="${empty postlist}">
					<div class="jumbotron">
						<h1>공지사항이 없습니다.</h1>
					</div>
				</c:if>
			</div>
		</div>
		<!-- 게시글 목록 End -->
		<!-- 게시글 작성 -->
		<div class="container" id="post-write" style="display: none;">
			<div class="form-group">
				<label for="email">제목:</label> <input type="text"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="pwd">내용:</label> <input type="text" class="form-control"
					style="height: 400px">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary newPost">글작성</button>
				<button type="submit" class="btn btn-warning">초기화</button>
				<button type="submit" class="btn btn-secondary"
					onclick=updateMainSite(2)>목록</button>
			</div>
		</div>
		<!-- 게시글 작성 End -->
		<!-- 게시글 보기 -->
		<div class="container mt-3" id="post-one" style="display: none;">
			<div class="mt-3">
				<button type="button" class="btn btn-primary newPost">새글쓰기</button>
				<button type="button" class="btn btn-info">수정</button>
				<button type="button" class="btn btn-danger">삭제</button>
			</div>
			<table class="table table-hover mt-3" border="1"
				bordercolor="lightgray">
				<thead>
					<tr>
						<th>제목</th>
						<th colspan="5" id="Ttitle"></th>
					</tr>

					<tr>
						<th>작성자</th>
						<td id="Tid"></td>
						<th>조회수</th>
						<td id="Tcheck"></td>
						<th>작성일</th>
						<td id="Tdate"></td>
					</tr>
				</thead>
				<tbody>
					<tr height="200px">
						<td colspan="6" id="Tcontent"></td>
					</tr>
				</tbody>
			</table>
			<div class="text-center">
				<button type="button" class="btn btn-info">최신목록</button>
				<button type="button" class="btn btn-info">이전목록</button>
			</div>
			<div class="row mt-3">
				<div class="col-sm-11">
					<textarea class="form-control" rows="5" id="comment"></textarea>
				</div>
				<div class="col-sm-1">
					<button type="button" rows="5" class="btn btn-primary"
						style="height: 100%">작성</button>
				</div>
			</div>
		</div>
		<!-- 게시글 보기 End -->
		<!-- 게시글 수정 버튼 삭제 버튼 활성화 -->
	</div>

	<!-- 회원정보 start-->
	<c:if test="${not empty move}">
		<div class="container" id="personData">
			<div class="jumbotron text-center bg-white"
				style="margin-bottom: 0; height: 200px">
				<h3>회원 정보</h3>
			</div>
			<div class="row">
				<c:if test="${not empty members}">
					<div class="col-sm-9 bg-black">
						<table class="table text-center">
							<thead>
								<tr>
									<th style="width: 20%">ID</th>
									<th style="width: 20%">Name</th>
									<th style="width: 25%">E-mail</th>
									<th style="width: 35%">관심지역</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='mem' items='${members}'>
									<tr>
										<th>${mem.userid}</th>
										<th>${mem.username}</th>
										<th>${mem.email}</th>
										<th><c:if test="${not empty favorites}">
												<c:forEach var='favorite' items='${favorites}'>
													<c:if test="${mem.userid eq favorite.userid}">
															${favorite.dongcode}<br>
													</c:if>
												</c:forEach>
											</c:if></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-sm-3">
						<div class="btn-group-vertical mt-3">
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#favoriteUpdateModal">관심지역
								추가</button>
						</div>
						<div class="btn-group-vertical mt-3">
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#joinModal">회원정보 추가</button>
						</div>
						<div class="btn-group-vertical mt-3">
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#personUpdateModal">회원정보
								수정</button>
						</div>
						<div class="btn-group-vertical mt-3">
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#personDeleteModal">회원정보
								삭제</button>
						</div>
						<div class="btn-group-vertical mt-3">
							<button type="button" class="btn btn-outline-primary"
								data-toggle="modal" data-target="#personSearchModal">회원정보
								검색</button>
						</div>
				</c:if>
				<c:if test="${empty members}">
					<div class="col-sm-9 jumbotron">
						<h1>검색된 데이터가 없습니다.</h1>
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
	<!-- 회원정보 end -->
	<!-- 웹사이트 소개 start-->
	<div class="container" id="websiteInfo">
		<div class="jumbotron text-center bg-white"
			style="margin-bottom: 0; height: 200px">
			<h3>웹사이트 소개</h3>
		</div>
		<hr>
	</div>
	<!-- 웹사이트 소개 end-->

	<!-- 비밀번호 찾기 start-->
	<div class="container" id="findPassword">
		<div class="jumbotron text-center bg-white"
			style="margin-bottom: 0; height: 200px">
			<h3>비밀번호 찾기</h3>
		</div>
		<div>
			<div class="form-group">
				<label for="email">ID:</label> <input type="text"
					class="form-control" placeholder="Enter ID" id="pfid">
			</div>
			<div class="form-group">
				<label for="pwd">Email:</label> <input type="email"
					class="form-control" placeholder="Enter eamil" id="pfemail">
			</div>
			<button type="submit" class="btn btn-primary" id="findPasswordbtn">Find
				Password</button>
		</div>
	</div>
	<!-- 비밀번호 찾기 end-->
	<!-- 사이트 맵 start -->
	<div class="container text-center" id="siteMap">
		<div class="jumbotron bg-white"
			style="margin-bottom: 0; height: 200px">
			<h3>사이트맵</h3>
		</div>
		<div class="alert alert-success " style="cursor: pointer"
			onclick=updateMainSite(0)>
			<strong>메인 홈페이지</strong>
		</div>
		<div class="alert alert-info" style="cursor: pointer"
			onclick=updateMainSite(1)>
			<strong>회원 정보</strong>
		</div>
		<div class="alert alert-warning" style="cursor: pointer"
			onclick=updateMainSite(2)>
			<strong>공지사항</strong>
		</div>
		<div class="alert alert-primary" style="cursor: pointer"
			onclick=updateMainSite(3)>
			<strong>웹사이트 소개</strong>
		</div>
		<div class="alert alert-secondary" style="cursor: pointer"
			onclick=updateMainSite(4)>
			<strong>비밀번호 찾기</strong>
		</div>
		<div class="alert alert-dark" style="cursor: pointer"
			onclick=updateMainSite(5)>
			<strong>사이트맵</strong>
		</div>
	</div>
	<!-- 사이트 맵 end -->
	<hr>
	<footer class="footer">
		<div class="container">
			<span class="text-muted">SSAFY 서울 8반 박호현, 양동혁</span>
		</div>
	</footer>
	<!-- Modal Start -->
	<!-- Login Start -->
	<div class="modal" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->

				<form id="loginform" method="post" action="">
					<input type="hidden" name="action" id="action" value="login">
					<div class="container">
						<div>
							<label for="usr">ID</label> <input type="text"
								class="form-control" id="loginID" name="loginID">
						</div>
						<div>
							<label for="usr">Password</label> <input type="password"
								class="form-control" id="loginPassword" name="loginPassword">
						</div>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" id="login"
								onclick="javascript:loginfunc();">Login</button>
							<button type="button" class="btn btn-primary"
								onclick=updateMainSite(4)>비밀번호 찾기</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	<!-- Login End -->
	<!-- Join Start -->
	<div class="modal" id="joinModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">회원가입</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->

				<form id="joinform" method="post" action="">
					<input type="hidden" name="action" id="action" value="join">


					<div class="container">
						<div>
							<label for="usr">ID</label> <input type="text"
								class="form-control" id="usrID" name="usrID">
						</div>
						<div>
							<label for="usr">Password</label> <input type="password"
								class="form-control" id="usrPassword" name="usrPassword">
						</div>
						<div>
							<label for="usr">Password Check</label> <input type="password"
								class="form-control" id="usrPasswordCheck"
								name="usrPasswordCheck">
						</div>

						<div>
							<label for="usr">Email</label> <input type="email"
								class="form-control" id="usrEmailCheck" name="usrEmailCheck">
						</div>
						<div>
							<label for="usr">Name</label> <input type="text"
								class="form-control" id="usrName" name="usrName">
						</div>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" id="join"
								onclick="javascript:joinfunc();">Join</button>
						</div>


						<c:if test="${not empty joinmsg}">
							<div>
								<div class="col-lg-6 text-danger">
									<span>${joinmsg}</span>
								</div>
							</div>
						</c:if>


					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Join End -->


	<!-- personUpdate Start -->
	<div class="modal" id="personUpdateModal" name="personUpdateModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">회원 정보 변경</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->

				<form id="updateform" method="post" action="">
					<input type="hidden" name="action" id="action" value="updatemember">

					<div class="container">
						<div>
							<label for="usr">ID</label> <input type="text"
								class="form-control" id="puID" name="puID">
						</div>
						<div>
							<label for="usr">Password</label> <input type="password"
								class="form-control" id="puPassword" name="puPassword">
						</div>
						<div>
							<label for="usr">Password Check</label> <input type="password"
								class="form-control" id="puPasswordCheck" name="puPasswordCheck">
						</div>
						<div>
							<label for="usr">Email</label> <input type="email"
								class="form-control" id="puEmailCheck" name="puEmailCheck">
						</div>
						<div>
							<label for="usr">Name</label> <input type="text"
								class="form-control" id="puName" name="puName">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" id="Update"
								onclick="javascript:updateMember();">Update</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- personUpdate End -->
	<!-- personDelete Start -->
	<div class="modal" id="personDeleteModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">회원 삭제</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->

				<form id="deleteform" method="post" action="">
					<input type="hidden" name="action" id="action" value="deletemember">
					<div class="container">
						<div>
							<label for="usr">ID</label> <input type="text"
								class="form-control" name="pdID" id="pdID">
						</div>
						<div>
							<label for="usr">Password</label> <input type="password"
								class="form-control" name="pdPassword" id="pdPassword">
						</div>
						<div>
							<label for="usr">Password Check</label> <input type="password"
								class="form-control" name="pdPasswordCheck" id="pdPasswordCheck">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" id="Delete"
								onclick="javascript:deleteMember();">Delete</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- personDelete End -->
	<!-- personSearch Start -->
	<div class="modal" id="personSearchModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">회원 검색</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="container">
					<div>
						main <label for="usr">이름</label> <input type="text"
							class="form-control" id="psID">
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" id="Search">Search</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- personSearch End -->
	<!-- favorites Start -->
	<div class="modal" id="favoriteUpdateModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title text-center">관심 지역 추가</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->

				<form id="addfavoriteform" method="post" action="">
					<input type="hidden" name="action" id="action" value="addfavorite">
					<div class="container">
						<div>
							<label for="usr">관심지역 입력 (동)</label> <input type="text"
								class="form-control" name="favdong" id="favdong">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="addFav"
								onclick="javascript:addFavorite();">Add</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- favorites End -->
	<!-- Modal End -->
</body>
</html>