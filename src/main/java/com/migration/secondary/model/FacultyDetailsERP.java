package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "facultydetails")
public class FacultyDetailsERP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "sr_no")
	private String srNo;

	@Id
	@Column(name = "empcode")
	private String empCode;

	@Column(name = "user_role")
	private String userRole;

	@Column(name = "level")
	private String level;

	@Column(name = "course")
	private String course;

	@Column(name = "department")
	private String department;

	@Column(name = "faculty_name")
	private String facultyName;

	@Column(name = "contact_number")
	private String contactNumber;

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

	@Column(name = "total_working_months")
	private String totalWorkingMonths;

	@Column(name = "research_experience")
	private String researchExperience;

	@Column(name = "subjectsHandled")
	private String subjectsHandled;

	@Column(name = "experienceRemarks")
	private String experienceRemarks;

	@Column(name = "highest_qualification")
	private String highestQualification;

	@Column(name = "photo_file_name")
	private String photoFileName;

	@Column(name = "photo_path")
	private String photoPath;

	@Column(name = "faculty_designation")
	private String facultyDesignation;

	@Column(name = "faculty_type")
	private String facultyType;

	@Column(name = "grade")
	private String grade;

	@Column(name = "uan_number")
	private String uanNumber;

	@Column(name = "pf_member_id")
	private String pfMemberId;

	@Column(name = "employee_exist_date")
	private String employeeExistDate;

	@Column(name = "employee_join_date")
	private String employeeJoinDate;

	@Column(name = "pan_number")
	private String panNumber;

	@Column(name = "short_name")
	private String shortName;

	@Column(name = "door_number")
	private String doorNumber;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "religion")
	private String religion;

	@Column(name = "category")
	private String category;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "marriage_date")
	private String marriageDate;

	@Column(name = "appointmentType")
	private String appointmentType;

	@Column(name = "appointment")
	private String appointment;

	@Column(name = "salary_mode")
	private String salaryMode;

	@Column(name = "pay_scale")
	private String payScale;

	@Column(name = "bank_acc_number")
	private String bankAccNumber;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "surname")
	private String surName;

	@Column(name = "ifsc_code")
	private String ifscCode;

	@Column(name = "rtgs_no")
	private String rtgsNo;

	@Column(name = "ssc_board")
	private String sscBoard;

	@Column(name = "ssc_passing_year")
	private String sscPassingYear;

	@Column(name = "ssc_percentage")
	private String sscPercentage;

	@Column(name = "inter_board")
	private String interBoard;

	@Column(name = "inter_passing_year")
	private String interPassingYear;

	@Column(name = "inter_percentage")
	private String interPercentage;

	@Column(name = "bio_metricdevice_id")
	private String bioMetricDeviceId;

	@Column(name = "shift_id")
	private String shiftId;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "emergency_contact_no")
	private String emergencyContactNumber;

	@Column(name = "certificates_submitted")
	private String certificatesSubmitted;

	@Column(name = "designation_type")
	private String designationType;

}
