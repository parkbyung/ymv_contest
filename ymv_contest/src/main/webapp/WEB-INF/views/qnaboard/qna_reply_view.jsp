<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<script type="text/javascript">
	$(document).ready(function(){
		$("#answerImg").click(function(){
			if($("#title").val()==""){
				alert("제목을 입력하세요!");
				return;
			}else if($("#content").val()==""){
				alert("본문 내용을 입력하세요!");
				return;
			}
			$("#writeForm").submit();
		});
	});
</script>
<div class="col-md-8 col-md-offset-2">
<form action="qna_reply.ymv" method="post" id="writeForm" class="form-horizontal">
    <h3>답변글쓰기</h3>
 <table class="table table-hover" >
    <tbody>
	 <tr>
		<td>제목</td>
		<td colspan="3"><input type="text" name="title" id="title"
		value="RE:${requestScope.qvo.title }" size="60" ></td>
	 </tr>
	 <tr>
		<td >작성자</td>
		<td colspan=2 >${sessionScope.mvo.name}</td>
	 </tr>
		 <tr>
		 <td>내용</td>
		<td colspan=2 >
		<textarea cols="65" rows="10" name="content" id="content"></textarea>		
		</td>
	 </tr>
	 <tr>
	 	<td  colspan=2 >
	 		<img src="${initParam.root}/img/write_btn.jpg"  id="answerImg" align="right"/>		
	 	</td>
	 </tr>
 </table> 
  <input type="hidden" name="ref" value="${requestScope.qvo.ref }">
 <input type="hidden" name="restep" value="${requestScope.qvo.restep }">
 <input type="hidden" name="relevel" value="${requestScope.qvo.relevel }">
 <input type="hidden" name="qnaNo" value="${requestScope.qvo.qnaNo}"> 
 </form>







