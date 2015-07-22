<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${initParam.root}resources/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="review_board.ymv";
			}else{
				return;
			}
		});
	});
</script>

<div class="col-md-6 col-md-offset-3">
<h3>봉사 후기 수정</h3>
		<form method=post action="review_board_update.ymv" class="form-horizontal">
			<table class="table table-hover">
				<tr>
					<td><b> 글번호 <input type=text name=boardNo
							value="${requestScope.rvo.boardNo }" readonly="readonly"></input> 
						&nbsp;&nbsp;&nbsp;	| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							작성자 <input type=text name=writer
							value="${requestScope.rvo.writer }" readonly="readonly"></input>
					</b></td>
				</tr>

				<tr>
					<td>제목: <input type=text name=title
						value="${requestScope.rvo.title }" size="68"></input>
					</td>
				</tr>
				<tr>
					<td><textarea rows="15" cols="75" name="content">${requestScope.rvo.content }</textarea>
					</td>
				</tr>
				<tr>
					<td valign="middle" align="right"><input type="submit" value="수정하기" class="btn btn-default btn-xs"></input>
						<input type="button" id="updateCancel" value="취소하기" class="btn btn-default btn-xs"></input></td>
				</tr>
			</table>

		</form>
	</div>













