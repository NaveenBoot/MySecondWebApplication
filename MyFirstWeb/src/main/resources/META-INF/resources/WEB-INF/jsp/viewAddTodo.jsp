
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- to use jstl tage we need to import this -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">  <!-- to use css file we can use link tag with these attributes -->
<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
<title>Add Todo</title>
</head>
<body>
 <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1" >
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
   <div>Welcome to Add Todo ${MyName}</div>
		<hr>
		<%-- <form method="post">
		 Course:<input type="text" name="course" required = "required"/>
		 <input type="submit" class="btn btn-success">
		</form> --%>
		<form:form method="post" modelAttribute="todo">    <!-- to tie this to todo bean in addingNewTodo method(Todo COntroller) we need to use a Attribute called ModelAttribute -->
		              <fieldset class="mb-3">
		                <form:label path="course">Course:</form:label>
		                <form:input type="text" path="course" required = "required"/>    <%--  to map course to course in Todo.java we need to use <form:input> tag and path attribute in side tag like this line --%>
		                <form:errors path="course"></form:errors>
		             </fieldset>
		             <fieldset class="mb-3">
		               <form:label path="period">Period:</form:label>
		               <form:input type="text" path="period" required = "required"/> 
		               <form:errors path="period"></form:errors> 
		             </fieldset>
		           <form:input type="hidden" path="id" />
		           <form:input type="hidden" path="username"/>
		           <form:input type="hidden" path="period"/>
		           <form:input type="hidden" path="status"/>
		   <input type="submit" class="btn btn-success">
		</form:form>
		
	</div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script> <!-- to make our html page dynamic we can use javascript and we need to configure a js file like this -->
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
  <script type="text/javascript">
        $('#period').datepicker({
	       format: 'yyyy-mm-dd'
	     });
  </script>
 </body>
 </html>
