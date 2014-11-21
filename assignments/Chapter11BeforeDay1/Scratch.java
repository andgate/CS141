import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Scratch
{
   public static void main(String[] args)
   {
      try
      {
         Scanner in = new Scanner(new File("input.txt"));
         int value = in.nextInt();
         System.out.println(value);
      }
      catch (IOException exception)
      {
         System.out.println("Error opening file.");
      }
   }
}