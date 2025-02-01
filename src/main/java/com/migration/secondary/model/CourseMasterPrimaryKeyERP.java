package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CourseMasterPrimaryKeyERP implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "degree")
	private String degree;

	@Column(name = "programe")
	private String programe;

	@Column(name = "semester")
	private String semester;
	
	@Column(name = "batch")
	private String batch;
	
	@Column(name = "subcode_forint")
	private String subcodeforInt;

	@Column(name = "subject_name")
	private String name;

}
