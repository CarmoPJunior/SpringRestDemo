<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Book List</title>
	</head>
	
	<body>
	
		<h1>Book List</h1>  
		
		<form method="get" action="search">
	        <input type="text" name="keyword" /> &nbsp;
	        <input type="submit" value="Search" />
	    </form>
		
		<table border="2" width="70%" cellpadding="2">  
		
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author</th>				
				<th>Edit</th>
				<th>Delete</th>
			</tr>  
		   	<c:forEach var="book" items="${bookList}">   
		   		<tr>  
				   <td>${book.id}</td>  
				   <td>${book.title}</td>  
				   <td>${book.author}</td> 
				   <td><a href="editBook?id=${book.id}">Edit</a></td>  
				   <td><a href="deleteBook?id=${book.id}">Delete</a></td>  
		   		</tr>  
		   </c:forEach>  
	   	</table>  
	   	
   		<br/>  
   		
   		<a href="newBook">Add New Book</a>  
   		
	</body>
</html>