<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>This is a test page~!!</p>

	<form action="weblist/add" method="post">
		<table>
			<tr>
				<td colspan="2" align="center">*** Add Data Form ***</td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>Tel</th>
				<td><input type="text" name="tel" /></td>
			</tr>
			<tr>
				<th>Addr</th>
				<td><input type="text" name="addr" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form>
	
	<c:if test="${not empty list}">
		<ul>
			<c:forEach var="listValue" items="${list}">
				<li>${listValue.name}</li>
				<li>${listValue.tel}</li>
				<li>${listValue.addr}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<c:if test="${not empty list2}">
		<ul>
			<c:forEach var="listValue" items="${list2}">
				<li>${listValue.name}</li>
				<li>${listValue.color}</li>
				<li>${listValue.size}</li>
			</c:forEach>
		</ul>
	</c:if>
		
</body>
</html>