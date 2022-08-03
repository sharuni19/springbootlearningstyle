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
@Document(collection = "SubjectLevelCollections")
public class SubjectLevelCollections {
	@Id
	private String id;
	private String Subject;
	private int TotalLevels;

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
	 * @return the subject
	 */
	public String getSubject() {
		return Subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}

	/**
	 * @return the totalLevels
	 */
	public int getTotalLevels() {
		return TotalLevels;
	}

	/**
	 * @param totalLevels the totalLevels to set
	 */
	public void setTotalLevels(int totalLevels) {
		TotalLevels = totalLevels;
	}

}
