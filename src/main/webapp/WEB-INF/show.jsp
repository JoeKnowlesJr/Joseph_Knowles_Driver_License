<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${person.toString()}</title>
	</head>
	<body>
		<h1>${person.toString()}</h1>
		<c:set var='l' value='${person.getLicense()}'></c:set>
		<table>
			<tbody>
				<tr>
					<td>License Number</td>
					<td>${l.getNumber()}</td>
				</tr>
				<tr>
					<td>State</td>
					<td>${l.getState()}</td>
				</tr>
				<tr>
					<td>Expiration Date</td>
					<td>${l.getExpirationDate()}</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>