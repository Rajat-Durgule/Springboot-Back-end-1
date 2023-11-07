package com.app.dto;

import java.sql.Timestamp;

public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
	/**
	 * 
	 */
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param departmentName
	 * @param createdAt
	 * @param updatedAt
	 */
	public EmployeeDto(Long id, String firstName, String lastName, String email, String departmentName,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentName = departmentName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", departmentName =" + departmentName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
    
    
}
