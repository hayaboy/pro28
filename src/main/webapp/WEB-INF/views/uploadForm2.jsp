<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script >

var cnt=1;
function fn_addFile(){
	/* alert("hi"); */
	
	$("#div_file").append("<br>"   +" <input type='file' name='file"+ cnt  + "'  />");
	cnt++;
	
}

</script>

</head>
<body>
 이것은 썸네일로 업로드하는  폼이여 


<form method="post", action="${contextPath}/upload2",  enctype="multipart/form-data">



아이디:   <input type="text" name="id"><br>
이름:     <input type="text" name="name"><br>
<input type="button"  value="파일추가" onClick="fn_addFile()"/><br>



<div id="div_file">
</div>

<input type="submit"  value="업로드"/>
</form>



</body>
</html>