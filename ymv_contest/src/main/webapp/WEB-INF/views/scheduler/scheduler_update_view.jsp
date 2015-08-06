<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>   
    
<div class="col-md-6 col-sm-offset-3">
		<h2 align="center">스케줄러 수정</h2>
		<br><br>
		<form id="recruitForm" action="scheduler_update.ymv?memberNo=${sessionScope.mvo.memberNo}" method="post">
			<table class="table table-striped table-hover">
				<tr>
					<th class="info">분야</th>
					<td><select id="field" name="field">
							<!-- 분야(노인, 아동, 장애, 동물, 환경) DB에서 받아오기 -->
							<option value="${requestScope.sdvo.field }">${requestScope.sdvo.field }</option>
							<c:forEach items="${requestScope.fieldlist }" var="f">
								<c:if test="${requestScope.sdvo.field != f.field}">
									<option value="${f.field }">${f.field }</option>
								</c:if>
							</c:forEach>
							<option value="">전체</option>
					</select></td>
				</tr>
				<tr>
					<th class="info">지역</th>
					<td><select id="location" name="location">
							<!-- 지역(*도 별로) DB에서 받아오기 -->
							<option value="${requestScope.sdvo.location}">${requestScope.sdvo.location}</option>
							<c:forEach items="${requestScope.locationlist }" var="l">
								<c:if test="${requestScope.sdvo.location != l.location }">
									<option value="${l.location }">${l.location }</option>
								</c:if>	
							</c:forEach>
							<option value="">전체</option>
					</select></td>
				</tr>
				<tr>
					<th class="info">시작시간</th>
					<td> <select id="startTime"
						name="volunteeringStartTime">
							<!-- 한시간 단위로 하기 -->
							<option value="${requestScope.sdvo.volunteeringStartTime}">${requestScope.sdvo.volunteeringStartTime}</option>
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
							<option value="">전체</option>
					</select></td>
				</tr>
				<tr>
					<th class="info">끝시간</th>
					<td>
						<select id="endTime" name="volunteeringEndTime">
							<!-- 한시간 단위로 하기 -->
							<option value="${requestScope.sdvo.volunteeringEndTime}">${requestScope.sdvo.volunteeringEndTime}</option>
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
							<option value="">전체</option>
					</select></td>
				</tr>
			</table>
			<br> 
			<div class = "col-sm-3 col-sm-offset-9">
			<input type="submit" value="스케쥴러 수정" class = "btn btn-primary"></div>
		</form>
	</div>
