<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6 col-sm-offset-3">
		<h2><p class = "text-center">봉사 후기</p></h2>
		<form action="review_register.ymv" enctype="multipart/form-data" method="post">
			<table class="table table-striped table-hover">
				<tr>
					<td colspan="1">제목</td>
					<td colspan="2"><input type="text" name="title" size="45"><input type="hidden" name = "memberNo" value="${sessionScope.mvo.memberNo }"></td>
				</tr>
				<tr>
					<td colspan="1">작성자 : ${sessionScope.mvo.name }  </td>
					<td colspan="2" align="right"><input type="file" name="fileName">
				</td>
				</tr>
				<tr>
					<td colspan="1">내용</td>
					<td colspan="2"><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
				</tr>
			</table>
			<br><div class="col-sm-12">
    <div class="pull-right"><input type="submit" value="글 등록" class = "btn btn-default btn-xs"> </div></div> <br><br>
				<input type="hidden" value="${sessionScope.mvo.name }" name="writer">
			</form>

	</div>