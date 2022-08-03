package com.learningstyle.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.UserCollections;

@Repository
public interface UserRepository extends MongoRepository<UserCollections, String> {
	@Query("{Email : ?0}")
	UserCollections getRecordsByEmail(String Email);
}
