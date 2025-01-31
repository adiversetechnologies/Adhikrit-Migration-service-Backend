package com.migration.erp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migration.constants.MigrationConstants;
import com.migration.constants.ObjectMapperInstance;
import com.migration.exceptionhandler.ResponseExceptionObject;
import com.migration.primary.model.DegreeAndProgramMaintenanceEC;
import com.migration.primary.model.DegreeProgramPrimaryKeyEC;
import com.migration.secondary.model.DegreeAndProgramMaintenanceERP;
import com.migration.secondary.repository.DegreeAndProgramMaintenanceRepoERP;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceServiceERP {

	@Autowired
	private DegreeAndProgramMaintenanceRepoERP degreeAndProgramMaintenanceRepoERP;

	public Object maintenance(Map<String, String> allParams) {
		return switch (allParams.get("type").toLowerCase()) {
		case  MigrationConstants.DEGREE: {
			yield degreeDetails(allParams);
		}
		default:
			throw new IllegalArgumentException("Unexpected value type is defined or selected : " + allParams.get("type"));
		};
	}

	/**
	 * getting data from erp to the exam cell
	 * 
	 */
	private List<DegreeAndProgramMaintenanceEC> degreeDetails(Map<String, String> allParams) {
		List<DegreeAndProgramMaintenanceERP> byRegulationAndbatch = degreeAndProgramMaintenanceRepoERP
				.getByRegulationAndbatch(allParams.get("regulation"), allParams.get("batch"));
		try {
			log.info("the data from db is ===>"+ ObjectMapperInstance.instance().writeValueAsString(byRegulationAndbatch));
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
