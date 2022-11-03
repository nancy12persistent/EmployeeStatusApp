package com.availability.employeeStatus.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.availability.employeeStatus.EmployeeRepository.EmployeeRepository;
import com.availability.employeeStatus.model.employeeStatus;
import com.availibility.employeeStatus.service.EmployeeService;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceimplTest {
	
    @Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repo;
	private employeeStatus employee;	
	
	@BeforeEach
	public void setup() {
		 employeeStatus employee=new employeeStatus(3,"Namisha Gupta",true);
		 System.out.println(employee);
		// Mockito.when(repo.findByName("Namisha Gupta")).thenReturn(employee);
	              
	}
	
	//Find by name
	@Test(expected=NullPointerException.class)
	public void testGetEmployeeByName() {
		/*boolean status=true;
		employeeStatus employeeById=service.findByNameMethod("Namisha Gupta");
		assertEquals(status,employeeById.isStatus());*/
		//given
		given(repo.findByName("Namisha Gupta")).willReturn(employee);

        // when
        employeeStatus savedEmployee = service.findByNameMethod(employee.getName());

        // then
        assertThat(savedEmployee).isNotNull();
	}

	//Save employee
    @Test(expected=NullPointerException.class)
    public void testSaveEmployee(){
        // given
        given(repo.save(employee)).willReturn(employee);
        // when
        employeeStatus savedEmployee = service.saveEmployeeS(employee);  
        // then
        assertThat(savedEmployee).isNotNull();
    	
	}
    
    //Update status to false
    @Test(expected=NullPointerException.class)
    public void testSetStatusFalse() {
    	// given-precondition or setup
        given(repo.save(employee)).willReturn(employee);
    	given(repo.findByName("Namisha Gupta")).willReturn(employee);
    	employee.setStatus(false);   	
    	// when-action or the behaviour that we are going test
    	service.deleteEmployeeS("Namisha Gupta");
    	// then - verify the output
    	        assertThat(employee.isStatus()).isEqualTo(false);
    	     
    	 }
    
    //Update Name 
    @Test(expected=NullPointerException.class)
    public void testSetName() {
    	// given-precondition or setup
    	given(repo.save(employee)).willReturn(employee);
    	given(repo.findByName("Namisha Gupta")).willReturn(employee);
    	employee.setName("Manisha Verma");
    	
    	// when-action or the behaviour that we are going test
    	service.updateEmployeeName(employee, "Namisha Gupta");
    	// then - verify the output
    	 assertThat(employee.getName()).isEqualTo("Manisha Verma");  	     
    	 }
    
  // Get all Employees
    @Test(expected=NullPointerException.class)
    public void testGetAllEmployees(){ {
    	    employeeStatus employee1 = new employeeStatus();
    	    employee1.setId(4);
    	    employee1.setName("Mini Verma");
    	    employee1.setStatus(true);
    	  
    	    List<employeeStatus> EmployeeList = new ArrayList<>();
    	    EmployeeList.add(employee1);

    	    // providing knowledge
    	    when(repo.findAll()).thenReturn(EmployeeList);

    	    List<employeeStatus> fetchedCustomers = service.getAllEmployeesStatus();
    	    assertThat(fetchedCustomers.size()).isGreaterThan(0);
    	}
    }
    
}


