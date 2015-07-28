<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	$(document).ready(function(){
		$("#loginForm").submit(function(){
			if($(":input[name=id]").val()==""){
				alert("아이디를 입력하세요!");
				return false;
			}
			if($(":input[name=password]").val()==""){
				alert("패스워드를 입력하세요!");
				return false;
			}
		});
		
/* $("#profile").click(function(){
			$("#profileView").html("<form action='member_profileUpload.ymv' enctype='multipart/form-data' method='post'><input type='file' class = 'btn btn-default btn-xs' name='fileName' accept='.gif, .jpg, .png'><input type='submit' class = 'btn btn-default btn-xs' value='프로필사진등록' style='position: relative;margin-left: 5%;'>");
		}); */
/* $("#profile").click(function(){
	$("#profileView").html("<form action='member_profileUpload.ymv' enctype='multipart/form-data' method='post'><input type='file' class = 'btn btn-default btn-xs' name='fileName' accept='.gif, .jpg, .png'><input type='submit' class = 'btn btn-default btn-xs' value='프로필사진등록' style='position: relative;margin-left: 5%;'>");
}); */
$("#modalBtn").click(function(){
       $.ajax({
            type : "post",
            url : "scheduler_Check.ymv",
            data : "memberNo=${sessionScope.mvo.memberNo}",
            dataType : "json",
            success : function(m) {
               if(m.memberNo<=0){
            	   location.href="scheduler_register_view.ymv";
               }else{
            	   $.ajax({
                       type : "post",
                       url : "scheduler_board.ymv",
                       data : "MemberNo="+m.memberNo+"&field="+m.field+"&location="+
                       m.location+"&startDate="+m.startDate+"&endDate="+m.endDate,
                       dataType : "json",
                       success : function(data) {
                    	   var modalInfo="";
                          $(data.dateList).each(function(index,date){
                        	  modalInfo+="<table class='table'><caption>"+date.DATE_LIST+"<hr></caption>";
                        	  modalInfo += "<colgroup><col style='width: 6%;' /><col style='width: 10%;' /><col style='width: 19%;' /><col style='width: 15%;' /><col style='width: 10%;' /><col style='width: 20%;' /><col style='width: 20%;' /></colgroup> <thead><tr><th scope='col' >NO</th><th scope='col'>모집상태</th><th scope='col' >제목</th><th scope='col'>분야</th><th scope='col'>지역</th><th scope='col'>시작일</th><th scope='col'>완료일</th></tr></thead>";
                        	  modalInfo += "<tbody>";
                        	  $(data.list).each(function(index,list){
                        		  if(date.DATE_LIST==list.checkDate){
                        			  if(list.mojib=='모집중'){
                            			  modalInfo +="<tr><td>"+list.recruitNo+"</td><td><img src='${initParam.root}img/recruiting.jpg'></td><td><a href='${initParam.root}voluntary_show_content_recruit_vol_type.ymv?recruitNo="+list.recruitNo+"'>"+list.title+"</a></td><td>"+list.field+"</td><td>"+list.location+"</td><td>"+list.startDate+"</td><td>"+list.endDate+"</td></tr>";
                        			  }else{
                            			  modalInfo +="<tr><td>"+list.recruitNo+"</td><td><img src='${initParam.root}img/recruitfin.jpg'></td><td><a href='${initParam.root}voluntary_show_content_recruit_vol_type.ymv?recruitNo="+list.recruitNo+"'>"+list.title+"</a></td><td>"+list.field+"</td><td>"+list.location+"</td><td>"+list.startDate+"</td><td>"+list.endDate+"</td></tr>";
                        			  }
                        		  }
                        	  });//each2
                        	  modalInfo+="</tbody></table>";
                          });//each1
                          $("#scheduletModal").html(modalInfo);
                       }
                    });//ajax2
               }
            }
         });//ajax
	});//modal click
	});//ready 
</script>

