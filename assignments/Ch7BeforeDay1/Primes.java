import java.util.Scanner;

public class Primes
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      double largestIndex = 0;
      
      double largest = in.nextDouble();
      while(in.hasNextDouble())
      {
         double input = in.nextDouble();
         if (input > largest)
         {
            largest = input;
         }
      }
   }

}