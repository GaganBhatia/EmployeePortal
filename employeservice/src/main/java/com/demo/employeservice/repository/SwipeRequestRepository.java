package com.demo.employeservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.employeservice.model.SwipeRequestDao;
import com.demo.employeservice.model.SwipeRequestModel;

@Repository
public interface SwipeRequestRepository extends MongoRepository<SwipeRequestDao, UUID>{
	
	public List<SwipeRequestDao> getSwipeSummary(String employeeId, long timeFrom, long timeTo);

}
