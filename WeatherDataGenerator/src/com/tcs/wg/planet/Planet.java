package com.tcs.wg.planet;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.dataprovider.DataProvider;
import com.tcs.wg.planet.dataprovider.FileBasedDataProvider;
import com.tcs.wg.planet.weather.WeatherGod;

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
	WeatherGod weatherGod;

	public Planet() throws WeatherGeneratorException
	{
		dataProvider=new FileBasedDataProvider();
		weatherGod=new WeatherGod();
	}
	
	public Environment getEnvironment(Double latitude, Double longitude) {
		return new Environment();
	}

	public Planet setDataProvider(DataProvider provider) {
		this.dataProvider = provider;
		return this;
	}

	public DataProvider getDataProvider() {
		return this.dataProvider;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeatherGod getWeatherGod() {
		return weatherGod;
	}

	public void setWeatherGod(WeatherGod weatherGod) {
		this.weatherGod = weatherGod;
	}

	public Environment getCurrentReading(DateTime time,WeatherStation weatherStation) throws WeatherGeneratorException {
		Environment env = new Environment();
		Double lat=weatherStation.getLatitude();
		Double lon=weatherStation.getLongitude();
		env.setLatitude(lat);
		env.setLongitude(lon);
		env.setElevation(dataProvider.getElevation(lat, lon));
		env.setDistanceToWaterBody(dataProvider.getDistanceToWaterBody(lat, lon));
		env.setDistanceToEquator(dataProvider.getDistanceToEquator(lat, lon));
		return weatherGod.getCurrentEnvironment(time, env);

	}

}
