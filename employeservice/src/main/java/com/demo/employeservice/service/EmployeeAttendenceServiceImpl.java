package com.demo.employeservice.service;

import java.time.Instant;
import java.util.UUID;

import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;
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
				new SwipeRequestDao();
		
		swipeInDaoRequest.setBuildingId(swipeInRequest.getBuildingId());
		swipeInDaoRequest.setEmployeeId(swipeInRequest.getEmployeeId());
		swipeInDaoRequest.setRequestType(swipeInRequest.getSwipeRequestType());
		swipeInDaoRequest.setTimeStamp(new BsonTimestamp().asTimestamp());
		swipeInDaoRequest.setId(new ObjectId());
		swipeRequestRepository.save(swipeInDaoRequest);
		
	}

	@Override
	public void swipeOutEmployee(SwipeRequestModel swipeRequest) {
		// TODO Auto-generated method stub

	}

}
