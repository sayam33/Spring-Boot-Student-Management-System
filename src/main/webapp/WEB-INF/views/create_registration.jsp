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
	<form action="createReg" method="post">
		<pre>
	         Name <input type="text" name="name"/>
	         Email <input type="text" name="email"/>
	         Mobile <input type="text" name="mobile"/>
	         Course <input type="text" name="course"/>
	         <input type="submit" value="save"/>
	   </pre>
	</form>
    ${msg}
</body>
</html>