<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div style="margin:100px;">
<h2>Update Student</h2>
<form action="updateStudent" method="post">

	<input type="hidden" name="id" value="${student.id}">
	  <div class="form-group">
	    <label for="name">Student Name</label>
	    <input type="text" class="form-control" name="name" placeholder="Enter name" value="${student.name}">
	    <small class="form-text text-muted">We'll never share your email with anyone else.</small>
	  </div>
	  <div class="form-group">
	   <label for="email">Student Email</label>
	    <input type="email" class="form-control" name="email" placeholder="Enter email" value="${student.email}">
	  </div>
	  <div class="form-group">
	   <label for="phoneNumber">Student Phone Number</label>
	    <input type="text" class="form-control" name="phoneNumber" placeholder="Enter Phone Number" value="${student.phoneNumber}">
	  </div>
	  <div class="form-group">
	   <label for=birthDate">Student Date Of Birth</label>
	    <input type="date" class="form-control" name="birthDate" placeholder="Enter Birth Date" value="${student.birthDate}">
	  </div>
	  <div class="form-group">
	   <label for="education">Student education</label>
	    <input type="text" class="form-control" name="education" placeholder="Enter Student's education" value="${student.education}">
	  </div>
  <button type="submit" class="btn btn-primary">Update</button>
</form>
</div>
</body>
</html>
