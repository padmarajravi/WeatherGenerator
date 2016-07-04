package com.tcs.wg.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import com.tcs.wg.exception.WeatherGeneratorException;
import com.tcs.wg.planet.Environment;
import com.tcs.wg.planet.WeatherStation;

/**
 * This class has utility methods to read station details from a file and create
 * records for writing.
 * 
 * @author 472423
 *
 */
public class Util {

	private static final String STATION_DATA_DELIM = ",";

	/**
	 * Returns a set of WeatherStation objects by reading the file of weather
	 * station details.
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Set<WeatherStation> loadWeatherStationDetails(String filePath) throws WeatherGeneratorException {
		Set<WeatherStation> weatherStationSet = new HashSet<WeatherStation>();
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				if (line.contains(STATION_DATA_DELIM)) {
					String[] details = line.split(STATION_DATA_DELIM);
					weatherStationSet.add(new WeatherStation(details[0], Double.parseDouble(details[1]),
							Double.parseDouble(details[2])));

				}

			}
			br.close();
		} catch (NumberFormatException | IOException e) {
			throw new WeatherGeneratorException(e.getMessage());
		}

		return weatherStationSet;
	}

	/**
	 * Creates record to be written as output based on DateTime , StationDetails
	 * and Environment details.
	 * 
	 * @param now
	 * @param station
	 * @param env
	 * @return
	 */

	public static String createRecord(DateTime now, WeatherStation station, Environment env) {
		return station.getStationCode() + "|" + env.getLatitude() + "," + env.getLongitude() + "," + env.getElevation()
				+ "|" + now + "|" + env.getTemperature() + "|" + env.getPressure() + "|" + env.getHumidity() + "|"
				+ env.getCondition();
	}

}
