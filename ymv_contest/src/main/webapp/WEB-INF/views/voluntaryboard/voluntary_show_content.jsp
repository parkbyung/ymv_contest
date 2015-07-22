<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#delete").click(function(){
		  if(!confirm("글을 삭제하시겠습니까?")){
	          return false;
	       }else{
	          location.href="voluntary_delete.ymv?recruitNo=${requestScope.rvo.recruitNo}";
	       }
	});
	
	$("#applicant").click(function(){
		var motivate = "";
		motivate +="<hr><h2>봉사 신청 이유</h2>";
		motivate += " <br><textarea rows='10' cols='80' id='motivate' name='motivate' placeholder='봉사신청 동기를 입력해주세요.'></textarea>";
		motivate += "<br><br><input type='button' value='신청하기' id='VolunteerApplicant'class='btn btn-default btn-xs'>";
		$("#motivateForm").html(motivate);
		$("#VolunteerApplicant").click(function(){
			if($("#motivate").val()=="" || $("#motivate").val()==null){
				alert("신청 동기를 입력해주세요");
				return;
			}else{
			$.ajax({
				type:"get",
				url:"voluntary_register_applicant.ymv",				
				data:"recruitNo=${requestScope.rvo.recruitNo }&motivate="+$("#motivate").val()+"&memberNo=${sessionScope.mvo.memberNo}",
				dataType:"json", 
				success:function(data){
					if(data==true){
						alert("이미 신청하셨습니다.");
						$("#motivate").val("");
						$("#motivateForm").html("");
					}else{
						alert("신청이 완료되었습니다.");
						$("#motivate").val("");
						$("#motivateForm").html("");
					}
				}
			});
			}
		});
	});//click
	
	
});
</script>
<h3 align="center">봉사 상세 글보기</h3>
<br><br>
<div class="col-sm-8 col-sm-offset-2" align="center">
<div class="panel panel-default">
  <div class="panel-body">
		<table class="col-sm-8" style="width: 700px;">
		<tbody>
			<tr>
				<td ><p>NO : ${requestScope.rvo.recruitNo }</p></td>
				<td colspan="2" style="font-weight: bold;"><p>제목 : ${requestScope.rvo.title}</p></td>
			</tr>
			<tr>
				<td><p>기업명 : ${requestScope.vo.name}</p></td>
				<td ><p>시간 : ${requestScope.rvo.postDate}</p></td>
				<td><p>조회수 : ${requestScope.rvo.hit }</p></td>
			</tr>
			<tr>
				<td><p>분야 : ${requestScope.rvo.field}</p></td>
				<td><p>나이제한 : ${requestScope.rvo.age}</p></td>
				<td><p>지역 : ${requestScope.rvo.location}</p></td>
			</tr>
			<tr>
				<td colspan="3" align="center" ><p>시작시간 : 
					${requestScope.rvo.startDate} &nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp; 종료시간 : 
					${requestScope.rvo.endDate}</p></td>
				<%--      <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp~</td>
         <td>종료시간: ${requestScope.rvo.endDate}</td> --%>
			</tr>

			<tr>
				<td colspan="15"><pre>${requestScope.rvo.content}</pre></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="3"><a
					href="${initParam.root}voluntary_board.ymv"> 
					<input type="button" class="btn btn-default btn-xs" value="목록" ></a>
						<c:choose>
						<c:when test="${sessionScope.mvo.memberNo==requestScope.rvo.memberNo}">
							<a
								href="${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }">
								<input type="button" class="btn btn-default btn-xs" value="수정" >
							</a>
							<input type="button" class="btn btn-default btn-xs" class = "action" id ="delete" value="삭제" >
						</c:when>
						<c:when test="${sessionScope.mvo.memberType=='admin'}">
							<a
								href="${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }&command=admin">
								<input type="button" class="btn btn-default btn-xs" value="수정" >
							</a>
								<input type="button" class="btn btn-default btn-xs" class = "action" id ="delete" value="삭제" >
						</c:when>
					</c:choose>
					<c:if test="${sessionScope.mvo.memberType=='normal'}">
					<c:choose>
						<c:when test="${requestScope.rvo.mojib=='모집중' }">
							<input type="button" class="btn btn-default btn-xs" value="신청하기" id="applicant">
						</c:when>
						<c:otherwise>
							
						</c:otherwise>
					 </c:choose>
					</c:if>
					<%-- <c:if test="${sessionScope.mvo.memberType=='admin'}">
							<input type="button" class="btn btn-default btn-xs" value="신청하기" id="applicant">
					</c:if> --%>
					</td>
			</tr>
			</tbody>
		</table>
		</div></div>
		<br>
		<br> <span id="motivateForm"></span>
	</div>

