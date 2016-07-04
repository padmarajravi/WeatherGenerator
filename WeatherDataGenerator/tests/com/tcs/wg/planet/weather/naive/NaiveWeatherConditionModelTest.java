package com.tcs.wg.planet.weather.naive;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.WeatherCondition;
import com.tcs.wg.planet.weather.WeatherConditionModel;

public class NaiveWeatherConditionModelTest extends NaiveModelTestBase {

	/**
	 * Tests for sunny weather.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetWeatherCondition_SUNNY() throws WeatherGeneratorException {
		env.setTemperature(32.0);
		env.setPressure(999.0);
		env.setHumidity(.65);
		WeatherCondition expectedCondition = WeatherCondition.SUNNY;
		WeatherConditionModel weatherModel = new NaiveWeatherConditionModel();
		assertEquals(expectedCondition, weatherModel.getWeatherCondition(date, env));
	}

	/**
	 * Tests for RAINY weather.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetWeatherCondition_RAINY() throws WeatherGeneratorException {
		env.setTemperature(32.0);
		env.setPressure(999.0);
		env.setHumidity(.76);
		WeatherConditionModel weatherModel = new NaiveWeatherConditionModel();
		WeatherCondition actualCondition = weatherModel.getWeatherCondition(date, env);
		assertEquals(WeatherCondition.RAINY, actualCondition);
	}

	/**
	 * Test for SNOWY weather.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetWeatherCondition_SNOWY() throws WeatherGeneratorException {
		env.setTemperature(4.0);
		env.setPressure(999.0);
		env.setHumidity(.76);
		WeatherConditionModel weatherModel = new NaiveWeatherConditionModel();
		WeatherCondition actualCondition = weatherModel.getWeatherCondition(date, env);
		assertEquals(WeatherCondition.SNOWY, actualCondition);
	}

}
