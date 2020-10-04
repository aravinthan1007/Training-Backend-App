<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClassReportForm</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>

<br/> <br/>
 <div class="container">
 
 <form action="<%=request.getContextPath() %>/ClassReport">          
                
              <input type="hidden" name="action" value="createreport">
           <div class="form-group">
	    		  <select name="sclassid" class="form-control">
				    <c:forEach items="${sclassList}" var="sclass">
				        <option value="${sclass.id}" >${sclass.name}</option>
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