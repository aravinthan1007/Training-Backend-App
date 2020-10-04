<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 
 <div class= "container">
 <br/><br/>

  <a href="<%=request.getContextPath()%>/Teachers?action=new" class="btn btn-outline-success">Add New Teacher</a>
		 <table class="table table-striped">
		  <thead class="thead-dark">
		    <tr> 
		      <th>TeacherId</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Email Address</th>
		      <th>Phone Number</th>
		      <th> Action</th>
		    </tr>
		  </thead>
		    <c:forEach var="teacher" items="${teacherList}">
		            <tr>
			            <td>
			               <c:out value="${teacher.id}"></c:out>
			            </td>
			            <td>
			              <c:out value="${teacher.firstName}"></c:out>
			            </td>
			            <td>
			              <c:out value="${teacher.lastName}"></c:out>
			            </td>
			             <td>
			              <c:out value="${teacher.emailAddress}"></c:out>
			            </td>
			             <td>
			              <c:out value="${teacher.phoneNumber}"></c:out>
			            </td>
			            
			            <td>
			            <a href="<%=request.getContextPath()%>/Teachers?action=edit&id=<c:out value="${teacher.id}"></c:out>" class="btn btn-outline-primary">Edit</a>
			            <a href="<%=request.getContextPath()%>/Teachers?action=delete&id=<c:out value="${teacher.id}"></c:out>" class="btn btn-outline-danger">Delete</a>
			            </td>
		            
		            </tr>    
		    </c:forEach>
		
		  <tbody></tbody>
		 </table>
		 <h4><p style="color:red";><c:out value="${teacherErrorMessage}"></c:out> </p></h4>
 </div>
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>