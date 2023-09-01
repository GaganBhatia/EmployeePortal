package com.demo.employeservice.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.employeservice.model.SwipeRequestDao;

@Repository
public interface SwipeRequestRepository extends MongoRepository<SwipeRequestDao, UUID>{

}
