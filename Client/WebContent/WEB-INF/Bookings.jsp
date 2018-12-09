<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		
		<style>
		table {
			  border-collapse: collapse;
			  width: 100%;
			}
			
			th, td {
			  text-align: left;
			  padding: 8px;
			}
			
			tr:nth-child(even) {background-color: #f2f2f2;}
		</style>

		<title>Customer List</title>
	</head>

	<body>
	
	<h3>List of All Bookings</h3>
	<table>
	   <tr>
       	<td style="height:30px;width:30px">ID</td>
       	<td style="height:30px;width:30px">REG</td>
       	<td style="height:30px;width:30px">MAKE</td>
       	<td style="height:30px;width:30px">MODEL</td>
       	<td style="height:30px;width:30px">CUSTOMER</td>
       	<td style="height:30px;width:30px">CUSTOMER ADDRESS</td>
       </tr>
	    <c:forEach items="${bookings}" var="booking">
	        <tr>
	        	<td style="height:30px;width:200px">${booking.id}</td>
	        	<td style="height:30px;width:200px">${booking.vehicle.reg}</td>
	        	<td style="height:30px;width:200px">${booking.vehicle.make}</td>
	        	<td style="height:30px;width:200px">${booking.vehicle.model}</td>
	        	<td style="height:30px;width:200px">${booking.customer.name}</td>
	        	<td style="height:30px;width:200px">${booking.customer.address}</td>
	        </tr>
	    </c:forEach>
	</table>
	
	</body>
</html>