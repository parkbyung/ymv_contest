<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h3>
		<p class="text-center">후원등록</p>
		<br>
	</h3>
<div class="col-md-6 col-sm-offset-3">
<form action="sponsor_register.ymv" enctype="multipart/form-data" method="post">
	<table class="table table-striped table-hover">
				<tr>
					<th class="info"><h4 class="text-center">제목</h4></th>
					<td><input type="text" name="title" id="title" size="46"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">파일업로드</h4></th>
					<td><input type="file" name="fileName"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">시작날짜</h4></th>
					<td><input type="text" id="datepicker1" name="startDate"
						placeholder="시작날짜">
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">종료날짜</h4></th>
					<td><input type="text" id="datepicker2" name="endDate"
						placeholder="종료날짜"></td>
				</tr>
			<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.spvo.content }</textarea></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">목표금액</h4></th>
					<td>$<input type="text" name="targetPrice"></td>
				</tr>
			</table>
<div align="right">
	<input type="submit" class ="btn btn-primary" value="등록">
</div>
</form>
</div>