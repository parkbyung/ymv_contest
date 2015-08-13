<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	if ("${requestScope.check}" == "NO") {
		alert("${requestScope.identityNo}가 이미 존재합니다!다시 확인해주세요");
		location.href = "${initParam.root}member_register_form.ymv";
	} else {
		if(confirm("${requestScope.identityNo} 사용가능합니다")!=false){
			location.href = "${initParam.root}member_register.ymv?identityNo=${requestScope.identityNo}&memberType=${requestScope.memberType}";
		}else{
			location.href = "${initParam.root}member_register_form.ymv";
		}



	}
</script>