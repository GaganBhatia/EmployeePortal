package com.demo.employeservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.employeservice.model.SwipeRequestDao;

public class SwipeRequestRepositoryImpl implements SwipeRequestTemplate{
	@Autowired MongoTemplate mongoTemplate;

}
