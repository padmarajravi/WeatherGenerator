package com.tcs.wg.planet.weather;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherCondition;

public class WeatherProviderTest {

	/**
	 * 
	 * Tests the getCurrentEnvironment method of WeatherProvider.Thi method returns environment object
	 * 
	 * Environment [latitude=-28.811309, longitude=130.341797, elevation=159.0,
	 * distanceToWaterbody=308784.68645676225, distanceToEquator=3201.22454299,
	 * temperature=15.210021888851502, humidity=69.33913612635517;,
	 * pressure=994.3711617150576, condition=SUNNY]
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetCurrentEnvironment() throws WeatherGeneratorException {
		Double latitude = -28.811309;
		Double longitude = 130.341797;
		Double elevation = 159.0;
		Double distanceToWaterbody = 308784.68645676225;
		Double distanceToEquator = 3201.22454299;
		Double temperature = 19.2;
		Double humidity = 69.33913612635517;
		Double pressure = 994.3711617150576;
		WeatherCondition condition = WeatherCondition.RAINY;
		WeatherProvider weatherGen = new WeatherProvider();
		DateTime date = DateTime.parse("22-05-1988 12:00",
				DateTimeFormat.forPattern("dd-MM-yyyy hh:mm"));
		Environment env = new Environment();
		env.setLatitude(latitude);
		env.setLongitude(longitude);
		env.setElevation(elevation);
		env.setDistanceToEquator(distanceToEquator);
		env.setDistanceToWaterBody(distanceToWaterbody);

		Environment actualResult = weatherGen.getCurrentEnvironment(date, env);
		System.out.println(actualResult.getHumidity());
		assertEquals(latitude, actualResult.getLatitude(), 0);
		assertEquals(longitude, actualResult.getLongitude(), 0);
		assertEquals(elevation, actualResult.getElevation(), 0);
		assertEquals(distanceToWaterbody,
				actualResult.getDistanceToWaterBody(), 0);
		assertEquals(distanceToEquator, actualResult.getDistanceToEquator(), 0);
		assertEquals(temperature, actualResult.getTemperature(), 1);
		assertEquals(humidity, actualResult.getHumidity(), 1);
		assertEquals(pressure, actualResult.getPressure(), 1);
		assertEquals(condition, actualResult.getCondition());

	}

	

}
