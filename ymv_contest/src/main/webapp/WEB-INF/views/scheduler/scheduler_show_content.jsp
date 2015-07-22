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
		motivate += " <br><textarea rows='10' cols='80' id='motivate' name='motivate'>봉사신청시 이 글을 지우고 써주세요.</textarea>";
		motivate += "<input type='button' value='신청하기' id='VolunteerApplicant'>";
		$("#motivateForm").html(motivate);
		
		$("#VolunteerApplicant").click(function(){
			//alert("버튼 클릭");
			/* location.href="voluntary_register_applicant.ymv?recruitNo=${requestScope.rvo.recruitNo }&memberNo=1&motivate="+$("#motivate").val(); */ 
			/* memberNo=${sessinScope.session.memberNo}우선 숫자 하나 넣어놓고 나중에 세션에서 받아온 memberNO로 바꾸기 */
			$.ajax({
				type:"get",
				url:"voluntary_register_applicant.ymv",				
				data:"recruitNo=${requestScope.rvo.recruitNo }&memberNo=1&motivate="+$("#motivate").val(),
				dataType:"json", 
				success:function(data){
					//alert(data);
					if(data==true){
						alert("이미 신청하셨습니다.");
						$("#motivate").val("");
					}else{
						alert("신청이 완료되었습니다.");
						$("#motivate").val("");
					}
				}
			});
		});
	});//click
	
	
});
</script>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="content">
		<tbody>
			<tr>
				<td width="150">NO : ${requestScope.rvo.recruitNo }</td>
				<td colspan="2">제목 : ${requestScope.rvo.title}</td>
			</tr>
			<tr>
				<td>기업명 : <%-- ${sessionScope.result.name } --%></td>
				<td width="180">시간:<%-- ${requestScope.rvo.time} --%></td>
				<td>조회수 :<%--  ${requestScope.rvo.hits } --%></td>
			</tr>
			<tr>
				<td>분야: ${requestScope.rvo.field}</td>
				<td>나이제한 : ${requestScope.rvo.age}</td>
				<td>지역 : ${requestScope.rvo.location}</td>
			</tr>
			<tr>
				<td colspan="3" align="center" height="30">시작시간:
					${requestScope.rvo.startDate} &nbsp&nbsp&nbsp~&nbsp&nbsp&nbsp 종료시간:
					${requestScope.rvo.endDate}</td>
				<%--      <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp~</td>
         <td>종료시간: ${requestScope.rvo.endDate}</td> --%>
			</tr>

			<tr>
				<td colspan="15"><pre>${requestScope.rvo.content}</pre></td>
			</tr>
			<tr>
				<td valign="middle" align="center" colspan="3"><a
					href="${initParam.root}voluntary_board.ymv"> <img
						class="action" src="${initParam.root}img/list_btn.jpg"
						onclick="sendList()"></a> <c:choose>
						<c:when test="${sessionScope.result.id==requestScope.bvo.id}">
							<a
								href="${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }">
								<img class="action" src="${initParam.root}img/modify_btn.jpg"
								id="update">
							</a>
							<img class="action" src="${initParam.root}img/delete_btn.jpg"
								id="delete">
							<input type="button" value="신청하기" id="applicant">
						</c:when>
					</c:choose></td>
			</tr>
			</tbody>
		</table>
		<br>
		<br> <span id="motivateForm"></span>
	</div>
</div>
