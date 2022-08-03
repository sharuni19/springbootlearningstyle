package com.learningstyle.application.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learningstyle.application.dto.RegisterUserDto;
import com.learningstyle.application.service.LearningStyleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LearningStyleController {
	@Autowired
	LearningStyleService learningStyleService;

	@GetMapping("/loginUser/{email}/{password}")
	public ResponseEntity<HashMap<String, Object>> loginUser(@PathVariable("email") String Email,
			@PathVariable("password") String Password) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("status", learningStyleService.loginUser(Email, Password));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/test")
	public String test() {
		return "Hello World!!";
	}

	@PostMapping(value = "/registerUser")
	public ResponseEntity<HashMap<String, Object>> registerUser(@RequestBody RegisterUserDto registerUserDto) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("status", learningStyleService.registerUser(registerUserDto));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/getUser/{email}")
	public ResponseEntity<HashMap<String, Object>> getUser(@PathVariable("email") String Email) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("records", learningStyleService.getUser(Email));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/getAllSubjectLevelCollections")
	public ResponseEntity<HashMap<String, Object>> getAllSubjectLevelCollections() {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("records", learningStyleService.getAllSubjectLevelCollections());
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/getUserCompletedLevel/{email}")
	public ResponseEntity<HashMap<String, Object>> getUserCompletedLevel(@PathVariable("email") String Email) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("records", learningStyleService.getUserCompletedLevel(Email));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/updateUserCompletedLevel/{email}/{subject}")
	public ResponseEntity<HashMap<String, Object>> updateUserCompletedLevel(@PathVariable("email") String Email,
			@PathVariable("subject") String subject) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("Status", learningStyleService.updateUserCompletedLevel(Email, subject));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/updateUserLearningType/{email}/{subject}/{learningType}")
	public ResponseEntity<HashMap<String, Object>> updateUserLearningType(@PathVariable("email") String Email,
			@PathVariable("subject") String subject, @PathVariable("learningType") String learningType) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("records", learningStyleService.updateUserLearningType(Email, subject, learningType));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/submitFeedback/{email}/{feedback}")
	public ResponseEntity<HashMap<String, Object>> submitFeedback(@PathVariable("email") String Email,
			@PathVariable("feedback") String feedback) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("Status", learningStyleService.submitFeedback(Email, feedback));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/getRankAndPoints/{email}/{subject}")
	public ResponseEntity<HashMap<String, Object>> getRankAndPoints(@PathVariable("email") String Email,
			@PathVariable("subject") String subject) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("records", learningStyleService.getRankAndPoints(Email, subject));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}

	@GetMapping("/updateLeaderBoardPoints/{email}/{subject}/{points}")
	public ResponseEntity<HashMap<String, Object>> updateLeaderBoardPoints(@PathVariable("email") String Email,
			@PathVariable("subject") String subject, @PathVariable("points") int points) {
		HashMap<String, Object> responseEntity = new HashMap<String, Object>();
		responseEntity.put("Status", learningStyleService.updateLeaderBoardPoints(Email, subject, points));
		return new ResponseEntity<HashMap<String, Object>>(responseEntity, HttpStatus.OK);
	}
}
