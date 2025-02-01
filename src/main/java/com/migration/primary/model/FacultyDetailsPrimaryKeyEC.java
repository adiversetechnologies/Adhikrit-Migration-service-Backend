package com.migration.primary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FacultyDetailsPrimaryKeyEC implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "empcode")
	private String empCode;

	@Column(name = "email_id")
	private String emailId;


}
