<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
	<h2>Create new registration</h2>
	<form action="updateReg" method="post">
		<pre>
		     <input type="hidden" name="id" value="${dto.id}"/>
	         Name <input type="text" name="name" value="${dto.name}"/>
	         Email <input type="text" name="email" value="${dto.email}"/>
	         Mobile <input type="text" name="mobile" value="${dto.mobile}"/>
	         Course <input type="text" name="course" value="${dto.course}"/>
	         <input type="submit" value="update"/>
	   </pre>
	</form>
    ${msg}
</body>
</html>