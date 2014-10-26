import java.util.Scanner;

public class Compare
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Please enter two equal strings: ");
      String firstStr = console.next();
      String secondStr = console.next();
      
      if(firstStr.equals(secondStr))
      {
         System.out.print("Those are equal strings! Good human, you win a cookie!");
      }
      else
      {
         System.out.print("You think those strings are equals? Wow. Just wow.");
      }
   }
}