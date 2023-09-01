package com.demo.employeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.service.EmployeeAttendenceService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired EmployeeAttendenceService attendenceService;
	
	@PostMapping("/swipe-in")
	public ResponseBody employeeSwipeIn(@RequestBody SwipeRequestModel swipeRequest){
		attendenceService.swipeInEmployee(swipeRequest);
		return null;
		
	}

	
	@PostMapping("/swipe-out")
	public ResponseBody employeeSwipeOut(@RequestBody SwipeRequestModel swipeRequest){
		attendenceService.swipeOutEmployee(swipeRequest);
		return null;
		
	}
}
