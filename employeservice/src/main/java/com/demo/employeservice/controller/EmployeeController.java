package com.demo.employeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.service.EmployeeSwipeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired EmployeeSwipeService employeeSwipeService;
	
	@PostMapping("/swipe-in")
	public ResponseBody employeeSwipeIn(@RequestBody SwipeRequestModel swipeRequest){
		//TODO check for validations
		employeeSwipeService.swipeInEmployee(swipeRequest);
		return null;
				//new ResponseEntity<T>(HttpStatus.ACCEPTED)
		
	}

	
	@PostMapping("/swipe-out")
	public ResponseBody employeeSwipeOut(@RequestBody SwipeRequestModel swipeRequest){
		employeeSwipeService.swipeOutEmployee(swipeRequest);
		return null;
		
	}
}
