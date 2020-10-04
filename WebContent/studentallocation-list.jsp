<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Allocation</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 
 <div class= "container">
 <br/><br/><br/>

  		 <table class="table table-striped">
		  <thead class="thead-dark">
		    <tr> 
		      <th>Id</th>
		      <th>Student Name</th>		      
		      <th>Class Name</th>
		      <th>Action</th>
		    </tr>
		  </thead>
		    <c:forEach var="student" items="${studentList}">
		            <tr>                      
			            <td>
			               <c:out value="${student.id}"></c:out>
			            </td>
			            <td>
			              <c:out value="${student.firstName}"></c:out>
			              <c:out value="${student.lastName}"></c:out>
			            </td>
			            <td>
			              <c:out value="${student.sclass.name}"></c:out>
			            </td>			            
			            <td>
			              <a href="<%=request.getContextPath()%>/StudentAllocation?action=edit&id=<c:out value="${student.id}"></c:out>" class="btn btn-outline-primary">Edit</a>
			               <a href="<%=request.getContextPath()%>/StudentAllocation?action=delete&id=<c:out value="${student.id}"></c:out>" class="btn btn-outline-danger">delete</a>			            
			            </td>
		            
		            </tr>    
		    </c:forEach>
		
		  <tbody></tbody>
		 </table>
 </div>
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>