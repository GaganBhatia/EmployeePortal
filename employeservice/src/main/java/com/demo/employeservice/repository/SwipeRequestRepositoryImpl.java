package com.demo.employeservice.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.BsonTimestamp;
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

	//TODO fetch records in 1 single query using group and traverse in-memory
	public List<SwipeRequestDao> getSwipeSummary(String employeeId, long timeFrom, long timeTo){
		BsonTimestamp startTime = new  BsonTimestamp(timeFrom);
		BsonTimestamp endTime = new  BsonTimestamp(timeTo);

		//First Swipe In
		Criteria swipeIncriteria = new Criteria();
		swipeIncriteria.andOperator(Criteria.where("employeeId").is(employeeId),Criteria.where("requestType").is(SwipeRequestType.SWIPE_IN)
				, Criteria.where("timeStamp").gte(startTime)/* ,Criteria.where("timeStamp").lte(endTime) */
				);
		Query firstSwipeInQuery = new Query(swipeIncriteria).with(Sort.by(Sort.Direction.ASC, "timeStamp")).limit(1);
		List<SwipeRequestDao> swipeInRequestDetail = mongoTemplate.find(firstSwipeInQuery, SwipeRequestDao.class, DBConstants.SWIPE_HISTORY_DOCUMENT);
		System.out.println("swipeInRequestDetail  -> " + swipeInRequestDetail.get(0).getTimeStamp().getTime());
		System.out.println("Type  -> " + swipeInRequestDetail.get(0).getRequestType().name());

		//Last SwipeOut
		Criteria swipeOutCriteria = new Criteria();
		swipeOutCriteria.andOperator(Criteria.where("employeeId").is(employeeId),Criteria.where("requestType").is(SwipeRequestType.SWIPE_OUT)
				,Criteria.where("timeStamp").gte(startTime)/*Criteria.where("timeStamp").lte(endTime)*/
				);
		Query firstSwipeOutQuery = new Query(swipeOutCriteria).with(Sort.by(Sort.Direction.DESC, "timeStamp")).limit(1);
		List<SwipeRequestDao> swipeOutRequestDetail = mongoTemplate.find(firstSwipeOutQuery, SwipeRequestDao.class, DBConstants.SWIPE_HISTORY_DOCUMENT);
		swipeInRequestDetail.addAll(swipeOutRequestDetail);
		
		return swipeInRequestDetail;
	}

}
