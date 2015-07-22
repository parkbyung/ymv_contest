<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <script type="text/javascript">
   $(document).ready(function(){
      $("#qnaForm").submit(function(){
         if($("#title").val()==""){
            alert("제목을 입력해주세요");
            return false;
         }else if($("#field").val()==""){
            alert("내용을 선택해 주세요");
            return false;
         }else if($("#location").val()==""){
            alert("지역을 선택해 주세요");
            return false;
         }else{
         if(!confirm("글을 수정하시겠습니까?")){
                 return false;
          }
         }
      });
      $("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="qna_board.ymv";
			}else{
				return;
			}
		});
      
      
   });

</script>
<div class="col-md-6 col-md-offset-3">
<h3>QnA 수정</h3>
<form id="qnaForm" action="qna_board_update.ymv" method="post" class="form-horizontal">
         <table class="table table-hover">
            <tr>
               <td>
              글번호&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;${requestScope.qvo.qnaNo }
               </td>
           </tr>
            <tr>
               <td>
          타이틀:&nbsp;&nbsp;
          <input type=text name=title value="${requestScope.qvo.title }" size="60"></input>
             
               </td>
               </tr>
            <tr>
               <td>                  
   <textarea rows="15" cols="70" name="content">${requestScope.qvo.content }</textarea>
               </td>
            </tr>
            <tr>
           
            <td valign="middle" align="center">                  
               <input type="submit" value="수정하기" class="btn btn-default btn-xs"></input>   
               <input type="button" id="updateCancel" value="취소하기" class="btn btn-default btn-xs"></input>
               </td>                       
            </tr>
         </table>
     <input type="hidden" value="${requestScope.qvo.qnaNo}" name="qnaNo">
</form>   
</div>