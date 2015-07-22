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
		$("#checkForm").submit();
	});
});

</script>
선정된 인원 : <br>
<form action="voluntary_confirm.ymv" method="get" id="checkForm">
<input type="hidden" id="memberList" name="memberList" value="">
<table class='confirm'><thead><tr><th>체크</th><th>이름</th><th>메일주소</th></thead>
	<tbody>
		<c:forEach items="${requestScope.list }" var="appOK">
		<input type='hidden' name='recruitNo' value='${appOK.recruitNo}'>
			<tr>
				<td><input class = 'tr_check' type='checkbox' name='memberNo' value='${appOK.memberNo }'></td>
				<td>${appOK.name }</td>
				<td>${appOK.id }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button type="button" id="memberBtn" >봉사활동 확인</button>
</form>




