package com.learningstyle.application.collections;

/**
 * 
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Administrator
 *
 */
@Document(collection = "UserCompletedLevelCollections")
public class UserCompletedLevelCollections {
	@Id
	private String id;
	private String Email;
	private String EnglishLeaningType;
	private String ComputerScienceLearningType;
	private int EnglishCompletedLevels;
	private int ComputerScienceCompletedLevels;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the englishLeaningType
	 */
	public String getEnglishLeaningType() {
		return EnglishLeaningType;
	}

	/**
	 * @param englishLeaningType the englishLeaningType to set
	 */
	public void setEnglishLeaningType(String englishLeaningType) {
		EnglishLeaningType = englishLeaningType;
	}

	/**
	 * @return the computerScienceLearningType
	 */
	public String getComputerScienceLearningType() {
		return ComputerScienceLearningType;
	}

	/**
	 * @param computerScienceLearningType the computerScienceLearningType to set
	 */
	public void setComputerScienceLearningType(String computerScienceLearningType) {
		ComputerScienceLearningType = computerScienceLearningType;
	}

	/**
	 * @return the englishCompletedLevels
	 */
	public int getEnglishCompletedLevels() {
		return EnglishCompletedLevels;
	}

	/**
	 * @param englishCompletedLevels the englishCompletedLevels to set
	 */
	public void setEnglishCompletedLevels(int englishCompletedLevels) {
		EnglishCompletedLevels = englishCompletedLevels;
	}

	/**
	 * @return the computerScienceCompletedLevels
	 */
	public int getComputerScienceCompletedLevels() {
		return ComputerScienceCompletedLevels;
	}

	/**
	 * @param computerScienceCompletedLevels the computerScienceCompletedLevels to
	 *                                       set
	 */
	public void setComputerScienceCompletedLevels(int computerScienceCompletedLevels) {
		ComputerScienceCompletedLevels = computerScienceCompletedLevels;
	}

}
