<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>후기 검색 결과</h4>
후기 검색 결과는 총 ${requestScope.revo.pagingBean.totalContent}개 입니다.
<div class="col-md-12">
		<div class="col-md-12">
			<table class="table">
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
					<c:forEach var="revo" items="${requestScope.revo.list}">
						<tr>
							<td>${revo.boardNo}</td>
							<td><a
								href="${initParam.root}review_showContent.ymv?boardNo=${revo.boardNo}">${revo.title }</a></td>
							<td>${revo.writer }</td>
							<td>${revo.timePosted }</td>
							<td>${revo.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<ul class="pagination">
					<c:choose>
						<c:when test="${requestScope.revo.pagingBean.previousPageGroup}">
							<li class="active"><a
								href="search_boards_review.ymv?pageNo=${requestScope.revo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><a
								href="search_boards_review.ymv?pageNo=${requestScope.revo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="i"
						begin="${requestScope.revo.pagingBean.startPageOfPageGroup}"
						end="${requestScope.revo.pagingBean.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${requestScope.revo.pagingBean.nowPage!=i}">
								<li><a
									href="search_boards_review.ymv?pageNo=${i}&search=${sebvo.search }">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${requestScope.revo.pagingBean.nextPageGroup}">
							<li class="active"><a
								href="search_boards_review.ymv?pageNo=${requestScope.revo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
						</c:when>
						<c:otherwise>
							<li class="disabled"><a
								href="search_boards_review.ymv?pageNo=${requestScope.revo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
						</c:otherwise>
					</c:choose>
					</ul>
			</div>
		</div>
		</div>