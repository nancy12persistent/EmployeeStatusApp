package com.availability.employeeStatus.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.availability.employeeStatus.model.employeeStatus;

public interface EmployeeRepository extends JpaRepository<employeeStatus , Long>{
	
	 public employeeStatus findByName(String name);
		
}
