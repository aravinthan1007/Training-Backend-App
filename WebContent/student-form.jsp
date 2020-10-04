<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Student</title>
	</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
  <div class= "container">
     <br/><br/>
     <form action="<%=request.getContextPath() %>/Students">          
          <c:if test="${student==null}">
                 <h2>Add Student</h2>
                 <input type="hidden" name="action" value="insert">
          </c:if>
          <c:if test="${student!=null}">
                <h2>Update Student</h2>
                 <input type="hidden" name="action" value="update">
                 <input type="hidden" name="id" value='<c:out value="${student.id}"></c:out>'>
          </c:if>          

           <div class="form-group">
		    <label for="fristname">First Name</label>
		    <input type="text" class="form-control" name ="firstname" value='<c:out value="${student.firstName}"></c:out>' required>
		  </div>
		             <div class="form-group">
		    <label for="lastname">Last Name</label>
		    <input type="text" class="form-control" name ="lastname" value='<c:out value="${student.lastName}"></c:out>' required>
		  </div>
		             <div class="form-group">
		    <label for="emailaddress">Email Address</label>
		    <input type="email" class="form-control" name ="emailaddress" value='<c:out value="${student.emailAddress}"></c:out>'>
		  </div>
		  <div class="form-group">
		    <label for="phonenumber">Phone Number</label>
		    <input type="text" class="form-control" name ="phonenumber" value='<c:out value="${student.phoneNumber}"></c:out>'>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>