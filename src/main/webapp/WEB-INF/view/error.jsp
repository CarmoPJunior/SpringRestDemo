<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Error Occurred</title>
	</head>
	
	<body>
		<h1>Error Occurred!</h1>    
	    <b>[<span ${status}>status</span>]
	        <span ${error}>error</span>
	    </b>
	    <p ${message}>message</p>
	</body>
	
</html>

