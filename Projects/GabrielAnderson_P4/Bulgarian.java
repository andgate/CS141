import java.util.ArrayList;
import java.util.Random;

/**
   An object that simulates a game of bulgarian solitaire.
   Bulgarian solitaire is played with cards arranged
   randomly in piles. The game is played by picking
   up the top card from every pile, and putting those
   top cards into a pile. This process is repeated until
   the piles are ordered like "1 2 3..".
   It's not much fun for a human to play, but computers love it! </br>
   <p>COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 23 November 2014
   @version 1.0
 */
public class Bulgarian
{
   private int soughtPiles;
   private int deckSize;
   private int steps;
   private int[] piles;
   private static final Random generator = new Random();
   
   private static final int[] EMPTY_PILES = { 0 };
   
   private static final String GAME_STEP_ECHO_FORMAT
      = "%d cards. Step %d: %s";
   private static final String PILE_ECHO_FORMAT
      = "%d ";
   private static final String WINNING_PILES_ECHO
      = "Winning Piles: %s";
   
   /**
      Constructs a Bulgarian object, that plays to build
      the given number of piles. Handles negative piles by 
      using the absolute value for the numberOfPiles given.
      Also handles zero piles.
      @param numberOfPiles The number of piles the game will finish with.
    */
   public Bulgarian(int numberOfPiles)
   {
      // Initializes soughtPiles and deckSize
      setNumberOfPiles(numberOfPiles);
      // Initializes steps and piles
      clear();
   }
   
   /**
      Calculates the sum of numbers from 1 to n.
      @param n The last number in the sequence.
    */
   private int sumOneToN(int n)
   {
      // Use gauss's trick for adding numbers
      return n * (n + 1) / 2;
   }
   
   /**
      Plays a full game of Bulgarian Solitaire.
      In other words, sorts the piles.
    */
   public void play()
   {
      createPiles();
      
      while(!winningConfig(piles))
      {
         playTurn();
      }
      
      printWinningPiles();
   }
   
   /**
      Performs one turn of bulgarian solitaire.
    */
   private void playTurn()
   {
      playARound(this.piles);
      printGameStep();
   }
   
   /**
      Empties all the piles and sets the number of game steps to zero.
      Use if the game needs to be played again.
    */
   public void clear()
   {
      piles = EMPTY_PILES;
      steps = 0;
   }
   
   /**
      Print deck size, current step, and piles.
    */
   public void printGameStep()
   {
      System.out.printf(GAME_STEP_ECHO_FORMAT, deckSize, steps, pilesToString());
      System.out.println();
   }
   
   /**
      Prints a message about winning
      and the current pile configuration.
      Does not guarentee the pile is a winning pile.
    */
   public void printWinningPiles()
   {
      System.out.printf(WINNING_PILES_ECHO, pilesToString());
      System.out.println();
   }
   
   /**
      Get the number of steps.
      @return Number of steps.
    */
   public int getSteps()
   {
      return steps;
   }
   
   /**
      Get the deck size.
      @return The deck size.
    */
   public int getDeckSize()
   {
      return deckSize;
   }
   
   /**
      Get the number of piles in the winning configuration.
      @return Number of piles in the winning configuration.
    */
   public int getNumberOfPiles()
   {
      return soughtPiles;
   }
   
   /**
      Sets the number of piles in the winning configuration.
      @param numberOfPiles Number of piles in the winning configuration.
    */
   public void setNumberOfPiles(int numberOfPiles)
   {
      soughtPiles = Math.abs(numberOfPiles);
      deckSize = sumOneToN(soughtPiles);
   }
   
   /**
      Get the current configuration of piles.
      @return The current configuration of piles.
    */
   public int[] getPiles()
   {
      return piles;
   }
   
   /**
      Set the configuration of piles to something different.
      @param piles A new pile configuration.
    */
   public void setPiles(int[] piles)
   {
      this.piles = piles;
   }
   
