import java.util.Random;

/**
   Simulates a coin flip.</br>
   Intended for randomly picking between two choices.
   <p>COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 09 November 2014
   @version 1.0
 */
public class Coin
{
   /**
      Arbitrary value for HEADS is 0.
    */
   public static final int HEADS = 0;
   
   /**
      Arbitrary value for TAILS is 1.
    */
   public static final int TAILS = 0;
   
   /**
      Randomly produces a 0 or a 1,
      which can be used in an if-statement
      to decided between two choices.
      @return The value 0 or 1, randomly chosen.
    */
   public static int toss()
   {
      return new Random().nextInt(2);
   }
}