import java.util.Scanner;

public class SimulatedBankTransaction
{
   private static final String ASK_DEBIT_BALANCE_ECHO
      = "Enter balance of the debit account: ";
   private static final String ASK_SAVINGS_BALANCE_ECHO
      = "Enter balance of the savings account: ";
   private static final String CHOOSE_TRANSACTION_ECHO
      = "Enter number for transaction. Withdrawl(1), Deposit(2), or Transfer(3): ";
   private static final String CHOOSE_ACCOUNT_ECHO
      = "Enter number for account. Debit(1), Savings(2): ";
   private static final String ENTER_AMOUNT_ECHO
      = "Enter amount: ";
      
   private static final String DEBIT_BALANCE_ECHO
      = "Debit account balance: ";
   private static final String SAVINGS_BALANCE_ECHO
      = "Savings account balance: ";
      
   private static final String NEGATIVE_BALANCE_ERROR
      = "Balance cannot be negative";
   private static final String INVALID_INPUT_ERROR
      = "Invalid input.";
   private static final String OVERDRAW_ACCOUNT_ERROR
      = "Would overdraw. Transaction rejected.";
      
   private static final String CASH_FORMAT = "$%.2f";
      
   private static final int WITHDRAWL_TRANSACTION = 1;
   private static final int DEPOSIT_TRANSACTION = 2;
   private static final int TRANSFER_TRANSACTION = 3;
   
   private static final int DEBIT_ACCOUNT = 1;
   private static final int SAVINGS_ACCOUNT = 2;
   
   private static double debitBalance;
   private static double savingsBalance;
   
      
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      
      debitBalance = askDebitBalance(console);
      savingsBalance = askSavingsBalance(console);
      int transactionType = askTransactionType(console);
      int accountType = askAccountType(console);
      double transactionAmount = askTransactionAmount(console);
      
      switch(transactionType)
      {
         case WITHDRAWL_TRANSACTION:
            withdrawl(accountType, transactionAmount);
            break;
         case DEPOSIT_TRANSACTION:
            deposit(accountType, transactionAmount);
            break;
         case TRANSFER_TRANSACTION:
            transfer(accountType, transactionAmount);
            break;
      }
      
      if(debitBalance < 0 || savingsBalance < 0)
      {
         System.out.println(OVERDRAW_ACCOUNT_ERROR);
         System.exit(0);
      }
      
      System.out.println(DEBIT_BALANCE_ECHO
                         + String.format(CASH_FORMAT, debitBalance));
                         
      System.out.println(SAVINGS_BALANCE_ECHO
                         + String.format(CASH_FORMAT, savingsBalance));
   }
   
   private static void withdrawl(int accountType, double amount)
   {
      if(accountType == DEBIT_ACCOUNT)
      {
         debitBalance -= amount;
      }
      else if(accountType == SAVINGS_ACCOUNT)
      {
         savingsBalance -= amount;
      }
   }
   
   private static void deposit(int accountType, double amount)
   {
      if(accountType == DEBIT_ACCOUNT)
      {
         debitBalance += amount;
      }
      else if(accountType == SAVINGS_ACCOUNT)
      {
         savingsBalance += amount;
      }
   }
   
   private static void transfer(int accountType, double amount)
   {
      if(accountType == DEBIT_ACCOUNT)
      {
         debitBalance += amount;
         savingsBalance -= amount;
      }
      else if(accountType == SAVINGS_ACCOUNT)
      {
         savingsBalance += amount;
         debitBalance -= amount;
      }
   }
   
   private static double askDebitBalance(Scanner console)
   {
      // Get the balance of the debit account.
      System.out.print(ASK_DEBIT_BALANCE_ECHO);
      double debitBalance = -1.0;
      try
      {
         debitBalance = console.nextDouble();
      }
      catch(java.util.InputMismatchException e)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      // If negative balance, spit out error and terminate.
      if(debitBalance < 0)
      {
         System.out.println(NEGATIVE_BALANCE_ERROR);
         System.exit(0);
      }
      
      return debitBalance;
   }
   
   private static double askSavingsBalance(Scanner console)
   {
      System.out.print(ASK_SAVINGS_BALANCE_ECHO);
      double savingsBalance = -1.0;
      try
      {
         savingsBalance = console.nextDouble();
      }
      catch(java.util.InputMismatchException e)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      // If negative balance, spit out error and terminate.
      if(savingsBalance < 0)
      {
         System.out.println(NEGATIVE_BALANCE_ERROR);
         System.exit(0);
      }
      
      return savingsBalance;
   }

   private static int askTransactionType(Scanner console)
   {
      System.out.print(CHOOSE_TRANSACTION_ECHO);
      int transactionType = -1;
      try
      {
         transactionType = console.nextInt();
      }
      catch(java.util.InputMismatchException e)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      // If not one 1-3, spit out error and terminate.
      if(transactionType < 1 || transactionType > 3)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      
      return transactionType;
   }
   
   private static int askAccountType(Scanner console)
   {
      System.out.print(CHOOSE_ACCOUNT_ECHO);
      int accountType = 0;
      try
      {
         accountType = console.nextInt();
      }
      catch(java.util.InputMismatchException e)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      // If not one 1 or 2, spit out error and terminate.
      if(accountType < 1 || accountType > 2)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      
      return accountType;
   }
   
   private static double askTransactionAmount(Scanner console)
   {
      System.out.print(ENTER_AMOUNT_ECHO);
      double transactionAmount = -1.0;
      try
      {
         transactionAmount = console.nextDouble();
      }
      catch(java.util.InputMismatchException e)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      // If negative amount, spit out error and terminate.
      if(transactionAmount < 0)
      {
         System.out.println(INVALID_INPUT_ERROR);
         System.exit(0);
      }
      
      return transactionAmount;
   }
}