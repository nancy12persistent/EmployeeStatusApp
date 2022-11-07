package com.availability.employeeStatus.ResponseHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String Message, HttpStatus status){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("message", Message);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map,status);
		
	}

}