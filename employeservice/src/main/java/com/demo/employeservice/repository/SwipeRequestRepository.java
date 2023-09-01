package com.demo.employeservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.employeservice.model.SwipeRequestDao;

public interface SwipeRequestRepository extends MongoRepository<SwipeRequestDao, Long>{

}
