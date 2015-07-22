<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#10Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=10",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>10대</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		
		$("#20Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=20",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>20대</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		$("#30Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=30",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>30대</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		$("#40Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=40",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>40대</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		$("#50Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=50",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>50대</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		$("#0Btn").click(function(){
			//alert($(this).val());
			 $.ajax({
					type:"post",
					url:"voluntary_selectStatisticsByAge.ymv",				
					data:"age=0",
					dataType:"json",   
					success:function(data){ 						
						var table ="<hr><br><h2>기타</h2>";
						table+="<div class='row'><div class = 'col-md-3''></div><div class='col-md-6 col-sm-6'>";
						table+="<table class='table table-striped table-hover'>";
						table+="<tr><th>순위</th><th>분야</th><th>신청수</th></tr>";
						$.each(data,function(index,e){
							table+="<tr>";
							table+="<th>"+e.RANKING+"</th><td>"+e.FIELD+"</td><td>"+e.APPLICATE_COUNT+"</td>";
							table+="</tr>";
						});
						table+="</table></div></div></div>";
						
						$("#statistics").html(table);
						
					}
				});//ajax 		
		});
		
		
		
	});//document
</script>

<div class = "col-sm-6 col-sm-offset-3">
<div class = "centered">
	<div class="row">
	<h2><p class = "text-center">나이별 선호 봉사</p></h2><br><br>
<div class="text-center">
		<input class="btn btn-primary btn-lg" type="button" value="10대" id="10Btn"> <input
			type="button" value="20대" id="20Btn" class="btn btn-primary btn-lg"> <input
			type="button" value="30대" id="30Btn" class="btn btn-primary btn-lg"> <input
			type="button" value="40대" id="40Btn" class="btn btn-primary btn-lg"> <input
			type="button" value="50대" id="50Btn" class="btn btn-primary btn-lg"> <input
			type="button" value="기타" id="0Btn" class="btn btn-primary btn-lg">
			</div>
	</div>
	</div>
		<span id="statistics">
	</span>
</div>































<%-- <br><br>
		<table border="1" cellpadding="5">
			<tr>
				<th>순위</th>
				<th>분야</th>
				<th>신청수</th>
				<th>나이</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="i">
				<tr>
					<td>${i.RANKING }</td>
					<td>${i.FIELD }</td>
					<td>${i.APPLICATE_COUNT }</td>
					<td>${i.AGE }</td>
					<!-- {RANKING=1, FIELD=아동, AGE=20, APPLICATE_COUNT=18} -->
				</tr>
			</c:forEach>
		</table> --%>