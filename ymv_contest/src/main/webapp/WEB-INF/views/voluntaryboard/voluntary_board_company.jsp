<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-10 col-sm-offset-1">
	<h3>
		<p class="text-center">봉사 등록 확인</p>
	</h3>
	<br><br>
	<table class="table table-striped table-hover">
			<colgroup>
			<col style="width: 6%;" />
			<col style="width: 10%;" />
			<col style="width: 27%;" />
			<col style="width: 14%;" />
			<col style="width: 7%;" />
			<col style="width: 18%;" />
			<col style="width: 18%;" />
			</colgroup>
			<thead>
				<tr>
				<th scope="col">NO</th>
				<th scope="col">모집상태</th>
				<th scope="col">제목</th>
				<th scope="col">분야</th>
				<th scope="col">지역</th>
				<th scope="col">시작일</th>
				<th scope="col">완료일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bvo" items="${requestScope.lvo.list}">
					<tr>
						<td>${bvo.recruitNo }</td>
						<c:choose>
						<c:when test="${bvo.mojib=='모집중'}">
						<td><img src="${initParam.root}img/recruiting.jpg"></td>						
						<td>
							<a href="${initParam.root}voluntary_show_content_recruit_vol_type.ymv?memberNo=${sessionScope.mvo.memberNo }&recruitNo=${bvo.recruitNo}&mojib=${bvo.mojib }"> ${bvo.title }</a>
						</td>
						</c:when>
						<c:otherwise>
						<td><img src="${initParam.root}img/recruitfin.jpg"></td>						
							<td>
								<a href="${initParam.root}voluntary_show_content_recruit_vol_type.ymv?memberNo=${sessionScope.mvo.memberNo }&recruitNo=${bvo.recruitNo}&mojib=${bvo.mojib }"> ${bvo.title }</a>
							</td>
						</c:otherwise>
						</c:choose>
						<td>${bvo.field }</td>
						<td>${bvo.location }</td>
						<td>${bvo.startDate }</td>
						<td>${bvo.endDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<div class="col-sm-12">
    <div class="pull-right"> <c:if test="${sessionScope.mvo.memberType=='company' }">
		<a href="${initParam.root }voluntary_register_view.ymv" class="btn btn-default btn-xs">글쓰기</a>
</c:if></div></div>
<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="voluntary_board_company.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="voluntary_board_company.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="voluntary_board_company.ymv?pageNo=${requestScope.lvo.pagingBean.endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</div>



