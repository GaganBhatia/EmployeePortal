package com.demo.attendenceservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SwipeSummaryKafkaProducerModel {
	private String employeeId;
	private Double totalHours;
	private LocalDate attendenceDate;
	private Attendence attendence;
	private LocalDateTime firstSwipeIn;
	private LocalDateTime lastSwipeOut;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public LocalDate getAttendenceDate() {
		return attendenceDate;
	}

	public void setAttendenceDate(LocalDate attendenceDate) {
		this.attendenceDate = attendenceDate;
	}

	public Attendence getAttendence() {
		return attendence;
	}

	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}

	public LocalDateTime getFirstSwipeIn() {
		return firstSwipeIn;
	}

	public void setFirstSwipeIn(LocalDateTime firstSwipeIn) {
		this.firstSwipeIn = firstSwipeIn;
	}

	public LocalDateTime getLastSwipeOut() {
		return lastSwipeOut;
	}

	public void setLastSwipeOut(LocalDateTime lastSwipeOut) {
		this.lastSwipeOut = lastSwipeOut;
	}
}
