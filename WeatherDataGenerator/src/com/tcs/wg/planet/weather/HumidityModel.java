package com.tcs.wg.planet.weather;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;


/**
 * This interface has methods to 
 * @author 472423
 *
 */
public interface HumidityModel {
	
	public Double getHumidity(DateTime time,Environment env) throws WeatherGeneratorException;

}
