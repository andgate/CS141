import java.util.ArrayList;
import java.util.Random;

public class Bulgarian
{
   private int soughtPiles;
   private int deckSize;
   private int steps;
   private int[] piles;
   private static final Random generator = new Random();
   
   private static final int[] EMPTY_PILES = { 0 };
   
   public Bulgarian(int numberOfPiles)
   {
      soughtPiles = Math.abs(numberOfPiles);
      piles = new int[soughtPiles];
      deckSize = sumOneToN(soughtPiles);
      steps = 0;
   }
   
   private int sumOneToN(int n)
   {
      // Use gauss's trick for adding numbers
      return n * (n + 1) / 2;
   }
   
   public void play()
   {
      createPiles();
      
      while(!winningConfig(piles))
      {
         playARound(this.piles);
         removeZeros(this.piles);
         
         steps++;
         
         System.out.printf("%d cards. Step %d: ", deckSize, steps);
         printPiles();
         System.out.println();
      }
      
      System.out.print("Winning Pile: ");
      printPiles();
      System.out.println();
   }
   
   public void printPiles()
   {
      for(int pile : piles)
      {
         System.out.printf("%d ", pile);
      }
   }
   
   public int getSteps()
   {
      return steps;
   }
   
   public int getDeckSize()
   {
      return deckSize;
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
      if(soughtPiles == 0)
      {
         this.piles = EMPTY_PILES;
         return EMPTY_PILES;
      }
      
      int intialNumberOfPiles = generator.nextInt(soughtPiles) + 1;
      int[] newPiles = new int[intialNumberOfPiles];
      // For each card in the deck
      for(int cardCount = 0; cardCount < deckSize; cardCount++)
      {
         // Pick a random pile
         int currentPile = generator.nextInt(newPiles.length);
         
         // Increase the pile's size by 1
         newPiles[currentPile] += 1; 
      }
      
      newPiles = removeZeros(newPiles);
      
      this.piles = newPiles;
      return newPiles;
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
      
      this.piles = newPiles;
      return newPiles;
   }
   
   private int[] removeZeros (int[] piles)
   {
      if(soughtPiles == 0)
      {
         this.piles = EMPTY_PILES;
         return EMPTY_PILES;
      }
      
      // Count the number of zeros
      int zeroCount = getZeroCount(piles);
      
      if(zeroCount == 0)
      {
         return piles;
      }
      
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
      
      
      this.piles = newPiles;
      return newPiles;
   }
   
   private int getZeroCount(int[] piles)
   {
      if(soughtPiles == 0)
      {
         return 0;
      }
      
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
      if(soughtPiles == 0)
      {
         return true;
      }
      
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