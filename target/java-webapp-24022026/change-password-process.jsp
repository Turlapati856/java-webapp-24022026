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
<jsp:setProperty name="employee" property="loginPassword" param="newpass"/>

<% 
	boolean passwordChangeStatus = employeeService.changeEmployeeLoginPassword(employee.getId(), employee.getLoginPassword());

	if (passwordChangeStatus) {
		session.invalidate();
%>
		<h2>
			<font color="green">
				Password successfully updated.
			</font>
		</h2>
		
		<a href="signin.html">Sign In Again</a>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error updating password. Please try again later.
			</font>
		</h2>
			
		<a href="signin.html">Try Again</a>
<%			
	}
%>
</body>
</html>