<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Subject Class Allocation</title>
	</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
  <div class= "container">
     <br/><br/>
     
     
                <h2>Update Teacher Allocation</h2>
           <form action="<%=request.getContextPath() %>/TeacherAllocation">
                 <input type="hidden" name="action" value="update">
                 <div class="form-group">
		            <label for="id">SubjectClassId</label>
		            <input type="text" class="form-control" name ="id" value='<c:out value="${subjectClass.id}"></c:out>' readonly>
		         </div>
		         <div class="form-group">
		            <label for="subject">Subject</label>
		            <input type="text" class="form-control" name ="subject" value='<c:out value="${subjectClass.getSubject().getName()}"></c:out>' readonly>
		         </div>
		         <div class="form-group">
		            <label for="id">Class</label>
		            <input type="text" class="form-control" name ="sclass" value='<c:out value="${subjectClass.getSclass().getName()}"></c:out>' readonly>
		         </div>               

           <div class="form-group">
    		  <select name="teacherid" class="form-control">
			     <c:forEach items="${teacherList}" var="teacher">
			        <option value="${teacher.id}" ${teacher.id == subjectClass.teacher.id ? 'selected="selected"' : ''} >${teacher.firstName} ${teacher.lastName}</option>
			    </c:forEach>
            </select>
            </div>
            
            
		  <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>
  
 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  

</body>
</html>