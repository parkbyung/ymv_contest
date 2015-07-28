<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateForm").submit(function(){
			if($(":input[name=password]").val()==""){
				alert("비밀번호를 입력하세요!");
				return false;
			}
			if($(":input[name=name]").val()==""){
				alert("이름을 입력하세요!");
				return false;
			}else if($(":input[name=address]").val()==""){
				alert("주소를 입력하세요!");
				return false;
			}else if($(":input[name=mailAddress]").val()==""){
				alert("이메일주소를 입력하세요!");
				return false;
			}
		});	
	});
</script>
<h3>
	<p class="text-center">회원정보수정</p>
</h3>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<form class="form-horizontal" role="form" action="member_update.ymv"
					enctype='multipart/form-data' method='post' id="updateForm">
					<div class="form-group">
						<label for="inputProfile" class="control-label">프로필 사진</label> <input
							type="file" class="form-control btn btn-default btn-xs"
							id="inputProfile3" name="fileName" accept='.gif, .jpg, .png'">
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="control-label">아이디</label> <input
							type="hidden" name="memberNo"
							value="${sessionScope.mvo.memberNo}"> <input type="text"
							class="form-control" name="id" id="inputEmail3"
							value="${sessionScope.mvo.id}" readonly>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="control-label">비밀번호</label> <input
							type="password" class="form-control" id="inputPassword3"
							name="password" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="inputName3" class="control-label">이름</label> <input
							type="text" class="form-control" id="inputName3" name="name"
							value="${sessionScope.mvo.name}">
					</div>
					<div class="form-group">
						<label for="inputAddress3" class="control-label">주소</label> <input
							type="text" class="form-control" id="inputAddress3"
							name="address" value="${sessionScope.mvo.address}">
					</div>
					<div class="form-group">
						<label for="inputmailAddress3" class="control-label">이메일
							주소</label> <input type="text" class="form-control" id="inputmailAddress3"
							name="mailAddress" value="${sessionScope.mvo.mailAddress}">
					</div>
					<div class="form-group">
						<p class="text-center">
							<button type="submit" class="btn btn-default">수정하기</button>
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
