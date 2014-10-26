/**
   A bank account that allows deposits, withdraws, and interest gain to it's balance.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class BankAccount
{
   private double balance;
   private double monthlyFee;
   private double transactionFee;
   private int freeTransactions;
   private int transactionCount;
   
   private final static double ZERO_BALANCE = 0.0;
   private final static double NO_FEE = 0.0;
   private final static int MINIMAL_TRANSACTION_LIMIT = 0;
   private final static int NO_TRANSACTIONS = 0;
   
   /**
      Constructs a BankAccount with a zero balance and no transaction fee.
    */
   public BankAccount()
   {
      this(ZERO_BALANCE, NO_FEE, MINIMAL_TRANSACTION_LIMIT);
   }
   
   /**
      Constructs a BankAccount with a starting balance and transaction fee in place.
      @param initialBalance The balance the bank account starts with, in dollars.
      @param initialTransactionFee Cost of a transaction made when over the limit, in dollars.
      @param currentFreeTransactions The number of free transactions that can be made.
    */
   public BankAccount(double initialBalance, double initialTransactionFee, int initialFreeTransactions)
   {
      balance = initialBalance;
      transactionFee = initialTransactionFee;
      freeTransactions = Math.max(0, initialFreeTransactions);
      transactionCount = NO_TRANSACTIONS;
   }
   
   /**
      Deposit the given amount to the bank account.
      @param amount The amount to add to the current balance, in dollars.
    */
   public void deposit(double amount)
   {
      balance += amount;
      transactionCount++;
   }
   
   /**
      Withdraw the given amount from the bank account. Transaction fee may apply.
      @param amount The amount to remove from the current balance, in dollars.
    */
   public void withdraw(double amount)
   {
      balance -= amount;
      transactionCount = ++transactionCount;
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
   
   /**
      Deducts the monthly charge, or the cost of the non-free transactions,
      from the balance of the account.
    */
   public void deductMonthlyCharge()
   {
      int chargedTransactions = Math.max(transactionCount, freeTransactions) - freeTransactions;
      double totalMonthlyCharge = chargedTransactions * transactionFee;
      balance -= totalMonthlyCharge;
      transactionCount = NO_TRANSACTIONS;
   }
}