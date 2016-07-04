package com.tcs.wg.planet.weather.naive;

import org.joda.time.DateTime;
import org.junit.Before;

import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherCondition;
import com.tcs.wg.planet.weather.WeatherProvider;

/**
 * Base class for all the naive weather attribute model tests
 * 
 * @author ravi
 *
 */
public class NaiveModelTestBase {

	final String dataFormat = "dd-MM-yyyy hh:mm a";
	Environment env;
	DateTime date;
	Double expectedTemperature;
	Double humidity;
	Double pressure;
	WeatherCondition condition;

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
	}

}
