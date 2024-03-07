package com.antibiotik.logger;

public interface MyLogger {
	void errorLog(String errorMessage, Exception exception);


	void errorLog(String errorMessage);


	void infoLog(String message);

}
