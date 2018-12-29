
/**
 * A weather forecast app determines if the pressure readings from 
 * its subscribed weather station, if any, indicate it is likely to rain
 * due to a reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {
	WeatherStation weatherStation;
	double p;
	double[] pLog = new double[10];
	int nop;
	
	/**
	 * Update the reading of this weather observer.
	 * Update the current and last readings of pressure.
	 */
	public void update() {
		/* Your Task */
		p = weatherStation.getPressure();
		pLog[nop] = p;
		nop++;
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
	 * Get the pressure level read from the last update.
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		/* Your Task */
		return p;
	}
	
	/**
	 * Get the pressure level read from the second last update.
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		
		if (nop - 2 >= 0) {
			return pLog[nop - 2];
		} else {
			return pLog[0];
		}
		
	}
	
	/**
	 * Based on the last and second last readings of the pressure level,
	 * it is determined as likely to rain if there is a reduction 
	 * on the pressure level; otherwise it is unlikely to rain.
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		boolean rain = false;
		
		if (this.getLastPressure() > this.getCurrentPressure()) {
			rain = true;
		}
		
		return rain;
	}
}