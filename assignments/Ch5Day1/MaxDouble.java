import java.util.Scanner;

public class MaxDouble
{
   private static final String INTRO_PROMPT = "Please enter three numbers: ";
   private static final String MAX_MSG = "Largest number: ";
   
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print(INTRO_PROMPT);
      double a = console.nextDouble();
      double b = console.nextDouble();
      double c = console.nextDouble();
      
      System.out.println(MAX_MSG + maxThree(a, b, c));
   }
   
   private static double max(double x, double y)
   {
      if ( x > y)
      {
         return x;
      }
      else
      {
         return y;
      }
   }
   
   private static double maxThree(double x, double y, double z)
   {
      return max( max(x, y), max(y, z) );
   }
}