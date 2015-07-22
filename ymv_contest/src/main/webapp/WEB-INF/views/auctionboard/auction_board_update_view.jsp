<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){      
    $("#updateCancelBtn").click(function() {
    	if(confirm("취소하시겠습니까?")==true){
			location.href="auction_board.ymv";
		}else{
			return;
		}
	});    
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
		<form id="auctionForm"
			action="auction_board_update.ymv?memberNo=${sessionScope.mvo.memberNo }" method="post">
			<table class="table table-striped table-hover">
				 <tr>
               <th class="info"><h4 class="text-center">제목</h4></th>
               <td><input type="text" name="title" id="title" value="${requestScope.abvo.title }"></td>
            </tr>
         <tr>
               <th class="info"><h4 class="text-center">파일업로드</h4></th>
               <td><input type="file" name="fileName"></td>
            </tr>
               <tr>
               <th class="info"><h4 class="text-center">물품명</h4></th>
               <td><input type="text" name="article" id="article" value="${requestScope.abvo.article }"></td>
               </tr>
				<tr>
					<th class="info"><h4 class="text-center">입찰시작가</h4></th>
					<td><input type="text" name="firstPrice" id="firstPrice" value="${requestScope.abvo.firstPrice}"></td>
					</tr>
				<tr>
					<th class="info"><h4 class="text-center" >끝시간</h4></th>
					<td><input type="text" id="datepicker2" name="endDate" placeholder="종료날짜"  value="${requestScope.abvo.endDate}">
						<select id="endTime" name="endTime">
							<!-- 한시간 단위로 하기 -->
							<option value="">-끝시간-</option>
							<option value="06:00">06:00</option>
							<option value="07:00">07:00</option>
							<option value="08:00">08:00</option>
							<option value="09:00">09:00</option>
							<option value="10:00">10:00</option>
							<option value="11:00">11:00</option>
							<option value="12:00">12:00</option>
							<option value="13:00">13:00</option>
							<option value="14:00">14:00</option>
							<option value="15:00">15:00</option>
							<option value="16:00">16:00</option>
							<option value="17:00">17:00</option>
							<option value="18:00">18:00</option>
							<option value="19:00">19:00</option>
							<option value="20:00">20:00</option>
							<option value="21:00">21:00</option>
							<option value="22:00">22:00</option>
							<option value="23:00">23:00</option>
							<option value="00:00">00:00</option>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.abvo.content }</textarea></td>
				</tr>
			</table>
			<br> <div class = "col-sm-2 col-sm-offset-10">
			<input type="submit" class = "btn btn-primary"value="글 등록"><br><br></div>		
			<input type="hidden" name="boardNo" value="${requestScope.abvo.boardNo }">
		</form>
	</div>

