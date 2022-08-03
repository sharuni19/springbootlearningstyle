package com.learningstyle.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.FeedbackCollections;

@Repository
public interface FeedbackRepository extends MongoRepository<FeedbackCollections, String> {

}
