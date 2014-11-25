import java.util.Scanner;
import java.io.File;

public class RegisterCheck
{
   private static final String TRANSACTIONS_FILENAME
      = "transactions.txt";
   
   private static final String RECEIVED = "R";
   private static final String PAID = "P";
   
   private static final String CASH_START_ECHO
      = "Enter amount of cash in register at start of day: ";
   private static final String CASH_END_ECHO
      = "Enter amount of cash in register at end of day: ";
      
   private static final String CORRUPT_FILE_ECHO
      = "Error: " + TRANSACTIONS_FILENAME + " is corrupt.";
   private static final String CORRUPT_SYSTEM_ECHO
      = "Something broke!";
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      double startCash = askMoney(in, CASH_START_ECHO);
      double endCash = askMoney(in, CASH_END_ECHO);
      
      String transactionsText = readTextFile(TRANSACTIONS_FILENAME);
      double total = sumTransactions(transactionsText);
      
      double expectedEndCash = startCash + total;
      
      if(expectedEndCash == endCash)
      {
         System.out.println("Everything is accounted for.");
      }
      else
      {
         System.out.println("Something is missing.");
      }
   }
   
   private static double sumTransactions(String transactions)
   {
      double total = 0;
      
      Scanner text = new Scanner(transactions);
      
      try
      {
         while(text.hasNext())
         {
            total += getAmountFromLine(text);
         }
      }
      catch (java.lang.IllegalStateException e)
      {
         systemError();
      }
      
      return total;
   }
   
   private static double getAmountFromLine(Scanner in)
   {
      double amount = 0.0;
      String type = "";
      
      try
      {
         in.next();
         amount = in.nextDouble();
         type = sanitizeInput(in.next());
      }
      catch (java.util.InputMismatchException e)
      {
         corruptFileError();
      }
      catch (java.util.NoSuchElementException e)
      {
         corruptFileError();
      }
      catch (java.lang.IllegalStateException e)
      {
         systemError();
      }
      
      if (type.equals(RECEIVED))
      {
         // Seems redundant
         // but could be useful
         // in the future
         amount = Math.abs(amount);
      }
      else if (type.equals(PAID))
      {
         amount = -1 * Math.abs(amount);
      }
      else
      {
         corruptFileError();
      }
      
      return amount;
   }
   
   private static String sanitizeInput(String input)
   {
      return input.trim().toUpperCase().substring(0,1);
   }
   
   private static double askMoney(Scanner in, String prompt)
   {                        
      while(true)
      {
         System.out.print(prompt);
         
         if (in.hasNext() && in.hasNextDouble())
         {
            return in.nextDouble();
         } else {
            flushInvalidInput(in);
         }
      }
   }
   
   private static void flushInvalidInput(Scanner in)
   {
      String junk = in.next(); //consume/sremove this input        
      System.out.println("'" + junk 
         + "' is invalid input. Please try again.");
   }
   
   private static String readTextFile(String filename)
   {
      String contents = "";
      try
      {
         File file = new File(filename);
         Scanner in = new Scanner(file);
         
         try
         {
            in.useDelimiter("\\Z");
            contents = in.next();
         }
         finally
         {
            in.close();
         }
      }
      catch(java.io.FileNotFoundException e)
      {
         System.out.println("ERROR: " + filename + " not found.");
         System.out.println("Could not read file.");
         System.exit(0);
      }
      
      return contents;
   }
   
   private static void corruptFileError()
   {
      System.out.println(CORRUPT_FILE_ECHO);
      System.exit(0);
   }
   
   private static void systemError()
   {
      System.out.println(CORRUPT_SYSTEM_ECHO);
      System.exit(0);
   }
}