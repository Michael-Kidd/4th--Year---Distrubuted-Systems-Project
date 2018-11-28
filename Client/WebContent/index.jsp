<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Booking Service</title>
</head>

<body>
	<form action= "ClientServlet" method="post">
		Name: <input type="text" name="username"/>
		Email: <input type="text" name="email"/>
		<input type="submit" value="get"/>
	</form>
</body>
</html>