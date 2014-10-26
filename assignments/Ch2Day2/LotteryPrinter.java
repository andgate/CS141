import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Arrays;

/**
   Play the lottery for huge cash rewards!<br>
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson. All Rights Reserved.
   @author Gabriel Anderson, Victor Erickson
   @since 6 October 2014
 */
public class LotteryPrinter
{
   final static String WINNING_NUMBERS_ECHO = "Play this combination, it'll make you rich!";
   final static String START_PICKING_ECHO = "Pick 6 numbers!";
   final static String PICKED_NUMBERS_ECHO = "You picked the following numbers:";
   final static String NUMBERPICKER_ECHO = "Pick a number between 1 and 49!";
   final static String INVALID_INPUT_ECHO = "Invalid input. Try again.";
   final static String OUT_OF_RANGE_ECHO = "Given number was out of range. Try again.";
   final static int LOTTERY_LENGTH = 6;
   final static int MIN_LOTTERY_NUMBER = 1;
   final static int MAX_LOTTERY_NUMBER = 49;
   
   public static void main(String[] args)
   {
      System.out.println(WINNING_NUMBERS_ECHO);
      
      int[] winningCombination = generateRandomLottery();
      printLottoNumbers(winningCombination);
      
      assert winningCombination.length == LOTTERY_LENGTH;
     
      System.out.println(START_PICKING_ECHO);
     
      int[] playerCombination = askPlayerCombination();
      printPlayerCombination(playerCombination);
      
      printResult(winningCombination, playerCombination);
   }
   
   /**
      Produces a random set lottery numbers, between 1 and 49.
      @return Array of 6 random, valid lottery numbers.
    */
   public static int[] generateRandomLottery()
   {
      Random generator = new Random();
      int[] numberList = new int[LOTTERY_LENGTH];
      
      for(int i = 0; i < LOTTERY_LENGTH; i++) 
      {
         numberList[i] = generator.nextInt(49) + 1; // generates a number between 1 and 49
      }
      
      return numberList;
   }
   
   /**
      Prints the given lottery numbers to the command line.<br>
      Example output: 23 24 27 43 2 19<br>
      Does not check for validity.
      @param lottoNumbers The lottery numbers to print.
    */
   public static void printLottoNumbers(int[] lottoNumbers)
   {
      for(int lottoNumber : lottoNumbers) 
      {
         System.out.print(lottoNumber + " ");
      }
      
      System.out.println("\n");
   }
   
   /**
      Produces a series of 6 dialog boxes, asking the player for valid lottery numbers.
      @return A set of the 6 valid lottery numbers entered by the player.
    */
   public static int[] askPlayerCombination()
   {
      int[] playerCombination = new int[LOTTERY_LENGTH];
       
      for(int i = 0; i < LOTTERY_LENGTH; i++)
      {
         playerCombination[i] = askNumber();
      }
      
      return playerCombination;
   }
   
   /**
      Prints a message to the command line telling the player which lottery numbers they picked.
    */
   public static void printPlayerCombination(int[] playerCombination)
   {
      System.out.print("\n");
      System.out.println(PICKED_NUMBERS_ECHO);
      printLottoNumbers(playerCombination);
   }
   
   /**
      Produces a single dialog box asking the player for a valid lottery number.<br>
      If the lottery number is invalid, that is out of the range 1-49, or the input is invalid,
      like letters and non-numeric symbols, the user is told their error and asked again.
      Finally, if the player chooses to exit the dialog, the program quits.
      @return The valid lottery number the player picked.
    */
   public static int askNumber()
   {
      int parsedNumber = 0;
      
      try
      {
         String numberInput = JOptionPane.showInputDialog(NUMBERPICKER_ECHO).trim();
         parsedNumber = Integer.parseInt(numberInput);
      }
      catch(NullPointerException e)
      {
         System.out.println("Goodbye!");
         System.exit(0);
      }
      catch(NumberFormatException e)
      {
         retryAskNumber(INVALID_INPUT_ECHO);
      }
      
      return validateNumber(parsedNumber);
   }
   
   /**
      Validates a given lottery number. If the number is out of range, informs the player and
      prompts them to enter another number.
      @param lotteryNumber The lottery number to validate. A valid number is between 1 and 49.
      @return A valid lottery number.
    */
   public static int validateNumber(int lotteryNumber)
   {
      if( (lotteryNumber <= MAX_LOTTERY_NUMBER)
         && (lotteryNumber >= MIN_LOTTERY_NUMBER))
      {
         System.out.println("You picked a " + lotteryNumber + "!");
         return lotteryNumber;
      }
      else
      {
         return retryAskNumber(OUT_OF_RANGE_ECHO);
      }
   }
   
   /**
      Called when the program needs to ask the player to renter a lottery number,
      as the input or number was invalid. Also informs the player why the number
      is being asked for again.
      @param echo The reason the program gives for asking again. 
      @return A valid lottery number.
    */
   public static int retryAskNumber(String echo)
   {
      System.out.println(echo);
      return askNumber();
   }
   
   /**
      Prints the result of lottery to the command line,
      informing the player whether they won or lost.
      @param winningCombination The combination needed for winning the lottery.
      @param playerCombination The combination the player hopes will win.
    */
   public static void printResult(int[] winningCombination, int[] playerCombination)
   {
      if(Arrays.equals(winningCombination, playerCombination))
      {
         System.out.println("$$$ You are a winner! Congratulations! $$$");
      }
      else
      {
         System.out.println("Sorry, you lose. Better luck next time!");
      }
   }
}