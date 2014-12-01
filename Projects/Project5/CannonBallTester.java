import java.util.Scanner;

/**
   A simple tester class for testing a CannonBall object.
   When run, the user is asked for an angle and velocity.
   A cannonball is then fired with those given parameters,
   and the progress is printed to System.out.
   @author Gabriel Anderson
   @version 1.0
   @since November 30, 2014
 */
public class CannonBallTester
{
   private static final double MIN_ANGLE
      = 0.0;
   private static final double MAX_ANGLE
      = 90.0;
   private static final double MIN_VELOCITY
      = 0.0;
   private static final double MAX_VELOCITY
      = 20.0;
   private static final String ASK_ANGLE_ECHO_FORMAT
      = "Enter firing angle (%.1f-%.1f degrees): ";
   private static final String ASK_VELOCITY_ECHO_FORMAT
      = "Enter firing velocity (%.1f-%.1f m/s): ";
   private static final String OUT_OF_RANGE_ECHO_FORMAT
      = "Value needs to from %.2f to %.2f. Try again.";
   private static final String INVALID_INPUT_ECHO
      = "Invalid input. Try again.";
   private static final String PROGRAM_EXIT_ECHO
      = "Program exit.";
   
   /**
      The main method.
      @param args The arguments given to the program.
    */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      // Look at me, I'm super modular woo!
      double angle = askDouble(in,
                               ASK_ANGLE_ECHO_FORMAT,
                               MIN_ANGLE,
                               MAX_ANGLE);
      double velocity = askDouble(in,
                               ASK_VELOCITY_ECHO_FORMAT,
                               MIN_VELOCITY,
                               MAX_VELOCITY);
      
      CannonBall cannon = new CannonBall();
      cannon.shoot(angle, velocity);
   }
   
   /**
      Asks the user for a double in the given range.
      Prompts the user with input, and continues to
      retry with the same prompt until a valid input is
      entered that lies within the given range.
      @param in The scanner used to query input.
      @param prompt The message to prompt with.
                    Must be formattable with two floats.
      @param low The lowest acceptable value.
      @param high The highest acceptable value.
      @return A valid double entered by the user.
    */
   private static double askDouble(Scanner in, String prompt, double low, double high)
   {
      while(true)
      {
         System.out.printf(prompt, low, high);
         
         // initialize with an invalid value
         double value = 0;
         
         try
         {
            value = in.nextDouble();
         }
         catch(java.util.InputMismatchException e)
         {
            System.out.println(INVALID_INPUT_ECHO);
            in.next();
         }
         catch(java.util.NoSuchElementException e)
         {
            programExit();
         }
         catch(java.lang.IllegalStateException e)
         {
            programExit();
         }
         
         if(low <= value && value <= high)
         {
            return value;
         }
         else
         {
            System.out.printf(OUT_OF_RANGE_ECHO_FORMAT, low, high);
            System.out.println();
         }
      }
   }
   
   /**
      Exits the program, and informs the user.
      For use when program abruptly needs to exit.
    */
   private static void programExit()
   {
      System.out.println(PROGRAM_EXIT_ECHO);
      System.exit(0);
   }
}