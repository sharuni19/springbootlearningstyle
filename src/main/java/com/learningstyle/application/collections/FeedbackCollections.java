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
@Document(collection = "FeedbackCollections")
public class FeedbackCollections {
	@Id
	private String id;
	private String Email;
	private String Feedback;

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
	 * @return the feedback
	 */
	public String getFeedback() {
		return Feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}

}
