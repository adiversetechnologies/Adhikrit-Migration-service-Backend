package com.migration.erp.service;

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
import com.migration.primary.model.CourseMasterPrimaryKeyEC;
import com.migration.primary.model.DegreeAndProgramMaintenanceEC;
import com.migration.primary.model.DegreeProgramPrimaryKeyEC;
import com.migration.primary.model.FacultyDetailsEC;
import com.migration.secondary.model.CourseMasterERP;
import com.migration.secondary.model.DegreeAndProgramMaintenanceERP;
import com.migration.secondary.model.FacultyDetailsERP;
import com.migration.secondary.repository.CourseMasterRepoERP;
import com.migration.secondary.repository.DegreeAndProgramMaintenanceRepoERP;
import com.migration.secondary.repository.FacultyDetailsRepoERP;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceServiceERP {

	@Autowired
	private DegreeAndProgramMaintenanceRepoERP degreeAndProgramMaintenanceRepoERP;

	@Autowired
	private CourseMasterRepoERP courseMasterRepoERP;

	@Autowired
	private FacultyDetailsRepoERP facultyDetailsRepoERP;

	/**
	 * getting data from erp too the exam cell
	 * 
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
			throw new IllegalArgumentException(
					"Unexpected value type is defined or selected : " + allParams.get("type"));
		};
	}

	private Object facultyDetails(Map<String, String> allParams) {
		List<FacultyDetailsERP> findAllFacultyDetails = facultyDetailsRepoERP.findAll();
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

	private List<FacultyDetailsEC> facultyDetailsMapping(List<FacultyDetailsERP> findAllFacultyDetails) {
		return findAllFacultyDetails.stream().map(singleData -> {
			FacultyDetailsEC facultyDetailsEC = new FacultyDetailsEC();

			facultyDetailsEC.setAddress(singleData.getAddress());
			facultyDetailsEC.setAdharNumber(singleData.getAdharNumber());
			facultyDetailsEC.setAlternateNo(singleData.getAlternateNo());
			facultyDetailsEC.setContactNumber(singleData.getContactNumber());
			facultyDetailsEC.setDateOfBirth(singleData.getDateOfBirth());
			facultyDetailsEC.setDepartment(singleData.getDepartment());
			facultyDetailsEC.setDesignation(singleData.getDesignationType());
			facultyDetailsEC.setDistrict(singleData.getDistrict());
			facultyDetailsEC.setEmailId(singleData.getEmailId());
			facultyDetailsEC.setEmpCode(singleData.getEmpCode());
			facultyDetailsEC.setExperience(singleData.getExperience());
			facultyDetailsEC.setFacultyDesignation(singleData.getFacultyDesignation());
			facultyDetailsEC.setFacultyName(singleData.getFacultyName());
			facultyDetailsEC.setFatherFullName(singleData.getFatherFullName());
			facultyDetailsEC.setGender(singleData.getGender());
			facultyDetailsEC.setHighestQualification(singleData.getHighestQualification());
			facultyDetailsEC.setMotherName(singleData.getMotherName());
			facultyDetailsEC.setPhotoFileName(singleData.getPhotoFileName());
			facultyDetailsEC.setPhotoPath(singleData.getPhotoPath());
			facultyDetailsEC.setState(singleData.getState());

			return facultyDetailsEC;
		}).collect(Collectors.toList());
	}

	private Object courseDetails(Map<String, String> allParams) {
		List<CourseMasterERP> byBatchProgramAndSemester = courseMasterRepoERP.getByBatchProgramAndSemester(
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

	private List<CourseMasterEC> courseDetailsMapping(List<CourseMasterERP> byBatchProgramAndSemester) {
		return byBatchProgramAndSemester.stream().map(singleData -> {

			CourseMasterEC courseMasterEC = new CourseMasterEC();
			CourseMasterPrimaryKeyEC courseMasterPrimaryKeyEC = new CourseMasterPrimaryKeyEC();

			courseMasterPrimaryKeyEC.setBatch(singleData.getCourseMasterPrimaryKey().getBatch());
			courseMasterPrimaryKeyEC.setDegree(singleData.getCourseMasterPrimaryKey().getDegree());
			courseMasterPrimaryKeyEC.setLevel(singleData.getCourseMasterPrimaryKey().getLevel());
			courseMasterPrimaryKeyEC.setName(singleData.getCourseMasterPrimaryKey().getName());
			courseMasterPrimaryKeyEC.setPrograme(singleData.getCourseMasterPrimaryKey().getPrograme());
			courseMasterPrimaryKeyEC.setSemester(singleData.getCourseMasterPrimaryKey().getSemester());
			courseMasterPrimaryKeyEC.setSubcodeforInt(singleData.getCourseMasterPrimaryKey().getSubcodeforInt());

			courseMasterEC.setCourseMasterPrimaryKey(courseMasterPrimaryKeyEC);

			courseMasterEC.setAdditionalSubject(singleData.getAdditionalSubject());
			courseMasterEC.setAdditionalUndergroup(singleData.getAdditionalUndergroup());
			courseMasterEC.setAuditCourses(singleData.getAuditCourses());
			courseMasterEC.setCredits(singleData.getCredits());
			courseMasterEC.setElective(singleData.getElective());
			courseMasterEC.setExternalMax(singleData.getExternalMax());
			courseMasterEC.setInternalMax(singleData.getInternalMax());
			courseMasterEC.setIntExamCode(singleData.getIntExamCode());
			courseMasterEC.setOthers(singleData.getOthers());
			courseMasterEC.setRefCode(singleData.getRefCode());
			courseMasterEC.setRegulation(singleData.getRegulation());
			courseMasterEC.setReplacement(singleData.getReplacement());
			courseMasterEC.setStudents(singleData.getStudents());
			courseMasterEC.setSubject(singleData.getSubject());
			courseMasterEC.setSubjectOrder(singleData.getSubjectOrder());
			courseMasterEC.setSubjectType(singleData.getSubjectType());
			courseMasterEC.setSubOrder(singleData.getSubOrder());
			courseMasterEC.setSubUnderElective(singleData.getSubUnderElective());

			return courseMasterEC;
		}).collect(Collectors.toList());
	}

	private List<DegreeAndProgramMaintenanceEC> degreeDetails(Map<String, String> allParams) {
		List<DegreeAndProgramMaintenanceERP> byRegulationAndbatch = degreeAndProgramMaintenanceRepoERP
				.getByRegulationAndbatch(allParams.get("regulation"), allParams.get("batch"));
		try {
			log.info("the data from db is ===>"
					+ ObjectMapperInstance.instance().writeValueAsString(byRegulationAndbatch));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (byRegulationAndbatch == null || byRegulationAndbatch.isEmpty()) {
			throw new ResponseExceptionObject("Data not present for the given criteria", HttpStatus.BAD_REQUEST);
		}
		return degreeDataMappingERPtoEC(byRegulationAndbatch);
	}

	private List<DegreeAndProgramMaintenanceEC> degreeDataMappingERPtoEC(
			List<DegreeAndProgramMaintenanceERP> byRegulationAndbatch) {

		return byRegulationAndbatch.stream().map(singeldata -> {
			DegreeAndProgramMaintenanceEC degreeAndProgramMaintenanceEC = new DegreeAndProgramMaintenanceEC();
			DegreeProgramPrimaryKeyEC degreeProgramPrimaryKeyEC = new DegreeProgramPrimaryKeyEC();

			degreeProgramPrimaryKeyEC.setBatch(singeldata.getDegreeProgramPrimaryKey().getBatch());
			degreeProgramPrimaryKeyEC.setDegree(singeldata.getDegreeProgramPrimaryKey().getDegree());
			degreeProgramPrimaryKeyEC.setLevel(singeldata.getDegreeProgramPrimaryKey().getLevel());
			degreeProgramPrimaryKeyEC.setProgram(singeldata.getDegreeProgramPrimaryKey().getProgram());
			degreeProgramPrimaryKeyEC.setRegulationName(singeldata.getDegreeProgramPrimaryKey().getRegulationName());

			degreeAndProgramMaintenanceEC.setDegreeProgramPrimaryKey(degreeProgramPrimaryKeyEC);
			degreeAndProgramMaintenanceEC.setAcademicYear(singeldata.getAcademicYear());
			degreeAndProgramMaintenanceEC.setDisplayName(singeldata.getDisplayName());
			degreeAndProgramMaintenanceEC.setIntakeIncludingLe(singeldata.getIntakeIncludingLe());
			degreeAndProgramMaintenanceEC.setProgramCode(singeldata.getProgramCode());
			degreeAndProgramMaintenanceEC.setSemDuration(singeldata.getSemDuraton());
			degreeAndProgramMaintenanceEC.setUniversityName(singeldata.getUniversityName());

			return degreeAndProgramMaintenanceEC;
		}).collect(Collectors.toList());

	}

}
