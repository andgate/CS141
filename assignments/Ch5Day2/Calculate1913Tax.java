import java.util.Scanner;

public class Calculate1913Tax
{   
   public static final double PERCENT_PER_STEP = 0.01;
   public static final double STEP_1 = 0;
   public static final double STEP_2 = 50000;
   public static final double STEP_3 = 75000;
   public static final double STEP_4 = 100000;
   public static final double STEP_5 = 250000;
   public static final double STEP_6 = 500000;
 
   public static void main(String[] args)  
   {
      System.out.print("Please enter your yearly income: ");
      Scanner console = new Scanner(System.in);
      double income = console.nextDouble();
      
      double tax = 0;
      
      if (income >= STEP_1) 
      {
         tax += income * PERCENT_PER_STEP;      
      }
      if (income > STEP_2)
      {
         tax += income * PERCENT_PER_STEP;
      }
      if (income > STEP_3)
      {
         tax += income * PERCENT_PER_STEP;
      }
      if (income > STEP_4)
      {
         tax += income * PERCENT_PER_STEP;
      }
      if (income > STEP_5)
      {
         tax += income * PERCENT_PER_STEP;
      }
      if (income > STEP_6)
      {
         tax += income * PERCENT_PER_STEP;
      }         
      
      System.out.print("The taxes due are: $" + String.format("%5.2f", tax));
   }   
   
}