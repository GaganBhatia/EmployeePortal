package com.demo.employeservice.model;

import org.bson.BsonTimestamp;
import org.bson.types.BSONTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;

public class SwipeRequestModel {

	private String buildingId;
	private String employeeId;
	private SwipeRequestType swipeRequestType;
	@JsonProperty(required = false)
	private BsonTimestamp timeStamp;

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

	public BsonTimestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(BsonTimestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public SwipeRequestModel(String buildingId, String employeeId, SwipeRequestType swipeRequestType, BsonTimestamp timeStamp) {
		this.buildingId = buildingId;
		this.employeeId = employeeId;
		this.swipeRequestType = swipeRequestType;
		this.timeStamp = timeStamp;
	}

	public SwipeRequestModel() {
	}

}
