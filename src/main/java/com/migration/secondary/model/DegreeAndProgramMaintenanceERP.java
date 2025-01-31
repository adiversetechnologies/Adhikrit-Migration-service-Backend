package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "degree_program_maintenance")
public class DegreeAndProgramMaintenanceERP implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DegreeProgramPrimaryKeyERP degreeProgramPrimaryKey;

	private long uniqueKey;

	private String academicYear;

	private String universityName;

	private String programCode;

	private String displayName;

	private String semDuraton;

	private String intakeIncludingLe;

	private String department;

}
