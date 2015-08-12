<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<script type="text/javascript">

</script>

<h3 align="center">검색 결과</h3>
<br><br>
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 40%;" />
				<col style="width: 10%;" />
				<col style="width: 10%;" />
				<col style="width: 15%;" />
				<col style="width: 15%;" />
			</colgroup>
			<h5 style="border-width: thick;">봉사 검색 결과</h5><br>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">제목</th>
					<th scope="col">분야</th>
					<th scope="col">지역</th>
					<th scope="col">시작일</th>
					<th scope="col">완료일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rvo" items="${requestScope.rvo}">
					<tr>
						<td>${rvo.recruitNo }</td>
						<td><a
							href="${initParam.root}voluntary_show_content.ymv?recruitNo=${rvo.recruitNo}">
								${rvo.title }</a></td>
						<td>${rvo.field }</td>
						<td>${rvo.location }</td>
						<td>${rvo.volunteeringStartDate }</td>
						<td>${rvo.volunteeringEndDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<c:if test="${fn:length(rvo)>=3}">
			<div class = "col-sm-12">
				<div class = "pull-right">
		
					<a href="search_boards_recruit.ymv?search=${requestScope.search }">더보기</a>
		
				</div>
			</div>
			</c:if>
			
		
		
		<br><br>
		<br>
</div>
</div>




<!-- notice 검색 결과-->

<div class="col-md-12">
	
	<div class="col-md-12">
		<table class="table">
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 40%;" />
				<col style="width: 17%;" />
				<col style="width: 17%;" />
				<col style="width: 17%;" />
			</colgroup>
			<thead>
			<h5 style="border-width: thick;">공지사항 검색 결과</h5><br>
				
				<tr>
					<th class="boardNo col">NO</th>
					<th class="title col">제목</th>
					<th class="writer col">작성자</th>
					<th class="timePosted col">등록시간</th>
					<th class="hit col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nvo" items="${requestScope.nvo}">
					<tr>
						<td>${nvo.boardNo }</td>
						<td><a
							href="${initParam.root}review_showContent.ymv?boardNo=${nvo.boardNo}">
								${nvo.title }</a></td>
						<td>${nvo.writer }</td>
						<td>${nvo.timePosted }</td>
						<td>${nvo.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<c:if test="${fn:length(nvo)>=3}">
		<div class = "col-sm-12">
		<div class = "pull-right">
		
		<a href="search_boards_notice.ymv?search=${requestScope.search }">더보기</a>
		
		</div>
		</div>
		</c:if>
		<br><br>
		<br>
	</div>
	</div>




	<!-- review 검색결과 -->





	<div class="col-md-12">
		<div class="col-md-12">
			<table class="table">
				<colgroup>
					<col style="width: 10%;" />
					<col style="width: 40%;" />
					<col style="width: 17%;" />
					<col style="width: 17%;" />
					<col style="width: 17%;" />
				</colgroup>
				<thead>
				<h5 style="border-width: thick;">후기 검색 결과</h5><br>
					
					<tr>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">등록시간</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="revo" items="${requestScope.revo}">
						<tr>
							<td>${revo.boardNo}</td>
							<td><a
								href="${initParam.root}review_showContent.ymv?boardNo=${revo.boardNo}">${revo.title }</a></td>
							<td>${revo.writer }</td>
							<td>${revo.timePosted }</td>
							<td>${revo.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<c:if test="${fn:length(revo)>=3}">
		<div class = "col-sm-12">
		<div class = "pull-right">
		
		<a href="search_boards_review.ymv?search=${requestScope.search }">더보기</a>
		
		</div>
		</div>
		</c:if>
		<br><br>
		<br>
		</div>
		</div>





		<!-- QnA 검색결과 -->



		<div class="col-md-12">
			<div class="col-md-12">
				<table class="table">
					<colgroup>
						<col style="width: 10%;" />
						<col style="width: 40%;" />
						<col style="width: 17%;" />
						<col style="width: 17%;" />
						<col style="width: 17%;" />
					</colgroup>
					<thead>
					<h5 style="border-width: thick;">QnA 검색 목록</h5><br>
						
						<tr>
							<th class="qnaNo col">NO</th>
							<th class="title col">제목</th>
							<th class="writer col">작성자</th>
							<th class="timePosted col">작성일</th>
							<th class="hit">조회수</th>
						</tr>
						<c:forEach var="qvo" items="${requestScope.qvo}">
							<tr>
								<td>${qvo.qnaNo }</td>
								<td class="titleView"><c:if test="${qvo.relevel!=0}">
										<c:forEach begin="0" end="${qvo.relevel}" step="1">&nbsp;&nbsp;</c:forEach>
										<img src="${initParam.root }/img/reply.jpg">
									</c:if> <a
									href="${initParam.root}qna_showContent.ymv?qnaNo=${qvo.qnaNo}">
										${qvo.title }</a>
								<td>${qvo.writer }</td>
								<td>${qvo.timePosted }</td>
								<td>${qvo.hit }</td>
							</tr>
						</c:forEach>
				</table>
				<br>
				<c:if test="${fn:length(qvo)>=3}">
		<div class = "col-sm-12">
		<div class = "pull-right">
		
		<a href="search_boards_QnA.ymv?search=${requestScope.search }">더보기</a>
		
		</div>
		</div>
		</c:if>
		<br><br>
		<br>
			</div>
			</div>