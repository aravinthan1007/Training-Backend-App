<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Student Allocation Form </title>
	</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
  <div class= "container">
     <br/><br/>
               
                   
          <h2>Update Student Allocation</h2>
                    
           <form action="<%=request.getContextPath()%>/StudentAllocation" method="get">
               <input type="hidden" name="action" value="update">                
	           <div class="form-group">
			      <label for="id">First Name</label>
			      <input type="text" class="form-control" name ="id" value='<c:out value="${student.id}"></c:out>' readonly>
			   </div>
	           <div class="form-group">
			    <label for="firstname">First Name</label>
			    <input type="text" class="form-control" name ="firstname" value='<c:out value="${student.firstName}"></c:out>' readonly>
			  </div>
			  <div class="form-group">
			    <label for="lastname">Last Name</label>
			    <input type="text" class="form-control" name ="lastname" value='<c:out value="${student.lastName}"></c:out>' readonly>
			  </div>
			  <div class="form-group">
	    		  <select name="sclassid" class="form-control">
				    <c:forEach items="${sclassList}" var="sclass">
				        <option value="${sclass.id}" ${sclass.id == student.sclass.id ? 'selected="selected"' : ''}>${sclass.name}</option>
				    </c:forEach>
	            </select>
	            </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>

</body>
</html>