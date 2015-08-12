<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(document).ready(function () {
    $.datepicker.regional['ko'] = {
        closeText: '닫기',
        prevText: '이전달',
        nextText: '다음달',
        currentText: '오늘',
        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
        '7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '',
        showOn: 'both',
        buttonText: "달력",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99',
        minDate: "+0D"
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
 
    $('#datepicker1').datepicker();
    $('#datepicker1').datepicker("option", "maxDate", $("#datepicker2").val());
    $('#datepicker1').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker2").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#datepicker2').datepicker();
    $('#datepicker2').datepicker("option", "minDate", $("#datepicker1").val());
    $('#datepicker2').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker1").datepicker( "option", "maxDate", selectedDate );
    });
});
</script>
    <h3>
		<p class="text-center">후원등록</p>
		<br>
	</h3>
<div class="col-md-6 col-sm-offset-3">
<form action="sponsor_register.ymv" enctype="multipart/form-data" method="post">
	<table class="table table-striped table-hover">
				<tr>
					<th class="info"><h4 class="text-center">제목</h4></th>
					<td><input type="text" name="title" id="title" size="46"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">파일업로드</h4></th>
					<td><input type="file" name="fileName"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">시작날짜</h4></th>
					<td><input type="text" id="datepicker1" name="startDate"
						placeholder="시작날짜">
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">종료날짜</h4></th>
					<td><input type="text" id="datepicker2" name="endDate"
						placeholder="종료날짜"></td>
				</tr>
			<tr>
					<th class="info"><h4 class="text-center">상세정보</h4></th>
					<td><textarea rows="10" cols="50" id="content" name="content">${requestScope.spvo.content }</textarea></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">목표금액</h4></th>
					<td>$<input type="text" name="targetPrice"></td>
				</tr>
			</table>
<div align="right">
	<input type="submit" class ="btn btn-primary" value="등록">
</div>
</form>
</div>