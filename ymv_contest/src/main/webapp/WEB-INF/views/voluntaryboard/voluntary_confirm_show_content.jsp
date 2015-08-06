<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id='print_table'>
<h3>
	<p class="text-center">봉사활동 확인서</p>
</h3>
<br>
<!-- style="width: 100px; height: 500px;" -->

<style> 
@page a4sheet { size: 21.0cm 29.7cm } 
.a4 { page: a4sheet; page-break-after: always } 
</style>


<div class="col-sm-3 col-sm-offset-3" align="center">
	<table class="a4" border="1" cellpadding="5" width="620px" height="630px" style="table-layout:fixed">

		<tr>
			<th rowspan="3" colspan="1" style="text-align: center;">인적사항</th>
			<th align="center" colspan="1" style="text-align: center;">성명</th>
			<td align="center" colspan="3">${sessionScope.mvo.name}</td>
		</tr>
		<tr>
			<th align="center" colspan="1" style="text-align: center;" >주민등록번호</th>
			<td align="center" colspan="3" >${sessionScope.mvo.identityNo} - ******</td>
		</tr>
		<tr>
			<th align="center" colspan="1" style="text-align: center;">주소</th>
			<td align="center" colspan="3" >${sessionScope.mvo.address}</td>
		</tr>
		<tr>
			<th colspan="1" style="text-align: center;">활동장소</th>
			<td align="center" colspan="4">${requestScope.cbvo.location}</td>
		</tr>
		<tr>
			<th colspan="1" style="text-align: center; word-break:break-all;" height="170px">활동내용</th>
			<td style="word-break:break-all;" align="center" colspan="4" height="170px">${requestScope.cbvo.title}<br>
			</td>
		</tr>
		<tr>
			<th colspan="1" style="text-align: center;">활동일시</th>
			<td align="center" colspan="4">${requestScope.cbvo.recruitingStart} ~
				${requestScope.cbvo.recruitingEnd}</td>
		</tr>
		<tr>
			<th style="text-align: center;" >확인기관명</th>
			<td align="center"  colspan="2" >너와 나의 봉사고리</td>
			<th style="text-align: center;">전화번호</th>
			<td align="center"  colspan="1" >031)1234-5678</td>
		</tr>
		
			<tr>
				<div class="col-md-12">
				<td align="center"  colspan="5" >
				위와 같이 봉사활동을 하였음을 확인합니다.

				<br><br>
				${requestScope.today.year} 년 
				${requestScope.today.month} 월
				${requestScope.today.date} 일
				<br><br>
		</div>
				<div class="col-md-8 col-sm-offset-1">
				<br>
				<strong><h4 style="color: black; font-weight: bold; ">
				너와 나의 봉사고리 회장 서정우
				</h4></strong></div>
				<img src="${initParam.root}img/stamp1.jpg" >
			</td><!-- style="height: 180px;" -->		
		</tr>
	</table>
<br>

</div>
			</div>
<div align="right" style="width: 610px">
<form>
<input type="button" value="인쇄하기" onclick="window.open('voluntary_print.ymv','print_win','width=800,height=400,left=200,status=no,toolbar=no,resizable=no,scrollbars=yes')">
<!-- 프린트 버튼 -->
</form>
<br><br><br><br><br>
</div>