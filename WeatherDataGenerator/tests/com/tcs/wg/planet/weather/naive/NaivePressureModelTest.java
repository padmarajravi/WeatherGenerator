package com.tcs.wg.planet.weather.naive;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.weather.PressureModel;

public class NaivePressureModelTest extends NaiveModelTestBase {

	/**
	 * Tests the NaivePressureModel for a place with low altitude and low
	 * temperature.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testgetPressure_LowAltitudeLowTemeperature() throws WeatherGeneratorException {
		env.setTemperature(13.0);
		env.setElevation(200.0);
		PressureModel pressureModel = new NaivePressureModel();
		assertEquals(989, pressureModel.getPressure(date, env), 1);
	}

	/**
	 * Tests the NaivePressureModel for a place with high altitude and low
	 * temperature.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testgetPressure_HighAltitudeLowTemeperature() throws WeatherGeneratorException {
		env.setTemperature(13.0);
		env.setElevation(1000.0);
		PressureModel pressureModel = new NaivePressureModel();
		assertEquals(900, pressureModel.getPressure(date, env), 1);
	}

	/**
	 * Tests the NaivePressureModel for a place with high altitude and high
	 * temperature
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testgetPressure_HighAltitudeHighTemeperature() throws WeatherGeneratorException {
		env.setTemperature(26.0);
		env.setElevation(1000.0);
		PressureModel pressureModel = new NaivePressureModel();
		assertEquals(904, pressureModel.getPressure(date, env), 1);
	}

	/**
	 * Tests the NaivePressureModel for a place with low altitude and high
	 * temperature.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testgetPressure_LowAltitudeHighTemeperature() throws WeatherGeneratorException {
		env.setTemperature(34.0);
		env.setElevation(200.0);
		PressureModel pressureModel = new NaivePressureModel();
		assertEquals(991, pressureModel.getPressure(date, env), 1);
	}

}
