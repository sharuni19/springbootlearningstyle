package com.learningstyle.application.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learningstyle.application.collections.LeaderBoardCollections;

@Repository
public interface LeaderBoardRepository extends MongoRepository<LeaderBoardCollections, String> {
	@Query(value = "{active:true}", sort = "{EnglishActivityPoints : -1}")
	List<LeaderBoardCollections> sortByEnglishCompletedPoints();

	@Query(value = "{active:true}", sort = "{ComputerScienceActivityPoints : -1}")
	List<LeaderBoardCollections> sortByComputerScienceCompletedPoints();

	@Query("{Email : ?0}")
	LeaderBoardCollections getRecordsByEmail(String Email);
}
