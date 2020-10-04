<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
 
 <div class= "container">
 <br/><br/>

  <a href="<%=request.getContextPath()%>/Classes?action=new" class="btn btn-outline-success">Add New Class</a>
		 <table class="table table-striped">
		  <thead class="thead-dark">
		    <tr> 
		      <th>Class Id</th>
		      <th>Class Name</th>
		      <th> Action</th>
		    </tr>
		  <tbody>
		    <c:forEach var="Sclass" items="${sclassList}">
		            <tr>
			            <td>
			               <c:out value="${Sclass.id}"></c:out>
			            </td>
			            <td>
			              <c:out value="${Sclass.name}"></c:out>
			            </td>
			            <td>
			            <a href="<%=request.getContextPath()%>/Classes?action=edit&id=<c:out value="${sclass.id}"></c:out>" class="btn btn-outline-primary">Edit</a>
			            <a href="<%=request.getContextPath()%>/Classes?action=delete&id=<c:out value="${sclass.id}"></c:out>" class="btn btn-outline-danger">Delete</a>
			            </td>
		            
		            </tr>    
		    </c:forEach>		    
		  </tbody>		  
		 </table>
		 <h5><p style="color:red;" ><c:out value="${CouldnotDeleteClass}"></c:out></p></h5>
 </div>
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>