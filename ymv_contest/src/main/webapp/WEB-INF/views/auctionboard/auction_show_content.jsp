<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function(){      
      $("#deleteBtn").click(function() {
         if (confirm("삭제하시겠습니까?")) {
            location.href = "auction_board_delete.ymv?boardNo=" + ${requestScope.abvo.boardNo};
         } else {
            return;
         }//if
      });      //click 
      $("#modifyBtn").click(function() {
          if (confirm("수정하시겠습니까?")) {
             location.href = "auction_board_update_view.ymv?boardNo=" + ${requestScope.abvo.boardNo};
          } else {
             return;
          }//if
       }); 
      $("#auctionForm").submit(function() {
         if ($("#currentPrice").val() == "") {
            alert("금액을 입력해 주세요");
            return false;
         }else if (isNaN($("#currentPrice").val())) {
            alert("금액을 숫자로 입력하세요");
            return false;
         }else   if (parseInt($("#currentPrice").val()) < parseInt("${requestScope.AuctionBoard.currentPrice}")) {
                  alert("현재가보다 금액이 작습니다.");
               return false;   
            }        
         }); //submit
}); //ready
</script>
<form id="auctionForm"  action="auction_update_currentPrice.ymv">
   <div class="col-sm-8 col-sm-offset-2" align="center">
      <div class="panel panel-default">
         <div class="panel-body">
            <table class="col-sm-8">
               <tbody>
                  <tr>
                     <td>NO : ${requestScope.AuctionBoard.boardNo }</td>
                     <td colspan="2">${requestScope.AuctionBoard.title}</td>
                  </tr>
                  <tr>
                     <td>제목 : ${requestScope.AuctionBoard.title}</td>
                     <td>등록시간: ${requestScope.AuctionBoard.timePosted}</td>
                     <td>조회수 : ${requestScope.abvo.hit }</td>
                  </tr>
                  <tr>
                     <td colspan="15"><c:if test="${requestScope.pvo!=null }">
                           <img src="${initParam.root }${requestScope.pvo.filePath}">
                        </c:if> <pre>${requestScope.AuctionBoard.content}</pre></td>
                  </tr>
                  <tr>
                     <td>물품명:${requestScope.AuctionBoard.article }</td>
                  </tr>
                  <tr>
                     <td>시작가:${requestScope.AuctionBoard.firstPrice }</td>
                  </tr>
                  <tr>
                     <td>현재가:${requestScope.AuctionBoard.currentPrice}</td>
                  </tr>
                  <tr>
                     <td><br> 금액 : <input type="text" size=5 id="currentPrice" name="currentPrice">
                        <input type="submit" value="거래하기" id="auctionBtn"> <input
                        type="reset" id="reset" value=reset></td>

                  </tr>
                  <tr>
                     <td colspan="3" align="center"><p>시작시간 :
                           ${requestScope.AuctionBoard.timePosted}
                           &nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp; 종료시간 :
                           ${requestScope.AuctionBoard.endDate}</p></td>
                  </tr>
                  <tr>
                     <td valign="middle" align="center" colspan="3"><a
                        href="${initParam.root}auction_board.ymv"> <img
                           class="action" src="${initParam.root}img/list_btn.jpg"
                           onclick="sendList()"></a><c:choose>
						<c:when test="${sessionScope.mvo.memberType=='admin' }">
                             <a
							href="${initParam.root}auction_board_update_view.ymv?boardNo=${requestScope.AuctionBoard.boardNo }">
										 <img id="modifyBtn" src="${initParam.root}img/modify_btn.jpg">
                              </a>
                              <a
                                 href="${initParam.root}auction_board_delete.ymv?boardNo=${requestScope.AuctionBoard.boardNo }">
                              <img id="deleteBtn" src="${initParam.root}img/delete_btn.jpg">
                              </a>
                           </c:when>
				</c:choose>
                         </td>
                  </tr>
            </table>
           
         </div>
      </div>     
      <br>
   </div>
   <input type="hidden" name="boardNo" value="${requestScope.AuctionBoard.boardNo}">
   
</form>