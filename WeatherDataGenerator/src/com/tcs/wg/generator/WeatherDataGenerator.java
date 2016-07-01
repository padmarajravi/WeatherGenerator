package com.tcs.wg.generator;

import java.io.PrintWriter;
import java.util.Set;

import org.joda.time.DateTime;

import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.Planet;
import com.tcs.wg.planet.WeatherStation;
import com.tcs.wg.util.Util;

public class WeatherDataGenerator {

	public static void main(String[] args) throws Exception {

		// System.out.println(new Planet().getCurrentReading(DateTime.now(),new WeatherStation("STA1",16.490169, 78.644530)));
		generate("data/station_details.txt","weather_data.txt");
	}

	public static void generate(String stationDetailFilePath,String outputFilePath) throws Exception {

		Planet planet = new Planet();
		Set<WeatherStation> stationDetails = Util
				.loadWeatherStationDetails(stationDetailFilePath);
		PrintWriter writer = new PrintWriter(outputFilePath,"UTF-8");

		for (WeatherStation station : stationDetails) {
			DateTime now = DateTime.now();
			Environment env = planet.getCurrentReading(DateTime.now(), station);
			writer.println(Util.createRecord(now, station, env));

		}
		writer.close();
	}

}
