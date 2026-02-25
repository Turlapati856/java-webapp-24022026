package com.codegnan.javawebapp24022026.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.codegnan.javawebapp24022026.entity.Employee;

public class EmployeeDao {
	private static EmployeeDao employeeDao;
	
	private EmployeeDao() {
		System.out.println("EmployeeDao()");
	}
	
	public static EmployeeDao getInstance() {
		if(employeeDao == null) {
			employeeDao = new EmployeeDao();
		}
		return employeeDao;
	}
	public boolean insertEmployee(Employee employee) {
		boolean isInsertSuccessful = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "INSERT INTO employees VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getDateOfJoining());
			preparedStatement.setString(5, employee.getEmailAddress());
			preparedStatement.setString(6, employee.getLoginPassword());

			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isInsertSuccessful = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isInsertSuccessful;
	}
	
	public boolean searchEmployeeByEmailAndPassword(Employee employee) {
		boolean isEmployeeFound = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "SELECT * FROM employees WHERE email_address=? AND login_password=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, employee.getEmailAddress());
			preparedStatement.setString(2, employee.getLoginPassword());

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isEmployeeFound = true;
				
				employee.setId(resultSet.getInt(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setDateOfJoining(resultSet.getString(4));
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeFound;
	}
	
	public ArrayList<Employee> selectAllEmployees() {
		ArrayList<Employee> employeesList = new ArrayList<Employee>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "SELECT * FROM employees";
			preparedStatement = connection.prepareStatement(sqlQuery);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setDateOfJoining(resultSet.getString(4));
				employee.setEmailAddress(resultSet.getString(5));
				employee.setLoginPassword(resultSet.getString(6));
				
				employeesList.add(employee);
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		
		return employeesList;
	}
	
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		boolean isEmployeeDeleted = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "DELETE FROM employees WHERE empid=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(1, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeDeleted = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeDeleted;
	}
	
	public boolean updateEmployeeLoginPassword(int employeeId, String newPassword) {
		boolean isEmployeeLoginPasswordUpdated = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "UPDATE employees SET login_password=? WHERE empid=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeLoginPasswordUpdated = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeLoginPasswordUpdated;
	}
	
	public boolean updateEmployeeEmailId(int employeeId, String newEmailId) {
		boolean isEmployeeEmailIdUpdated = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "Root");
			String sqlQuery = "UPDATE employees SET email_address=? WHERE empid=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, newEmailId);
			preparedStatement.setInt(2, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeEmailIdUpdated = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeEmailIdUpdated;
	}
}