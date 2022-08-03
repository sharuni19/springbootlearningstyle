package com.learningstyle.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.SubjectLevelCollections;

@Repository
public interface SubjectRepository extends MongoRepository<SubjectLevelCollections, String> {

}
