package com.learningstyle.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.UserCompletedLevelCollections;

@Repository
public interface UserCompletedLevelRepository extends MongoRepository<UserCompletedLevelCollections, String> {
	@Query("{Email : ?0}")
	UserCompletedLevelCollections getRecordsByEmail(String Email);
}
