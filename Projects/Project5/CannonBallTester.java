import java.util.Scanner;

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
      
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
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
      Prompts the user with input, and keeps attempting
      .
      @param in The scanner used to query input.
      @return A valid number of piles.
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
            sayProgramExit();
            System.exit(0);
         }
         catch(java.lang.IllegalStateException e)
         {
            sayProgramExit();
            System.exit(0);
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
   
   private static void sayProgramExit()
   {
      System.out.println(PROGRAM_EXIT_ECHO);
   }
}