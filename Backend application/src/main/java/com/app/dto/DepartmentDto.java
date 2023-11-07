package com.app.dto;

import java.sql.Timestamp;

public class DepartmentDto {
    private String departmentId;
    private String departmentName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
	/**
	 * 
	 */
	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param departmentId
	 * @param departmentName
	 * @param createdAt
	 * @param updatedAt
	 */
	public DepartmentDto(String departmentId, String departmentName, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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
		return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
}
