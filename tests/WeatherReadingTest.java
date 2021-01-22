import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import weather.WeatherReading;

/**
 * A JUnit test class for the WeatherReading class.
 */
public class WeatherReadingTest {
  private WeatherReading dayInJune;

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
    assertEquals(0, dayInJune.getRelativeHumidity(), .0000004);
  }

  @Test
    public void testHeatIndex() {
    assertEquals(15, dayInJune.getHeatIndex(), .5);
  }

  @Test
    public void testFahrenheitFromCelcius() {
    assertEquals(62.6, dayInJune.getFahrenheitFromCelsius(), .5);
  }

  @Test
   public void testCelciusFromFahrenheit() {
    assertEquals(21.11, dayInJune.getCelsiusFromFahrenheit(70), .5);
  }

  @Test
  public void testWindChill() {
    assertEquals(15, dayInJune.getWindChill(), 1);
  }

  @Test
  public void testString() {
    assertEquals("Reading: T = 17.000000, " + "D = 15.000000, " + "V = 20.000000, rain = 0.000000",
                dayInJune.toString());
  }

  @Test
    public void testIfInvalidDuaration() {
    WeatherReading wr;
    WeatherReading we;
    final WeatherReading re;
    try {
      wr = new WeatherReading(25, 10, 20, 30);
    } catch (final IllegalArgumentException e) {
      fail("An exception should not have been thrown");
    }

    try {
      wr = new WeatherReading(10, 15, 20, 0);
      fail("The above line should have thrown an exception");
    } catch (final IllegalArgumentException e) {
    }
    try {
      we = new WeatherReading(27, 10, -7, 0);
      fail("The above line should have thrown an exception");
    } catch (final IllegalArgumentException e) {
    }
    try {
      we = new WeatherReading(27, 10, 7, -100);
      fail("The above line should have thrown an exception");
    } catch (final IllegalArgumentException e) {
    }

  }
}
