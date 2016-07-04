package com.tcs.wg.generator;

import java.io.PrintWriter;
import java.util.Set;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.Planet;
import com.tcs.wg.planet.WeatherStation;
import com.tcs.wg.util.Util;

public class WeatherDataGenerator {

	
	/**
	 * Main method which takes two input (Station detail file and output file path)
	 * Generates data and writes to a file specified by second argument.
	 * Station Details file format is as given below
	 * <STATIONNAME><COMMA<LATITUDE><COMMA><LONGITUDE>
	 * @param args
	 * @throws WeatherGeneratorException
	 */
	public static void main(String[] args) throws WeatherGeneratorException  {
		if (args.length != 2) {
			System.out.println("Usage : Please provide station details file path(arg1) and output file path (arg2)");
		} else {
			try{
				generate(args[0], args[1]);
			}
			catch(Exception e)
			{
				throw new WeatherGeneratorException(e.getMessage());
			}
			
		}

		// generate("data/station_details.txt","weather_data.txt");
	}

	
	/**
	 * 
	 * Generates weather data and writes to data file spcified by second argument.
	 * Takes station details as the input to generate data for.
	 * Station details file should be in the format 
	 * <STATIONNAME><COMMA<LATITUDE><COMMA><LONGITUDE>
	 * @param stationDetailFilePath
	 * @param outputFilePath
	 * @throws Exception
	 */
	public static void generate(String stationDetailFilePath, String outputFilePath) throws Exception {

		Planet planet = new Planet();
		Set<WeatherStation> stationDetails = Util.loadWeatherStationDetails(stationDetailFilePath);
		PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");

		for (WeatherStation station : stationDetails) {
			DateTime now = DateTime.now();
			Environment env = planet.getCurrentReading(DateTime.now(), station);
			writer.println(Util.createRecord(now, station, env));

		}
		writer.close();
	}

}
