<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>회원정보 수정</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#updateBtn").click(function() {
		if($("#emailid").val() == "") {
			alert("이메일 입력!!!");
			return;
		}  else {
			document.getElementById("memberform").action = "<%=root%>/main.do";
			document.getElementById("memberform").submit();
		}
	});
});

function cancel() {
	  history.back();
}

function deleteMember(){
	location.href="${root}/main?act=deleteMember";
}

</script>
</head>
<body>
	<div class="container mt-3" align="center">
	<div class="col-lg-6" align="center">
		<form id="memberform" method="post" action="post">
		<input type="hidden" name="action" id="action" value="modifyMember">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="username" name="username" placeholder="${userinfo.username}" disabled>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="${userinfo.userid}" disabled>
			</div>
			
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<p></p>
				<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="email" name="email" placeholder="" size="25" value="${userinfo.email}">
				
				</div>
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="updateBtn">회원 정보 수정</button>
		      	<button type="button" class="btn btn-warning" onclick="javascript:cancel();">취소</button>
				<button type="button" class="btn btn-danger" onclick="javascript:deleteMember();">탈퇴</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>