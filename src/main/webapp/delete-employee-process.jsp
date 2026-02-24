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

<% 
	int employeeId = Integer.parseInt(request.getParameter("empid"));

	boolean employeeDeleteStatus = employeeService.removeEmployeeByEmployeeId(employeeId);

	if (employeeDeleteStatus) {
%>
		<h2>
			<font color="green">
				Employee successfully deleted.
			</font>
		</h2>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error deleting employee. Please try again later.
			</font>
		</h2>
<%			
	}
%>
</body>
</html>
