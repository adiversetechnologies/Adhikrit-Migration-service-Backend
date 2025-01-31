package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DegreeProgramPrimaryKeyERP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String level;

	private String batch;

	private String degree;

	private String regulationName;
	
	private String program;
}
