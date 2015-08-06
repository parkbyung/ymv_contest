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
	$("#applicantlist").click(function(){
		$.ajax({
			type:"get",
			url:"find_applicant_list.ymv",				
			data:"recruitNo=${requestScope.rvo.recruitNo }",
			dataType:"json", 
			success:function(data){
					var modalinfo = "";
					modalinfo+="<table class='table table-striped table-hover '><thead><tr><th>체크</th><th>이름</th><th>신청동기</th><th>메일주소</th></thead><tbody>";
				$(data).each(function(index,e){
					modalinfo+="<input type='hidden' name='recruitNo' value='"+e.recruitNo+"'>";
					modalinfo+="<tr><td><input class = 'tr_check' type='checkbox' name='memberNo' value='"+e.memberNo+"'></td>";
					modalinfo+="<td>"+e.name+"</td><td>"+e.motivate+"</td><td>"+e.mailAddress+"</td></tr>";
				});
				modalinfo+="</tbody></table>";
					$("#applicant_modal").html(modalinfo);
			}
		});
	});
	$("#memberBtn").click(function(){
        $("input:checkbox:checked").each(function (index){
           memberNoList+=$(this).val() + ",";
        });
        $("#memberList").val(memberNoList);
		$("#checkForm").submit();
	});
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
			</tr>

			<tr>
				<td colspan="15"><pre>${requestScope.rvo.content}</pre></td>
			</tr>
					<tr>
						<td valign="middle" align="center" colspan="3"><a
							href="${initParam.root}voluntary_board.ymv"> <input
								type="button" class="btn btn-default btn-xs" value="목록"></a>
							<c:choose>
								<c:when
									test="${sessionScope.mvo.memberNo==requestScope.rvo.memberNo}">
									<a
										href="${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }">
										<input type="button" class="btn btn-default btn-xs" value="수정">
									</a>
									<input type="button" class="btn btn-default btn-xs"
										class="action" id="delete" value="삭제">
								</c:when>
								<c:when test="${sessionScope.mvo.memberType=='admin'}">
									<a
										href="${initParam.root}voluntary_board_update_view.ymv?recruitNo=${requestScope.rvo.recruitNo }&command=admin">
										<input type="button" class="btn btn-default btn-xs" value="수정">
									</a>
									<input type="button" class="btn btn-default btn-xs"
										class="action" id="delete" value="삭제">
								</c:when>
							</c:choose> <c:choose>
								<c:when test="${sessionScope.mvo.memberType=='normal'}">
									<c:choose>
										<c:when test="${requestScope.rvo.mojib=='모집중' }">
											<input type="button" class="btn btn-default btn-xs"
												value="신청하기" id="applicant">
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</c:when>
								<c:when test="${sessionScope.mvo.memberType=='company'}">
									<c:choose>
										<c:when test="${requestScope.rvo.mojib=='모집중' }">
											<a href="#modal2" data-toggle="modal"><p
													id="applicantlist" class="btn btn-default btn-xs">신청자리스트보기</p></a>
										</c:when>
										<c:otherwise>
											<a
												href="voluntary_OKList.ymv?recruitNo=${requestScope.rvo.recruitNo }">선정된
												인원 보기</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<%-- 관리자 일 경우도 만들어 주기
						<c:when test="">
								</c:when> --%>
							</c:choose></td>
					</tr>
				</tbody>
		</table>
		</div></div>
		<br>
		<br> <span id="motivateForm"></span>
	</div>
 <div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-content">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">신청자 리스트</h4>
      </div>
      <div class="modal-body">
      	<form action="voluntary_applicantOK.ymv" id="checkForm" method="get">
        <p id = "applicant_modal"></p>
        <input type="hidden" id="memberList" name="memberList" value="">
        <input type="hidden" name="title" value="${requestScope.rvo.title}">
        <button type="button" class="btn btn-primary"  id="memberBtn" >신청자 뽑기</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
