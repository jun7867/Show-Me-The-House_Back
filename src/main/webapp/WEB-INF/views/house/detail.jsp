<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   


<!DOCTYPE html>
<html lang="ko">
<head>
  <title>집 상세 정보</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container" align="center">
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<c:choose>
		<c:when test="${not empty house }">
			<div class="col-lg-6">
			  <div class="jumbotron">
			    <h1>상세페이지: House 넘버 - ${house.no}</h1>      
			  </div>
			  <div>
			  	<div class="container" align="center">
					<div class="col-lg-6" align="center">
						<div class="form-group" align="left">
							<label for="">Dong</label>
							<input type="text" class="form-control" id="dong" name="dong" placeholder=""  value="${house.dong}" >
						</div>
						<div class="form-group" align="left">
							<label for="">아파트</label>
							<input type="text" class="form-control" id="aptName" name="aptName" placeholder=""  value="${house.aptName}" >
						</div>
						<div class="form-group" align="left">
							<label for="">평수</label>
							<input type="text" class="form-control" id="area" name="area" placeholder=""  value="${house.area}" >
						</div>
						<div class="form-group" align="left">
							<label for="">층수</label>
							<input type="text" class="form-control" id="floor" name="floor" placeholder="" value="${house.floor}" >
						</div></div></div></div>  
			</div>
		</c:when>
		<c:otherwise>
			 <div class="col-lg-6"><span>${msg}</span></div>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>








