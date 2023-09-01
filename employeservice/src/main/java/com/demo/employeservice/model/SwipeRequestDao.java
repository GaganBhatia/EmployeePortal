package com.demo.employeservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;

@Document(value = "employeeSwipeHistory")
public class SwipeRequestDao {

	@Generated(value = { "_id" })
	private Long id;
	private String employeeId;
	private String buildingId;
	private Long timeStamp;
	private SwipeRequestType requestType;

	public SwipeRequestDao(String employeeId, String buildingId,
			SwipeRequestType requestType) {
		this.employeeId = employeeId;
		this.buildingId = buildingId;
		this.requestType = requestType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public SwipeRequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(SwipeRequestType requestType) {
		this.requestType = requestType;
	}
}
