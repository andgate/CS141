import java.util.Scanner;

public class BankAccountSimulator
{
   public static void main(String[] args)
   {
      System.out.print("Initial Balance: ");
      
      Scanner in = new Scanner(System.in);
      double initialBalance = in.nextDouble();
      
      System.out.print("Annual interest rate in percent: ");
      double interest = in.nextDouble();
      
      BankAccount account = new BankAccount();
      account.deposit(initialBalance);
      
      account.addInterestMonthly(interest);
      System.out.printf("After first month:  %8.2f\n", account.getBalance());
      
      account.addInterestMonthly(interest);
      System.out.printf("After second month: %8.2f\n", account.getBalance());
      
      account.addInterestMonthly(interest);
      System.out.printf("After third month:  %8.2f\n", account.getBalance());
   }
}