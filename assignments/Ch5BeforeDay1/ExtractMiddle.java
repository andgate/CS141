import java.util.Scanner;

public class ExtractMiddle
{
   public static void main(String[] args)
   {
      System.out.println("Enter a string: ");
      
      Scanner console = new Scanner(System.in);
      String str = console.next();
      
      System.out.println("The middle of the given string is " + getMiddle(str) + ".");
   }
   
   private static String getMiddle(String str)
   {
      String middle = "";
      int length = str.length();
      
      if(odd(length))
      {
         middle = getMiddleOne(str);
      }
      else if(even(length))
      {
         middle = getMiddleTwo(str);
      }
      
      return middle;
   }
   
   private static String getMiddleOne(String str)
   {
      int halfPos = str.length() / 2;
      return str.substring(halfPos, halfPos + 1);
   }
   
   private static String getMiddleTwo(String str)
   {
      int halfPos = str.length() / 2;
      return str.substring(halfPos - 1, halfPos + 1);
   }
   
   private static boolean even(int number)
   {
      // the low bit of an integer is
      // always set to 0 when even.
      return (number & 1) == 0;
   }
   
   private static boolean odd(int number)
   {
      // the low bit of an integer is
      // always set to 1 when odd.
      return (number & 1) == 1;
   }
}