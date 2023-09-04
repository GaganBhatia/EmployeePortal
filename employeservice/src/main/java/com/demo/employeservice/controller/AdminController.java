package com.demo.employeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.service.EmployeeSwipeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired EmployeeSwipeService employeeSwipeService;

	@GetMapping("/swipe-summary")
	public ResponseBody employeeSwipeIn(@RequestParam String employeeId,
			@RequestParam long requestTimeFrom,@RequestParam long requestTimeTo){
		
				employeeSwipeService.getSwipeSummary(employeeId,requestTimeFrom,requestTimeTo);
				//new ResponseEntity<T>(HttpStatus.ACCEPTED)
				return null;
		
	}

}
