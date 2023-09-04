package com.demo.employeservice.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.employeservice.model.SwipeRequestDao;
import com.demo.employeservice.model.SwipeRequestModel;
import com.demo.employeservice.model.SwipeRequestType;
import com.demo.employeservice.utility.DBConstants;

public class SwipeRequestRepositoryImpl implements SwipeRequestTemplate{
	@Autowired MongoTemplate mongoTemplate;

	
	public List<SwipeRequestModel> getSwipeSummary(String employeeId, long timeFrom, long timeTo){
		System.out.println("employeeId  -> " + employeeId);

		//First Swipe In
		Criteria swipeIncriteria = new Criteria();
		swipeIncriteria.andOperator(Criteria.where("employeeId").is(employeeId),Criteria.where("requestType").is(SwipeRequestType.SWIPE_IN)
				,Criteria.where("timeStamp").lte(timeFrom),Criteria.where("timeStamp").gte(timeFrom)
				);
		Query firstSwipeInQuery = new Query(swipeIncriteria).with(Sort.by(Sort.Direction.ASC, "timeStamp")).limit(1);
		List<SwipeRequestModel> swipeInRequestDetail = mongoTemplate.find(firstSwipeInQuery, SwipeRequestModel.class, DBConstants.SWIPE_HISTORY_DOCUMENT);
		//System.out.print("Sample  -> " + Arrays.toString(swipeInRequestDetail.toArray()));
		
		//Last SwipeOut
		Criteria swipeOutCriteria = new Criteria();
		swipeOutCriteria.andOperator(Criteria.where("employeeId").is(employeeId),Criteria.where("requestType").is(SwipeRequestType.SWIPE_OUT)
				,Criteria.where("timeStamp").lte(timeFrom),Criteria.where("timeStamp").gte(timeFrom)
				);
		Query firstSwipeOutQuery = new Query(swipeOutCriteria).with(Sort.by(Sort.Direction.ASC, "timeStamp")).limit(1);
		
		
		//TODO fetch records in 1 single query using group and traverse in-memory
		List<SwipeRequestModel> swipeOutRequestDetail = mongoTemplate.find(firstSwipeOutQuery, SwipeRequestModel.class, DBConstants.SWIPE_HISTORY_DOCUMENT);
		
		swipeInRequestDetail.forEach(record -> System.out.println(record.getEmployeeId()));
		List<SwipeRequestModel> list = new ArrayList<SwipeRequestModel>();
		return list;
	}

}
