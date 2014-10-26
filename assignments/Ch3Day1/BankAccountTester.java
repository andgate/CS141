/**
   Tests withdrawing and depositing of a BankAccount object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class BankAccountTester
{
   public static void main(String[] args)
   {
      BankAccount checking = new BankAccount();
      
      checking.deposit(1000);
      checking.withdraw(500);
      checking.withdraw(400);
      
      System.out.println("Actual balance: " + checking.getBalance());
      System.out.println("Expected balance: 100.0");
   }
}