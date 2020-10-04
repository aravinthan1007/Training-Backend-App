<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClassReportForm</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<br />
	<br />
	<div class="container">
	   <br/>
	   <h2> <c:out value="${sclass.name}"></c:out> Report </h2>
	   <br/>
	   <br/>
		<h3>Subjects & Teachers</h3>
		<table class="table table-striped">
			<thead class="thead-dark">

				<tr>
					<th>SubjectId</th>
					<th>SubjectName</th>
					<th>TeacherId</th>
					<th>TeacherName</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subjectClassSet}" var="subjectClass">
					<tr>
						<td><c:out value="${subjectClass.subject.id}"></c:out></td>
						<td><c:out value="${subjectClass.subject.name}"></c:out></td>
						<td><c:out value="${subjectClass.teacher.id}"></c:out></td>
						<td>
						   <c:out value="${subjectClass.teacher.firstName}"></c:out>
						   <c:out value="${subjectClass.teacher.lastName}"></c:out>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        <br />
	    <br />		
		<h3>Students</h3>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>StudentId</th>
					<th>StudentName</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${studentSet}" var="student">
					<tr>
						<td><c:out value="${student.id}"></c:out></td>
						<td>
						   <c:out value="${student.firstName}"></c:out>
						   <c:out value="${student.lastName}"></c:out>
						
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>