   /**
      Creates a random set of piles. The number of piles
      is a random number from 1 to the sought piles.
      The number of cards in each pile is randomly chosen.
      @return The new set of piles.
    */
   public int[] createPiles()
   {
      if(soughtPiles == 0)
      {
         this.piles = EMPTY_PILES;
         return EMPTY_PILES;
      }
      
      int intialNumberOfPiles = generator.nextInt(soughtPiles) + 1;
      this.piles = fillWithRandomCards(intialNumberOfPiles);
      
      return this.piles;
   }
   
   /**
      Given the number of piles, randomly places cards into
      those piles. Some piles may not be given cards.
      Therefore, this method is not guarenteed to allocate
      the given number of piles.
      @param numberOfPiles The number of piles to place cards into.
      @return Randomly filled set of piles.
    */
   private int[] fillWithRandomCards(int numberOfPiles)
   {
      int[] newPiles = new int[numberOfPiles];
      
      // For each card in the deck
      for(int cardCount = 0; cardCount < deckSize; cardCount++)
      {
         // Pick a random pile
         int currentPile = generator.nextInt(newPiles.length);
         
         // Increase the pile's size by 1
         newPiles[currentPile] += 1; 
      }
      
      return removeZeros(newPiles);
   }
   
   /**
      Play one round.
      Decreases all the current piles by one.
      Adds a new pile that is the size of
      the number of current piles.
      Increases the step value.
      @param piles The piles to play the round with.
      @return The pile resulting at the end of the round. 
    */
   public int[] playARound(int[] piles)
   {
      this.piles = newPileFromTopCards(piles);
      steps++;
      
      return this.piles;
   }
   
   /**
      Helper method for playARound.
      Removes a card from the top of each pile,
      and places those cards into a new pile.
      @param piles The piles to use.
      @return A new set of piles.
    */
   private int[] newPileFromTopCards(int[] piles)
   {
      // create the new pile list
      int[] newPiles = new int[piles.length + 1];
      
      // Fill the new list with the old list
      for(int pileIndex = 0; pileIndex < piles.length; pileIndex++)
      {
         newPiles[pileIndex] = piles[pileIndex] - 1;
      }
      
      newPiles[piles.length] += piles.length;
      
      return removeZeros(newPiles);
   }
   
   /**
      Remove the zero piles (empty piles).
      @param piles The piles to clean.
      @return A new set of piles, with no zeros.
    */
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
   
   /**
      Returns a count of piles with zero cards.
      @param piles The piles to count.
      @return The number of piles with zero cards.
    */
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
   
   /**
      Determines if a set of piles is the winning configuration.
      A winning set of piles is arranged in acending order,
      with a difference of 1 between each pile size.</br>
      For examples: 1 2 3 4
      @param piles The set of piles to check.
      @return True if winning, false otherwise.
    */
   public boolean winningConfig(int[] piles)
   {
      // If there are no piles, then return true
      if(soughtPiles == 0 && piles.length == 0)
      {
         return true;
      }
      
      // If the length of the piles is not equivalent to
      // the soughtPiles, then there is no way this is true.
      if(soughtPiles != piles.length)
      {
         return false;
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
      return true;
   }
   
   
   private static final String SOUGHT_PILES_FORMAT
      = "Sought piles %d\n";
   private static final String DECK_SIZE_FORMAT
      = "Deck size: %d\n";
   private static final String STEPS_FORMAT
      = "Steps: %d\n";
   private static final String PILES_FORMAT
      = "Piles: %s\n";
   
   /**
      Get the information about the current game.
      @return Formatted string with the game's instance variables.
    */
   public String toString()
   {
      String output = "";
      
      output += String.format(SOUGHT_PILES_FORMAT, soughtPiles);
      output += String.format(DECK_SIZE_FORMAT, deckSize);
      output += String.format(STEPS_FORMAT, steps);
      output += String.format(PILES_FORMAT, pilesToString());
      
      
      return output;
   }
   
   /**
      Get a string of the current piles.
      @return String containing current piles.
    */
   public String pilesToString()
   {
      String pilesString = "";
      for(int pile : piles)
      {
         pilesString += String.format(PILE_ECHO_FORMAT, pile);
      }
      
      return pilesString;
   }
}