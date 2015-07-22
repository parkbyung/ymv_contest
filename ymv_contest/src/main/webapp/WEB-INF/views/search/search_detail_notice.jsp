<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>공지사항 검색 결과</h4>
공지사항 검색 결과는 총 ${requestScope.nvo.pagingBean.totalContent}개 입니다.
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<thead>
				<tr>
					<th class="boardNo">NO</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="timePosted">등록시간</th>
					<th class="hit">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nvo" items="${requestScope.nvo.list}">
					<tr>
						<td>${nvo.boardNo }</td>
						<td><a
							href="${initParam.root}review_showContent.ymv?boardNo=${nvo.boardNo}">
								${nvo.title }</a></td>
						<td>${nvo.writer }</td>
						<td>${nvo.timePosted }</td>
						<td>${nvo.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br>
		<div class="text-center">
			<ul class="pagination">
				<c:choose>
					<c:when test="${requestScope.nvo.pagingBean.previousPageGroup}">
						<li class="active"><a
							href="search_boards_notice.ymv?pageNo=${requestScope.nvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a
							href="search_boards_notice.ymv?pageNo=${requestScope.nvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="i"
					begin="${requestScope.nvo.pagingBean.startPageOfPageGroup}"
					end="${requestScope.nvo.pagingBean.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${requestScope.nvo.pagingBean.nowPage!=i}">
							<li><a
								href="search_boards_notice.ymv?pageNo=${i}&search=${sebvo.search }">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.nvo.pagingBean.nextPageGroup}">
						<li class="active"><a
							href="search_boards_notice.ymv?pageNo=${requestScope.nvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a
							href="search_boards_notice.ymv?pageNo=${requestScope.nvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
					</c:otherwise>
				</c:choose>
				</ul>
		</div>
	</div>
	</div>
