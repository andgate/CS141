import java.util.Scanner;

public class SumWithoutSmallest
{
   public static void main(String[] args)
   {
      int[] values = new int[10];
      Scanner in = new Scanner(System.in);
      
      for(int i = 0; i < values.length; i++)
      {
         values[i] = in.nextInt();
      }
      
      int sum = sumWithoutSmallest(values);
      
      System.out.println("Sum without smallest: " + sum);
   }
   
   static int sumWithoutSmallest(int[] values)
   {
      int min = values[0];
      int sum = values[0];
      
      for(int i = 1; i < values.length; i++)
      {
         min = Math.min(min, values[i]);
         sum += values[i];
      }
   
      sum -= min;
      
      return sum;
   }
}