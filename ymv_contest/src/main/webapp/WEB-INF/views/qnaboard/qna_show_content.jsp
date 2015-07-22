<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<script type="text/javascript">
    function checkDelete(){
       if(!confirm("글을 삭제하시겠습니까?")){
          return false;
       }else{
          location.href="qna_delete.ymv?qnaNo=${requestScope.qvo.qnaNo}";
       }
    }
</script>

<div class="col-sm-6 col-sm-offset-3">
<h3 align="center">상세 Q & A 보기</h3>
<br><br><br>
	<table class="table table-hover">
		<tr>
			<td width="150">NO : ${requestScope.qvo.qnaNo }</td>
			<td width="180">작성일:${requestScope.qvo.timePosted}</td>
			<td width="180">조회수 : ${requestScope.qvo.hit }</td>
		</tr>
		<tr>
			<td colspan="2" align="center" style="font-weight: bold;">제목 : ${requestScope.qvo.title}</td>
			<td>작성자 : ${sessionScope.mvo.name }</td>
		</tr>
		<tr>
			<td colspan="15"><pre>${requestScope.qvo.content}</pre></td>
		</tr>
		<tr>
			<td valign="middle" align="center" colspan="3"><a
				href="${initParam.root}qna_board.ymv" class="btn btn-default btn-xs">목록</a>
				<c:choose>
					<c:when test="${requestScope.qvo.restep >= 1 }">
						<c:if test="${sessionScope.mvo.memberType=='admin' }">
						</c:if>
					</c:when>
					<c:when test="${sessionScope.mvo.memberType=='admin' }">
						<a href="qna_reply_view.ymv?qnaNo=${requestScope.qvo.qnaNo}"
							class="btn btn-default btn-xs">답글 </a>
						<a
							href="${initParam.root}qna_board_update_view.ymv?qnaNo=${requestScope.qvo.qnaNo}"
							class="btn btn-default btn-xs">수정 </a>
						<input type="button" onclick="checkDelete()" value="삭제"
							class="btn btn-default btn-xs">
					</c:when>
				</c:choose> <c:choose>
					<c:when
						test="${sessionScope.mvo.memberNo==requestScope.qvo.memberNo}">
						<a
							href="${initParam.root}qna_board_update_view.ymv?qnaNo=${requestScope.qvo.qnaNo}"
							class="btn btn-default btn-xs">수정 </a>
						<input type="button" onclick="checkDelete()" value="삭제"
							class="btn btn-default btn-xs">
					</c:when>
				</c:choose></td>
		</tr>
	</table>
</div>