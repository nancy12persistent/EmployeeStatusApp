package com.availability.employeeStatus.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.availability.employeeStatus.ResponseHandler.ResponseHandler;
import com.availability.employeeStatus.model.employeeStatus;
import com.availibility.employeeStatus.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/employees/save")
	public ResponseEntity<Object> saveEmployee(@RequestBody employeeStatus employee) {
		boolean result = employeeService.matchRegex(employee);
		if (result) {
			employee = employeeService.saveEmployee(employee);
			return ResponseHandler.generateResponse("Successfully data saved!", HttpStatus.CREATED);
		} else {
			return ResponseHandler.generateResponse("Enter the correct format", HttpStatus.MULTI_STATUS);
		}
	}

	@PutMapping(value = "/employees/updateStatus/{name}")
	public void updateEmployeeStatus(@PathVariable String name) {
		employeeService.updateEmployeeStatus(name);
	}

	@PutMapping(value = "/employees/update/{name}")
	public void updateEmployee(@PathVariable("name") String name, @RequestBody employeeStatus employee) {
		employeeService.updateEmployeeName(employee, name);
	}

	
	@GetMapping(value = "/employees/getemployee")
	public List<employeeStatus> getAllEmployeesStatus() {
		return employeeService.getAllEmployeesStatus();
	}

	
	@GetMapping(value = "GET_EMPBYNAME/{name}")
	public employeeStatus findByNameMethod(@PathVariable String name) {
		return employeeService.findByNameMethod(name);
	}

	@GetMapping(value = "/employees/status/{name}")
	public boolean checkStatus(@PathVariable String name) {
		return employeeService.checkStatus(name);
	}
}
