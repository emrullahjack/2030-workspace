
/**
 * A weather station measures temperature and pressure and
 * has a list of subscribed weather observers.
 * When there is an update on the measures, the weather station
 * publishes the update to all currently-subscribed observers.
 */
public class WeatherStation {

	/* 
	 * Your Task: 
	 * Declare an attribute for the ***list*** of subscribed weather observers.  
	 */
	
	WeatherObserver[] observers;
	int noo;
	double t;
	double p;
	
	/**
	 * Initialize a new weather station.
	 * @param t initial temperature measure
	 * @param p initial pressure measure 
	 */
	public WeatherStation(double t, double p) {
		/* Your Task */

		this.t = t;
		this.p = p;
		observers = new WeatherObserver[30];
	}
	
	/**
	 * Subscribe the input weather observer o as
	 * one of the observers of the current weather station.
	 * Add the input o to the list of subscribed observers. 
	 * @param o a weather observer
	 */
	public void subscribe(WeatherObserver o) {
		/* Your Task */

		observers[noo] = o;
		noo++;
		o.setWeatherStation(this);
	}

	/**
	 * Unsubscribe the input weather observer o from
	 * the list of observers of the current weather station.
	 * Remove the input o from the list of subscribed observers. 
	 * Assume that the input o is an already-subscribed observer.  
	 * @param o a weather observer
	 */
	public void unsubscribe(WeatherObserver o) {
		/* Your Task */

		for (int i = 0; i < noo; i++) {

			if (observers[i] == o) {
				observers[i].setWeatherStation(null);

				for (int k = i; k < noo - 1; k++) {
					observers[k] = observers[k + 1];
				}

				observers[noo - 1] = null;
				noo--;
			}

		}

	}

	/**
	 * Publish the latest readings of weather data 
	 * to all subscribed observers. 
	 * That is, perform an update on each subscribed observer. 
	 */
	public void publish() {
		/* Your Task */ 
		
		for (int i = 0; i < noo; i++) {
			observers[i].update();
		}
		
	}
	
	/**
	 * Get the list of subscribed weather observers.
	 * @return an array of subscribed weather observers. 
	 */
	public WeatherObserver[] getObservers() {
		/* Your Task */ 
		
		WeatherObserver[] currentObservers = new WeatherObserver[noo];
		
		for (int i = 0; i < noo; i++) {
			currentObservers[i] = observers[i];
		}
		
		return currentObservers;
	}
	
	/**
	 * Get the latest temperature measure.
	 * @return latest temperature measure
	 */
	public double getTemperature() {
		/* Your Task */ 
		return t;
	}
	
	/**
	 * Get the latest pressure measure.
	 * @return latest pressure measure 
	 */
	public double getPressure() {
		/* Your Task */ 
		return p;
	}

	/**
	 * Update the weather data 
	 * @param t new temperature measure
	 * @param p new pressure measure
	 */
	public void set_measurements(double t, double p) {
		/* Your Task */ 
		
		this.t = t;
		this.p = p;
	}
}