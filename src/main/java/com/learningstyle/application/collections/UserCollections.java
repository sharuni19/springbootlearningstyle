package com.learningstyle.application.collections;

/**
 * 
 */

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

/**
 * @author Administrator
 *
 */
@Document(collection = "UserCollections")
public class UserCollections {
	@Id
	private String id;
	private String FirstName;
	private String LastName;
	private String Degree;
	private String Course;
	private Date DateOfBirth;
	private int Age;
	private String Email;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return Degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		Degree = degree;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return Course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		Course = course;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
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

}
