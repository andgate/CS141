import java.util.Scanner;

/**
   Tests the object PickupGame for proper functionality.</br>
   <p>COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 09 November 2014
   @version 1.0
 */
public class PickupGameTester
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      
      PickupGame game = new PickupGame();
      game.play(console);
      
      System.out.println(game.toString());
   }
}