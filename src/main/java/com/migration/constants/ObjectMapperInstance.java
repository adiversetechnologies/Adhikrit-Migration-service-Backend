package com.migration.constants;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ObjectMapperInstance {

	private static volatile ObjectMapper singletonObj;

	public static ObjectMapper instance() {
		if (singletonObj == null) {
			singletonObj = new ObjectMapper();
		}
		return singletonObj;
	}

}
