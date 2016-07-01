package com.tcs.wg.planet.weather;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherCondition;

public interface WeatherConditionModel {
	
	public WeatherCondition getWeatherCondition(DateTime time,Environment env) throws WeatherGeneratorException;

}
