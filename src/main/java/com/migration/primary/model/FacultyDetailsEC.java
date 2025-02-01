package com.migration.primary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "facultydetails")
@IdClass(FacultyDetailsPrimaryKeyEC.class)
@Data
public class FacultyDetailsEC  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "sr_no")
	private String srNo;

	@Id
	@Column(name = "empcode")
	private String empCode;

	@Column(name = "department")
	private String department;

	@Column(name = "faculty_name")
	private String facultyName;

	@Column(name = "contact_number")
	private String contactNumber;

	@Id
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "adhar_number")
	private String adharNumber;

	@Column(name = "father_full_name")
	private String fatherFullName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "alternate_mobile_number")
	private String alternateNo;

	@Column(name = "address")
	private String address;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "experience")
	private String experience;

	@Column(name = "highest_qualification")
	private String highestQualification;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "photo_file_name")
	private String photoFileName;
	
	@Column(name = "photo_path")
	private String photoPath;
	
	@Column(name = "faculty_designation")
	private String facultyDesignation;
	

}
