package com.tcs.wg.planet;

/**
 * 
 * THis class is a value object to hold the details of a particular weather
 * station.
 * 
 * @author 472423
 *
 */

public class WeatherStation {
	String stationCode;
	Double latitude;
	Double longitude;

	/**
	 * COnstructor which takes station code , latitude and longitude as
	 * arguments
	 * 
	 * @param stationCode
	 * @param latitude
	 * @param longitude
	 */
	public WeatherStation(String stationCode, Double latitude, Double longitude) {
		super();
		this.stationCode = stationCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Returns the stationCode of the WeatherStation
	 * 
	 * @return
	 */
	public String getStationCode() {
		return stationCode;
	}

	/**
	 * Sets the station code with the string argument passed.
	 * 
	 * @param stationCode
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	/**
	 * Returns the latitude of the WeatherStation
	 * 
	 * @return
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude of the WeatherStation.
	 * 
	 * @param latitude
	 * @return
	 */
	public WeatherStation setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	/**
	 * Returns the longitude of the weather station as Double.
	 * 
	 * @return
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude of the WeatherStation.
	 * 
	 * @param longitude
	 * @return
	 */
	public WeatherStation setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	/**
	 * Overrides the default toString method.
	 */
	@Override
	public String toString() {
		return "WeatherStation [stationCode=" + stationCode + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}

}
