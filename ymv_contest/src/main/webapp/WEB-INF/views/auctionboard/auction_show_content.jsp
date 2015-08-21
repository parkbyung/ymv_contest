<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#auctionBtn").click(function(){
			var auctionTable="";
			var nameView = "";
			if($("#auctionNewPrice").val()==null || $("#auctionNewPrice").val()=="" ){
				alert("거래 금액을 입력해 주세요");
				return;
			}else if(isNaN($("#auctionNewPrice ").val())){
				alert("가격은 숫자만 입력하실 수 있습니다.");
				return;
			}else if(parseFloat($("#auctionNewPrice ").val()) < parseFloat("${requestScope.auvo.currentPrice}")){
				alert("현재가격보다 큰 금액을 입력해주세요.");
				return;
			}else{
			$.ajax({
				type:"get",
				url:"auction_update_price.ymv",				
				data:"boardNo=${requestScope.auvo.boardNo }&bidder=${sessionScope.mvo.name}&currentPrice="+$("#auctionNewPrice").val(),
				dataType:"json", 
				success:function(data){
					alert("거래에 참여하셨습니다.");
					$("#auctionNewPrice").val("");
					auctionTable+= "<p>현재가격 : " + data.currentPrice  + " </p>";
					nameView += "낙찰예정자 : " + data.bidder ;
					$("#priceView1").html(auctionTable);
					$("#priceView2").html(auctionTable);
					$("#name").html(nameView);
				}//success
			});//ajax
		
			}
		});//click
		
		$("#auctionReset").click(function(){
			$("#auctionNewPrice").val("");
		});//click
		
		$("#deleteBtn").click(function(){
			if(confirm("삭제 하시겠습니까?")){
				location.href="${initParam.root}auction_board_delete.ymv?boardNo=${requestScope.auvo.boardNo }";
			}else{
				
			}
		})
		
	});//document


</script>


<h3 align="center">나눔 활동 상세 글보기</h3>
   <div class="col-sm-8 col-sm-offset-2" align="center">
      <div class="panel panel-default">
         <div class="panel-body">
         	<table class="col-sm-8" style="width: 700px;">
         		<tbody>
         			<tr>
         				<td>NO : ${requestScope.auvo.boardNo }</td>
         				<td>
         					<c:choose>
         					<c:when test="${requestScope.auvo.gyeongmae == '경매중'}">
         						<div id="name">낙찰예정자 : ${requestScope.auvo.bidder }</div>
         					</c:when>
         					<c:otherwise>
         						최종낙찰자 : ${requestScope.auvo.bidder }
         					</c:otherwise>
         					</c:choose>
         				</td>
         			</tr>
         			<tr>
         				<td colspan="2" style="font-weight: bold; font-size: 7;" >제목 : ${requestScope.auvo.title }</td>
         			</tr>
         			<tr>
         				<td>시작일 : ${requestScope.auvo.timePosted} 
         				&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp; 마감일 : ${requestScope.auvo.endDate}</td>
         			</tr>
         			<tr>
         				<td><p>물품명 : ${requestScope.auvo.article }</p></td>
         			</tr>
         			<tr>
                    <td colspan="15">
                    	<c:if test="${requestScope.pvo!=null }">
                           <img src="${initParam.root }${requestScope.pvo.filePath}">
                        </c:if> 
                        <pre>${requestScope.auvo.content}</pre></td>
                  	</tr>
         			<tr>
         				<td>시작가격 : ${requestScope.auvo.firstPrice }</td>
         			</tr>
         			<tr>
         				<c:choose>
         					<c:when test="${requestScope.auvo.currentPrice == 0}">
         						<td><div id="priceView1"><p>현재가격 : ${requestScope.auvo.firstPrice }</p></div></td>
         					</c:when>
         					<c:otherwise>
		         				<td><div id="priceView2"><p>현재가격 : ${requestScope.auvo.currentPrice}</p></div></td>
         					</c:otherwise>
         				</c:choose>
         			</tr>
         			<tr>
         				<td>
         					<c:choose>
         					<c:when test="${requestScope.auvo.gyeongmae == '경매중'}">
         					 	<font size="4" color="blue"><div id="sangtae"> 현재 경매 진행 중입니다.</div></font>
         					 </c:when>
         					 <c:otherwise>
         					 	<font size="4" color="blue">
         					 	경매가 완료되었습니다.</font>
         					 </c:otherwise>
         					 </c:choose>
         				</td>
         			</tr>
         			<tr>
         				<td>
         				<c:choose>
         					<c:when test="${requestScope.auvo.gyeongmae == '경매중'}">
	         					<p><p>금액 : <input type="text" id="auctionNewPrice">
	         					<input type="button" class="btn btn-default btn-xs"  value="거래하기" id="auctionBtn">
	         					<input type="reset"  class="btn btn-default btn-xs" id="auctionReset" value="취소"></p></p>
                      		</c:when>
                      		<c:otherwise>
                      		
                      		</c:otherwise>
                      	</c:choose>
         				</td>
         			</tr>
         			
         			<!-- 버튼 -->
         			<tr>
         				<td valign="middle" align="center" colspan="2">
         					<a	href="${initParam.root}auction_board.ymv"><img src="${initParam.root}img/list_btn.jpg" ></a>
         					<c:choose>
								<c:when test="${sessionScope.mvo.memberType=='admin' }">
									<a href="${initParam.root}auction_update_view.ymv?boardNo=${requestScope.auvo.boardNo }">
										<img id="modifyBtn" src="${initParam.root}img/modify_btn.jpg"></a>
									<%-- <a href="${initParam.root}auction_board_delete.ymv?boardNo=${requestScope.auvo.boardNo }">
                              			<img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg"></a> --%>
                              			<img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg">
								</c:when>
							</c:choose>
         					
         				</td>
         			</tr>
         		</tbody>
         	</table>
         </div>
      </div>
   </div>
