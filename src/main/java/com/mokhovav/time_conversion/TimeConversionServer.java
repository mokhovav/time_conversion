package com.mokhovav.time_conversion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeConversionServer {
	private static final Logger logger = LogManager.getLogger();
	private static final Marker ADMIN_USER = MarkerManager.getMarker("ADMIN");

	public static void main(String[] args) {
		SpringApplication.run(TimeConversionServer.class, args);
		logger.info(ADMIN_USER, "Admin actions are triggered");
	}

}
