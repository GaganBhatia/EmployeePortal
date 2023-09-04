package com.demo.employeservice.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.bson.BsonTimestamp;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employeservice.model.SwipeRequestDao;
import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.model.SwipeRequestType;
import com.demo.employeservice.model.SwipeSummaryModel;
import com.demo.employeservice.repository.SwipeRequestRepository;

@Service
public class EmployeeAttendenceServiceImpl implements EmployeeSwipeService {

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
	public void swipeOutEmployee(SwipeRequestModel swipeOutRequest) {
		SwipeRequestDao swipeOutDaoRequest = 
				new SwipeRequestDao();

		swipeOutDaoRequest.setBuildingId(swipeOutRequest.getBuildingId());
		swipeOutDaoRequest.setEmployeeId(swipeOutRequest.getEmployeeId());
		swipeOutDaoRequest.setRequestType(swipeOutRequest.getSwipeRequestType());
		swipeOutDaoRequest.setTimeStamp(new BsonTimestamp().asTimestamp());
		swipeOutDaoRequest.setId(new ObjectId());
		swipeRequestRepository.save(swipeOutDaoRequest);
	}

	@Override
	public SwipeSummaryModel getSwipeSummary(String employeeId, long timeFrom, long timeTo) {
		List<SwipeRequestDao> swipeDetails = swipeRequestRepository.getSwipeSummary(employeeId, timeFrom, timeTo);
		SwipeSummaryModel swipeSummary = new  SwipeSummaryModel();
		if(swipeDetails.size() > 0) {
			swipeSummary.setEmployeeId(employeeId);
			swipeSummary.setBuildingId(swipeDetails.get(0).getBuildingId());
			Optional<SwipeRequestDao> swipeInRequest = swipeDetails.stream().filter(record -> record.getRequestType()!= null && record.getRequestType().equals(SwipeRequestType.SWIPE_IN)).findFirst();
			if(swipeInRequest.isPresent()) {
				swipeSummary.setFirstSwipeInRequestTime(swipeInRequest.get().getTimeStamp().getTime());
			}
			Optional<SwipeRequestDao> swipeOutRequest = swipeDetails.stream().filter(record -> record.getRequestType()!= null && record.getRequestType().equals(SwipeRequestType.SWIPE_OUT)).findFirst();
			if(swipeOutRequest.isPresent()) {
				swipeSummary.setLastSwipeOutRequestTime(swipeOutRequest.get().getTimeStamp().getTime());
			}
}		return swipeSummary;
	}

	@Override
	public void generateAttendence(String employeeId) {

		SwipeSummaryModel swipeDaySummary = getSwipeSummary(employeeId, 
				LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC),
				LocalDate.now().atTime(23, 59).toEpochSecond(ZoneOffset.UTC));		
		System.out.println("test -> "+swipeDaySummary.getFirstSwipeInRequestTime());
		System.out.println("test1 -> "+swipeDaySummary.getLastSwipeOutRequestTime());

	}

}
