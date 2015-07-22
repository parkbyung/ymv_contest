<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
	$(document).ready(function(){
	$("#scheduler").click(function(){
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
<br><br>
	<div class="section text-center">
		<div class="container text-center">
			<div class="row text-center">
				<div class="col-md-3 hidden-md text-center"><a href="voluntary_board.ymv">
					<img
							src="${initParam.root}img/main1.jpg"
						class="center-block img-responsive"></a> <br><!-- 봉사게시판 -->
					<div class="row">
						<div class="section">
							<div class="col-md-5 col-md-offset-1"><a href="notice_board.ymv">
								<img
							src="${initParam.root}img/main5.jpg"
									class="center-block img-responsive"></a><!-- 공지사항 -->
							</div>
							<div class="col-md-5"><a href="review_board.ymv">
								<img
							src="${initParam.root}img/main7.jpg"
									class="center-block img-responsive"></a><!-- 후기게시판 -->
							</div>
						</div>
					</div>
					<div><br></div>
					<div class="row">
						<div class="section">
							<div class="col-md-5 col-md-offset-1"><a href="sponsor_board.ymv">
								<img
							src="${initParam.root}img/main3.jpg"
									class="center-block img-responsive"></a><!-- 후원 -->
							</div>
							<div class="col-md-5"><a href="introduce_map.ymv">
								<img
							src="${initParam.root}img/main9.jpg"
									class="center-block img-responsive"></a><!-- 찾아오는길 -->
							</div>
						</div>
					</div>
					<br>
				</div>
				<div class="col-md-6 text-center">
					<div class="section">						
						<div id="myCarousel" class="carousel slide" data-ride="carousel" >
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${initParam.root}img/main_1.jpg">
						</div>
						<div class="item">
							<img src="${initParam.root}img/main_2.jpg">
						</div>
						<div class="item">
							<img src="${initParam.root}img/main_3.jpg">
						</div>
						<div class="item">
							<img src="${initParam.root}img/main_4.jpg">
						</div>
					</div>
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
						
					</div>
				</div>
				<div class="col-md-3">
					<div class="row">
						<div class="col-md-5 col-md-offset-1"><a href="introduce_ymv.ymv">
								<img
							src="${initParam.root}img/main4.jpg"
									class="center-block img-responsive"></a><!-- 너나봉이란 -->
							</div>
							<div class="col-md-5"><a href="qna_board.ymv">
								<img
							src="${initParam.root}img/main8.jpg"
									class="center-block img-responsive"></a><!-- QNA으로 바뀜-->
							</div>
					</div>
					<div><br></div>
					<div class="row">
						<div class="section">
							<div class="col-md-5 col-md-offset-1"><a href="search_view.ymv">
								<img
							src="${initParam.root}img/main2.jpg"
									class="center-block img-responsive"></a><!-- 통합검색 -->
							</div>
							<div class="col-md-5"><a href="voluntary_statistics.ymv">
								<img
							src="${initParam.root}img/main6.jpg"
									class="center-block img-responsive"></a><!-- 통계 -->
							</div>
						</div>
					</div>
					<br>
					<div class="section">
						<a href="#modal" data-toggle="modal"><img	src="${initParam.root}img/main10.jpg" class="center-block img-responsive" id="scheduler"></a><!-- 스케쥴러사진 -->
					</div>
				</div>
			</div>
			<div>
				<br>
			</div>
		</div>
	</div>


