<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
   $(document).ready(function() {
      $("#auctionForm").submit(function() {
         if ($("#title").val() == "") {
            alert("제목을 입력해 주세요");
            return false;
         }else if ($("#article").val() == "") {
            alert("물품명을 입력해 주세요");
            return false;
         } else if ($("#firstPrice ").val() == "") {
            alert("시작가격을 입력해 주세요");
            return false;
         } else if (isNaN($("#firstPrice ").val())) {
             alert("가격은 숫자만 입력해 주세요");
             return false;
         } else if ($("#datepicker2").val() == "") {
            alert("마감일을 입력해 주세요");
            return false;
         } else if ($("#content").val() == "") {
            alert("상세정보를 입력해 주세요");
            return false;
         }
      });
   });

</script>
   <link rel="stylesheet"
   href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
   type="text/css" media="all" />
<script
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
   type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
   type="text/javascript"></script>
<script>
   $(function() {
      $("#datepicker2").datepicker(
            {
               dateFormat : 'yy-mm-dd',
               prevText : '이전 달',
               nextText : '다음 달',
               monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
                     '8월', '9월', '10월', '11월', '12월' ],
               monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
                     '7월', '8월', '9월', '10월', '11월', '12월' ],
               dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
               dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
               dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
               showMonthAfterYear : true,
               yearSuffix : '년'
            });
   });
</script>
<div class="col-md-6 col-sm-offset-3">
      <h2>나눔 활동</h2>
      <form id="auctionForm"  action="auction_register.ymv?memberNo=${sessionScope.mvo.memberNo }" enctype="multipart/form-data" method="post">
         <table class="table table-striped table-hover">
            <tr>
               <th class="info"><h4 class="text-center">제목</h4></th>
               <td><input type="text" name="title" id="title"></td>
            </tr>
         	<tr>
               <th class="info"><h4 class="text-center">사진 업로드</h4></th>
               <td><input type="file" name="fileName" ></td>
            </tr>
               <tr>
               <th class="info"><h4 class="text-center">물품명</h4></th>
               <td><input type="text" name="article" id="article"></td>
               </tr>
            <tr>
               <th class="info"><h4 class="text-center">시작가격</h4></th>
               <td><input type="text" name="firstPrice" id="firstPrice"></td>
               </tr>
            <tr>
               <th class="info"><h4 class="text-center">마감일</h4></th>
               <td><input type="text" id="datepicker2" name="endDate" placeholder="종료날짜"></td>
            </tr>
            <tr>
               <th class="info"><h4 class="text-center">상세정보</h4></th>
               <td><textarea rows="10" cols="50" id="content" name="content"></textarea></td>
            </tr>
         </table>
         <br> <div class = "col-sm-2 col-sm-offset-10">
         <input type="submit" class = "btn btn-primary" value="글 등록"><br><br></div>
      </form>
   </div>