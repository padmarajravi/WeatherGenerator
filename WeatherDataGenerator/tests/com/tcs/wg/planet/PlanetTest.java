package com.tcs.wg.planet;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;

public class PlanetTest {

	/**
	 * 
	 * Returns environment object
	 * 
	 * Environment [latitude=-28.811309, longitude=130.341797, elevation=159.0,
	 * distanceToWaterbody=308784.68645676225, distanceToEquator=3201.22454299,
	 * temperature=15.210021888851502, humidity=0.6736123763323371,
	 * pressure=994.3711617150576, condition=SUNNY]
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testGetCurrentReading() throws WeatherGeneratorException {
		Planet planet = new Planet();
		Double latitude = -28.811309;
		Double longitude = 130.341797;
		Double elevation = 159.0;
		Double distanceToWaterbody = 308784.68645676225;
		Double distanceToEquator = 3201.22454299;
		Double temperature = 18.786409294333463;
		Double humidity = 0.6736123763323371;
		Double pressure = 994.3711617150576;
		WeatherCondition condition = WeatherCondition.SUNNY;

		WeatherStation weatherStation = new WeatherStation("STA1", latitude,
				longitude);
		DateTime date = DateTime.parse("22-05-1988 12:00",
				DateTimeFormat.forPattern("dd-MM-yyyy hh:mm"));
		Environment actualResult = planet.getCurrentReading(date,
				weatherStation);
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

	/**
	 * Returns an out of coverage exception since the latitude and logitude is
	 * out of coverage
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test(expected = Exception.class)
	public void testGetCurrentReading_Outofcoverage()
			throws WeatherGeneratorException {
		Planet planet = new Planet();
		Double latitude = -28.811309;
		Double longitude = 46.341797;
		WeatherStation weatherStation = new WeatherStation("STA1", latitude,
				longitude);
		DateTime date = DateTime.parse("22-05-1988 12:00",
				DateTimeFormat.forPattern("dd-MM-yyyy hh:mm"));
		Environment actualResult = planet.getCurrentReading(date,
				weatherStation);

	}

}
