<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<link rel="stylesheet" href="../style.css" type="text/css"> 
</head> 

<body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0"> 
<div id=print_sheet class="col-md-12" style="text-align: center"> 
</div> 

<script type="text/javascript">
  print_sheet.innerHTML = opener.document.getElementById("print_table").innerHTML; 
  window.print(); 
</script> 

</body> 
</html> 