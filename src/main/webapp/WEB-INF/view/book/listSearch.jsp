<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Result</title>
	</head>
	<body>
		<div align="center">
		
		    <h2>Search Result</h2>
		    
		    <table border="1" cellpadding="5">
		    
		        <tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author</th>				
					<th>Edit</th>
					<th>Delete</th>
				</tr>  
				
		        <c:forEach items="${result}" var="book">
			        <tr>
			           <td>${book.id}</td>  
					   <td>${book.title}</td>  
					   <td>${book.author}</td> 
					   <td><a href="editBook?id=${book.id}">Edit</a></td>  
					   <td><a href="deleteBook?id=${book.id}">Delete</a></td>  
			        </tr>
		        </c:forEach>
		        
		    </table>
		    
		</div>   
		
	</body>
	
</html>