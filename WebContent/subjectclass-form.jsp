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
     <form action="<%=request.getContextPath() %>/SubjectAllocation">          
          <c:if test="${subjectclass==null}">
                 <h2>Add Subject Allocation</h2>
                 <input type="hidden" name="action" value="insert">
          </c:if>
          <c:if test="${subjectclass!=null}">
                <h2>Update Subject Allocation</h2>
                 <input type="hidden" name="action" value="update">
                 <input type="hidden" name="id" value='<c:out value="${subjectclass.id}"></c:out>'>
          </c:if>          
            <div class="form-group">
    		  <select name="sclass" class="form-control">
			    <c:forEach items="${sclassList}" var="sclass">
			        <option value="${sclass.id}" ${sclass.id == subjectclass.sclass.id ? 'selected="selected"' : ''}>${sclass.name}</option>
			    </c:forEach>
            </select>
            </div>
           <div class="form-group">
    		  <select name="subject" class="form-control">
			    <c:forEach items="${subjectList}" var="subject">
			        <option value="${subject.id}" ${subject.id == subjectclass.subject.id ? 'selected="selected"' : ''}>${subject.name}</option>
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