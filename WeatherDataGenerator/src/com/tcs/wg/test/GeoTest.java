package com.tcs.wg.test;

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
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class GeoTest {

	
	public static void main(String[] args) throws Exception {
       
		
		System.out.println("Alt:"+getElevationForCOordinate(-40.751697, 108.896484));
		System.out.println("Distance to sea:"+getDistanceToOcean(-40.751697, 108.896484));
        System.out.println("Distance to equator:"+getDistanceToEquator(-40.751697, 108.896484));  
	    System.out.println(Math.random());
	}
	
	
	public static Integer getElevationForCOordinate(Double lat, Double lon) throws IOException
	{
		//Point p=new GeometryFactory().createPoint(getCoordinate(lat, lon));
		//System.out.println(p);
		File file = new File("data/elevation/E100S10.DEM");
		GTopo30Reader reader=new GTopo30Reader(file);
		int[] objArray = (int[])reader.read(null).evaluate(new DirectPosition2D(lon,lat));
		return objArray[0];
		
	}
	

	private static void asNumberArray(Object objArray) {
		System.out.println(objArray.getClass().getComponentType());
		
		
	}


	public static Double getDistanceToOcean(Double lat, Double lon)
			throws Exception {
		Point p = new GeometryFactory().createPoint(new Coordinate(lon, lat));
		File file = new File("data/ocean/ne_50m_ocean.shp");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", file.toURI().toURL());
		DataStore dataStore = DataStoreFinder.getDataStore(map);
		String typeName = dataStore.getTypeNames()[0];
		SimpleFeatureSource featureSource = dataStore
				.getFeatureSource(typeName);
		SimpleFeatureCollection collection = featureSource.getFeatures();
		SimpleFeatureIterator iterator = collection.features();
		Double minDIstantToOcean = Double.MAX_VALUE;
		Double curDistance;
		while (iterator.hasNext()) {
			SimpleFeature feature = iterator.next();
			Geometry geo = (Geometry) feature.getDefaultGeometry();
			curDistance = geo.distance(p);
			if (curDistance < minDIstantToOcean) {
				minDIstantToOcean = curDistance;
			}

		}
		return minDIstantToOcean* (Math.PI / 180) * 6378137;

	}
	
	public static Coordinate getCoordinate(Double latitude,Double longitude)
	{
		double EARTH_RADIUS = 6378137.0;
	    double x = longitude * EARTH_RADIUS * Math.PI / 180.;
	    double y = EARTH_RADIUS * Math.sin(Math.toRadians(latitude));
	    return new Coordinate(x,y,0.);
	}

	
	public static Double getDistanceToEquator(Double latitude, Double longitude) {
		return Math.abs(latitude*111.11);
	}
	
	
	
}
