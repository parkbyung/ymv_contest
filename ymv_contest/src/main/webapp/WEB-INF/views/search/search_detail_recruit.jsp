<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>봉사 검색 결과</h4>
봉사 검색 결과는 총 ${requestScope.rvo.pagingBean.totalContent}개 입니다.
<div class="col-md-12">
	<div class="col-md-12">
		<table class="table">
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 10%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
				<col style="width: 20%;" />
			</colgroup>
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
				<c:forEach var="rvo" items="${requestScope.rvo.list}">
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


		<br> <br>


		<div class="text-center">
			<ul class="pagination">
				<c:choose>
					<c:when test="${requestScope.rvo.pagingBean.previousPageGroup}">
						<li class="active"><a
							href="search_boards_recruit.ymv?pageNo=${requestScope.rvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a
							href="search_boards_recruit.ymv?pageNo=${requestScope.rvo.pagingBean.
    startPageOfPageGroup-1}&search=${sebvo.search }">«</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="i"
					begin="${requestScope.rvo.pagingBean.startPageOfPageGroup}"
					end="${requestScope.rvo.pagingBean.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${requestScope.rvo.pagingBean.nowPage!=i}">
							<li><a
								href="search_boards_recruit.ymv?pageNo=${i}&search=${sebvo.search }">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.rvo.pagingBean.nextPageGroup}">
						<li class="active"><a
							href="search_boards_recruit.ymv?pageNo=${requestScope.rvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a
							href="search_boards_recruit.ymv?pageNo=${requestScope.rvo.pagingBean.endPageOfPageGroup+1}&search=${sebvo.search }">»</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>