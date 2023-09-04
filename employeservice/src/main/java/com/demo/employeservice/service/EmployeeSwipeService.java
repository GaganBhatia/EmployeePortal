package com.demo.employeservice.service;

import org.springframework.stereotype.Service;

import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.model.SwipeSummaryModel;


public interface EmployeeSwipeService {

	public void swipeInEmployee(SwipeRequestModel swipeRequest);

	public void swipeOutEmployee(SwipeRequestModel swipeRequest);
	
	public SwipeSummaryModel getSwipeSummary(String employeeId, long timeFrom, long timeTo);

}
