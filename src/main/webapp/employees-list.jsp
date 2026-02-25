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
	EmployeeService employeeService = EmployeeService.getInstance();
%>

	<table border="1" width="100%">
		<tr>
			<th>Employee Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Date Of Joining</th>
			<th>Email Address</th>
			<th>Password</th>
		</tr>
<%
	ArrayList<Employee> employeesList = employeeService.getAllEmployees();
	
	for (Employee employee : employeesList) {
%>
		<tr>
			<td><%= employee.getId() %></td>
			<td><%= employee.getFirstName() %></td>
			<td><%= employee.getLastName() %></td>
			<td><%= employee.getDateOfJoining() %></td>
			<td><%= employee.getEmailAddress() %></td>
			<td><%= employee.getLoginPassword() %></td>
			<td><a href="delete-employee-process.jsp?empid=<%= employee.getId() %>">Delete</a></td>
		</tr>
<%
		}
%>
	</table>
</body>
</html>