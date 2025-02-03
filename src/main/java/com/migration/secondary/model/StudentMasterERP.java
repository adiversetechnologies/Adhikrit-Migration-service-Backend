package com.migration.secondary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student_master")
public class StudentMasterERP implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "level")
	private String level;

	@Column(name = "course")
	private String course;

	@Column(name = "branch")
	private String branch;

	@Column(name = "semester")
	private String semester;

	@Column(name = "batch")
	private String batch;

	@Column(name = "student_type")
	private String StudentType;

	@Column(name = "regulation")
	private String regulation;

	@Column(name = "hollticket_no")
	private String hollticketNo;

	@Column(name = "admin_no")
	private String adminNo;

	@Id
	@Column(name = "roll_no")
	private String rollNumber;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "yearof_join")
	private String yearofJoin;

	@Column(name = "admin_date")
	private String adminDate;

	@Column(name = "admission_type")
	private String admissionType;

	@Column(name = "dateof_birth")
	private String dateofBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "parent_mobile_number")
	private String parentMobileNumber;

	@Column(name = "student_mobile_number")
	private String studentMobileNumber;

	@Column(name = "cet_name")
	private String cetName;

	@Column(name = "cet_hollticketno")
	private String cetHollticketno;

	@Column(name = "cet_rank")
	private String cetRank;

	@Column(name = "lateral_no")
	private String lateralNo;

	@Column(name = "admintype_code")
	private String admintypeCode;

	@Column(name = "cetid")
	private String cetid;

	@Column(name = "sub_branch")
	private String subBranch;

	@Column(name = "fee_remib_amount")
	private String feeRemibAmount;

	@Column(name = "temperory_door_no1")
	private String tdoorNo1;

	@Column(name = "temperory_street_no1")
	private String tstreetNo1;

	@Column(name = "temperory_village1")
	private String tvillage1;

	@Column(name = "temperory_mandal1")
	private String tmandal1;

	@Column(name = "temperory_district1")
	private String tdistrict1;

	@Column(name = "temperory_state1")
	private String tstate1;

	@Column(name = "temperory_pincode1")
	private String tpincode1;

	@Column(name = "permanent_door_no1")
	private String pdoorNo1;

	@Column(name = "permanent_street_no1")
	private String pstreetNo1;

	@Column(name = "permanent_village1")
	private String pvillage1;

	@Column(name = "permanent_mandal1")
	private String pmandal1;

	@Column(name = "permanent_district1")
	private String pdistrict1;

	@Column(name = "permanent_state1")
	private String pstate1;

	@Column(name = "permanent_pincode1")
	private String ppincode1;

	@Column(name = "identification_marks1")
	private String identificationMarks1;

	@Column(name = "identification_marks2")
	private String identificationMarks2;

	@Column(name = "adhar_no")
	private String adharNo;

	@Column(name = "castecategory")
	private String casteCategory;

	@Column(name = "sub_caste")
	private String subCastInfo;

	@Column(name = "scholarship")
	private String scholarship;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "status")
	private String status;

	@Column(name = "imagepath")
	private String imagepath;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "studentsign_filename")
	private String studentsignFilename;

	@Column(name = "studentphoto_path")
	private String studentphotoPath;

	@Column(name = "studentphotofile_name")
	private String studentphotofileName;

	@Column(name = "studentsign_path")
	private String studentsignPath;

	@Column(name = "student_biometric")
	private String studentBiometric;

	@Column(name = "biometric_left")
	private String biometricLeft;

	@Column(name = "biometric_right")
	private String biometricRight;

	@Column(name = "biometric_left_path")
	private String biometricLeftPath;

	@Column(name = "biometric_right_path")
	private String biometricRightPath;

	@Column(name = "detainee_status")
	private String detaineeStatus;

	@Column(name = "section_name")
	private String sectionName;

	@Column(name = "completion_year")
	private String completionYear;

	@Column(name = "dateof_leaving")
	private String dateofLeaving;

	@Column(name = "discontinue_date")
	private String discontinueDate;

	@Column(name = "parent_email_id")
	private String parentEmailId;

	@Column(name = "cmmtracking_no")
	private String cmmtrackingNo;

	@Column(name = "pctracking_no")
	private String pctrackingNo;

	// ecap adding columns

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "religion")
	private String religion;

	@Column(name = "mother_tongue")
	private String motherTongue;

	@Column(name = "entrance_type")
	private String entranceType;

	@Column(name = "rank")
	private String rank;

	@Column(name = "joining_date")
	private String joiningDate;

	@Column(name = "seat_type")
	private String seatType;

	@Column(name = "land_line_number")
	private String landLineNumber;

	@Column(name = "distance_from_residence")
	private String distanceFromResidence;

	@Column(name = "bank_account")
	private String bankAccount;

	@Column(name = "ration_card_no")
	private String rationCardNo;

	@Column(name = "phc")
	private String PhysicallyHandicapped;

	@Column(name = "ssc_year_of_pass")
	private String sscYearOfPass;

	@Column(name = "ssc_ht_no")
	private String sscHtNo;

	@Column(name = "ssc_10th_board")
	private String ssc10thBoard;

	@Column(name = "ssc_marks")
	private String sscMarks;

	@Column(name = "ssc_percentage")
	private String sscPercentage;

	@Column(name = "ssc_institution")
	private String sscInstitution;

	@Column(name = "ssc_grade_points")
	private String sscGradePoints;

	@Column(name = "ssc_total_marks")
	private String sscTotalMarks;

	@Column(name = "inter_ht_no")
	private String interHtNo;

	@Column(name = "inter_board")
	private String interBoard;

	@Column(name = "inter_year_of_pass")
	private String interYearOfPass;

	@Column(name = "inter_marks")
	private String interMarks;

	@Column(name = "inter_percentage")
	private String interPercentage;

	@Column(name = "inter_institution")
	private String interInstitution;

	@Column(name = "inter_grade_points")
	private String interGradePoints;

	@Column(name = "inter_total_marks")
	private String interTotalMarks;

	@Column(name = "diploma_hall_ticket_no")
	private String diplomaHallTicketNo;

	@Column(name = "diploma_board")
	private String diplomaBoard;

	@Column(name = "diploma_year_of_pass")
	private String diplomaYearOfPass;

	@Column(name = "diploma_marks")
	private String diplomaMarks;
	
	@Column(name = "diploma_total_marks")
	private String diplomaTotalMarks;

	@Column(name = "diploma_percentage")
	private String diplomaPercentage;

	@Column(name = "diploma_institution")
	private String diplomaInstitution;

	@Column(name = "ug_ht_no")
	private String ugHtNo;

	@Column(name = "degree_board")
	private String degreeBoard;

	@Column(name = "degree_year_of_pass")
	private String degreeYearOfPass;

	@Column(name = "ug_marks")
	private String ugMarks;
	
	@Column(name = "degree_total_marks")
	private String degreeTotalMarks;

	@Column(name = "degree_percentage")
	private String degreePercentage;

	@Column(name = "degree_institution")
	private String degreeInstitution;

	@Column(name = "parent_occupation")
	private String parentOccupation;

	@Column(name = "father_annual_income")
	private String fatherAnnualIncome;

	@Column(name = "mother_occupation")
	private String motherOccupation;

	@Column(name = "mother_mobile_number")
	private String motherMobileNumber;

	@Column(name = "fathe_adhar_no")
	private String fatheAdharNo;

	@Column(name = "mother_adhar_no")
	private String motherAdharNo;

	@Column(name = "previous_study")
	private String previousStudy;

	@Column(name = "class_on_adm")
	private String classOnAdm;

	@Column(name = "dateof_tc_produced")
	private String dateofTcProduced;

	@Column(name = "tc_no")
	private String tcNo;

	@Column(name = "class_on_leaving")
	private String classOnLeaving;

	@Column(name = "leaving_reason")
	private String leavingReason;

	@Column(name = "no_and_dateof_tc")
	private String noAndDateofTc;

	@Column(name = "signature_of_Principal")
	private String signatureOfPrincipal;

	@Column(name = "permanent_address")
	private String permanentAddr;

	
	@Column(name = "temporary_address")
	private String temporaryAddr;

	@Column(name = "sur_name")
	private String surName;

	private String GurdianName;

	private String GurdianPhoneNo;

	private String GurdianAddress;

	private String admissionEntryType;

	private String lastAttendedInstituded;

	private String agent;

	private String distanceHouseToCollege;

	private String isHostler;

	@Column(name = "rejoin_status")
	private String rejoinStatus;

	@Column(name = "status_change_date")
	private String date;

	@Column(name = "detained_by")
	private String detainedBy;


}
