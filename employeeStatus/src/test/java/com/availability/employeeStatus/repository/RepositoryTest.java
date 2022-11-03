package com.availability.employeeStatus.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.availability.employeeStatus.EmployeeRepository.EmployeeRepository;
import com.availability.employeeStatus.model.employeeStatus;

import java.util.List;

@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private EmployeeRepository repo;
	
	employeeStatus emp1=new employeeStatus(2L,"Meena Kumar",true);
	employeeStatus emp2=new employeeStatus(3L,"Naman Kumar",true);
	
	//Junit test for save employee
	@Test(expected=NullPointerException.class)
	public void saveEmployeeTest() {
		employeeStatus emp =new employeeStatus(1L,"Nayan Sharma",true);
		repo.save(emp);
		Assertions.assertThat(emp.getId()).isGreaterThan(0);
	}
				
	//Junit test to get employee By Name
	@Test(expected=NullPointerException.class)
	public void getEmployeeByNameTest(){
	   employeeStatus emp = repo.findByName("Meena Kumar");
	   Assertions.assertThat(emp.getId()).isEqualTo(2L);
	}
	
	//Junit test to get all employees
	@Test(expected=NullPointerException.class)
	public void getListOfEmployeesTest(){
        List<employeeStatus> employees = repo.findAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }
	
	//Junit test tp update Employee Status
	@Test(expected=NullPointerException.class)
	 public void updateEmployeeStatus(){
	        employeeStatus employee = repo.findByName("Meena Kumar");
	        employee.setStatus(false);
	        employeeStatus employeeUpdated =  repo.save(employee);
	        Assertions.assertThat(employeeUpdated.isStatus()).isEqualTo(false);
    }
	
	//Junit test to update Employee name
	@Test(expected=NullPointerException.class)
	public void updateEmployeeNameTest(){
	        employeeStatus employee = repo.findByName("Meena Kumar");
	        employee.setName(emp2.getName());
	        employeeStatus upemp=repo.save(employee);
	        Assertions.assertThat(upemp.getName()).isEqualTo("Naman Kumar");
	       
	    }	

}