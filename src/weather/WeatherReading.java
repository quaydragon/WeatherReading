package weather;
/**
 * This class represents a weather reading. A weather reading has an air temperature in Celsius, a dew point temperature in Celsius and a wind speed in miles per hour, and total rain received in the last 24 hours in Millimeters.
 */
public class WeatherReading {
  private static final String String = null;
private double air_temp;
  private double dew_point_temp;
  private double wind_speed;
  private double total_rain;
  

  /**
   * Construct a Book object that has the provided title, author and  price.
   *
   * @param air_temp  the air temperature to be given to this weather reading
   * @param dew_point_temp the dew point temperature to be given to this weather reading
   * @param wind_speed  the wind speed to be given to this weather reading
   * @param total_rain the total rain to be given to this weather reading
   */

  public WeatherReading(double air_temp, double dew_point_temp, double wind_speed, double total_rain) 
	  throws IllegalArgumentException {
	    	   if ((air_temp < dew_point_temp) || (wind_speed < 0) || (total_rain < 0)) {
	    	      throw new IllegalArgumentException("Negative wind speed or total rain are not supported. \n "
	    	      		+ "Air Temperatures lower than dew points are not supported.");
	    	   }
    this.air_temp = air_temp;
    this.dew_point_temp = dew_point_temp;
    this.wind_speed = wind_speed;
    this.total_rain = total_rain;
    
  }


  /*
   * Return the temperature of this weather reading.
   * 
   * @return the temperature of this weather reading
   */

  	public double getTemperature() {
  		return this.air_temp;

  	}
  	
  	/*
  	 * Return the dew point temperature of this weather reading.
  	 * 
  	 * @return the dew point temperature of this weather reading
  	 */

  	public double getDewPoint() {
  		return this.dew_point_temp;
  	
  	}
  	
  	/*
  	 * Return the wind speed of this weather reading.
  	 * 
  	 * @return the wind speed of this weather reading
  	 */
  	
  	public double getWindSpeed() {
  		return this.wind_speed;
  		
  	}
  	
  	/*
  	 * Return the total rain received in the last 24 hours of this weather reading. 
  	 * 
  	 * @return the total rain received in the last 24 hours of this weather reading
  	 */
  	public double getTotalRain() {
  		return this.total_rain;  		
  		
  	}
  	
  	/*
  	 * Return the relative humidity using the air temperature and dew point temperature. 
  	 * 
  	 * @return relative humidity of this weather reading
  	 */
  	public double getRelativeHumidity() {
  		double humidity = -5*this.dew_point_temp + 5*this.air_temp - 100;
  		
  		if (humidity < 0) {
  			humidity = 0;
  		}
  		
  		if (humidity > 100) {
  			humidity = 100;
  		}
  		
  		return humidity;
  	}
  	
  	/*
  	 * Return the heat index using the temperature, relative humidity, and the 9 heat coefficients associated with this function.
  	 *
  	 * @return heat index of this weather reading 
  	 */
  	public double getHeatIndex() {  		
  		double c1 = -8.78469475556;
  		double c2 = 1.61139411;
  		double c3 = 2.33854883889;
  		double c4 = -0.14611605;
  		double c5 = -0.012308094;
  		double c6 = -0.0164248277778;
  		double c7 = 0.002211732;
  		double c8 = 0.00072546;
  		double c9 = -0.000003582;
  		
  		double humidity = this.getRelativeHumidity();
  		double temp = this.getTemperature();
  		
  		double heat_index = c1 + c2*temp + c3*humidity + c4*temp*humidity + c5*Math.pow(temp, 2) + c6*Math.pow(humidity, 2) + c7*Math.pow(temp, 2)*humidity + c8*temp*Math.pow(humidity, 2) + c9*Math.pow(temp, 2)*Math.pow(humidity, 2);
  		
  		return heat_index;
  
  		
  	}
  	
  	/* Return Fahrenheit temperature from the air temperature from the weather reading.
  	 * 
  	 * @return the Fahrenheit value for the weather reading. 
  	 */
  	public double getFahrenheitFromCelsius() {
  		double celsius = this.air_temp;
  		double fahrenheit = (celsius * 9 / 5) + 32;
  		return fahrenheit;
  	}
  	
  	/*
  	 * Return the Celsius temperature of an inputed Fahrenheit temperature. 
  	 * 
  	 * @param fahrenheit temperature
  	 * 
  	 * @return the converted Fahrenheit temperature
  	 */
  	public double getCelsiusFromFahrenheit(double fahrenheit) {
  		double celsius = (fahrenheit - 32) * 5 / 9;
  		
  		return celsius;
  	}
  	
  	
  	
  	/*
  	 * Return the wind chill of this weather reading using air temperature in degree Fahrenheit and the wind speed in miles per hour. 
  	 *
  	 * @return 
  	 */
  	public double getWindChill() {
  		double fahrenheit = this.getFahrenheitFromCelsius();
  		double windchill_f = 35.74 + .6215*fahrenheit - 35.75*Math.pow(this.wind_speed, .16) + .4275*fahrenheit*Math.pow(this.wind_speed, .16);  		
  		double windchill_c = this.getCelsiusFromFahrenheit(windchill_f);
  		
  		return windchill_c;
  		
  	}
  	
  	public String toString() {
  		String reading;
  		reading = String.format("Reading: T = %f, D = %f, V = %f, rain = %f", this.air_temp, this.dew_point_temp, this.wind_speed, this.total_rain);
  		return reading;
  	}
}