package com.demo.employeservice.model;

import java.util.UUID;

import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;

@Document(value = "employeeSwipeHistory")
public class SwipeRequestDao {

	@Generated(value = { "_id" })
	private ObjectId id;
	private String employeeId;
	private String buildingId;

	public SwipeRequestDao() {
	}

	private BsonTimestamp timeStamp;
	private SwipeRequestType requestType;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public BsonTimestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(BsonTimestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public SwipeRequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(SwipeRequestType requestType) {
		this.requestType = requestType;
	}

}
