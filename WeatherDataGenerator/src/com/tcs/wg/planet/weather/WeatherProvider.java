package com.tcs.wg.planet.weather;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.weather.naive.NaiveHumidityModel;
import com.tcs.wg.planet.weather.naive.NaivePressureModel;
import com.tcs.wg.planet.weather.naive.NaiveTemperatureModel;
import com.tcs.wg.planet.weather.naive.NaiveWeatherConditionModel;

/**
 * 
 * This class has methods to create the weather pattern for a particular
 * environment. It uses four models : one for each of the weather attribute to
 * create the weather pattern.
 * 
 * @author 472423
 *
 */
public class WeatherProvider {

	TemperatureModel tempModel;
	HumidityModel humidModel;
	PressureModel pressureModel;
	WeatherConditionModel weatherConditionModel;

	/**
	 * Default constructor which initiliazes the models with
	 * NaiveImplementations.
	 */
	public WeatherProvider() {
		tempModel = new NaiveTemperatureModel();
		humidModel = new NaiveHumidityModel();
		pressureModel = new NaivePressureModel();
		weatherConditionModel = new NaiveWeatherConditionModel();
	}

	/**
	 * Returns the current instance of TemperatureModel in use.
	 * 
	 * @return
	 */
	public TemperatureModel getTempModel() {
		return tempModel;
	}

	/**
	 * Sets the TemperatureModel with the TemepratureModel object.
	 * 
	 * @param tempModel
	 */
	public void setTempModel(TemperatureModel tempModel) {
		this.tempModel = tempModel;
	}

	/**
	 * Returns the current instance of HumidityModel in use.
	 * 
	 * @return
	 */
	public HumidityModel getHumidModel() {
		return humidModel;
	}

	/**
	 * Sets the humidity model with the HumidityModel instance.
	 * 
	 * @param humidModel
	 */
	public void setHumidModel(HumidityModel humidModel) {
		this.humidModel = humidModel;
	}

	/**
	 * Returns the current instance of PressureModel in use.
	 * 
	 * @return
	 */
	public PressureModel getPressureModel() {
		return pressureModel;
	}

	/**
	 * Sets the pressureModel with PressureMode object.
	 * 
	 * @param pressureModel
	 */
	public void setPressureModel(PressureModel pressureModel) {
		this.pressureModel = pressureModel;
	}

	/**
	 * Returns the current instance of WeatherConditionModel in use.
	 * 
	 * @return
	 */

	public WeatherConditionModel getWeatherConditionModel() {
		return weatherConditionModel;
	}

	/**
	 * Sets the WeatherCondition model.
	 * 
	 * @param weatherConditionModel
	 */
	public void setWeatherConditionModel(WeatherConditionModel weatherConditionModel) {
		this.weatherConditionModel = weatherConditionModel;
	}

	/**
	 * Uses the configured models to get the appropriate parameter value and
	 * sets the environment object. It returns the same environment object that
	 * was given as input. It needs the environment object as input since ,some
	 * implementation of the models can use other weather parameters also to
	 * arrive at its result.
	 * 
	 * @param time
	 * @param env
	 * @return Environment
	 */
	public Environment getCurrentEnvironment(DateTime time, Environment env) throws WeatherGeneratorException {

		env.setTemperature(tempModel.getTemperature(time, env));
		env.setHumidity(humidModel.getHumidity(time, env));
		env.setPressure(pressureModel.getPressure(time, env));
		env.setCondition(weatherConditionModel.getWeatherCondition(time, env));
		return env;

	}

}
