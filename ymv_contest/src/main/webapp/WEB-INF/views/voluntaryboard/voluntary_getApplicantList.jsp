<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function(){
		var memberNoList="";
		$("#memberBtn").click(function(){
			$("input:checkbox:checked").each(function (index){
				memberNoList+=$(this).val() + ",";
			});
			$("#memberList").val(memberNoList);
			alert(memberNoList);
			$("#checkForm").submit();
		});
	});
</script>
<form action="voluntary_applicantOK.ymv" id="checkForm" method="get">
<c:forEach items="${requestScope.list }" var="applicant">
	<input type="checkbox" name="memberNo" value="${applicant.memberNo }">${applicant.id } + ${applicant.name } + ${applicant.mailAddress } + ${applicant.motivate } <br>
	<input type="hidden" name="recruitNo" value="${applicant.recruitNo }">
</c:forEach>
<input type="button" id="memberBtn" value="신청자리스트뽑기">
<input type="hidden" id="memberList" name="memberList" value="">
</form>