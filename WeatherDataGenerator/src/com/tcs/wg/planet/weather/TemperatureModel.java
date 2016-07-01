package com.tcs.wg.planet.weather;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;

public interface TemperatureModel {
	
	public Double getTemperature(DateTime time,Environment env) throws WeatherGeneratorException;

}
