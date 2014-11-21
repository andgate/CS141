import org.junit.Test;
import org.junit.Assert;

public class EarthquakeTest
{
   @Test
   public void smallQuake()
   {
      Earthquake quake = new Earthquake(1.0);
      String expectedDescription = "No destruction of buildings";
      Assert.assertEquals(expectedDescription, quake.getDescription());
   }
}