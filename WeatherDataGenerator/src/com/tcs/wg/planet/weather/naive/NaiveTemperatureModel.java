package com.tcs.wg.planet.weather.naive;

import org.joda.time.DateTime;

import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.weather.TemperatureModel;
import com.tcs.wg.util.Constants;

/**
 * 
 * This class has methods to calculate the temperature of a region based on 1)
 * Distance from equator 2) Elevation 3) Day of the year 4) Time of the day
 * 
 * @author 472423
 *
 */
public class NaiveTemperatureModel implements TemperatureModel {

	Double lapseRate = -9.8;
	Double diurnalDecreaseGradientPerhour = 0.25;
	Double diurnalIncreaseGradientPerhour = 0.25;
	Double poleToEquatorHighGradientZone = 3000.0;
	Double poleToEquatorZone1Gradient = 13.0;
	Double poleToEquatorZone2Gradient = 5.0;

	/**
	 * Returns the temerature by considering 1) Distance from equator 2)
	 * Elevation 3) Day of the year 4) Time of the day
	 * 
	 */
	public Double getTemperature(DateTime time, Environment env) {

		Double temperature = -50.0;
		temperature = adjustForPoleToEquatorGradient(temperature, env);
		temperature = adjustForLapseRate(temperature, env);
		temperature = adjustForSeasons(temperature, time);
		temperature = adjustForDiurnalVariation(temperature, time);
		return temperature + Math.random();

	}

	/**
	 * Adjusts for the daily temperature variation by assuming the maximum
	 * temperature time as 3 PM and minimu temperature time as 4 PM.
	 * 
	 * @param temperature
	 * @param time
	 * @return
	 */

	private Double adjustForDiurnalVariation(Double temperature, DateTime time) {
		int maxTempHourofDay = 15;
		int minTempHouyrOfDay = 4;
		int currentHour = time.getHourOfDay();
		if (currentHour > maxTempHourofDay) {
			temperature = temperature + diurnalDecreaseGradientPerhour
					* (currentHour - maxTempHourofDay);
		} else {
			temperature = temperature + diurnalDecreaseGradientPerhour
					* (currentHour - minTempHouyrOfDay);
		}
		return temperature;
	}

	/**
	 * Adjusts for season by adding a constant temperature for different seasons
	 * 
	 * @param temperature
	 * @param time
	 * @return
	 */

	private Double adjustForSeasons(Double temperature, DateTime time) {
		int month = time.getMonthOfYear();
		switch (month) {
		// winter
		case 11:
		case 12:
		case 1:
		case 2:
			return temperature;
			// spring
		case 3:
		case 4:
			return temperature + 5;
			// summer
		case 5:
		case 6:
		case 7:
		case 8:
			return temperature + 10;
		default:
			// autumn
			return temperature + 5;

		}

	}

	/**
	 * Adjusts for the altitude by using the lapse rate equation. Lapse rate is
	 * assumed as -9.8 degree c per 1 km of altitude
	 * 
	 * @param temperature
	 * @param env
	 * @return
	 */

	private Double adjustForLapseRate(Double temperature, Environment env) {
		temperature = temperature - lapseRate * env.getElevation() / 1000;
		return temperature;
	}

	/**
	 * 
	 * Adjusts for pole to equator gradient by multiplying a gradient to the
	 * distanceFrom poles. The gradient is high towards poles and low towards
	 * equator.
	 * 
	 * @param temperature
	 * @param env
	 * @return
	 */
	private Double adjustForPoleToEquatorGradient(Double temperature,
			Environment env) {

		Double distanceFromPoles = Constants.EARTH_RADIUS
				- env.getDistanceToEquator();
		if (distanceFromPoles < poleToEquatorHighGradientZone) {
			temperature = temperature + distanceFromPoles
					* poleToEquatorZone1Gradient / 1000;
		} else {
			//Adjusting for the low gradient towards equator.
			temperature = temperature + poleToEquatorHighGradientZone
					* (poleToEquatorZone1Gradient / 1000)
					+ (distanceFromPoles - poleToEquatorHighGradientZone)
					* (poleToEquatorZone2Gradient / 1000);
		}
		return temperature;
	}

}