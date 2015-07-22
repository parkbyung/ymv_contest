<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
	$(document).ready(function(){
		$("#qnaForm").submit(function(){
			if($("#title").val()==""){
				alert("제목을 입력해주세요");
				return false;
			}else if($("#content").val()==""){
				alert("상세정보를 입력해 주세요");
				return false;
			}
		});
	});
</script>
<div class="col-sm-6 col-sm-offset-3">
	<h2>
		<p class="text-center">Q & A 등록</p>
	</h2>
	<form class="form-horizontal" id="qnaForm" action="qna_register.ymv"
		method="post">
		<table class="table table-hover">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title" size="50"></td>
			</tr>
			<tr>
				<td colspan="3">작성자&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp; ${sessionScope.mvo.name}</td>
			</tr>
			<tr>
				<td>상세정보</td>
				<td colspan="2"><textarea rows="10" cols="60" id="content"
						name="content"></textarea></td>
			</tr>
		</table>
		<div class="col-sm-12">
		<div class="pull-right">
			<input class="btn btn-default btn-xs" type="submit" value="글 등록">
		</div></div>
	</form>
</div>