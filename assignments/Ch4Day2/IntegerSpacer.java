import java.util.Scanner;

public class IntegerSpacer
{
   public static void main(String[] args)
   {
      System.out.println("Please enter an integer: ");
      
      Scanner console = new Scanner(System.in);
      int inputInt = console.nextInt();
     
     
      String spacedIntegerStr = spaceInt(inputInt);
      
      System.out.println(spacedIntegerStr);
   }
   
   private static String spaceInt(int integer)
   {
      String intStr = Integer.toString(integer);
      
      
      String spacedIntegerString = StringDecomposer.getFirstCharacter(intStr);
      String restOfString = StringDecomposer.deleteFirstCharacter(intStr);
      
      while(restOfString.length() > 0)
      {
         String chunk = " " + StringDecomposer.getFirstCharacter(restOfString);
         spacedIntegerString = spacedIntegerString + chunk;
         restOfString = StringDecomposer.deleteFirstCharacter(restOfString);
      }
      
      return spacedIntegerString;
   }
}