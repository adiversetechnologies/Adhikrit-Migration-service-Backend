package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "course_master")
@Data
public class CourseMasterERP implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CourseMasterPrimaryKeyERP courseMasterPrimaryKey;

	@Column(name = "regulation")
	private String regulation;

	@Column(name = "sub_order")
	private String subOrder;

	@Column(name = "subject")
	private String subject;

	@Column(name = "elective")
	private String elective;

	@Column(name = "students")
	private String students;

	@Column(name = "under_elective")
	private String underElective;

	@Column(name = "tag")
	private String tag;

	@Column(name = "year")
	private String year;

	@Column(name = "credits")
	private String credits;

	@Column(name = "internal_max")
	private String internalMax;

	@Column(name = "external_max")
	private String externalMax;

	@Column(name = "total")
	private String total;

	@Column(name = "subject_type")
	private String subjectType;

	@Column(name = "subject_order")
	private String subjectOrder;

	@Column(name = "audit_courses")
	private String auditCourses;

	@Column(name = "additional_subject")
	private String additionalSubject;

	@Column(name = "additional_undergrop")
	private String additionalUndergroup;

	@Column(name = "others")
	private String others;

	@Column(name = "replacement")
	private String replacement;

	@Column(name = "intexam_code")
	private String intExamCode;

	@Column(name = "refcode")
	private String refCode;

	@Column(name = "sub_underelective")
	private String subUnderElective;

	@Column(name = "current_user_name")
	private String currentUserName;

	@Column(name = "current_user_email")
	private String currentUserEmail;
	
	@Column(name = "current_upload_datetime")
	private String currentUploadDateTime;
	
	@Column(name = "no_of_sessions")
	private String noOfSessions;
	
	@Column(name = "no_of_units")
	private String noOfUnits;
	
	@Column(name = "internal_pass_marks")
	private String internalPassMarks;
	
	@Column(name = "external_pass_marks")
	private String externalPassMarks;
	
	@Column(name = "total_pass_marks")
	private String totalPassMarks;
	
	@Column(name = "display_order")
	private String displayOrder;

	@Column(name = "dept_or_lab")
	private String deptorLab;

	@Column(name = "marks_posting_status")
	private String marksPostingStatus;

}
