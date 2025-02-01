package com.migration.examcell.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.migration.constants.MigrationConstants;
import com.migration.constants.ObjectMapperInstance;
import com.migration.exceptionhandler.ResponseExceptionObject;
import com.migration.primary.model.CourseMasterEC;
import com.migration.primary.model.DegreeAndProgramMaintenanceEC;
import com.migration.primary.model.FacultyDetailsEC;
import com.migration.primary.repository.CourseMasterRepoEC;
import com.migration.primary.repository.DegreeAndProgramMaintenanceRepoEC;
import com.migration.primary.repository.FacultyDetailsRepoEC;
import com.migration.secondary.model.CourseMasterERP;
import com.migration.secondary.model.CourseMasterPrimaryKeyERP;
import com.migration.secondary.model.DegreeAndProgramMaintenanceERP;
import com.migration.secondary.model.DegreeProgramPrimaryKeyERP;
import com.migration.secondary.model.FacultyDetailsERP;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceServiceEC {

	@Autowired
	private DegreeAndProgramMaintenanceRepoEC degreeAndProgramMaintenanceRepo;

	@Autowired
	private CourseMasterRepoEC courseMasterRepoEC;

	@Autowired
	private FacultyDetailsRepoEC facultyDetailsRepoEC;

	/**
	 * switch case to differenced the maintenance details .
	 * 
	 * @param allParams
	 * @return
	 */
	public Object maintenance(Map<String, String> allParams) {

		return switch (allParams.get("type").toLowerCase()) {
		case MigrationConstants.DEGREE: {
			yield degreeDetails(allParams);
		}
		case MigrationConstants.COURSE: {
			yield courseDetails(allParams);
		}
		case MigrationConstants.FACULTY: {
			yield facultyDetails(allParams);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + allParams.get("type"));
		};
	}

	/**
	 * getting data form exam cell and mapping to the erp model class
	 * 
	 * @param allParams
	 * @return
	 */
	private Object degreeDetails(Map<String, String> allParams) {
		List<DegreeAndProgramMaintenanceEC> degreeDataOfEC = degreeAndProgramMaintenanceRepo
				.getByRegulationAndbatch(allParams.get("regulation"), allParams.get("batch"));
		try {
			log.info("the data from db is ===>" + ObjectMapperInstance.instance().writeValueAsString(degreeDataOfEC));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (degreeDataOfEC == null || degreeDataOfEC.isEmpty()) {
			throw new ResponseExceptionObject("Data not present for the given criteria", HttpStatus.BAD_REQUEST);
		}
		return degreeDataMappingECtoERP(degreeDataOfEC);
	}

	private Object facultyDetails(Map<String, String> allParams) {
		List<FacultyDetailsEC> findAllFacultyDetails = facultyDetailsRepoEC.findAll();
		try {
			log.info("the data from db is ===>"
					+ ObjectMapperInstance.instance().writeValueAsString(findAllFacultyDetails));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (findAllFacultyDetails == null || findAllFacultyDetails.isEmpty()) {
			throw new ResponseExceptionObject("Data not present for the given criteria", HttpStatus.BAD_REQUEST);
		}
		return facultyDetailsMapping(findAllFacultyDetails);
	}

	private Object facultyDetailsMapping(List<FacultyDetailsEC> findAllFacultyDetails) {
		return findAllFacultyDetails.stream().map(singleData -> {
			FacultyDetailsERP facultyDetailsERP = new FacultyDetailsERP();

			facultyDetailsERP.setAddress(singleData.getAddress());
			facultyDetailsERP.setAdharNumber(singleData.getAdharNumber());
			facultyDetailsERP.setAlternateNo(singleData.getAlternateNo());
			facultyDetailsERP.setContactNumber(singleData.getContactNumber());
			facultyDetailsERP.setDateOfBirth(singleData.getDateOfBirth());
			facultyDetailsERP.setDepartment(singleData.getDepartment());
			facultyDetailsERP.setDistrict(singleData.getDistrict());
			facultyDetailsERP.setEmailId(singleData.getEmailId());
			facultyDetailsERP.setEmpCode(singleData.getEmpCode());
			facultyDetailsERP.setExperience(singleData.getExperience());
			facultyDetailsERP.setFacultyDesignation(singleData.getFacultyDesignation());
			facultyDetailsERP.setFacultyName(singleData.getFacultyName());
			facultyDetailsERP.setFatherFullName(singleData.getFatherFullName());
			facultyDetailsERP.setGender(singleData.getGender());
			facultyDetailsERP.setHighestQualification(singleData.getHighestQualification());
			facultyDetailsERP.setMotherName(singleData.getMotherName());
			facultyDetailsERP.setPhotoFileName(singleData.getPhotoFileName());
			facultyDetailsERP.setPhotoPath(singleData.getPhotoPath());
			facultyDetailsERP.setState(singleData.getState());

			return facultyDetailsERP;
		}).collect(Collectors.toList());
	}

	private Object courseDetails(Map<String, String> allParams) {
		List<CourseMasterEC> byBatchProgramAndSemester = courseMasterRepoEC.getByBatchProgramAndSemester(
				allParams.get("batch"), allParams.get("degree"), allParams.get("branch"), allParams.get("semester"));
		try {
			log.info("the data from db is ===>"
					+ ObjectMapperInstance.instance().writeValueAsString(byBatchProgramAndSemester));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (byBatchProgramAndSemester == null || byBatchProgramAndSemester.isEmpty()) {
			throw new ResponseExceptionObject("Data not present for the given criteria", HttpStatus.BAD_REQUEST);
		}
		return courseDetailsMapping(byBatchProgramAndSemester);
	}

	private List<CourseMasterERP> courseDetailsMapping(List<CourseMasterEC> byBatchProgramAndSemester) {
		return byBatchProgramAndSemester.stream().map(singleEcData -> {
			CourseMasterERP courseMasterERP = new CourseMasterERP();
			CourseMasterPrimaryKeyERP courseMasterPrimaryKeyERP = new CourseMasterPrimaryKeyERP();

			courseMasterPrimaryKeyERP.setBatch(singleEcData.getCourseMasterPrimaryKey().getBatch());
			courseMasterPrimaryKeyERP.setDegree(singleEcData.getCourseMasterPrimaryKey().getDegree());
			courseMasterPrimaryKeyERP.setLevel(singleEcData.getCourseMasterPrimaryKey().getLevel());
			courseMasterPrimaryKeyERP.setName(singleEcData.getCourseMasterPrimaryKey().getName());
			courseMasterPrimaryKeyERP.setPrograme(singleEcData.getCourseMasterPrimaryKey().getPrograme());
			courseMasterPrimaryKeyERP.setSemester(singleEcData.getCourseMasterPrimaryKey().getSemester());
			courseMasterPrimaryKeyERP.setSubcodeforInt(singleEcData.getCourseMasterPrimaryKey().getSubcodeforInt());

			courseMasterERP.setCourseMasterPrimaryKey(courseMasterPrimaryKeyERP);
			courseMasterERP.setAdditionalSubject(singleEcData.getAdditionalSubject());
			courseMasterERP.setAdditionalUndergroup(singleEcData.getAdditionalUndergroup());
			courseMasterERP.setAuditCourses(singleEcData.getAuditCourses());
			courseMasterERP.setCredits(singleEcData.getCredits());
			courseMasterERP.setElective(singleEcData.getElective());
			courseMasterERP.setExternalMax(singleEcData.getExternalMax());
			courseMasterERP.setInternalMax(singleEcData.getInternalMax());
			courseMasterERP.setIntExamCode(singleEcData.getIntExamCode());
			courseMasterERP.setOthers(singleEcData.getOthers());
			courseMasterERP.setRefCode(singleEcData.getRefCode());
			courseMasterERP.setRegulation(singleEcData.getRegulation());
			courseMasterERP.setReplacement(singleEcData.getReplacement());
			courseMasterERP.setStudents(singleEcData.getStudents());
			courseMasterERP.setSubject(singleEcData.getSubject());
			courseMasterERP.setSubjectOrder(singleEcData.getSubjectOrder());
			courseMasterERP.setSubjectType(singleEcData.getSubjectType());
			courseMasterERP.setSubOrder(singleEcData.getSubOrder());
			courseMasterERP.setSubUnderElective(singleEcData.getSubUnderElective());
			courseMasterERP.setTag(singleEcData.getTag());
			courseMasterERP.setTotal(singleEcData.getTotal());
			courseMasterERP.setUnderElective(singleEcData.getUnderElective());
			courseMasterERP.setYear(singleEcData.getYear());

			return courseMasterERP;
		}).collect(Collectors.toList());
	}

	private List<DegreeAndProgramMaintenanceERP> degreeDataMappingECtoERP(
			List<DegreeAndProgramMaintenanceEC> degreeDataOfEC) {
		return degreeDataOfEC.stream().map(singleECData -> {
			DegreeAndProgramMaintenanceERP singleERPData = new DegreeAndProgramMaintenanceERP();
			DegreeProgramPrimaryKeyERP degreePKERP = new DegreeProgramPrimaryKeyERP();

			singleERPData.setAcademicYear(singleECData.getAcademicYear());

			degreePKERP.setBatch(singleECData.getDegreeProgramPrimaryKey().getBatch());
			degreePKERP.setDegree(singleECData.getDegreeProgramPrimaryKey().getDegree());
			degreePKERP.setLevel(singleECData.getDegreeProgramPrimaryKey().getLevel());
			degreePKERP.setProgram(singleECData.getDegreeProgramPrimaryKey().getProgram());
			degreePKERP.setRegulationName(singleECData.getDegreeProgramPrimaryKey().getRegulationName());

			singleERPData.setDegreeProgramPrimaryKey(degreePKERP);
			singleERPData.setDisplayName(singleECData.getDisplayName());
			singleERPData.setIntakeIncludingLe(singleECData.getIntakeIncludingLe());
			singleERPData.setProgramCode(singleECData.getProgramCode());
			singleERPData.setSemDuraton(singleECData.getSemDuration());
			singleERPData.setUniversityName(singleECData.getUniversityName());

			return singleERPData;
		}).collect(Collectors.toList());
	}

}
