<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">나눔 활동</p>
	</h3>
	<table class="table table-striped table-hover">
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 10%;" />
			<col style="width: 40%;" />
			<col style="width: 17%;" />
			<col style="width: 17%;" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">경매상태</th>
				<th scope="col">제목</th>
				<th scope="col">등록시간</th>
				<th scope="col">종료시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="auvo" items="${requestScope.auvo.list}">
				<tr>
					<td>${auvo.boardNo}</td>
					<td><a href="${initParam.root}auction_show_content.ymv?boardNo=${auvo.boardNo}&gyeongmae=${auvo.gyeongmae}">${auvo.gyeongmae}</a></td>
					<td><a href="${initParam.root}auction_show_content.ymv?boardNo=${auvo.boardNo}&gyeongmae=${auvo.gyeongmae}">${auvo.title }</a></td>
					<td>${auvo.timePosted }</td>
					<td>${auvo.endDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${sessionScope.mvo.memberType=='admin' }">
	<c:choose>
		<c:when test="${sessionScope.mvo==null}">

		</c:when>
		<c:otherwise>
					<div class="col-sm-12">
    <div class="pull-right"> 
			<a href="${initParam.root}auction_register_view.ymv" class="btn btn-default btn-xs">글쓰기</a></div></div>
		</c:otherwise>
	</c:choose>
	</c:if>
	<br></br>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.auvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="auction_board.ymv?pageNo=${requestScope.auvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="auction_board.ymv?pageNo=${requestScope.auvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.auvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.auvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.auvo.pagingBean.nowPage!=i}">
						<li><a href="auction_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.auvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="auction_board.ymv?pageNo=${requestScope.auvo.pagingBean.
    endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="auction_board.ymv?pageNo=${requestScope.auvo.pagingBean.
    endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
