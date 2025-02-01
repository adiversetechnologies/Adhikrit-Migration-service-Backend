package com.migration.examcell.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.migration.examcell.service.MaintenanceServiceEC;
import com.migration.exceptionhandler.ResponseExceptionObject;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class MaintenanceControllerEC {

	@Autowired
	private MaintenanceServiceEC maintenanceServiceEC;

	@GetMapping("/maintenance/detailsfromexamcell")
	public ResponseEntity<Object> degreeDetailsFromExamcell(@RequestParam Map<String, String> allParams) {
		Object responseObject;
		try {
			responseObject = maintenanceServiceEC.maintenance(allParams);
			return ResponseEntity.status(HttpStatus.OK).body(responseObject);
		} catch (ResponseExceptionObject e) {
			log.error("Error ==>", e);
			return ResponseEntity.status(e.getStatus()).body(e.getError());
		} catch (IllegalArgumentException e) {
			log.error("Error ==>", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			log.error("Error ===>", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
