import java.util.Scanner;

public class TwoIntegers
{
   private static int x;
   private static int y;
   
   private static final int TOTAL_NUMBERS = 2;
   
   public static void main(String[] args)
   {
      System.out.print("Please enter two integers: ");
         
      Scanner in = new Scanner(System.in);
      x = in.nextInt();
      y = in.nextInt();
      
      System.out.printf("Sum:            %5d\n", sum());
      System.out.printf("Difference:     %5d\n", difference());
      System.out.printf("Product:        %5d\n", product());
      System.out.printf("Average:        %8.2f\n", average());
      System.out.printf("Distance:       %5d\n", distance());
      System.out.printf("Maximum:        %5d\n", maximum());
      System.out.printf("Minimum:        %5d\n", minimum());
      System.out.printf("First / Second: %8.2f\n", divideFirstBySecond());
      System.out.printf("First %% Second: %8.2f\n", modulusFirstBySecond());
      System.out.printf("Second / First: %8.2f\n", divideSecondByFirst());
      System.out.printf("Second %% First: %8.2f\n", modulusSecondByFirst());
   }
   
   public static int sum()
   {
      return x + y;
   }
   
   public static int difference()
   {
      return x - y;
   }
   
   public static int product()
   {
      return x * y;
   }
   
   public static double average()
   {
      return (double) (x + y) / TOTAL_NUMBERS;
   }
   
   public static int distance()
   {  
      return Math.abs(difference());
   }
   
   public static int maximum()
   {  
      return Math.max(x, y);
   }
   
   public static int minimum()
   {  
      return Math.min(x, y);
   }
   
   public static double divideFirstBySecond()
   {
      return (double) x / y;
   }
   
   public static double modulusFirstBySecond()
   {
      return (double) x % y;
   }
   
   public static double divideSecondByFirst()
   {
      return (double) y / x;
   }

   public static double modulusSecondByFirst()
   {
      return (double) y % x;
   }
}
