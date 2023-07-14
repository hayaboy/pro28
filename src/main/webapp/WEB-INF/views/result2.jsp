<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ${map.id}
${map.name}
${map.fileList}

--%>


	썸네일 이미지 업로드 완료
	<br> 리퀘스트에서 넘어온 파라미터 id : ${map.id}
	<br> 리퀘스트에서 넘어온 파라미터 name : ${map.id}
	<br> 리퀘스트에서 넘어온 파라미터 파일 리스트 : ${map.fileList}
	<br>








	<a href="${pageContext.request.contextPath}/form2">썸네일로
		업로드하는 폼으로 가기</a>
	<br>
	<c:if test="${not empty map.fileList}">
		<c:forEach var="imageFileName" items="${map.fileList}">
			<img
				src="${pageContext.request.contextPath}/download2?imageFileName=${imageFileName}" />
			<a
				href="${pageContext.request.contextPath}/download2?imageFileName=${imageFileName}">내려받기
			</a>
			<br>

		</c:forEach>

	</c:if>




</body>
</html>