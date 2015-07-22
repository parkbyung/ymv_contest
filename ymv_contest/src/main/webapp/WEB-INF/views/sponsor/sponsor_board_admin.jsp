<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>
		<p class="text-center">후원게시판</p>
	</h3>
<c:forEach items="${requestScope.lvo.list}" var="sponsor">
	<div class="col-md-4">
		<div class="col-md-1"></div>
		<form id="sponsorForm" action="sponsor_update_view.ymv">
			<div class="col-md-11"
				style="border-style: solid; border-color: activecaption; height: 600px;">
				<b>후원 시작 ${sponsor.startDate} / 후원 끝 ${sponsor.endDate}</b><br>
				<br>
				<div style="height: 75%">
					<c:forEach items="${requestScope.pvo}" varStatus="checkCount"
						var="picture">
						<c:if test="${picture.pictureNo==sponsor.boardNo}">
							<img src="${initParam.root }${picture.filePath}" style="width: 100%; height: 300px">
						</c:if>
					</c:forEach>
					<c:choose>
					<c:when test="${sponsor.hoowon=='후원중'}">
						<h3><img src="${initParam.root}img/hj1.jpg"> ${sponsor.title}<br></h3>
					</c:when>
					<c:when test="${sponsor.hoowon=='후원완료'}">
						<h3><img src="${initParam.root}img/hw1.jpg"> ${sponsor.title}<br></h3>
					</c:when>
					
					</c:choose>
					${sponsor.content}<br>
					
				</div>
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
					<input type="submit" id="sponsorBtn" value="후원글 관리" class="btn btn-default btn-xs">
					${sponsor.startDate} ${sponsor.endDate}
				</div>
			</div>
			<input type="hidden" name="boardNo" value="${sponsor.boardNo}">
		</form>
	</div>
</c:forEach>
<!-- paging -->
<div class="col-md-12">
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="sponsor_board_admin.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="sponsor_board_admin.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="sponsor_board_admin.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="sponsor_board_admin.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="sponsor_board_admin.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
