package com.availability.employeeStatus.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.availability.employeeStatus.model.employeeStatus;
import com.availibility.employeeStatus.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControllerTest extends EmployeeStatusTest{
	
	@Autowired
	private WebApplicationContext webApplicationContext;

    private ObjectMapper objectMapper;

	private MockMvc mockMvc;
	
	 @MockBean
	 private EmployeeService employeeService;
	 
	 employeeStatus emp1=new employeeStatus(1L,"Nancy Sharma",true);
	 employeeStatus emp2=new employeeStatus(2L,"Riya Verma",true);
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	//Junit test to get all employees
	@Test
	public void GetAllEmployee() throws Exception {
		List<employeeStatus> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(emp1);
        listOfEmployees.add(emp2);
        Mockito.when(employeeService.getAllEmployeesStatus()).thenReturn(listOfEmployees);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/employees/getemployee"));
        // then - verify the output
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));      
    }
	
	//Junit test to get employee By name
	@Test
	public void getEmployeeBYNameTest() throws Exception{
        Mockito.when(employeeService.findByNameMethod(emp1.getName())).thenReturn(emp1);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/employees/employeename/{name}", emp1.getName()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Nancy Sharma"))
                .andExpect(jsonPath("$.status").value(true));           
    }
	
	//Junit test to save employee 
	@Test
	public void SaveEmployeeTest()throws Exception {
	        Mockito.when(employeeService.saveEmployee(ArgumentMatchers.any())).thenReturn(emp1);
	        String json = objectMapper.writeValueAsString(emp1);
	        mockMvc.perform(post("/employees/save").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
	                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
	                .andExpect(jsonPath("$.id", Matchers.equalTo(1L)))
	                .andExpect(jsonPath("$.name", Matchers.equalTo("Nancy Sharma")));
		
		    }
	
	// Junit test to set status false
	@Test
     public void setStatusFalse()throws Exception {       
         emp1.setStatus(false);
         Mockito.when(employeeService.deleteEmployeeS(emp1.getName())).thenReturn("status change");
         String json = objectMapper.writeValueAsString(emp1);
         mockMvc.perform(put("/employees/updateStatus/{name}").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
            .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
            .andExpect(jsonPath("$.status", Matchers.equalTo(false)));
            }
     
     //Junit test to set name
	@Test
     public void setStatusName()throws Exception { 
    	 employeeStatus emp=new employeeStatus();
    	 emp.setName("Kiara Aadvani");
         emp1.setName(emp.getName());
         Mockito.when(employeeService.updateEmployeeName(ArgumentMatchers.any(),emp.getName())).thenReturn("name updated");
         // when -  action or the behaviour that we are going test
         ResultActions response = mockMvc.perform(put("/employees/update/{name}", emp.getName()));
      // then - verify the output
         response.andExpect(status().isOk())           
                 .andExpect(jsonPath("$.name").value("Kiara Aadvani"));
                          
     }
 
       
}


	

    

		


