package com.tcs.wg.planet.weather.naive;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.weather.TemperatureModel;

public class NaiveTemperatureModelTest extends NaiveModelTestBase {

	/**
	 * Test for NaiveTemperatureModel for summer season and midnight
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetTemperature_midnight_summer() throws WeatherGeneratorException {

		TemperatureModel tempModel = new NaiveTemperatureModel();
		date = DateTime.parse("22-05-2016 12:00 AM", DateTimeFormat.forPattern(dataFormat));
		expectedTemperature = 19.1;
		assertEquals(expectedTemperature, tempModel.getTemperature(date, env), 2);

	}

	/**
	 * Tests the NaiveTemperatureModel for summer season and morning time.
	 * 
	 * @throws WeatherGeneratorException
	 */

	@Test
	public void testGetTemperature_morning_summer() throws WeatherGeneratorException {

		TemperatureModel tempModel = new NaiveTemperatureModel();
		expectedTemperature = 20.5;
		date = DateTime.parse("22-05-2016 08:00 AM", DateTimeFormat.forPattern(dataFormat));
		assertEquals(expectedTemperature, tempModel.getTemperature(date, env), 2);

	}

	/**
	 * Tests the NaiveTemeprature model for a noon time and summer season.
	 * 
	 * @throws WeatherGeneratorException
	 */

	@Test
	public void testGetTemperature_noon_summer() throws WeatherGeneratorException {

		TemperatureModel tempModel = new NaiveTemperatureModel();
		expectedTemperature = 21.9;
		date = DateTime.parse("22-05-2016 12:00 PM", DateTimeFormat.forPattern(dataFormat));
		assertEquals(expectedTemperature, tempModel.getTemperature(date, env), 2);

	}

	/**
	 * Tests the NaiveTemperature model for noon time and winter.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetTemperature_noon_winter() throws WeatherGeneratorException {

		TemperatureModel tempModel = new NaiveTemperatureModel();
		expectedTemperature = 13.0;
		date = DateTime.parse("22-12-2016 12:00 PM", DateTimeFormat.forPattern(dataFormat));
		assertEquals(expectedTemperature, tempModel.getTemperature(date, env), 2);

	}

	@Test
	public void testGetTemperature_morning_winter() throws WeatherGeneratorException {

		TemperatureModel tempModel = new NaiveTemperatureModel();
		expectedTemperature = 11.5;
		date = DateTime.parse("22-12-2016 12:00 PM", DateTimeFormat.forPattern(dataFormat));
		assertEquals(expectedTemperature, tempModel.getTemperature(date, env), 2);

	}

}
