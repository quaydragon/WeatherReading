package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;

/**
 * A JUnit test class for the WeatherReading class.
 */
public class WeatherReadingTest {
  private WeatherReading dayInJune;


  /**
   * This function creates two different weather readings.
   */
  @Before
    public void setUp() {

    dayInJune = new WeatherReading(17, 15, 20, 0);
  }

  @Test
    public void testTemperature() {
    assertEquals(17, dayInJune.getTemperature(), .0000004);
  }

  @Test
    public void testDewPoint() {
    assertEquals(15, dayInJune.getDewPoint(), .0000004);
  }

  @Test
    public void testWindSpeed() {
    assertEquals(20, dayInJune.getWindSpeed(), .0000004);
  }

  @Test
    public void testTotalRain() {
    assertEquals(0, dayInJune.getTotalRain(), .0000004);
  }

  @Test
    public void testRelativeHumidity() {
    assertEquals(90, dayInJune.getRelativeHumidity(), .0000004);
  }

  @Test
    public void testHeatIndex() {
    assertEquals(17, dayInJune.getHeatIndex(), .5);
  }

  @Test
    public void testFahrenheitFromCelcius() {
    assertEquals(62, dayInJune.getFahrenheitFromCelsius(), .5);
  }

  @Test
   public void testCelciusFromFahrenheit() {
    assertEquals(21.11, dayInJune.getCelsiusFromFahrenheit(70), .5);
  }

  @Test
  public void testWindChill() {
    assertEquals(59, dayInJune.getWindChill(), 1);
  }

  @Test
  public void testString() {
    assertEquals("Reading: T = 17, " + "D = 15, " + "v = 20, rain = 0",
                dayInJune.toString());
  }
  
  @Test
  public void testHumidty() {
    assertEquals(90, dayInJune.getRelativeHumidity(), .0005);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidDuration() {
    WeatherReading wr = new WeatherReading(4, 38, -20, 0);
  }
}
