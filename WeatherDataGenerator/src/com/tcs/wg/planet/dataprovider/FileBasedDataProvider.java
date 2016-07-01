package com.tcs.wg.planet.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.gce.gtopo30.GTopo30Reader;
import org.geotools.geometry.DirectPosition2D;
import org.opengis.coverage.CannotEvaluateException;
import org.opengis.feature.simple.SimpleFeature;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class FileBasedDataProvider implements DataProvider {

	File elevationFile;
	File shapeFile;
	GTopo30Reader elevationReader;
	DataStore shapeFileDataStore;

	/**
	 * Initializes by default with elevation file for east 100 degree and south
	 * 10 degree .Throws an out of coverage exception for latitude and longitude
	 * other than this area.
	 * 
	 * @throws IOException
	 */
	public FileBasedDataProvider() throws WeatherGeneratorException {
		File elevationFile = new File("data/elevation/E100S10.DEM");
		try {
			elevationReader = new GTopo30Reader(elevationFile);
			File shapeFIle = new File("data/ocean/ne_50m_ocean.shp");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", shapeFIle.toURI().toURL());
			shapeFileDataStore = DataStoreFinder.getDataStore(map);
		} catch (IOException e) {
			throw new WeatherGeneratorException(e.getMessage());
		}

	}

	public File getElevationFile() {
		return elevationFile;
	}

	public void setElevationFile(File elevationFile) {
		this.elevationFile = elevationFile;
	}

	public File getShapeFile() {
		return shapeFile;
	}

	public void setShapeFile(File shapeFile) {
		this.shapeFile = shapeFile;
	}

	/**
	 * Reads the GTOP30 elevation file and provides the elevation.
	 * 
	 * @throws WeatherGeneratorException
	 */
	@Override
	public Double getElevation(Double latitude, Double longitude)
			throws WeatherGeneratorException {

		int[] objArray;
		try {
			objArray = (int[]) elevationReader.read(null).evaluate(
					new DirectPosition2D(longitude, latitude));
		} catch (CannotEvaluateException | IllegalArgumentException
				| IOException e) {
			throw new WeatherGeneratorException(e.getMessage());
		}
		return Integer.valueOf(objArray[0]).doubleValue();
	}

	/**
	 * 
	 * Reads the ocean shape file from natural earth and provides closest
	 * distance to ocean. Gives 0.0 in case the point is in ocean.
	 */
	@Override
	public Double getDistanceToWaterBody(Double latitude, Double longitude)
			throws WeatherGeneratorException {

		Point p = new GeometryFactory().createPoint(new Coordinate(longitude,
				latitude));
		Double minDIstantToOcean = Double.MAX_VALUE;
		String typeName;
		try {
			typeName = shapeFileDataStore.getTypeNames()[0];
			SimpleFeatureSource featureSource = shapeFileDataStore
					.getFeatureSource(typeName);
			SimpleFeatureCollection collection = featureSource.getFeatures();
			SimpleFeatureIterator iterator = collection.features();
			Double curDistance;
			while (iterator.hasNext()) {
				SimpleFeature feature = iterator.next();
				Geometry geo = (Geometry) feature.getDefaultGeometry();
				curDistance = geo.distance(p);
				if (curDistance < minDIstantToOcean) {
					minDIstantToOcean = curDistance;
				}

			}

			iterator.close();

		} catch (IOException e) {
			throw new WeatherGeneratorException(e.getMessage());
		}

		// Converting degree distance to meters.
		return minDIstantToOcean * (Math.PI / 180) * 6378137;

	}

	/**
	 * Returns the approximate distance to equator by multiplying with a
	 * constant distance to each degree of latitude.
	 */
	@Override
	public Double getDistanceToEquator(Double latitude, Double longitude) {
		return Math.abs(latitude * 111.11);
	}

}
