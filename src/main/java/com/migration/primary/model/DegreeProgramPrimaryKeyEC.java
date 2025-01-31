package com.migration.primary.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DegreeProgramPrimaryKeyEC implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String level;

	private String batch;

	private String degree;

	private String regulationName;

	private String program;

}
