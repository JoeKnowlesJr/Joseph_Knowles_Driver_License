<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='index.css'>
		<meta charset="ISO-8859-1">
		<title>Driver's License</title>
	</head>
	<body>
		<form>
			<button class='btn' formaction='/addPerson'>Add Person</button>
			<button class='btn' formaction='/addLicense'>Add License</button>
		</form>

		<form method='post'>
			<table>
				<thead>
					<tr>
						<td>First</td>
						<td>Last</td>
						<td>|</td>
						<td>Number</td>
						<td>Expiration Date</td>
						<td>State</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${persons}" var="p">
					<c:set var="l" value="${p.getLicense()}"></c:set>
					
						<tr>
							<td colspan='2'><button class='list_btn' formaction='/show/${p.getId()}'>${p.toString()}</button></td>
							<td>|</td>
							<td>${l.getNumber()}</td>
							<td>${l.getExpirationDate()}</td>
							<td>${l.getState()}</td>						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</body>
</html>