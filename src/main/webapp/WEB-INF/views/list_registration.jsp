<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
	<table>
		<tr>
			<th>name</th>
			<th>email</th>
			<th>mobile</th>
			<th>course</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.mobile}</td>
				<td>${student.course}</td>
				<td><a href="deleteReg?id=${student.id}">delete</a></td>
				<td><a href="studentByIdReg?id=${student.id}">update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>