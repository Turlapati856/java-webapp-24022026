<%@ page import="com.codegnan.javawebapp24022026.entity.Employee" %>
<%@ page import="com.codegnan.javawebapp24022026.service.EmployeeService" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	EmployeeService employeeService = new EmployeeService();
%>

<jsp:useBean class="com.codegnan.javawebapp24022026.entity.Employee" id="employee"/>
<jsp:setProperty name="employee" property="id" param="empid"/>
<jsp:setProperty name="employee" property="firstName" param="fname"/>
<jsp:setProperty name="employee" property="lastName" param="lname"/>
<jsp:setProperty name="employee" property="dateOfJoining" param="doj"/>
<jsp:setProperty name="employee" property="emailAddress" param="emadd"/>
<jsp:setProperty name="employee" property="loginPassword" param="pass"/>

<% 
	boolean signUpStatus = employeeService.signUpEmployee(employee);

	if (signUpStatus) {			
%>
		<h2>
			<font color="green">
				Sign Up Successful.
			</font>
		</h2>
<%
	} else {
%>
		<h2>
			<font color="red">
				Problem occurred during sign up. Please try again after sometime.
			</font>
		</h2>
<%			
	}
%>
</body>
</html>