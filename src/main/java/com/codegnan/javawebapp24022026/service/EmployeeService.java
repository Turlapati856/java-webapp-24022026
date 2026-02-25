package com.codegnan.javawebapp24022026.service;

import java.util.ArrayList;

import com.codegnan.javawebapp24022026.dao.EmployeeDao;
import com.codegnan.javawebapp24022026.entity.Employee;

public class EmployeeService {
	EmployeeDao employeeDao = EmployeeDao.getInstance();
	
	private static EmployeeService employeeService;
	
	private EmployeeService() {
		System.out.println("EmployeeService()");
		}
	public static EmployeeService getInstance() {
		if(employeeService == null) {
			employeeService = new EmployeeService();
		}
		return employeeService;
	}
	
	public boolean signUpEmployee(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}
	
	public boolean signInEmployee(Employee employee) {
		return employeeDao.searchEmployeeByEmailAndPassword(employee);
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return employeeDao.selectAllEmployees();
	}
	
	public boolean removeEmployeeByEmployeeId(int employeeId) {
		return employeeDao.deleteEmployeeByEmployeeId(employeeId);
	}
	
	public boolean changeEmployeeLoginPassword(int employeeId, String newPassword) {
		return employeeDao.updateEmployeeLoginPassword(employeeId, newPassword);
	}
	
	public boolean changeEmployeeEmailId(int employeeId, String newEmailId) {
		return employeeDao.updateEmployeeEmailId(employeeId, newEmailId);
	}
}
