/**
   The purpose of this CannonBall class is to simulate
   the motion of a CannonBall when fired from a cannon
   at a particular angle and initial velocity, assuming
   a constant velocity.
   @author Gabriel Anderson, Erickson Victor
   @version 1.0
   @since November 30, 2014
 */
public class CannonBall
{
   private double elapsed;
   private double xPos;
   private double xVel;
   private double yPos;
   private double yVel;
   
   private static final String LOCATION_FORMAT
      = "time:%5.2fs, x:%5.2fm, y:%5.2fm";
   private static final String GROUND
      = "|";
   private static final String CANNON_BALL
      = "*";
   private static final double CLOCK_TICK_SECONDS
      = 0.1;
   private static final double MAX_ELAPSED_SECONDS
      = 2.0;
   private static final double DEFAULT_X_POSITION
      = 0.0;
   private static final String EMPTY_SPACE
      = " ";
   private static final double GRAVITY_METERS_PER_SECONDS_SQUARED
      = -9.8;
   private static final String SPACE_BETWEEN_GROUND_AND_TEXT
      = "    ";
   private static final int SCALE
      = 1;
   private static final double DEGREES_TO_RADIANS
      = Math.PI / 180.0;
   private static final double EPSILON
      = 1.0 / 1E15;
   
   /**
      Construct a cannonball at the default x position of zero.
    */
   public CannonBall()
   {
      // Use CannonBall(double xPos) to construct
      // a cannonball with a x pos of 0.
      this(0.0);
   }
   
   /**
      Construct a cannonball at the given x position.
      @param xPos The x position where the cannonball is fired.
    */
   public CannonBall(double xPos)
   {
      // Initialize the cannonball with the given xPos.
      // Initialize the rest of the instance variables with zeros.
      elapsed = 0.0;
      xPos = xPos;
      xVel = 0.0;
      yPos = 0.0;
      yVel = 0.0;
   }
   
   /**
      Displays a graphic of the cannon ball and the ground at a given y postion.
      Only prints text to the console.
      @param yPos The position of the cannonball above the ground.
    */
   private static void displayGraphic(double yPos)
   {
      // The yPos is the distance between the ground and the
      // cannonball. With that, display it with text-graphiic.
      
      // Print out the ground with it's space.
      System.out.print(SPACE_BETWEEN_GROUND_AND_TEXT + GROUND);
      
      // Use the repeat String method to print out the
      // blank spaces between the ground and the cannonball
      // based on the (yPos - 1).
      int spaceSize = (int)Math.ceil(yPos - 1);
      System.out.print(repeat(EMPTY_SPACE, spaceSize));
      
      // Print out the cannon ball.
      // Then print a newline.
      System.out.print(CANNON_BALL);
      System.out.println();
   }
   
   /**
      Display the current elapsed time and x+y coordinates.
      Only prints text to the console.
      @param elapsed The current elapsed time.
      @param xPos The current x position.
      @param yPos The current y position.
    */
   private static void displayLocation(double elapsed, double xPos, double yPos)
   {
      // Use printf to format the output with elapsed time,
      // x position, and y position.
      System.out.printf(LOCATION_FORMAT, elapsed, xPos, yPos);
   }
   
   /**
      Get the current x position.
      @return The current x position.
    */
   public double getX()
   {
      // Just return xPos.
      return xPos;
   }
   
   /**
      Get the current y position.
      @return The current y position.
    */
   public double getY()
   {
      // Just return yPos
      return yPos;
   }
   
   /**
      Get the current elapsed time.
      @return The current elapsed time.
    */
   public double getElapsed()
   {
      // Just return elapsed time.
      return elapsed;
   }
   
   /**
      Moves the cannonball for the given time unit
      based on its x and y velocities, and also
      updates y velocity with respect to gravity.
      @param timeChange The change in time, in seconds.
    */
   public void moveBall(double timeChange)
   {
      // Updates the x and y positions based on their velocities.

      // The new x position would be x + x velocity * elapsed time.
      xPos += xVel * timeChange;
      // The new y position would be y + y velocity * elapsed time.
      yPos += yVel * timeChange;
      
      // Then update the y velocity.
      // The new y velocity is y velocity + gravity * elapsed time.
      yVel += GRAVITY_METERS_PER_SECONDS_SQUARED * timeChange;
      
      // Add the timeChange to the elapsed time.
      elapsed += timeChange;
   }
   
   /**
      Produces a string composed the given string
      repeated a given number of times.
      @param str The string to be repeated.
      @param times The number of times the string is repeated.
      @return The given string repeated the given number of times.      
    */
   private static String repeat(String str, int times)
   {
      // Create an empty string. This will be the output string.
      String output = "";
      
      // Loop the given number of times.
      for(int i = 0; i < times; i++)
      {
         // In the loop, concatenate the given string to
         // the output string.
         output += str;
      }
      
      // Once the loop is finished, return the output string.
      return output;
   }
   
   /**
      Simulates a cannonball being fired given
      the launch angle and initial velocity.
      Displays a full simulation until cannonball
      hits ground or the simulation runs out of time.
      @param launchAngle The launch angle of the cannonball, in degrees.
      @param initialVelocity The velocity of the cannonball, in meters per second.
    */
   public void shoot(double launchAngle, double initialVelocity)
   {
      // Calculate the x velocity, and store it.
      xVel = getComponentX(launchAngle, initialVelocity);
      // Calculate the y velocity, and store it.
      yVel = getComponentY(launchAngle, initialVelocity);
      
      // Loop while the current time is lesser or equal to
      // the max elapsed time, or while the y position
      // is greater than or equal to zero.
      while(elapsed < (MAX_ELAPSED_SECONDS + EPSILON)
            && yPos >= (0.0 - EPSILON))
      {  
         // Display the location.
         displayLocation(elapsed, xPos, yPos);
         
         // Display the graphic.
         displayGraphic(yPos);
         
         // Update the cannonball's movement.
         moveBall(CLOCK_TICK_SECONDS);
      }
   }
   
   /**
      Calculates the x component of a vector.
      @param angle The angle of the vector.
      @param velocity The magnitude of the vector.
      @return The magnitude of the x component of the vector.
    */
   private static double getComponentX(double angle, double magnitude)
   {
      // The x component of velocity is
      // computed with velocity * cos(angle)
      return magnitude * Math.cos(angle * DEGREES_TO_RADIANS);
   }
   
   /**
      Calculates the y component of a vector.
      @param angle The angle of the vector.
      @param velocity The magnitude of the vector.
      @return The magnitude of the y component of the vector.
    */
   private static double getComponentY(double angle, double magnitude)
   {
      // The y component of velocity is
      // computed with velocity * sin(angle)
      return magnitude * Math.sin(angle * DEGREES_TO_RADIANS);
   }
}