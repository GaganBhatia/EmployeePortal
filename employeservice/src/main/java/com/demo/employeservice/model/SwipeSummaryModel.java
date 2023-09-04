package com.demo.employeservice.model;

public class SwipeSummaryModel {
	
	private String employeeId;
	private String buildingId;
	private long firstSwipeInRequestTime;
	private long lastSwipeOutRequestTime;
	
	public SwipeSummaryModel() {
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
	public long getFirstSwipeInRequestTime() {
		return firstSwipeInRequestTime;
	}
	public void setFirstSwipeInRequestTime(long firstSwipeInRequestTime) {
		this.firstSwipeInRequestTime = firstSwipeInRequestTime;
	}
	public long getLastSwipeOutRequestTime() {
		return lastSwipeOutRequestTime;
	}
	public void setLastSwipeOutRequestTime(long lastSwipeOutRequestTime) {
		this.lastSwipeOutRequestTime = lastSwipeOutRequestTime;
	}	
}
