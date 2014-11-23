import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class GetValidInteger
{
   private static int askInt(Scanner in, int lowest, int highest)
   {
      int enteredValue = 0;
      
      boolean isDone = false;
      while(!isInRange(enteredValue, lowest, highest))
      {
         enteredValue = getInteger(in, lowest, highest);
         isDone = validateInputCheck(enteredValue, lowest, highest);
      }
      
      return enteredValue;
   }
   
   private static int getInteger(Scanner in, int lowest, int highest)
   {                           
      while(true)
      {
         System.out.print("Enter an integer ( " + lowest
                        +" to " + highest + ")? ");
                        
         if (in.hasNext() && in.hasNextInt())
         {
            return in.nextInt();
         } else {
            flushInvalidInput(in);
         }
      }
   }
   
   private static boolean validateInputCheck(int enteredValue, int lowest, int highest)
   {
      if(!isInRange(enteredValue, lowest, highest))
      {
         System.out.println(enteredValue 
               + " is out of range. Please try again.");
         return false;
      }
      
      return true;
   }
   
   private static boolean isInRange(int x, int a, int b)
   {
      if(a > b)
      {
         return (a >= x && x >= b);
      }
      
      return (b >= x && x >= a);
   }
   
   private static void flushInvalidInput(Scanner in)
   {
      String junk = in.next(); //consume/sremove this input        
      System.out.println("'" + junk 
         + "' is invalid input. Please try again.");
   }
   
   private static final int LOW = 1;
   private static final int HIGH = 3;
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int enteredValue = askInt(in, LOW, HIGH);
      
      assert(enteredValue >= HIGH);
      assert(LOW <= enteredValue);
      
      System.out.print("you entered: " + enteredValue);
      in.close();
   }
}