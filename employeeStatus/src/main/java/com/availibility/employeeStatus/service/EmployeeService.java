package com.availibility.employeeStatus.service;

import java.util.List;


import com.availability.employeeStatus.model.employeeStatus;

public interface EmployeeService {
	employeeStatus saveEmployeeS(employeeStatus employee);
	
	void updateEmployeeName(employeeStatus employee,String name);
	
	void deleteEmployeeS(String name);
	
	List<employeeStatus> getAllEmployeesStatus();
	
	employeeStatus findByNameMethod(String name);
	
	boolean checkStatus(String name);
	

}
