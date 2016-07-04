package com.tcs.wg.planet;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.dataprovider.DataProvider;
import com.tcs.wg.planet.dataprovider.FileBasedDataProvider;
import com.tcs.wg.planet.weather.WeatherProvider;

/**
 * 
 * This class has methods that gives weather data for a particular time and
 * space instant. It needs a data provider service which gives details like
 * elevation, distance to sea etc..
 * 
 * @author 472423
 *
 */
public class Planet {
	String name;
	DataProvider dataProvider;
	WeatherProvider weatherProvider;

	/**
	 * Default constructor which intitializes with FileBasedDataProvider and
	 * WeatherDataProvider..
	 * 
	 * @throws WeatherGeneratorException
	 */
	public Planet() throws WeatherGeneratorException {
		dataProvider = new FileBasedDataProvider();
		weatherProvider = new WeatherProvider();
	}

	/**
	 * Sets the dataprovider with an instance of DataProvider interface.
	 * 
	 * @param provider
	 * @return
	 */
	public Planet setDataProvider(DataProvider provider) {
		this.dataProvider = provider;
		return this;
	}

	/**
	 * Returns the dataprovider (Instance of current DataProvider) if any has
	 * been set.
	 * 
	 * @return
	 */
	public DataProvider getDataProvider() {
		return this.dataProvider;
	}

	/**
	 * Returns the name if initialized with.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the planet.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the current WeatherProvider instance that has been set.
	 * 
	 * @return
	 */
	public WeatherProvider getWeatherProvider() {
		return weatherProvider;
	}

	/**
	 * Sets the weatherProvider member with an instance of WeatherProvider.
	 * 
	 * @param weatherGod
	 */
	public void setWeatherProvider(WeatherProvider weatherProvider) {
		this.weatherProvider = weatherProvider;
	}

	/**
	 * Returns the current environment details as an Environment Object .Takse
	 * two arguments - The time as a DateTime object and the weather station
	 * details as a WeatherStation object.
	 * 
	 * @param time
	 * @param weatherStation
	 * @return Environment
	 * @throws WeatherGeneratorException
	 */
	public Environment getCurrentReading(DateTime time, WeatherStation weatherStation)
			throws WeatherGeneratorException {
		Environment env = new Environment();
		Double lat = weatherStation.getLatitude();
		Double lon = weatherStation.getLongitude();
		env.setLatitude(lat);
		env.setLongitude(lon);
		env.setElevation(dataProvider.getElevation(lat, lon));
		env.setDistanceToWaterBody(dataProvider.getDistanceToWaterBody(lat, lon));
		env.setDistanceToEquator(dataProvider.getDistanceToEquator(lat, lon));
		return weatherProvider.getCurrentEnvironment(time, env);

	}

}
