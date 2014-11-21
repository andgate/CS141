import java.util.Random;

public class RandomFilled
{
   private static int[] values;
   
   public static void main(String[] args)
   {
      values = new int[10];
      Random generator = new Random();
      
      for(int index = 0; index < values.length; index++)
      {
         values[index] = generator.nextInt(100) + 1;
      }
      
      for(int value : values)
      {
         System.out.print(value + " ");
      }
   }
}