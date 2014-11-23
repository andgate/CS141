import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class FlushScanner
{ 
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int enteredValue = 0;
      
      while (enteredValue < 1 || enteredValue > 3)
      {
         System.out.print("Enter an integer ( 1 to 3)? ");
         
         if (in.hasNext() && in.hasNextInt()) {
            enteredValue = in.nextInt();
         } else {
            String junk = in.next(); //consume/sremove this input        
            System.out.println("'" + junk 
            + "' is invalid input. Please try again.");
         }
         
         if(enteredValue < 1 || enteredValue > 3) {
            System.out.println(enteredValue 
            + " is out of range. Please try again.");     
         }
      }
      
      System.out.print("you entered: " + enteredValue);
      in.close();
   }
}