package weather;

/**
 * This class represents a weather reading. A weather reading has an air
 * temperature in Celsius, a dew point temperature in Celsius and a wind speed
 * in miles per hour, and total rain received in the last 24 hours in
 * Millimeters.
 */
public class WeatherReading {
  private int airTemp;
  private int dewPointTemp;
  private int windSpeed;
  private int totalRain;

  /**
   * Construct a Book object that has the provided title, author and price.
   *
   * @param airTemp      the air temperature to be given to this weather reading
   * @param dewPointTemp the dew point temperature to be given to this weather
   *                     reading
   * @param windSpeed    the wind speed to be given to this weather reading
   * @param totalRain    the total rain to be given to this weather reading
   */

  public WeatherReading(int airTemp, int dewPointTemp, int windSpeed, int totalRain)
            throws IllegalArgumentException {
    if ((airTemp < dewPointTemp) || (windSpeed < 0) || (totalRain < 0)) {
      throw new IllegalArgumentException("Negative wind speed or total rain are not supported. \n "
                    + "Air Temperatures lower than dew points are not supported.");
    }
    this.airTemp = airTemp;
    this.dewPointTemp = dewPointTemp;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;

  }

  /**
   * Return the temperature of this weather reading.
   * 
   * @return the temperature of this weather reading
   */

  public int getTemperature() {
    return this.airTemp;

  }

  /**
   * Return the dew point temperature of this weather reading.
   * 
   * @return the dew point temperature of this weather reading
   */

  public int getDewPoint() {
    return this.dewPointTemp;

  }

  /**
   * Return the wind speed of this weather reading.
   * 
   * @return the wind speed of this weather reading
   */

  public int getWindSpeed() {
    return this.windSpeed;

  }

  /**
  * Return the total rain received in the last 24 hours of this weather reading.
  * 
  * @return the total rain received in the last 24 hours of this weather reading
  */
  
  public int getTotalRain() {
    return this.totalRain;

  }

  /**
   * Return the relative humidity using the air temperature and dew point
   * temperature.
   * 
   * @return relative humidity of this weather reading
   */
  
  public int getRelativeHumidity() {
    int humidity = -5 * this.dewPointTemp + 5 * this.airTemp - 100;    
    humidity = Math.abs(humidity);
    return humidity;
  }

  /**
   * Return the heat index using the temperature, relative humidity, and the 9
   * heat coefficients associated with this function.
   *
   * @return heat index of this weather reading
   */
  
  public int getHeatIndex() {
    int humidity = this.getRelativeHumidity();
    int temp = this.getTemperature();
    double c1 = -8.78469475556;
    double c2 = 1.61139411 * temp;
    double c3 = 2.33854883889 * humidity;
    double c4 = -0.14611605 * temp * humidity;
    double c5 = -0.012308094 * Math.pow(temp, 2);
    double c6 = -0.0164248277778 * Math.pow(humidity, 2);
    double c7 = 0.002211732 * Math.pow(temp, 2) * humidity;
    double c8 = 0.00072546 * temp * Math.pow(humidity, 2);
    double c9 = -0.000003582 * Math.pow(temp, 2) * Math.pow(humidity, 2);
    
    int heatIndex = (int) (c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9);
    
    return heatIndex;

  }

  /**
  * Return Fahrenheit temperature from the air temperature from the weather
  * reading.
  * 
  * @return the Fahrenheit value for the weather reading.
  */
  public int getFahrenheitFromCelsius() {
    int celsius = this.airTemp;
    int fahrenheit = (celsius * 9 / 5) + 32;
    return fahrenheit;
  }

  /*
   * Return the Celsius temperature of an inputed Fahrenheit temperature.
   * 
   * @param fahrenheit temperature
   * 
   * @return the converted Fahrenheit temperature
   */
  public int getCelsiusFromFahrenheit(int fahrenheit) {
    int celsius = (fahrenheit - 32) * 5 / 9;
    return celsius;
  }

  /**
   * Return the wind chill of this weather reading using air temperature in degree
   * Fahrenheit and the wind speed in miles per hour.
   *
   * @return
   */
  public int getWindChill() {
    int fahrenheit = this.getFahrenheitFromCelsius();
    int windchillF = (int) (35.74 + (.6215 * fahrenheit) - (35.75 * Math.pow(this.windSpeed, .16))
                + (.4275 * fahrenheit * Math.pow(this.windSpeed, .16)));
    //int windchillC = this.getCelsiusFromFahrenheit(windchillF);

    return windchillF;

  }
  
  /**
   * Returns overrode toString method.
   * 
   * @return returns the original params
   */

  public String toString() {
    String reading;
    int air = this.airTemp;
    int dew = this.dewPointTemp;
    int wind = this.windSpeed;
    int rain = this.totalRain;
    
    reading = String.format("Reading: T = %d, D = %d, v = %d, rain = %d", air, dew, wind, rain);
    return reading;
  }
}