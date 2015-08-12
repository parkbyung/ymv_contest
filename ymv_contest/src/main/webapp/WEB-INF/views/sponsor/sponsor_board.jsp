<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <link rel="stylesheet" type="text/css" href="css/style_common.css" />
        <link rel="stylesheet" type="text/css" href="css/style10.css" />
       <!--  <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css' /> -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#sponsorForm").submit(function() {
		if ($("#currentPrice").val() == "") {
			alert("금액을 선택해 주세요");
			return false;
		}
	});
});
	
</script>
<h3>
	<p class="text-center">후원게시판</p>
</h3>
<c:forEach items="${requestScope.lvo.list}" var="sponsor" varStatus="i">
	<div class="col-md-4">
		<div class="col-md-1"></div>
		<c:choose>
			<c:when test="${sessionScope.mvo.memberType=='admin' }">
				<form id="sponsorForm" action="sponsor_update_view.ymv">
					<div class="col-md-11"
						style="border-style: solid; border-color: activecaption; height: 600px;">
						<b>후원 시작 ${sponsor.startDate} / 후원 끝 ${sponsor.endDate}</b> <input
							type="submit" id="sponsorBtn" value="후원글 관리"
							class="btn btn-default btn-xs"> <br>
						<div style="height: 75%">
							<c:forEach items="${requestScope.pvo}" varStatus="checkCount"
								var="picture">
								<c:if test="${checkCount.count==i.count}">
									<div class="view view-tenth">
										<img src="${initParam.root }${picture.filePath}"
											style="width: 100%; height: 300px"><br>
										<div class="mask">
											<p class="text-center">${sponsor.content}</p>
										</div>
									</div>
								</c:if>
							</c:forEach>
							<c:choose>
							<c:when test="${sponsor.hoowon=='후원예정'}">
									<h3>
										후원예정${sponsor.title}<br>
									</h3>
								</c:when>
								<c:when test="${sponsor.hoowon=='후원중'}">
									<h3>
										<img src="${initParam.root}img/hj1.jpg">
										${sponsor.title}<br>
									</h3>
								</c:when>
								<c:when test="${sponsor.hoowon=='후원완료'}">
									<h3>
										<img src="${initParam.root}img/hw1.jpg">
										${sponsor.title}<br>
									</h3>
								</c:when>

							</c:choose>
						</div>
						<div style="height: 25%">
							<div>목표금액 ${sponsor.targetPrice}$ / 현재금액
								${sponsor.currentPrice}$</div>

							<div class="progress progress-striped active">
								<div class="progress-bar " role="progressbar"
									aria-valuenow="${sponsor.currentPrice}" aria-valuemin="0"
									aria-valuemax="${sponsor.targetPrice}"
									style="width: ${sponsor.percentage}%;text-align:left">
									${sponsor.percentage}%</div>
							</div>
							<div>
								<c:choose>
									<c:when test="${sponsor.hoowon=='후원완료'}">

									</c:when>
									<c:otherwise>
										
									</c:otherwise>

								</c:choose>

							</div>
						</div>
					</div>
					<input type="hidden" name="boardNo" value="${sponsor.boardNo}">
				</form>
			</c:when>
			<c:otherwise>
				<form id="sponsorForm" action="sponsor_update_currentPrice.ymv">
					<div class="col-md-11"
						style="border-style: solid; border-color: activecaption; height: 600px;">
						<b>후원 시작 ${sponsor.startDate} / 후원 끝 ${sponsor.endDate}</b>
						<br>
						<div style="height: 75%">
							<c:forEach items="${requestScope.pvo}" varStatus="checkCount"
								var="picture">
								<c:if test="${checkCount.count==i.count}">
									<div class="view view-tenth">
										<img src="${initParam.root }${picture.filePath}"
											style="width: 100%; height: 300px"><br>
										<div class="mask">
											<p class="text-center">${sponsor.content}</p>
										</div>
									</div>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${sponsor.hoowon=='후원예정'}">
									<h3>
										후원예정<br>
									</h3>
									</c:when>
								<c:when test="${sponsor.hoowon=='후원중'}">
									<h3>
										<img src="${initParam.root}img/hj1.jpg">
										${sponsor.title}<br>
									</h3>
								</c:when>
								<c:when test="${sponsor.hoowon=='후원완료'}">
									<h3>
										<img src="${initParam.root}img/hw1.jpg">
										${sponsor.title}<br>
									</h3>
								</c:when>

							</c:choose>
						</div>
						<div style="height: 25%">
							<div>목표금액 ${sponsor.targetPrice}$ / 현재금액
								${sponsor.currentPrice}$</div>

							<div class="progress progress-striped active">
								<div class="progress-bar " role="progressbar"
									aria-valuenow="${sponsor.currentPrice}" aria-valuemin="0"
									aria-valuemax="${sponsor.targetPrice}"
									style="width: ${sponsor.percentage}%;text-align:left">
									${sponsor.percentage}%</div>
							</div>
							<div>
								<c:choose>
									<c:when test="${sponsor.hoowon=='후원완료'}">

									</c:when>
									<c:otherwise>
										<select id="currentPrice" name="currentPrice">
											<option value="">-금액-</option>
											<option value="25">25$</option>
											<option value="50">50$</option>
											<option value="75">75$</option>
											<option value="100">100$</option>
											<option value="125">125$</option>
											<option value="150">150$</option>
											<option value="175">175$</option>
											<option value="200">200$</option>
										</select>
										<input type="submit" id="sponsorBtn" value="후원하기"
											class="btn btn-default btn-xs">
									</c:otherwise>

								</c:choose>

							</div>
						</div>
					</div>
					<input type="hidden" name="boardNo" value="${sponsor.boardNo}">
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</c:forEach>
<!-- paging -->
<div class="col-md-12">
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a href="#">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="sponsor_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="sponsor_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
