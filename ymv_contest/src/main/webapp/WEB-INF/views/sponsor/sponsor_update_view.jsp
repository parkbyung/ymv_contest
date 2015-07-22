<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
	$("#deleteBtn")	.click(function() {
		location.href = "sponsor_delete.ymv?boardNo=${requestScope.spvo.boardNo}";
		});
	});
</script>
<script>
	$(function() {
		$("#datepicker1, #datepicker2").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					prevText : '이전 달',
					nextText : '다음 달',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					showMonthAfterYear : true,
					yearSuffix : '년'
				});
	});
</script>
<div class="col-md-6 col-sm-offset-3">
	<form action="sponsor_update.ymv" enctype="multipart/form-data"
		method="post">
		<table class="table table-striped table-hover">
			<tr>
				<th class="info"><h4 class="text-center">제목</h4></th>
				<td><input type="text" name="title"
					value="${requestScope.spvo.title}"></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">파일업로드</h4></th>
				<td><input type="file" name="fileName"></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">시작날짜</h4></th>
				<td><input type="text" id="datepicker1" name="startDate"
					value="${requestScope.spvo.startDate}"></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">종료날짜</h4></th>
				<td><input type="text" id="datepicker2" name="endDate"
					value="${requestScope.spvo.endDate}"></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">상세정보</h4></th>
				<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.spvo.content }</textarea></td>
			</tr>
			<tr>
				<th class="info"><h4 class="text-center">목표금액</h4></th>
				<td><input type="text" name="targetPrice"
					value="${requestScope.spvo.targetPrice }"></td>
			</tr>
		</table>
			<input type="submit" class="btn btn-primary" value="수정">
			<input type="button" class="btn btn-primary" value="삭제" id="deleteBtn">
			<input type="hidden" name="boardNo" value="${requestScope.spvo.boardNo}">
	</form>
</div>
