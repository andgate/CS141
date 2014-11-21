import java.util.Scanner;

/**
   This program reads a sequence of values and prints them, marking the extreme values.
*/
public class ExtremesInArray
{
   public static void main(String[] args)
   {  
      final int LENGTH = 100;
      double[] values = new double[LENGTH];
      int currentSize = 0;

      // Read inputs

      System.out.println("Please enter values, Q to quit:");
      Scanner in = new Scanner(System.in);
      while (in.hasNextDouble() && currentSize < values.length)
      {  
         values[currentSize] = in.nextDouble();
         currentSize++;
      }

      // Find the exteme values, largest and smallest

      double largest = values[0];
      double smallest = values[0];
      for (int i = 1; i < currentSize; i++)
      {
         largest = Math.max(values[i], largest);
         smallest = Math.min(values[i], smallest);
      }

      // Print all values, marking the extremes

      for (int i = 0; i < currentSize; i++)
      {  
         System.out.print(values[i]);
         if (values[i] == largest) 
         {
            System.out.print(" <== largest value");
         }
         if (values[i] == smallest) 
         {
            System.out.print(" <== smallest value");
         }
         
         System.out.println();
      }
   }
}
