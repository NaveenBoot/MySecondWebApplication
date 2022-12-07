
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- to use jstl tage we need to import this -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">  <!-- to use css file we can use link tag with these attributes -->
<title>TODO List</title>
</head>
<body>
     <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	   <a class="navbar-brand m-1" >Naveen</a>
	     <div class="collapse navbar-collapse">
		    <ul class="navbar-nav">
			  <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			  <li class="nav-item"><a class="nav-link" href="/todo-list">Todos</a></li>
		    </ul>
	    </div>
	   <ul class="navbar-nav">
		  <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	  </ul>	
   </nav>
 <div class="container">
   <div>Welcome to TodoList ${MyName}</div>
		<hr>
		<h2>Your Todos</h2>
		<table class="table">
			<thead>
				<tr>
					
					<th>UserName</th>
					<th>Course</th>
					<th>Period</th>
					<th>Status</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						
						<td>${todo.username}</td>
						<td>${todo.course}</td>
						<td>${todo.period}</td>
						<td>${todo.status}</td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script> <!-- to make our html page dynamic we can use javascript and we need to configure a js file like this -->
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
 </body>
 </html>
