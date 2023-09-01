package com.demo.employeservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;

public class SwipeRequestModel {

	private String buildingId;
	private String employeeId;
	private SwipeRequestType swipeRequestType;
	@JsonProperty(required = false)
	private long timeStamp;

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public SwipeRequestType getSwipeRequestType() {
		return swipeRequestType;
	}

	public void setSwipeRequestType(SwipeRequestType swipeRequestType) {
		this.swipeRequestType = swipeRequestType;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public SwipeRequestModel(String buildingId, String employeeId, SwipeRequestType swipeRequestType, long timeStamp) {
		this.buildingId = buildingId;
		this.employeeId = employeeId;
		this.swipeRequestType = swipeRequestType;
		this.timeStamp = timeStamp;
	}

	public SwipeRequestModel() {
	}

}
