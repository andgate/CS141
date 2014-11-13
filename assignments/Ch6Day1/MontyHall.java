import java.util.Random;

public class MontyHall
{
   private static final int SAMPLE_SIZE = 1000;
   private static final int ROUNDS_PER_GAME = 1000;
   
   public static void main(String[] args)
   {
      int switchWins = 0;
      int stayWins = 0;
      Random random = new Random();
      
      for (int plays = 0; plays < SAMPLE_SIZE; plays++)
      {
         // Generates a random number from 0 to 2.
         // Add one to make from 1 to 3,
         // which is the number of doors.
         int winner = random.nextInt(3) + 1;
         
         // Choose a random door
         int choice = random.nextInt(3) + 1;
         
         // Wins by staying
         if (winner == choice)
         {
            stayWins++;
         }
         // Otherwise, win by switching
         else
         {
            switchWins++;
         }
      }
      
      System.out.println("Switch wins: " + switchWins);
      System.out.println("Stay wins: " + stayWins);
   }
}