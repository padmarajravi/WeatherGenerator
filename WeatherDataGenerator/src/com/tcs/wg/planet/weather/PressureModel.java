package com.tcs.wg.planet.weather;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;

public interface PressureModel {
	
	public Double getPressure(DateTime time,Environment env) throws WeatherGeneratorException;

}
