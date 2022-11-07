package com.availibility.employeeStatus.service;

import java.util.List;


import com.availability.employeeStatus.model.employeeStatus;

public interface EmployeeService {
	employeeStatus saveEmployee(employeeStatus employee);
	
	String updateEmployeeName(employeeStatus employee,String name);
	
	String deleteEmployeeS(String name);
	
	List<employeeStatus> getAllEmployeesStatus();
	
	employeeStatus findByNameMethod(String name);
	
	boolean checkStatus(String name);
	

}
