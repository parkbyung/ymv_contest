<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if (confirm("삭제하시겠습니까?")) {
				location.href = "review_board_delete.ymv?boardNo=" + ${requestScope.rvo.boardNo};
			} else {
				return;
			}//if
		}); //click
	});
</script>
<h3 align="center">후기 상세 글</h3>
<br>
<div class="col-md-8 col-sm-offset-2">
	<table class="table table-striped table-hover">
		<tr class="info">
			<td>NO : ${requestScope.rvo.boardNo }</td>
			<td colspan="2" style="font-weight: bold;">${requestScope.rvo.title}</td>
		</tr>
		<tr class="warning">
			<td>작성자 : ${requestScope.rvo.writer }</td>
			<td>시간: ${requestScope.rvo.timePosted}</td>
			<td>조회수 : ${requestScope.rvo.hit }</td>
		</tr>
		<tr></tr>
		<tr>
			<td colspan="15" align="center"><c:if test="${requestScope.pvo!=null }">
					<img src="${initParam.root }${requestScope.pvo.filePath}" >
					<br>
				</c:if> <br> <pre>${requestScope.rvo.content}</pre></td>
		</tr>
		<tr class="warning">
		<td align="center" colspan="3">
		 <c:choose>
					<c:when
						test="${sessionScope.mvo.memberNo==requestScope.rvo.memberNo }">
						<a
							href="${initParam.root}review_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }">
							<input type="button" class="btn btn-default btn-xs" value="수정">
						</a>
						<input type="button" class="btn btn-default btn-xs" class="action"
							id="deleteBtn" value="삭제">
					</c:when>
					<c:when test="${sessionScope.mvo.memberType=='admin' }">
						<a
							href="${initParam.root}review_board_update_view.ymv?boardNo=${requestScope.rvo.boardNo }">
							<input type="button" class="btn btn-default btn-xs" value="수정">
						</a>
						<input type="button" class="btn btn-default btn-xs" class="action"
							id="deleteBtn" value="삭제">
					</c:when>
				</c:choose>
				<a	href="${initParam.root}review_board.ymv"> <input type="button"
					class="btn btn-default btn-xs" value="목록" ></a>
				</td>

		</tr>
		<tr>
			<td colspan="3">
					<table class="table table-hover">
						<tr class="active">
							<td colspan="3" align="left">
								<form name="commentForm" action="register_review_comment.ymv"
									method="post">
									작성자:<input type="text" name="writer"
										value="${sessionScope.mvo.id }" readonly="readonly" size="10">
									내용<input type="text" name="content" size="70"> <input
										type="hidden" name="boardNo"
										value="${requestScope.rvo.boardNo}"> <input
										type="submit" value="댓글달기" class = "btn btn-default btn-xs">
								</form>
							</td>
						</tr>
						<c:forEach items="${requestScope.commentList}" var="comment">
							<tr class = "info">
								<td>${comment.commentNo}</td>
								<td>작성자 : <strong>${comment.writer}</strong></td>
								<td align="right"><span style="color:#92B3B7">시간 : ${comment.timePosted}</span></td>
							</tr>
							<tr>
							<td></td>
								<td>${comment.content}</td>
								<td align="right"><c:choose>
										<c:when test="${sessionScope.mvo.memberType=='admin' }">
											<a
												href="delete_review_comment.ymv?commentNo=${comment.commentNo}&boardNo=${comment.boardNo}"
												class="btn btn-default btn-xs">댓글삭제</a>
										</c:when>
										<c:when test="${comment.writer==sessionScope.mvo.id }">
											<a
												href="delete_review_comment.ymv?commentNo=${comment.commentNo}&boardNo=${comment.boardNo}"
												class="btn btn-default btn-xs">댓글삭제</a>

										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>

					</table>
				</td>
		</tr>
	</table>
</div>
