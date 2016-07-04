package com.tcs.wg.planet.weather.naive;

import org.joda.time.DateTime;

import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherCondition;
import com.tcs.wg.planet.weather.WeatherConditionModel;

/**
 * This class has methods to determine the weather condition based on parameters
 * like humidity , temperature and pressure.
 * 
 * @author 472423
 *
 */
public class NaiveWeatherConditionModel implements WeatherConditionModel {

	Double rainPressureLimit = 990.0;
	Double rainHumidityLimit = .70;
	Double rainTempLimit = 10.0;

	/**
	 * Returns the weather conditon based on humidity , temperature and
	 * pressure. If the pressure and humidity are more than predefined levels ,
	 * it assigns "cloudy" as the weather condition on a 50 pc probablity level.
	 * In the other case it assigns RAINY. If the temperature is below a
	 * predefined limit , it assigns snowy instead of rainy.
	 */

	@Override
	public WeatherCondition getWeatherCondition(DateTime time, Environment env) {

		WeatherCondition weatherCOndition = WeatherCondition.SUNNY;
		if (env.getPressure() > rainPressureLimit && env.getHumidity() > rainHumidityLimit) {
			if (env.getTemperature() > rainTempLimit) {
				weatherCOndition = WeatherCondition.RAINY;
			} else {
				weatherCOndition = WeatherCondition.SNOWY;
			}
		}
		return weatherCOndition;

	}

}
