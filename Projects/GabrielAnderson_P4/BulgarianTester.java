import java.util.Scanner;

/**
   This class if for testing a Bulgarian object.</br>
   <p>COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 22 November 2014
   @version 1.0
 */
public class BulgarianTester
{
   private static final String ASK_NUM_PILES
      = "Enter the number of piles (1 or greater): ";
   private static final String OUT_OF_RANGE_ECHO
      = "Number needs to be 1 or higher. Try again.";
   private static final String INVALID_INPUT_ECHO
      = "Invalid input. Try again.";
   private static final String GOODBYE_ECHO
      = "Goodbye.";
   private static final String CONTINUE_ECHO
      = "Continue? (yes or no): ";
      
   private static final String YES_RESPONSE
      = "Y";
   private static final String NO_RESPONSE
      = "N";
   
   /**
      The entry point for the tester.
    */
   public static void main(String[] args)
   {
      Bulgarian game = new Bulgarian(0);
      Scanner in = new Scanner(System.in);
      boolean isRunning = true;
      
      while(isRunning)
      {
         int numberOfPiles = askNumberOfPiles(in);
         game.setNumberOfPiles(numberOfPiles);
         game.play();
         game.clear();
         
         isRunning = askContinue(in);
      }
      
      sayGoodbye();
   }
   
   /**
      Asks the user whether to continue or not.
      Answered with a yes or no.
      Repeats question until user gives a yes or no.
      @param in Scanner used to query input.
      @return True if yes, false if no.
    */
   private static boolean askContinue(Scanner in)
   {
      while(true)
      {
         System.out.print(CONTINUE_ECHO);
         
         
         String response = "";
         try
         {
            response = in.next();
         }
         catch(java.util.NoSuchElementException e)
         {
            sayGoodbye();
            System.exit(0);
         }
         catch(java.lang.IllegalStateException e)
         {
            sayGoodbye();
            System.exit(0);
         }
         
         response = response.trim().toUpperCase().substring(0,1);
         
         if(response.equals(YES_RESPONSE))
         {
            return true;
         }
         else if(response.equals(NO_RESPONSE))
         {
            return false;
         }
         
         // The response didn't pass
         // the check, was invalid.
         System.out.println(INVALID_INPUT_ECHO);
      }
   }
   
   /**
      Asks the user for the number of piles to play
      Bulgarian Solitaire with. Repeats question
      until user gives an input within the proper range.
      The range is 1 to 2,147,483,647. (can your heap handle it?)
      @param in The scanner used to query input.
      @return A valid number of piles.
    */
   private static int askNumberOfPiles(Scanner in)
   {
      while(true)
      {
         System.out.print(ASK_NUM_PILES);
         
         // initialize with an invalid value
         int numberOfPiles = 0;
         
         try
         {
            numberOfPiles = in.nextInt();
         }
         catch(java.util.InputMismatchException e)
         {
            System.out.println(INVALID_INPUT_ECHO);
            in.next();
         }
         catch(java.util.NoSuchElementException e)
         {
            sayGoodbye();
            System.exit(0);
         }
         catch(java.lang.IllegalStateException e)
         {
            sayGoodbye();
            System.exit(0);
         }
         
         if(numberOfPiles > 0)
         {
            return numberOfPiles;
         }
         else
         {
            System.out.println(OUT_OF_RANGE_ECHO);
         }
      }
   }
   
   /**
      Prints out a goodbye message.
    */
   private static void sayGoodbye()
   {
      System.out.println(GOODBYE_ECHO);
   }
}