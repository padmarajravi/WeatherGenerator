package com.tcs.wg.planet.weather.naive;

import org.joda.time.DateTime;

import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.weather.HumidityModel;

public class NaiveHumidityModel implements HumidityModel {

	/**
	 * 
	 * THis class calculates the humididty based on temperature and closeness to
	 * ocean. Temperature increases the saturated vapor pressure which is
	 * governed by equation VD=5.018 + .3231*TC+ 8.1847 *10 ^-3 * TC ^2
	 * (Reference :
	 * http://hyperphysics.phy-astr.gsu.edu/hbase/kinetic/relhum.html).Actual
	 * vapor density is calculated as an approximate measure of closeness to
	 * sea. Actual vapor density calculation is based on the assumption that
	 * oceans have a relative humidity of 80 %. A proportionate decrease
	 * (Decided by factor distanceToWaterVaporDensityGradient) is made in the
	 * ocean water vapor density according to the distance from the ocean. This
	 * parameter was calculated by manual inspection of relative humidity data
	 * from coastal regions and dry places. Alternately , a regression can also
	 * be run to find this parameter.
	 * 
	 * 
	 */
	Double oceanSaturatedvaporDensityProportion = 0.8;
	Double distanceToWaterVaporDensityGradient = .0003;
	Double maxDistanceToWaterToBeCOnsidered = 5000.0;

	@Override
	public Double getHumidity(DateTime time, Environment env) {

		Double saturatedWaterVaporDensity = 5.08 + 0.3231
				* env.getTemperature() + .0081 * env.getTemperature()
				* env.getTemperature();
		Double vaporDensityOverOcean = oceanSaturatedvaporDensityProportion
				* saturatedWaterVaporDensity;
		Double distanceToWaterToBeConsidered = (env.getDistanceToWaterBody() > maxDistanceToWaterToBeCOnsidered) ? maxDistanceToWaterToBeCOnsidered
				: env.getDistanceToWaterBody();
		
		Double actualVaporDensity = vaporDensityOverOcean
				- distanceToWaterToBeConsidered
				* distanceToWaterVaporDensityGradient;
		return actualVaporDensity / saturatedWaterVaporDensity;

	}

}