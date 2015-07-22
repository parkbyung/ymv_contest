<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-10 col-sm-offset-1">
<h3><p class = "text-center">봉사 후기</p></h3>
	<table class="table table-striped table-hover">
		<%--table 시작할때 colgroup으로 사이즈 조절  하단에서는 scope로 col 찍으면됨--%>
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 40%;" />
			<col style="width: 17%;" />
			<col style="width: 17%;" />
			<col style="width: 17%;" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">등록시간</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bvo" items="${requestScope.lvo.list}">
				<tr>
					<td>${bvo.boardNo}</td>
					<td><a
						href="${initParam.root}review_showContent.ymv?boardNo=${bvo.boardNo}">${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.timePosted }</td>
					<td>${bvo.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:choose>
		<c:when test="${sessionScope.mvo==null}">

		</c:when>
		<c:otherwise>
					<div class="col-sm-12">
    <div class="pull-right"> 
			<a href="${initParam.root}review_register_view.ymv" class="btn btn-default btn-xs">글쓰기</a></div></div>
		</c:otherwise>
	</c:choose>
	<br></br>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="review_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="review_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>







