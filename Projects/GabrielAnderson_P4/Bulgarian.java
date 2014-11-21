import java.util.ArrayList;
import java.util.Random;

public class Bulgarian
{
   private int soughtPiles;
   private int deckSize;
   private int steps;
   private int[] piles;
   private static final Random generator = new Random();
   
   public Bulgarian(int numberOfPiles)
   {
      this(numberOfPiles, generator.nextInt(45) + 1);
   }
   
   public Bulgarian(int numberOfPiles, int deckSize)
   {
      this.piles = new int[numberOfPiles];
      this.deckSize = deckSize;
   }
   
   public void play()
   {
      piles = createPiles();
      
      while(!winningConfig(piles))
      {
         piles = playARound(piles);
         piles = removeZeros(piles);
         
         steps++;
         
         
         // print current state
         String message = "";
         message += deckSize + " cards. ";
         message += "Step " + steps + ": ";
         
         for(int pile : piles)
         {
            message += pile + " ";
         }
         
         System.out.println(message);
         
      }
   }
   
   public int[] getPiles()
   {
      return piles;
   }
   
   public void setPiles(int[] piles)
   {
      this.piles = piles;
   }
   
   public int[] createPiles()
   {
      // For each card in the deck
      for(int cardCount = 0; cardCount < deckSize; cardCount++)
      {
         // Pick a random pile
         int currentPile = generator.nextInt(piles.length);
         
         // Increase the pile's size by 1
         piles[currentPile] += 1; 
      }
      
      piles = removeZeros(piles);
      
      return piles;
   }
   
   public int[] playARound(int[] piles)
   {
      // create the new pile list
      int[] newPiles = new int[piles.length + 1];
      
      // Fill the new list with the old list
      for(int pileIndex = 0; pileIndex < piles.length; pileIndex++)
      {
         newPiles[pileIndex] = piles[pileIndex] - 1;
      }
      
      newPiles[piles.length] += piles.length;
      
      return newPiles;
   }
   
   private int[] removeZeros (int[] piles)
   {
      // Count the number of zeros
      int zeroCount = getZeroCount(piles);
      
      // Make an array the size of the old one
      // minus the number of zeros
      int newSize = piles.length - zeroCount;
      int[] newPiles = new int[newSize];
      
      // fill the new array with the non-zero
      // elements of the old one.
      int nextFillIndex = 0;
      for(int pileIndex = 0; pileIndex < piles.length; pileIndex++)
      {
         if(piles[pileIndex] != 0)
         {
            newPiles[nextFillIndex] = piles[pileIndex];
            nextFillIndex++;
         }
      }
      
      return newPiles;
   }
   
   private int getZeroCount(int[] pile)
   {
      int zeroCount = 0;
      for(int pileIndex = 0; pileIndex < piles.length; pileIndex++)
      {
         if(piles[pileIndex] == 0)
         {
            zeroCount++;
         }
      }
      return zeroCount;
   }
   
   public boolean winningConfig(int[] piles)
   {
      // For each pile
      for (int pileIndex = 0; pileIndex < piles.length; pileIndex++)
      {
         // If the (index+1) isn't the same as the pile
         if((pileIndex+1) != piles[pileIndex])
         {
            // Then the configuration does not win.
            return false;
         }
      }
      
      // The configuration passed the check.
      // This means the piles are winning.
      
      // Print out the winning piles.
      
      return true;
   }
   
   public String toString()
   {
      return "";
   }
}