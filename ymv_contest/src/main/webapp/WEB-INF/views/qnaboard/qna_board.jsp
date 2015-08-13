<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">Q & A</p>
	</h3>
	<table class="table table-striped table-hover">
		<colgroup>
			<col style="width: 5%;" />
			<col style="width: 10%;" />
			<col style="width: 30%;" />
			<col style="width: 10%;" />
			<col style="width: 15%;" />
			<col style="width: 10%;" />
		</colgroup>
		<thead>
			<tr>
				<th class="qnaNo">NO</th>
				<th scope="col">답변상태</th>
				<th class="title">제목</th>
				<th class="writer">작성자</th>
				<th class="timePosted">작성일</th>
				<th class="hit">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lvo" items="${requestScope.lvo.list}">
				<tr>
					<td>${lvo.qnaNo }</td>
					<c:choose>
							<c:when test="${lvo.relevel==0}">
							<c:choose>
								<c:when test="${lvo.answer=='답변중'}">
									<td><img src="${initParam.root}img/answer_not.jpg"></td>
								</c:when>
								<c:otherwise>
									<td><img src="${initParam.root}img/answer_ok.jpg"></td>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<td>&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;</td>
						</c:otherwise>
					</c:choose>
					
					<%-- lvo에 relevel이 0이 아니면 답변글이므로 relevel만큼 공백으로 제목을 밀어준다  --%>
					<td class="titleView">
					<c:if	test="${lvo.relevel!=0}">
							<c:forEach begin="0" end="${lvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
							<img src="${initParam.root }/img/reply.jpg">
						</c:if> <a href="${initParam.root}qna_showContent.ymv?qnaNo=${lvo.qnaNo}">
							${lvo.title }</a>
					<td>${lvo.writer }</td>
					<td>${lvo.timePosted }</td>
					<td>${lvo.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			<div class="col-sm-12">
    <div class="pull-right"> 
	<a href="${initParam.root }qna_register_view.ymv"	class="btn btn-default btn-xs">글쓰기 </a> <br></br></div></div>
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="qna_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="qna_board.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
