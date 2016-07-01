package com.tcs.wg.planet;


/**
 * 
 * THis class is a value obbject to hold the details of a particular weather station.
 * @author 472423
 *
 */

public class WeatherStation {
	String stationCode;
	Double latitude;
	Double longitude;

	public WeatherStation(String stationCode, Double latitude, Double longitude) {
		super();
		this.stationCode = stationCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public WeatherStation setLatitude(Double latitude) {
		this.latitude = latitude;
		return this;
	}

	public Double getLongitude() {
		return longitude;
	}

	public WeatherStation setLongitude(Double longitude) {
		this.longitude = longitude;
		return this;
	}

	@Override
	public String toString() {
		return "WeatherStation [stationCode=" + stationCode + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}

	
	
}
