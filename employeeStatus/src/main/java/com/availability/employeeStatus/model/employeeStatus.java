package com.availability.employeeStatus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Builder
@Entity
@Table(name="EmployeeStatus")
public class employeeStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="Status", nullable=false)
	private boolean status;

	public employeeStatus() {
	}

	public employeeStatus(long id,String name, boolean status) {
		this.id=id;
		this.name = name;
		this.status = status;
	}

	public employeeStatus(String name, boolean status) {
		this.name = name;
		this.status = status;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	

}
