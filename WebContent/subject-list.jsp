<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 
 <div class= "container">
 <br/><br/>

  <a href="<%=request.getContextPath()%>/Subjects?action=new" class="btn btn-outline-success">Add New Subject</a>
		 <table class="table table-striped">
		  <thead class="thead-dark">
		    <tr> 
		      <th>Subject Id</th>
		      <th>Subject Name</th>
		      <th> Action</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="subject" items="${subjectList}">
		            <tr>
			            <td>
			               <c:out value="${subject.id}"></c:out>
			            </td>
			            <td>
			              <c:out value="${subject.name}"></c:out>
			            </td>
			            <td>
			            <a href="<%=request.getContextPath()%>/Subjects?action=edit&id=<c:out value="${subject.id}"></c:out>" class="btn btn-outline-primary">Edit</a>
			            <a href="<%=request.getContextPath()%>/Subjects?action=delete&id=<c:out value="${subject.id}"></c:out>" class="btn btn-outline-danger">Delete</a>
			            </td>
		            
		            </tr>    
		    </c:forEach>		      
		  </tbody>
		 </table>
 </div>
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>