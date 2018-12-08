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
	<h3>List of All Customers</h3>
	<table>
	    <c:forEach items="${customers}" var="customer">
	        <tr>
	        	<td style="height:30px;width:200px">${customer.name}</td>
	        </tr>
	    </c:forEach>
	</table>
	
	</body>
</html>