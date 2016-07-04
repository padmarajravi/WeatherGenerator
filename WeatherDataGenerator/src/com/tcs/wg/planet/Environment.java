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

	
	/**
	 * Returns the elevation value of the particular environment
	 * @return
	 */
	public Double getElevation() {
		return elevation;
	}
	
	/**
	 * Sets the elevation value
	 * @param elevation
	 */

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	
	/**
	 * 
	 * Gets the distance to the nearest water body in the environment
	 * @return
	 */
	public Double getDistanceToWaterBody() {
		return distanceToWaterbody;
	}

	
	/**
	 * Sets the distance to the nearest water body in the environment
	 * @param distanceToSea
	 */
	public void setDistanceToWaterBody(Double distanceToSea) {
		this.distanceToWaterbody = distanceToSea;
	}

	
	/**
	 * Gets distance to the equator as a double
	 * @return 
	 */
	public Double getDistanceToEquator() {
		return distanceToEquator;
	}

	
	/**
	 * Sets the distance to the equator(distanceToEquator) attribute of environment
	 * @param distanceToEquator
	 */
	public void setDistanceToEquator(Double distanceToEquator) {
		this.distanceToEquator = distanceToEquator;
	}

	
	/**
	 * Returns the latitude as a double value
	 * @return
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	/**
	 * Takes a double input and sets the latitude value
	 * @param latitude
	 */

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	
	/**
	 * Returns the longitude of the environment
	 * @return
	 */
	public Double getLongitude() {
		return longitude;
	}

	
	/**
	 * Sets the double value as the longitude of the environment
	 * @param longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
	/**
	 * Returns the temperature of the environment
	 * @return
	 */
	public Double getTemperature() {
		return temperature;
	}

	
	/**
	 * Sets the temperature of the environment from the Double argument
	 * @param temperature
	 */
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	
	/**
	 * Returns the humidity of the environment
	 * @return
	 */
	public Double getHumidity() {
		return humidity;
	}
	/**
	 * Sets the humidity of the environment from the Double argument
	 * @param humidity
	 */

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	
	/**
	 * Returns the pressure of the environment
	 * @return
	 */
	public Double getPressure() {
		return pressure;
	}
	
	/**
	 * Sets the pressure attribute of the environment from the Double value passed.
	 * @param pressure
	 */

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	
	/**
	 * Gets the weather condition specified by the enum WeatherCondition of the environment
	 * @return
	 */
	public WeatherCondition getCondition() {
		return condition;
	}

	/**
	 * Sets the WeatherCondition attribute by taking a WeatherCondition enum as argument
	 * @param condition
	 */
	public void setCondition(WeatherCondition condition) {
		this.condition = condition;
	}

	/**
	 * To string method to override the default one.
	 */
	@Override
	public String toString() {
		return "Environment [latitude=" + latitude + ", longitude=" + longitude
				+ ", elevation=" + elevation + ", distanceToSea="
				+ distanceToWaterbody + ", distanceToEquator=" + distanceToEquator
				+ ", temperature=" + temperature + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", condition=" + condition + "]";
	}

}
