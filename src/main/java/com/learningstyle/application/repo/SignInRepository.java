package com.learningstyle.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.SignInCollections;

@Repository
public interface SignInRepository extends MongoRepository<SignInCollections, String> {
	@Query("{Email : ?0}")
	SignInCollections getRecordsByEmail(String Email);
}
