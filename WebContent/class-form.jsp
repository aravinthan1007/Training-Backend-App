<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<title>Add Subject</title>
	</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
  <div class= "container">
     <br/><br/>
     <form action="<%=request.getContextPath() %>/Classes">          
          <c:if test="${sclass==null}">
                 <h2>Add Class</h2>
                 <input type="hidden" name="action" value="insert">
          </c:if>
          <c:if test="${sclass!=null}">
                <h2>Update Class</h2>
                 <input type="hidden" name="action" value="update">
                 <input type="hidden" name="id" value='<c:out value="${sclass.id}"></c:out>'>
          </c:if>          

           <div class="form-group">
		    <label for="sclassname">Class Name</label>
		    <input type="text" class="form-control" name ="sclassname" value='<c:out value="${sclass.name}"></c:out>' required>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>
  
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  

</body>
</html>