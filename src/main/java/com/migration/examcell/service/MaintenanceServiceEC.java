package com.migration.examcell.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migration.exceptionhandler.ResponseExceptionObject;
import com.migration.primary.model.DegreeAndProgramMaintenanceEC;
import com.migration.primary.repository.DegreeAndProgramMaintenanceRepoEC;
import com.migration.secondary.model.DegreeAndProgramMaintenanceERP;
import com.migration.secondary.model.DegreeProgramPrimaryKeyERP;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceServiceEC {

	@Autowired
	private DegreeAndProgramMaintenanceRepoEC degreeAndProgramMaintenanceRepo;

	/**
	 * switch case to differenced the maintenance details .
	 * @param allParams
	 * @return
	 */
	public Object maintenance(Map<String, String> allParams) {

		return switch (allParams.get("type")) {
		case "degree": {
			yield degreeDetails(allParams);
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
			log.info("the data from db is ===>"+ new ObjectMapper().writeValueAsString(degreeDataOfEC));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (degreeDataOfEC == null || degreeDataOfEC.isEmpty()) {
		    throw new ResponseExceptionObject("Data not present for the given criteria", HttpStatus.BAD_REQUEST);
		}
		return degreeDataMappingECtoERP(degreeDataOfEC);
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
