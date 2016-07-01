package com.tcs.wg.planet.dataprovider;

import com.tcs.wg.exception.WeatherGeneratorException;

/**
 * This is an interface to provide data for the planet class. It has methods to
 * get the elevation m distance to water body and distance to equator when a
 * latitude and longitude is given.
 * 
 * @author 472423
 *
 */
public interface DataProvider {

	/**
	 * Implementation should return the elevation of latitude and lontitude
	 * combination given.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return Double
	 * @throws Exception
	 */

	public Double getElevation(Double latitude, Double longitude)
			throws WeatherGeneratorException;

	/**
	 * Implementation should return the distance to the nearest water body of
	 * latitude and lontitude combination given.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return Double
	 * @throws Exception
	 */
	public Double getDistanceToWaterBody(Double latitude, Double longitude)
			throws WeatherGeneratorException;

	/**
	 * Implementation should return the distance to equator of latitude and
	 * lontitude combination given.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return Double
	 * @throws Exception
	 */
	public Double getDistanceToEquator(Double latitude, Double longitude)
			throws WeatherGeneratorException;

}
