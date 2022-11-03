package com.availability.employeeStatus.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.availability.employeeStatus.EmployeeRepository.EmployeeRepository;
import com.availability.employeeStatus.model.employeeStatus;
import com.availibility.employeeStatus.service.EmployeeService;




@Service
public class EmployeeServiceimpl implements EmployeeService {
	private EmployeeRepository employeeRepositoryA;
	
	

	public EmployeeServiceimpl(EmployeeRepository employeeRepositoryA) {
		super();
		this.employeeRepositoryA = employeeRepositoryA;
	}

	@Override
	public employeeStatus saveEmployeeS(employeeStatus employee) {
		employee.setStatus(true);
		return employeeRepositoryA.save(employee);
	}

	@Override
	public void updateEmployeeName(employeeStatus employee, String name) {
       employeeStatus existingemployee= employeeRepositoryA.findByName(name);
		
		existingemployee.setName(employee.getName());
		employeeRepositoryA.save(existingemployee);
		}
      

	@Override
	public void deleteEmployeeS(String name) {
		employeeStatus emp=employeeRepositoryA.findByName(name);
		if(emp.isStatus()) {
		emp.setStatus(false);
		employeeRepositoryA.save(emp);
		}		
	}

	@Override
	public List<employeeStatus> getAllEmployeesStatus() {
		return employeeRepositoryA.findAll();
	
	}
	
	 public employeeStatus findByNameMethod(String name){
			return employeeRepositoryA.findByName(name);
			
	}
	 
	 public boolean checkStatus(String name) {
		 employeeStatus emp=employeeRepositoryA.findByName(name);
		 if(emp.isStatus()) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }

}


