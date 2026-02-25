<%@ page import="com.codegnan.javawebapp24022026.entity.Employee" %>
<%@ page import="com.codegnan.javawebapp24022026.service.EmployeeService" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	EmployeeService employeeService = EmployeeService.getInstance();
%>

<jsp:useBean class="com.codegnan.javawebapp24022026.entity.Employee" id="employee" scope="session"/>
<jsp:setProperty name="employee" property="emailAddress" param="newemail"/>

<% 
	boolean emailidChangeStatus = employeeService.changeEmployeeEmailId(employee.getId(), employee.getEmailAddress());

	if (emailidChangeStatus) {
		session.invalidate();
%>
		<h2>
			<font color="green">
				Email ID successfully updated.
			</font>
		</h2>
		
		<a href="signin.html">Sign In Again</a>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error updating Email ID. Please try again later.
			</font>
		</h2>
			
		<a href="signin.html">Try Again</a>
<%			
	}
%>
</body>
</html>