<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
	<div style="margin:100px;">
	<button class="btn btn-primary"><a href="getStudent?id=0" style="color:white;">Add Student</a></button>
	    <h1>Students List</h1>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Phone Number</th>
		      <th scope="col">Birth Date</th>
		      <th scope="col">Education</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${studentList}" var="student">
		    <tr>
		      <td>${student.id}</td>
		      <td>${student.name}</td>
		      <td>${student.email}</td>
		      <td>${student.phoneNumber}</td>
		      <td>${student.birthDate}</td>
		      <td>${student.education}</td>
		      <td><a href="deleteStudent?id=${student.id}">Delete</a>
		      <a href="getStudent?id=${student.id}">Update</a></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
	</body>
</html>
