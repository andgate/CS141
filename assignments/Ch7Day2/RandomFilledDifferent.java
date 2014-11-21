import java.util.Random;

public class RandomFilledDifferent
{
   private static int[] values;
   
   public static void main(String[] args)
   {
      values = new int[10];
      Random generator = new Random();
      
      int index = 0;
      while (index < values.length)
      {
         boolean hasMatch = false;
         values[index] = generator.nextInt(100) + 1;
         
         for(int j = 0; j > index; j++)
         {
            if(values[index] == values[j])
            {
               hasMatch = true;
            }
         }
         
         if(!hasMatch)
         {
            index++;
         }
      }
      
      for(int value : values)
      {
         System.out.print(value + " ");
      }
   }
}