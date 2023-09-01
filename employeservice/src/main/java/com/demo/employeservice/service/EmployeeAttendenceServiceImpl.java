package com.demo.employeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employeservice.model.SwipeRequestDao;
import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.repository.SwipeRequestRepository;
@Service
public class EmployeeAttendenceServiceImpl implements EmployeeAttendenceService {

	@Autowired
	SwipeRequestRepository swipeRequestRepository;

	@Override
	public void swipeInEmployee(SwipeRequestModel swipeInRequest) {
		SwipeRequestDao swipeInDaoRequest = 
				new SwipeRequestDao(swipeInRequest.getEmployeeId(), swipeInRequest.getBuildingId(), swipeInRequest.getSwipeRequestType());
		swipeRequestRepository.save(swipeInDaoRequest);
		
	}

	@Override
	public void swipeOutEmployee(SwipeRequestModel swipeRequest) {
		// TODO Auto-generated method stub

	}

}
