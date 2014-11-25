import java.lang.IllegalArgumentException;

/**
   A bank account that allows deposits, withdraws, and interest gain to it's balance.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson
 */
public class BankAccount
{
   private double balance;
   
   /**
      Constructs a BankAccount with a balance of 0.
    */
   public BankAccount()
   {
      balance = 0;
   }
   
   /**
      Constructs a BankAccount with the given balance.
      @param initialBalance The balance the bank account starts with, in dollars.
    */
   public BankAccount(double initialBalance)
      throws IllegalArgumentException
   {
      if(initialBalance < 0)
      {
         throw new IllegalArgumentException("Initial balance must be non-negative.");
      }
      
      balance = initialBalance;
   }
   
   /**
      Deposit the given amount to the bank account.
      @param amount The amount to add to the current balance, in dollars.
    */
   public void deposit(double amount)
      throws IllegalArgumentException
   {
      if(amount < 0)
      {
         throw new IllegalArgumentException("Deposit amount must be non-negative.");
      }
      
      balance += amount;
   }
   
   /**
      Withdraw the given amount from the bank account.
      @param amount The amount to remove from the current balance, in dollars.
    */
   public void withdraw(double amount)
   {
      if((balance - amount) < 0)
      {
         throw new IllegalArgumentException("Withdraw amount cannot overdraft account.");
      }
      
      balance -= amount;
   }
   
   /**
      Retrieve the current balance from the bank account.
      @return The current balance in the bank account, in dollars.
    */
   public double getBalance()
   {
      return balance;
   }
   
   /**
      Add a given interest into the balance at the given rate.
      @param rate The rate of interest, in percent.
    */
   public void addInterest(double rate)
   {
      double decimalRate = rate / 100.0; // change the rate from percent to a decimal value.
      balance += balance * decimalRate;
   }
}