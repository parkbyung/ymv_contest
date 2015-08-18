<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){      
		$("#auctionForm").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			} else if ($("#article").val() == "") {
				alert("물품명을 입력해 주세요");
				return false;
			} else if ($("#firstPrice ").val() == "") {
				alert("시작가를 입력해 주세요");
				return false;
			} else if ($("#endTime").val() == "") {
				alert("끝시간을 입력해 주세요");
				return false;
			} else if ($("#content").val() == "") {
				alert("상세정보를 입력해 주세요");
				return false;
			}
			else if ($("#fileName").val() == "") {
				if (confirm("새로운 파일을 첨부하지 않으십니까?") == true) {
					$("#hidden").val("2");
					alert($("#hidden").val());
					location.href = "auction_update.ymv";
				} else {
					alert($("#hidden").val());
					return false;			
				}
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
		<h2>글 수정</h2>
		<form id="auctionForm" action="auction_board_update.ymv?memberNo=${sessionScope.mvo.memberNo }" enctype="multipart/form-data" method="post">
			<table class="table table-striped table-hover">
				 <tr>
               <th class="info"><h4 class="text-center">제목</h4></th>
               <td><input type="text" name="title" id="title" value="${requestScope.abvo.title }"></td>
            </tr>
         <tr>
               <th class="info"><h4 class="text-center">파일업로드</h4></th>
               <td><input type="file" name="fileName" id = "fileName"></td>
            </tr>
               <tr>
               <th class="info"><h4 class="text-center">물품명</h4></th>
               <td><input type="text" name="article" id="article" value="${requestScope.abvo.article }"></td>
               </tr>
				<tr>
					<th class="info"><h4 class="text-center">시작가격</h4></th>
					<td><input type="text" name="firstPrice" id="firstPrice" value="${requestScope.abvo.firstPrice}"></td>
					</tr>
				<tr>
               		<th class="info"><h4 class="text-center">마감일</h4></th>
               		<td><input type="text" id="datepicker2" name="endDate" value="${requestScope.abvo.endDate}"></td>
            	</tr>
				<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.abvo.content }</textarea></td>
				</tr>
			</table>
			<br> <div class = "col-sm-2 col-sm-offset-10">
			<input type="submit" class = "btn btn-primary"value="글 수정"><br><br></div>		
			<input type="hidden" name="boardNo" value="${requestScope.abvo.boardNo }">
			<input type="hidden" name = "hidden" id = "hidden" value = "1">
		</form>
	</div>

