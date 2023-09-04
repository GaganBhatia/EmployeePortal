package com.demo.employeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeservice.model.SwipeSummaryModel;
import com.demo.employeservice.service.EmployeeSwipeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	EmployeeSwipeService employeeSwipeService;

	@GetMapping("/swipe-summary")
	public ResponseEntity<SwipeSummaryModel> employeeSwipeIn(@RequestParam String employeeId,
			@RequestParam long requestTimeFrom, @RequestParam long requestTimeTo) {
		SwipeSummaryModel swipeSummary = employeeSwipeService.getSwipeSummary(employeeId, requestTimeFrom,
				requestTimeTo);
		ResponseEntity responseEntity = new ResponseEntity<SwipeSummaryModel>(swipeSummary, HttpStatus.OK);
		return responseEntity;

	}
	
	@GetMapping("/generate-attendence")
	public ResponseEntity<SwipeSummaryModel> generateAttendence(@RequestParam String employeeId) {
		 employeeSwipeService.generateAttendence(employeeId);
		return null;

	}

}
