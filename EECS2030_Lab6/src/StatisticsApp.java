
/**
 * A weather statistics app calculates the 
 * minimum, maximum, and average temperature 
 * read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {
	WeatherStation weatherStation;
	double t;
	double[] tLog = new double[10];
	int not;
	
	/**
	 * Update the reading of this weather observer.
	 * Update the current temperature and the 
	 * maximum, minimum, and average accordingly.
	 */
	public void update() {
		/* Your Task */
		t = weatherStation.getTemperature();
		tLog[not] = t;
		not++;
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return weatherStation;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */ 
		this.weatherStation = ws;
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		double min = tLog[0];
		
		for (int i = 1; i < not; i++) {
			
			if (tLog[i] <= min) {
				min = tLog[i];
			}
			
		}
		
		return min;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		double max = tLog[0];
		
		for (int i = 1; i < not; i++) {
			
			if (tLog[i] >= max) {
				max = tLog[i];
			}
			
		}
		
		return max;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		double sum = 0;
		
		for (int i = 0; i < not; i++) {
			sum += tLog[i];
		}
		
		return sum / not;
	}
}

