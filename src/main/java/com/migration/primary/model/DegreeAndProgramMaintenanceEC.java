package com.migration.primary.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "degree_program_maintenance")
public class DegreeAndProgramMaintenanceEC implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DegreeProgramPrimaryKeyEC degreeProgramPrimaryKey;

	private String academicYear;

	private String universityName;

	private String programCode;

	private String displayName;

	private String semDuration;

	private String intakeIncludingLe;

}
