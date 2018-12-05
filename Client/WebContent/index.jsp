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
		<input type="submit" value="Get All Bookings" style="height:30px;width:200px"/>
	</form>
	<form action= "ClientServlet" method="get">
		<input type="submit" value="Get All Vehicles" style="height:30px;width:200px"/>
	</form>
	<form action= "ClientServlet" method="get">
		<input type="submit" value="Get All Customers" style="height:30px;width:200px"/>
	</form>
	
	<br/>
	
	<form action= "ClientServlet" method="post">
		<br/> First Name <br/>
		<input type="text" name="firstName" style="height:30px;width:200px"/>
		<br/> Last Name <br/>
		<input type="text" name="lastName" style="height:30px;width:200px"/>
		<br/> Hire Date <br/>
		<input type="date" name="startDate" style="height:30px;width:200px"/>
		<br/> Return Date <br/>
		<input type="date" name="endDate" style="height:30px;width:200px"/>
		<br/><br/>
		<input type="submit" value="Make a Booking" style="height:30px;width:200px"/>
	</form>
	
</body>
</html>