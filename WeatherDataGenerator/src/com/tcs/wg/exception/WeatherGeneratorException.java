package com.tcs.wg.exception;

public class WeatherGeneratorException extends Exception {

	/**
	 * Exception class for wrapping all the exceptions thrown by
	 * WeatherDataGenerator
	 */
	private static final long serialVersionUID = 1L;

	public WeatherGeneratorException(String message) {
		super(message);
	}

}