<c:choose>
	<c:when test="${sessionScope.mvo==null}">
		<form id="loginForm" class="form-horizontal"
			style="position: relative; left: 5%;" action="login.ymv">
			<fieldset>
				<div class="form-group">
					<label for="inputId" class="col-lg-2 control-label">ID</label><br>
					<br>
					<div class="col-lg-10">
						<input type="text" class="form-control" name="id" id="id"
							placeholder="ID입력">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-lg-2 control-label">Password</label><br>
					<br>
					<div class="col-lg-10">
						<input type="password" class="form-control" name="password"
							id="password" placeholder="Password입력">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="reset" class="btn btn-default btn-xs">Cancel</button>
						<button type="submit" class="btn btn-primary btn-xs">Submit</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
	<c:otherwise>
		<br>
		<br>
		<c:choose>
			<c:when test="${sessionScope.mvo.filePath!=null }">
				<img src="${initParam.root }${sessionScope.mvo.filePath}"
					id="profile" style="width: 80%; height: 50%; position: relative; margin-left: 15%;">
			</c:when>
			<c:otherwise>
					<img
						src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png"
						class="center-block img-circle img-responsive" id="profile">
				<br>
				<br>
			</c:otherwise>
		</c:choose>
		<!-- <div id="profileView"></div> -->
		<div class="panel panel-default"
			style="position: relative; margin-left: 5%;">
			<div class="panel-body">
				<div class="col-xs-12 text-center">
					<h5 class="glyphicon glyphicon-ok">${sessionScope.mvo.name}님</h5>
					<br>
				</div>


				<div class="btn-group-vertical btn-block">
					<c:choose>
						<c:when test="${sessionScope.mvo.memberType=='company' }">
							<a href="#"
								class="btn btn-default btn-xs glyphicon glyphicon-briefcase">
								기업회원</a>
							<br>
						</c:when>
						<c:when test="${sessionScope.mvo.memberType=='normal' }">
							<a href="#"
								class="btn btn-default btn-xs glyphicon glyphicon-heart ">
								일반회원</a>
							<br>
						</c:when>
						<c:when test="${sessionScope.mvo.memberType=='admin' }">
							<a href="#"
								class="btn btn-default btn-xs glyphicon glyphicon-lock">
								관리자</a>
							<br>
						</c:when>
					</c:choose>
					<a href="${initParam.root }member_update_form.ymv"
						class="btn btn-default btn-xs glyphicon glyphicon-edit ">
						정보수정</a><br> <a href="${initParam.root }logout.ymv"
						class="btn btn-default btn-xs glyphicon glyphicon-log-out">
						로그아웃</a> <br>
					<a href="#modal" data-toggle="modal"><img
						src="${initParam.root}img/scheduler.jpg" class="img-responsive"
						id="modalBtn"></a>
				</div>
			</div>
		</div>
	</c:otherwise>

</c:choose>
<c:choose>
	<c:when test="${sessionScope.mvo==null }">
		<c:choose>
			<c:when test="${requestScope.loginSession=='X'}">
				<script type="text/javascript">
					alert("아이디와 비밀번호가 일치하지 않습니다!");
				</script>
			</c:when>
		</c:choose>
		<div class="col-sm-12">
    <div class="pull-right"> 
		<a href="${initParam.root}member_register_form.ymv"
			class="btn btn-primary btn-xs">회원가입</a>
    </div>
  </div>
		<br>
	</c:when>
</c:choose>

<br>

<div class="modal fade" id="modal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-content">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Modal title</h4>
			</div>
			<div class="modal-body">
				<p id="scheduletModal" align="center">로그인후 이용하시기 바랍니다.</p>
			</div>
			<div class="modal-footer">
				<a href="" data-dismiss="modal"><img src="${initParam.root}img/close.jpg"></a>
				<a href="scheduler_update_view.ymv?memberNo=${sessionScope.mvo.memberNo}"><img src="${initParam.root}img/schedulerUpdate.jpg"></a>
			</div>
		</div>
	</div>
</div>




