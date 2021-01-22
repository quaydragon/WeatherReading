import org.junit.Before;
import org.junit.Test;

import weather.WeatherReading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * A JUnit test class for the WeatherReading class.
 */
public class WeatherReadingTest {

  
  private WeatherReading day_in_june;


  @Before
  public void setUp() {
    
    day_in_june = new WeatherReading(17, 15, 20, 0);
  }

  @Test
  public void testTemperature() {
    assertEquals(17, day_in_june.getTemperature(), .0000004);
  }
 

  @Test
  public void testDewPoint() {
    assertEquals(15, day_in_june.getDewPoint(), .0000004);
  }
  
  @Test
  public void testWindSpeed() {
    assertEquals(20, day_in_june.getWindSpeed(), .0000004);
  }
  
  @Test
  public void testTotalRain() {
    assertEquals(0, day_in_june.getTotalRain(), .0000004);
  }
  
  @Test
  public void testRelativeHumidity() {
    assertEquals(0, day_in_june.getRelativeHumidity(), .0000004);
  }
  
  @Test
  public void testHeatIndex() {
    assertEquals(15, day_in_june.getHeatIndex(), .5);
  }
  
  @Test
  public void testFahrenheitFromCelcius() {
    assertEquals(62.6, day_in_june.getFahrenheitFromCelsius(), .5);
  }
  
  @Test
  public void testCelciusFromFahrenheit() {
    assertEquals(21.11, day_in_june.getCelsiusFromFahrenheit(70), .5);
  }

  @Test
  public void testWindChill() {
    assertEquals(15, day_in_june.getWindChill(), 1);
  }
  
  @Test
  public void testString() {
    assertEquals("Reading: T = 17.000000, D = 15.000000, V = 20.000000, rain = 0.000000", day_in_june.toString());
  }
  
  @Test
  public void testIfInvalidDuaration() {
     WeatherReading wr;
     WeatherReading we;
     WeatherReading re;
     try {
        wr = new WeatherReading(25, 10, 20, 30);
     } catch (IllegalArgumentException e) { 
        fail("An exception should not have been thrown");
     }

     try {
        wr = new WeatherReading(10, 15, 20, 0);
        fail("The above line should have thrown an exception");
     } catch (IllegalArgumentException e) {
     }
     try {
         we = new WeatherReading(27, 10, -7, 0);
         fail("The above line should have thrown an exception");
      } catch (IllegalArgumentException e) {
      }
     try {
         we = new WeatherReading(27, 10, 7, -100);
         fail("The above line should have thrown an exception");
      } catch (IllegalArgumentException e) {
      }
     
     
  }
}
