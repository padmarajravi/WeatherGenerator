package com.tcs.wg.planet;

/**
 * 
 * This class is a value object to hold geographic, topographic and weather
 * details of a time space instant.
 * 
 * @author 472423
 *
 */
public class Environment {

	Double latitude;
	Double longitude;
	Double elevation;
	Double distanceToWaterbody;
	Double distanceToEquator;
	Double temperature;
	Double humidity;
	Double pressure;
	WeatherCondition condition;

	public Double getElevation() {
		return elevation;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public Double getDistanceToWaterBody() {
		return distanceToWaterbody;
	}

	public void setDistanceToWaterBody(Double distanceToSea) {
		this.distanceToWaterbody = distanceToSea;
	}

	public Double getDistanceToEquator() {
		return distanceToEquator;
	}

	public void setDistanceToEquator(Double distanceToEquator) {
		this.distanceToEquator = distanceToEquator;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	public WeatherCondition getCondition() {
		return condition;
	}

	public void setCondition(WeatherCondition condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "Environment [latitude=" + latitude + ", longitude=" + longitude
				+ ", elevation=" + elevation + ", distanceToSea="
				+ distanceToWaterbody + ", distanceToEquator=" + distanceToEquator
				+ ", temperature=" + temperature + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", condition=" + condition + "]";
	}

}
