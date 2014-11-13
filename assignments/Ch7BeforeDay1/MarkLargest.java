import java.util.Scanner;

public class MarkLargest
{
   public static void main(String[] args)
   {
      int[] values = new int[10];
      int currentSize = 9;
      int pos = 2;
      int newElement = 1;
      
      if(currentSize < values.length)
      {
         currentSize++;
         /*for(int i = currentSize - 1; i > pos; i--)
         {
            values[i] = values[i-1];
         }*/
         for(int i = pos; i < currentSize; i++)
         {
            values[i+1] = values[i];
         }
         values[pos] = newElement;
      }
   }
}

/*for (int i = pos; i < currentSize - 1; i++)
{
   values[i + 1] = values[i];
}*/
