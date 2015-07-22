<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>QnA 검색 목록</h4>
QnA 검색 결과는 총 ${requestScope.qvo.pagingBean.totalContent}개 입니다.

<div class="col-md-12">
			<div class="col-md-12">
				<table class="table">
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 20%;" />
						<col style="width: 10%;" />
						<col style="width: 20%;" />
						<col style="width: 20%;" />
						<col style="width: 20%;" />
					</colgroup>
					<thead>
						<tr>
							<th class="qnaNo">NO</th>
							<th class="title">제목</th>
							<th class="writer">작성자</th>
							<th class="timePosted">작성일</th>
							<th class="hit">조회수</th>
						</tr>
						<c:forEach var="qvo" items="${requestScope.qvo.list}">
							<tr>
								<td>${qvo.qnaNo }</td>
								<td class="titleView"><c:if test="${qvo.relevel!=0}">
										<c:forEach begin="0" end="${qvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
										<img src="${initParam.root }/img/reply.jpg">
									</c:if> <a
									href="${initParam.root}qna_showContent.ymv?qnaNo=${qvo.qnaNo}">
										${qvo.title }</a>
								<td>${qvo.writer }</td>
								<td>${qvo.timePosted }</td>
								<td>${qvo.hit }</td>
							</tr>
						</c:forEach>
				</table>
				<br> <br>
				<div class="text-center">
					<ul class="pagination">
						<c:choose>
							<c:when test="${requestScope.qvo.pagingBean.previousPageGroup}">
								<li class="active"><a
									href="search_boards_QnA.ymv?pageNo=${requestScope.qvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a
									href="search_boards_QnA.ymv?pageNo=${requestScope.qvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i"
							begin="${requestScope.qvo.pagingBean.startPageOfPageGroup}"
							end="${requestScope.qvo.pagingBean.endPageOfPageGroup}">
							<c:choose>
								<c:when test="${requestScope.qvo.pagingBean.nowPage!=i}">
									<li><a
										href="search_boards_QnA.ymv?pageNo=${i}&search=${sebvo.search }">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li class="active"><a href="#">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${requestScope.qvo.pagingBean.nextPageGroup}">
								<li class="active"><a
									href="search_boards_QnA.ymv?pageNo=${requestScope.qvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a
									href="search_boards_QnA.ymv?pageNo=${requestScope.qvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
							</c:otherwise>
						</c:choose>
						</ul>
				</div>
			</div>
			</div>