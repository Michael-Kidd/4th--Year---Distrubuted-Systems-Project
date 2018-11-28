<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Booking Service</title>
</head>

<body>
	<form action= "ClientServlet" method="get">
		<input type="submit" value="Get All Bookings"/>
	</form><form action= "ClientServlet" method="get">
		<input type="submit" value="Get All Vehicles"/>
	</form>
	<form action= "ClientServlet" method="get">
		<input type="submit" value="Get All Customers"/>
	</form>
	<br/>
	<form action= "ClientServlet" method="post">
		<br/> Name <br/>
		<input type="text" name="customerName"/>
		<br/> Hire Date <br/>
		<input type="date" name="startDate"/>
		<br/> Return Date  <br/>
		<input type="date" name="endDate"/>
		<br/>
		<input type="submit" value="Make a Booking"/>
	</form>
</body>
</html>