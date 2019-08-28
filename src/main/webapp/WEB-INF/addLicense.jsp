<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add License</title>
	</head>
	<body>
		<h1>New License</h1>
		<form:form action="/lCreate" method="post" modelAttribute="license">
		    <input type="hidden" name="_method" value="put">
		    <p>
			    <form:select  path="personId">
			    <c:choose>
			    	<c:when test="${persons.size() < 2}">
			    		<form:option value="${persons}"></form:option>
			    	</c:when>
			    	<c:otherwise>
			    		<form:options items="${persons}"></form:options>	
			    	</c:otherwise>
			    </c:choose>
			    </form:select>
		    </p>
		    <p>
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
		    </p>
		    <p>
		        <form:label path="expirationDate">Expiration Date</form:label>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" path="expirationDate"/>
		    </p>
		    <input type="submit" value="Submit"/>		
		</form:form>
	</body>
</html>