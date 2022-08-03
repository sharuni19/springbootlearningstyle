package com.learningstyle.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learningstyle.application.collections.FeedbackCollections;
import com.learningstyle.application.collections.LeaderBoardCollections;
import com.learningstyle.application.collections.SignInCollections;
import com.learningstyle.application.collections.SubjectLevelCollections;
import com.learningstyle.application.collections.UserCollections;
import com.learningstyle.application.collections.UserCompletedLevelCollections;
import com.learningstyle.application.dto.LeaderBoardDto;
import com.learningstyle.application.dto.RegisterUserDto;
import com.learningstyle.application.repo.FeedbackRepository;
import com.learningstyle.application.repo.LeaderBoardRepository;
import com.learningstyle.application.repo.SignInRepository;
import com.learningstyle.application.repo.SubjectRepository;
import com.learningstyle.application.repo.UserCompletedLevelRepository;
import com.learningstyle.application.repo.UserRepository;

@Service
public class LearningStyleService {
	@Autowired
	SignInRepository signInRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserCompletedLevelRepository userCompletedLevelRepository;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	LeaderBoardRepository leaderBoardRepository;

	public String loginUser(String Email, String Password) {
		String status = "";
		try {
			SignInCollections recordsByEmail = signInRepository.getRecordsByEmail(Email);
			if (recordsByEmail != null) {
				if (recordsByEmail.getPassword().equals(Password)) {
					status = "Success";
				} else {
					status = "Invalid Password";
				}
			} else {
				status = "Invalid Email";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error Occurred";
		}
		return status;
	}

	public String registerUser(RegisterUserDto registerUserDto) {
		String status = "";
		try {
			SignInCollections recordsByEmail = signInRepository.getRecordsByEmail(registerUserDto.getEmail());
			if (recordsByEmail == null) {
				UserCollections userCollections = new UserCollections();
				userCollections.setAge(registerUserDto.getAge());
				userCollections.setCourse(registerUserDto.getCourse());
				userCollections.setDateOfBirth(registerUserDto.getDateOfBirth());
				userCollections.setDegree(registerUserDto.getDegree());
				userCollections.setEmail(registerUserDto.getEmail());
				userCollections.setFirstName(registerUserDto.getFirstName());
				userCollections.setLastName(registerUserDto.getLastName());
				userRepository.save(userCollections);
				SignInCollections signInCollections = new SignInCollections();
				signInCollections.setEmail(registerUserDto.getEmail());
				signInCollections.setPassword(registerUserDto.getPassword());
				signInRepository.save(signInCollections);
				UserCompletedLevelCollections userCompletedLevelCollections = new UserCompletedLevelCollections();
				userCompletedLevelCollections.setEmail(registerUserDto.getEmail());
				userCompletedLevelCollections.setEnglishCompletedLevels(0);
				userCompletedLevelCollections.setComputerScienceCompletedLevels(0);
				userCompletedLevelRepository.save(userCompletedLevelCollections);
				LeaderBoardCollections leaderBoardCollections = new LeaderBoardCollections();
				leaderBoardCollections.setEmail(registerUserDto.getEmail());
				leaderBoardCollections.setComputerScienceActivityPoints(0);
				leaderBoardCollections.setEnglishActivityPoints(0);
				leaderBoardRepository.save(leaderBoardCollections);
				status = "Success";
			} else {
				status = "Already Registered";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error Occurred";
		}
		return status;

	}

	public UserCollections getUser(String Email) {
		return userRepository.getRecordsByEmail(Email);
	}

	public List<SubjectLevelCollections> getAllSubjectLevelCollections() {
		return subjectRepository.findAll();
	}

	public UserCompletedLevelCollections getUserCompletedLevel(String Email) {
		return userCompletedLevelRepository.getRecordsByEmail(Email);
	}

	public String updateUserCompletedLevel(String Email, String subject) {
		String status = "";
		try {
			UserCompletedLevelCollections recordsByEmail = userCompletedLevelRepository.getRecordsByEmail(Email);
			if (subject.equalsIgnoreCase("English")) {
				recordsByEmail.setEnglishCompletedLevels(recordsByEmail.getEnglishCompletedLevels() + 1);
			} else {
				recordsByEmail
						.setComputerScienceCompletedLevels(recordsByEmail.getComputerScienceCompletedLevels() + 1);
			}
			userCompletedLevelRepository.save(recordsByEmail);
			status = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error Ocurred";
		}
		return status;
	}

	public String updateUserLearningType(String Email, String subject, String learningType) {
		String status = "";
		try {
			UserCompletedLevelCollections recordsByEmail = userCompletedLevelRepository.getRecordsByEmail(Email);
			if (subject.equalsIgnoreCase("English")) {
				recordsByEmail.setEnglishLeaningType(learningType);
			} else {
				recordsByEmail.setComputerScienceLearningType(learningType);
			}
			userCompletedLevelRepository.save(recordsByEmail);
			status = "Success";
		} catch (Exception e) {
			status = "Error Ocurred";
		}
		return status;
	}

	public String submitFeedback(String Email, String feedback) {
		String status = "";
		try {
			FeedbackCollections feedbackCollections = new FeedbackCollections();
			feedbackCollections.setEmail(Email);
			feedbackCollections.setFeedback(feedback);
			feedbackRepository.save(feedbackCollections);
			status = "Success";
		} catch (Exception e) {
			status = "Error Occurred";
		}
		return status;
	}

	public LeaderBoardDto getRankAndPoints(String email, String subject) {
		LeaderBoardDto leaderBoardDto = new LeaderBoardDto();
		leaderBoardDto.setRank(999);
		leaderBoardDto.setPoints(0);
		if (subject.equalsIgnoreCase("English")) {
			List<LeaderBoardCollections> sortByEnglishCompletedPoints = leaderBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "EnglishActivityPoints"));
			for (LeaderBoardCollections leaderBoardCollections : sortByEnglishCompletedPoints) {
				if (leaderBoardCollections.getEmail().equalsIgnoreCase(email)) {
					if (leaderBoardCollections.getEnglishActivityPoints() > 0) {
						leaderBoardDto.setPoints(leaderBoardCollections.getEnglishActivityPoints());
						leaderBoardDto.setRank(sortByEnglishCompletedPoints.indexOf(leaderBoardCollections)+1);
					}
					break;
				}
			}
		} else {
			List<LeaderBoardCollections> sortByComputerScienceCompletedPoints = leaderBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "ComputerScienceActivityPoints"));
			for (LeaderBoardCollections leaderBoardCollections : sortByComputerScienceCompletedPoints) {
				if (leaderBoardCollections.getEmail().equalsIgnoreCase(email)) {
					if (leaderBoardCollections.getComputerScienceActivityPoints() > 0) {
						leaderBoardDto.setPoints(leaderBoardCollections.getComputerScienceActivityPoints());
						leaderBoardDto.setRank(sortByComputerScienceCompletedPoints.indexOf(leaderBoardCollections)+1);
					}
					break;
				}
			}
		}
		return leaderBoardDto;
	}

	public String updateLeaderBoardPoints(String email, String subject, int points) {
		String status = "";
		try {
			LeaderBoardCollections recordsByEmail = leaderBoardRepository.getRecordsByEmail(email);
			if (recordsByEmail != null) {
				if (subject.equalsIgnoreCase("English")) {
					int updatedPoints = recordsByEmail.getEnglishActivityPoints() + points;
					recordsByEmail.setEnglishActivityPoints(updatedPoints);
					leaderBoardRepository.save(recordsByEmail);
					status = "Success";
				} else {
					int updatedPoints = recordsByEmail.getComputerScienceActivityPoints() + points;
					recordsByEmail.setComputerScienceActivityPoints(updatedPoints);
					leaderBoardRepository.save(recordsByEmail);
					status = "Success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Failure";
		}
		return status;
	}
}
