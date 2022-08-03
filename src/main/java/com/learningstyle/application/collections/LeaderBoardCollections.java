package com.learningstyle.application.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LeaderBoardCollections")
public class LeaderBoardCollections {
	@Id
	private String id;
	private String Email;
	private int EnglishActivityPoints;
	private int ComputerScienceActivityPoints;

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
	 * @return the englishActivityPoints
	 */
	public int getEnglishActivityPoints() {
		return EnglishActivityPoints;
	}

	/**
	 * @param englishActivityPoints the englishActivityPoints to set
	 */
	public void setEnglishActivityPoints(int englishActivityPoints) {
		EnglishActivityPoints = englishActivityPoints;
	}

	/**
	 * @return the computerScienceActivityPoints
	 */
	public int getComputerScienceActivityPoints() {
		return ComputerScienceActivityPoints;
	}

	/**
	 * @param computerScienceActivityPoints the computerScienceActivityPoints to set
	 */
	public void setComputerScienceActivityPoints(int computerScienceActivityPoints) {
		ComputerScienceActivityPoints = computerScienceActivityPoints;
	}

}
