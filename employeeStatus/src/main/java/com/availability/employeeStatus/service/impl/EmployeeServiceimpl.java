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
	public employeeStatus saveEmployee(employeeStatus employee) {
		employee.setStatus(true);
		return employeeRepositoryA.save(employee);
	}

	@Override
	public String updateEmployeeName(employeeStatus employee, String name) {
		employeeStatus existingemployee = employeeRepositoryA.findByName(name);

		existingemployee.setName(employee.getName());
		employeeRepositoryA.save(existingemployee);
		return ("Name changed");
	}

	@Override
	public String updateEmployeeStatus(String name) {
		employeeStatus emp = employeeRepositoryA.findByName(name);
		if (emp.isStatus()) {
			emp.setStatus(false);
			employeeRepositoryA.save(emp);
			return ("Status changed");
		} else {
			return ("Status not changed");
		}

	}

	@Override
	public List<employeeStatus> getAllEmployeesStatus() {
		return employeeRepositoryA.findAll();

	}

	public employeeStatus findByNameMethod(String name) {
		return employeeRepositoryA.findByName(name);

	}

	public boolean checkStatus(String name) {
		employeeStatus emp = employeeRepositoryA.findByName(name);
		if (emp.isStatus()) {
			return true;
		} else {
			return false;
		}
	}
	

	@Override
	public boolean matchRegex(employeeStatus employee) {
		if (employee.getName().matches("^[a-zA-Z0-9_ ]*$")) {
			return true;
		}
		else {
			return false;
		}
	}

}
