import java.util.Scanner;
import java.util.ArrayList;

public class AddDoubles
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      ArrayList<Double> inputs = new ArrayList<Double>();
      int chances = 2;
      
      while(chances > 0)
      {
         if(chances == 1)
         {
            System.out.print("(Last Chance) ");
         }
         
         System.out.print("Please enter a floating point number: ");
         
         try
         {
            inputs.add(in.nextDouble());
            chances = 2;
         }
         catch(java.util.InputMismatchException e)
         {
            // The input was not a number
            // Reduce the chance
            chances--;
            in.next();
         }
         catch(java.util.NoSuchElementException e)
         {
            // No more input.
            // Set chances to zero and continue progam
            chances = 0;
         }
         catch(java.lang.IllegalStateException e)
         {
            // Something bad happened.
            // Just close the program.
            System.exit(0);
         }
      }
      
      System.out.printf(
         "The sum of the values is %f.",
         sumDoubles(inputs));
   }
   
   private static double sumDoubles(ArrayList<Double> numbers)
   {
      double sum = 0.0;
      
      for(Double number : numbers)
      {
         sum += number;
      }
      
      return sum;
   }
}