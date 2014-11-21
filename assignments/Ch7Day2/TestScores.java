import java.util.Scanner;

public class TestScores
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      // Get input
      int[] scores = askScores(in);
      
      // Find minimum
      int min = getMin(scores);
      
      // Sum values
      int sum = getSum(scores);
      
      // Get the average of (n - 1) values
      int averageScore = sum / (scores.length - 1);
      
      System.out.println("Average Score: " + averageScore);
   }
   
   private static int[] askScores(Scanner in)
   {
      int[] scores = new int[10];
      
      for(int i = 0; i < scores.length; i++)
      {
         scores[i] = in.nextInt();
      }
      
      return scores;
   }
   
   private static int getMin(int[] values)
   {
      int min = values[0];
      
      for(int i = 1; i < values.length; i++)
      {
         if(values[i] < min)
         {
            min = values[i];
         }
      }
      
      return min;
   }
   
   private static int getSum(int[] values)
   {
      int sum = 0;
      for(int i = 0; i < values.length; i++)
      {
         sum += values[i];
      }
      
      return sum;
   }
}