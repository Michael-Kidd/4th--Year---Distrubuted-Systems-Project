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

		<title>Booking List</title>
	</head>

	<body>
	
	<h3>List of All Bookings</h3>
	<table>
	   <tr>
       	<td style="height:30px;width:30px">REG</td>
       	<td style="height:30px;width:30px">MAKE</td>
       	<td style="height:30px;width:30px">MODEL</td>
       	<td style="height:30px;width:30px">CUSTOMER</td>
       	<td style="height:30px;width:30px">CUSTOMER ADDRESS</td>
       </tr>
	    <c:forEach items="${bookings}" var="booking">
	        <tr>
	        	<td style="height:30px;width:200px">${booking.v.reg}</td>
	        	<td style="height:30px;width:200px">${booking.v.make}</td>
	        	<td style="height:30px;width:200px">${booking.v.model}</td>
	        	<td style="height:30px;width:200px">${booking.c.name}</td>
	        	<td style="height:30px;width:200px">${booking.c.address}</td>
	        	
	        	<td style="height:30px;width:30px">
	        		<form action= "Bookings" method="post">
						<input type="submit" name="updateButton" value="Update"/>
					</form>
	        	</td>
	        	<td style="height:30px;width:30px">
	        		<form action= "Bookings" method="post">
						<input type="submit" name="delButton" value="Delete"/>
					</form>
	        	</td>
	        	
	        </tr>
	    </c:forEach>
	</table>
	<form action= "index.jsp">
		<input type="submit" value="Back" style="height:30px;width:200px"/>
	</form>
	</body>
		
	<SCRIPT>
        function update()
        {
        	window.alert("Updated");
        } 
        
        function del()
        {
        	window.alert("Deleted");
        } 
    </SCRIPT>
	
</html>