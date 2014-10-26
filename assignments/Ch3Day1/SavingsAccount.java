/**
   A savings account that allows deposits, withdraws, and interest gain to it's balance.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class SavingsAccount
{
    private double balance;
    private double interest;
   
   /**
      Constructs a SavingsAccount with a balance of 0 and the given interest rate.
    */
   public SavingsAccount()
   {
      balance = 0;
      interest = 0;
   }
   
   /**
      Constructs a SavingsAccount with the given balance and given interest rate.
      @param initialBalance The balance the savings account starts with, in dollars.
      @param initialInterest The interest rate of the savings account, in percent.
    */
   public SavingsAccount(double initialBalance, double intialInterest)
   {
      balance = initialBalance;
      interest = intialInterest;
   }
   
   /**
      Deposit the given amount to the savings account.
      @param amount The amount to add to the current balance, in dollars.
    */
   public void deposit(double amount)
   {
      balance += amount;
   }
   
   /**
      Withdraw the given amount from the savings account.
      @param amount The amount to remove from the current balance, in dollars.
    */
   public void withdraw(double amount)
   {
      balance -= amount;
   }
   
   /**
      Retrieve the current balance from the savings account.
      @return The current balance in the savings account, in dollars.
    */
   public double getBalance()
   {
      return balance;
   }
   
   /**
      Add the savings account's interest into the balance.
    */
   public void addInterest()
   {
      double decimalRate = interest / 100.0; // change the rate from percent to a decimal value.
      balance += balance * decimalRate;
   }
}