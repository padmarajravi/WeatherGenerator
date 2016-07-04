package com.tcs.wg.planet.dataprovider;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileBasedProviderTest {

	/**
	 * Tests the getElevationMethod.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgetElevation() throws Exception {

		DataProvider dataProvider = new FileBasedDataProvider();
		Double actualValue = dataProvider.getElevation(-30.794071, 130.693359);
		assertEquals("The elevation should be equal to 378 meters", 378.0, actualValue, 0.0);

	}

	/**
	 * tests he getDistanceToEquator method.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgetDistanceToEquator() throws Exception {

		DataProvider dataProvider = new FileBasedDataProvider();
		Double actualValue = dataProvider.getDistanceToEquator(-30.794071, 130.693359);
		assertEquals("Distance to equator should be 3421.52922881", 3421.52922881, actualValue, 0.0);

	}

	/**
	 * Tests the getDistanceToWaterBody method.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgetDistanceToWaterBody() throws Exception {

		DataProvider dataProvider = new FileBasedDataProvider();
		Double actualValue = dataProvider.getDistanceToWaterBody(-30.794071, 130.693359);
		assertEquals("Distance to water body should be 89715.70254764929", 89715.70254764929, actualValue, 0.0);

	}

}
