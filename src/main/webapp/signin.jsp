<%@ page import="com.codegnan.javawebapp24022026.entity.Employee" %>
<%@ page import="com.codegnan.javawebapp24022026.service.EmployeeService" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	EmployeeService employeeService =  EmployeeService.getInstance();
%>

<jsp:useBean class="com.codegnan.javawebapp24022026.entity.Employee" id="employee" scope="session"/>
<jsp:setProperty name="employee" property="emailAddress" param="emadd"/>
<jsp:setProperty name="employee" property="loginPassword" param="pass"/>

<% 
	boolean signInStatus = employeeService.signInEmployee(employee);

	if (signInStatus) {			
%>
		<h2>
			<font color="green">
				Welcome <jsp:getProperty name="employee" property="firstName"/> <jsp:getProperty name="employee" property="lastName"/>
			</font>
		</h2>
		
		<a href="change-password-process.html">Update Password</a><br/>
		<a href="change-emailid-process.html">Update Email ID</a>
<%
	} else {
%>
		<h2>
			<font color="red">
				Invalid Access
			</font>
		</h2>
			
		<a href="signin.html">Try Again</a>
<%			
	}
%>
</body>
</html>
			
			

