package com.tcs.wg.planet.weather.naive;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.weather.HumidityModel;

public class NaiveHumidityModelTest extends NaiveModelTestBase{

	@Test
	public void testGetHumidity_CoastalRegion() throws WeatherGeneratorException {
		HumidityModel humMode=new NaiveHumidityModel();
		env.setTemperature(16.0);
		env.setDistanceToWaterBody(50.0);
		assertEquals(80, humMode.getHumidity(date, env),1);
	}
	
	@Test
	public void testGetHumidity_coastal_hightemperature() throws WeatherGeneratorException {
		HumidityModel humMode=new NaiveHumidityModel();
		env.setTemperature(40.0);
		env.setDistanceToWaterBody(5000.0);
		assertEquals(75, humMode.getHumidity(date, env),1);
	}
	
	@Test
	public void testGetHumidity_dryRegion() throws WeatherGeneratorException {
		HumidityModel humMode=new NaiveHumidityModel();
		env.setTemperature(16.0);
		env.setDistanceToWaterBody(5000.0);
		assertEquals(67, humMode.getHumidity(date, env),1);
	}
	
	

}
