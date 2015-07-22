<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%-- Spring Expression Language (SpEL) 선언부 --%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

   <script type="text/javascript">
   $(document).ready(function(){
	   if("${requestScope.info}" != ""){
		   alert("${requestScope.info}");
	   }
   });
   </script>
   <div class="section">
      <div class="container">
        <div class="row">
			<div class="col-sm-6 col-sm-offset-3">
   <h3>회원가입</h3>
            <form:form method = "post" action="${initParam.root}member_register_validation.ymv?identityNo=${requestScope.memberVO.identityNo }&memberType=${requestScope.memberVO.memberType }"
             commandName="memberVO"	class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="id" class="control-label">아이디</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="id" path="id" id="id"/>
          		   <span id = "idCheck"></span>
 <font color="red"><form:errors path="id"></form:errors></font>
                </div>
              </div>
  <!-- 패스워드 -->
            <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">비밀번호</label>
                </div>
                <div class="col-sm-5">
                  <form:password class="form-control" placeholder="password" path="password" id="password"/>
         <font color="red"><form:errors path="password"></form:errors></font>
                </div>
              </div>
    <!-- 이름 -->
      <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">이름</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="name" path="name" id="name"/>
					<font color="red"><form:errors path="name"></form:errors></font>
                </div>
              </div>
	<!-- 주소 -->
      <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">주소</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="name" path="address" id="address"/>
			 <font color="red"><form:errors path="address"></form:errors></font>
                </div>
              </div>
  <!-- 이메일 -->
 	     <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">이메일</label>
                </div>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" placeholder="mailAddress" path="mailAddress" id="mailAddress"/>
	 <font color="red"><form:errors path="mailAddress"></form:errors></font>
                </div>
              </div>
 	 <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">회원가입</button>
                </div>
              </div>
</form:form>
          </div>
        </div>
      </div>
    </div>
  </body>