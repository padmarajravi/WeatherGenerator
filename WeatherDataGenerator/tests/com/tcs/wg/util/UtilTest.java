package com.tcs.wg.util;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherCondition;
import com.tcs.wg.planet.WeatherStation;
import com.tcs.wg.planet.weather.WeatherProvider;

public class UtilTest {

	final String dataFormat = "dd-MM-yyyy hh:mm a";
	Environment env;
	DateTime date;
	Double expectedTemperature;
	Double humidity;
	Double pressure;
	WeatherCondition condition;

	/**
	 * Init method to initialize with an Environment instance.
	 */

	@Before
	public void init() {
		Double latitude = -28.811309;
		Double longitude = 130.341797;
		Double elevation = 159.0;
		Double distanceToWaterbody = 308784.68645676225;
		Double distanceToEquator = 3201.22454299;
		expectedTemperature = 15.210021888851502;
		humidity = 0.6736123763323371;
		pressure = 994.3711617150576;
		condition = WeatherCondition.SUNNY;
		WeatherProvider weatherGen = new WeatherProvider();
		env = new Environment();
		env.setLatitude(latitude);
		env.setLongitude(longitude);
		env.setElevation(elevation);
		env.setDistanceToEquator(distanceToEquator);
		env.setDistanceToWaterBody(distanceToWaterbody);
		env.setTemperature(21.993804095280275);
		env.setPressure(1013.25);
		env.setHumidity(0.7068576964443403);
		env.setCondition(WeatherCondition.RAINY);

	}

	/**
	 * Tests the createRecord method with instances of Environment ,
	 * WeatherStation and DateTime classes.
	 */

	@Test
	public void testCreateRecord() {
		String expectedString = "WST9|-28.811309,130.341797,159.0|2016-05-22T12:00:00.000+05:30|21.993804095280275|1013.25|0.7068576964443403|RAINY";
		WeatherStation station = new WeatherStation("WST9", -25.844724, 118.212891);
		DateTime time = DateTime.parse("22-05-2016 12:00 PM", DateTimeFormat.forPattern("dd-MM-yyyy hh:mm a"));
		String actualString = Util.createRecord(time, station, env);
		assertEquals(expectedString, actualString);

	}

	/**
	 * Tests the loadWeatherStationDetails method with a test input file at
	 * data/tests/test_util_load_station.txt
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Test
	public void testLoadWeatherStationDetails() throws WeatherGeneratorException {
		Set<WeatherStation> stationSet = new HashSet<WeatherStation>();
		stationSet.add(new WeatherStation("WST1", -33.911759, 118.037109));
		stationSet.add(new WeatherStation("WST2", -32.143371, 124.013672));
		Set<WeatherStation> actualSet = Util.loadWeatherStationDetails("data/tests/test_util_load_station.txt");
		assertEquals(actualSet.toString(), stationSet.toString());
	}

}
