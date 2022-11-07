package com.availability.employeeStatus.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.availability.employeeStatus.model.employeeStatus;
import com.availibility.employeeStatus.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//Build create employeeStatus REST API
	@PostMapping(value="/save")
	public ResponseEntity<employeeStatus> saveEmployee(@RequestBody employeeStatus employee) {
			 if(employee.getName().matches("^[a-zA-Z0-9_ ]*$")) {
			    employee=employeeService.saveEmployee(employee);
	            return new ResponseEntity<>(employee, HttpStatus.CREATED);
			}
				else{
					return new ResponseEntity<>(null, HttpStatus.MULTI_STATUS);
			}}
	
	@PutMapping(value="/updateStatus/{name}")
	public void deleteEmployee(@PathVariable String name) {
		employeeService.deleteEmployeeS(name);
	}
    @PutMapping(value="/update/{name}")
	public void updateEmployee(@PathVariable("name") String name,@RequestBody employeeStatus employee) {
		employeeService.updateEmployeeName(employee, name);
	 }
		
   //Build get all employee 
  @GetMapping(value="/getemployee")
  public List<employeeStatus> getAllEmployeesStatus(){
	  return employeeService.getAllEmployeesStatus();
	}
  
  //Build employee by name
    @GetMapping(value="/employeename/{name}")
    public employeeStatus findByNameMethod(@PathVariable String name){
	    return employeeService.findByNameMethod(name);
    }
    
    @GetMapping(value="/status/{name}")
    public boolean checkStatus(@PathVariable String name) {
		 return employeeService.checkStatus(name);
}
}
	



 
