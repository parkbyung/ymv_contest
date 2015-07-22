<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#recruitForm").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			} else if ($("#field").val() == "") {
				alert("분야를 선택해 주세요");
				return false;
			} else if ($("#location").val() == "") {
				alert("지역을 선택해 주세요");
				return false;
			} else if ($("# :radio[name=age]:checked").val() == ""||$("# :radio[name=age]:checked").val() == null) {
				alert("봉사 가능한 나이를 선택해 주세요");
				return false;
			} else if ($("#startTime").val() == "") {
				alert("시작시간을 입력해 주세요");
				return false;
			} else if ($("#endTime").val() == "") {
				alert("끝시간을 입력해 주세요");
				return false;
			} else if ($("#content").val() == "") {
				alert("상세정보를 입력해 주세요");
				return false;
			}
		});
	});
</script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>
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
		<h2>봉사 등록</h2>
		<form id="recruitForm"
			action="volunteer_register.ymv?memberNo=${sessionScope.mvo.memberNo }"
			method="post">
			<table class="table table-striped table-hover">
				<tr>
					<th class="info"><h4 class="text-center">제목</h4></th>
					<td><input type="text" name="title" id="title" size="40"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">분야</h4></th>
					<td><select id="field" name="field">
							<!-- 분야(노인, 아동, 장애, 동물, 환경) DB에서 받아오기 -->
							<option value="">-분야-</option>
							<c:forEach items="${requestScope.fieldlist }" var="f">
								<option value="${f.field }">${f.field }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">지역</h4></th>
					<td><select id="location" name="location">
							<!-- 지역(*도 별로) DB에서 받아오기 -->
							<option value="">-지역-</option>
							<c:forEach items="${requestScope.locationlist }" var="l">
								<option value="${l.location }">${l.location }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">나이제한</h4></th>
					<td>
						<!-- <input type="text" name="age" id="age"> --> <!-- 숫자로 입력 안하면 submit 못하게
			나이를 select or input text로 둘중에 뭐할지 정하기 --> <input type="radio"
						name="age" value="전체">전체 <input type="radio" name="age"
						value="학생">학생 <input type="radio" name="age" value="성인">성인
						<!-- 전체, 학생, 성인으로 나눠서 -->
					</td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">시작시간</h4></th>
					<td><input type="text" id="datepicker1" name="startDate"
						placeholder="시작날짜"> <select id="startTime"
						name="startTime">
							<!-- 한시간 단위로 하기 -->
							<option value="">-시작시간-</option>
							<option value="06:00">06:00</option>
							<option value="07:00">07:00</option>
							<option value="08:00">08:00</option>
							<option value="09:00">09:00</option>
							<option value="10:00">10:00</option>
							<option value="11:00">11:00</option>
							<option value="12:00">12:00</option>
							<option value="13:00">13:00</option>
							<option value="14:00">14:00</option>
							<option value="15:00">15:00</option>
							<option value="16:00">16:00</option>
							<option value="17:00">17:00</option>
							<option value="18:00">18:00</option>
							<option value="19:00">19:00</option>
							<option value="20:00">20:00</option>
							<option value="21:00">21:00</option>
							<option value="22:00">22:00</option>
							<option value="23:00">23:00</option>
							<option value="00:00">00:00</option>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">끝시간</h4></th>
					<td><input type="text" id="datepicker2" name="endDate" placeholder="종료날짜">
						<select id="endTime" name="endTime">
							<!-- 한시간 단위로 하기 -->
							<option value="">-끝시간-</option>
							<option value="06:00">06:00</option>
							<option value="07:00">07:00</option>
							<option value="08:00">08:00</option>
							<option value="09:00">09:00</option>
							<option value="10:00">10:00</option>
							<option value="11:00">11:00</option>
							<option value="12:00">12:00</option>
							<option value="13:00">13:00</option>
							<option value="14:00">14:00</option>
							<option value="15:00">15:00</option>
							<option value="16:00">16:00</option>
							<option value="17:00">17:00</option>
							<option value="18:00">18:00</option>
							<option value="19:00">19:00</option>
							<option value="20:00">20:00</option>
							<option value="21:00">21:00</option>
							<option value="22:00">22:00</option>
							<option value="23:00">23:00</option>
							<option value="00:00">00:00</option>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
				</tr>
			</table>
			<br> <div class = "col-sm-2 col-sm-offset-10">
			<input type="submit" class = "btn btn-primary"value="글 등록"><br><br></div>
		</form>
	</div>