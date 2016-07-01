package com.tcs.wg.planet.weather.naive;

import org.joda.time.DateTime;

/**
 * 
 * This class calculates the atmospheric air pressure based on the hypsometric formula.
 * 
 *   P= P0*(1-0.0065h/(T+.0.0065h+273.15)^5.257)
 *   P0=1013.25 hpa
 *   
 */
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.weather.PressureModel;

/**
 * 
 * This class calculates the atmospheric air pressure based on the hypsometric formula.
 * 
 *   P= P0*(1-0.0065h/(T+.0.0065h+273.15)^5.257)
 *   P0=1013.25 hpa
 *   
 */


public class NaivePressureModel implements PressureModel {

	/**
	 * This method calculates the pressure using hypsothermal pressure equation.
	 * P=P0*(1-(h*.0065/(h+temperature+273.15)^5.257) It uses the temperature of
	 * the environment and the elevation to generate the pressure value.
	 * 
	 */
	Double p0 = 1013.25;

	@Override
	public Double getPressure(DateTime time, Environment env) {
		Double elevationFactor = 0.0065 * env.getElevation();
		Double pressure = p0
				* Math.pow((1 - elevationFactor
						/ (env.getTemperature() + elevationFactor + 273.15)),
						5.257);
		return pressure;
	}

}