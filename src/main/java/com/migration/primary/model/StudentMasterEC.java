package com.migration.primary.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_master")
@Data
public class StudentMasterEC implements Serializable {
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

	@Column(name = "student")
	private String student;

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

	@Column(name = "door_no1")
	private String doorNo1;

	@Column(name = "street_no1")
	private String streetNo1;

	@Column(name = "village1")
	private String village1;

	@Column(name = "mandal1")
	private String mandal1;

	@Column(name = "district1")
	private String district1;

	@Column(name = "state1")
	private String state1;

	@Column(name = "pincode1")
	private String pincode1;

	@Column(name = "identification_marks1")
	private String identificationMarks1;

	@Column(name = "identification_marks2")
	private String identificationMarks2;

	@Column(name = "adhar_no")
	private String adharNo;

	@Column(name = "castecategory")
	private String casteCategory;

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

	@Column(name = "detention_reason")
	private String detentionReason;

	@Column(name = "pctracking_no")
	private String pctrackingNo;

	@Column(name = "cmmtracking_no")
	private String cmmtrackingNo;

	@Column(name = "current_user_name")
	private String currentUserName;

	@Column(name = "current_user_email")
	private String currentUserEmail;

	@Column(name = "current_upload_datetime")
	private String currentUploadDateTime;

	@Column(name = "studied_board10th")
	private String studied_board10th;

	@Column(name = "grade_percentage10th")
	private String grade_percentage10th;

	@Column(name = "sshtno")
	private String sshtno;

	@Column(name = "intermarks")
	private String intermarks;

	@Column(name = "inter_htno")
	private String inter_htno;

	@Column(name = "parent_occupation")
	private String parentOccupation;

	@Column(name = "institutionlaststudied")
	private String institutionlaststudied;

	@Column(name = "universitybelongsto")
	private String universitybelongsto;

	@Column(name = "tuitionfees")
	private String tuitionfees;

	@Column(name = "ug_htno")
	private String ughtno;

	@Column(name = "ug_marks")
	private String ugmarks;

	@Column(name = "semester_start_date")
	private String semesterStartDate;

	@Column(name = "abc_id")
	private String abcId;

	@Column(name = "student_adhar_name")
	private String StudentAdharName;

	@Column(name = "father_adhar_no")
	private String fatherAdharNo;

	@Column(name = "mother_adhar_no")
	private String motherAdharNo;

}
