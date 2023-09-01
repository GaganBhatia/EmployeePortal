package com.demo.employeservice.service;

import org.springframework.stereotype.Service;

import com.demo.employeservice.model.SwipeRequestModel;


public interface EmployeeAttendenceService {

	public void swipeInEmployee(SwipeRequestModel swipeRequest);

	public void swipeOutEmployee(SwipeRequestModel swipeRequest);

}
