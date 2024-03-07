package com.antibiotik.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger implements MyLogger {

	private final Logger logger;

	public TestLogger(Class<?> loggedClass) {
		logger = LoggerFactory.getLogger(loggedClass);
	}

	@Override
	public void errorLog(String errorMessage, Exception exception) {
		logger.error(errorMessage, exception);
		System.out.println(errorMessage + exception);
	}

	@Override
	public void errorLog(String errorMessage) {
		logger.error(errorMessage);
		System.out.println(errorMessage);
	}

	@Override
	public void infoLog(String message) {
		logger.error(message);
		System.out.println(message);
	}
}
