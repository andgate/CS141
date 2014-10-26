import java.util.Scanner;

public class IsLiquid
{
   private static final double FREEZING_POINT_OF_WATER = 0.0; // Celcius
   private static final double BOILING_POINT_OF_WATER = 100.0; // Celcius
   
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      
      System.out.print("What is the current temperature, in celsius? ");
      
      double temperature;
      if(console.hasNextDouble())
      {
         temperature = console.nextDouble();
      }
      else
      {
         System.out.println("Invalid input");
         return;
      }
   
      boolean waterIsLiquid = FREEZING_POINT_OF_WATER < temperature
                              && temperature < BOILING_POINT_OF_WATER;
      
      if(waterIsLiquid)
      {
         System.out.println("Water is liquid.");
      }
      else
      {
         System.out.println("Water is not liquid.");
      }
   }
}