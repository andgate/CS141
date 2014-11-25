/**
   Tests withdrawing and depositing of a BankAccount object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson
 */
public class BankAccountTester
{
   public static void main(String[] args)
   {
      
      BankAccount checking;
      
      try
      {
         checking = new BankAccount(-1000);
      }
      catch(java.lang.IllegalArgumentException e)
      {
         System.out.print("Negative initial balance caught: ");
         System.out.println(e.getMessage());
      }
      
      // Now make a checking account that can be used.
      checking = new BankAccount(1000);
      
      
      try
      {
         checking.deposit(-1);
      }
      catch(java.lang.IllegalArgumentException e)
      {
         System.out.print("Negative deposit amount caught: ");
         System.out.println(e.getMessage());
      }
      
      try
      {
         checking.withdraw(1001);
      }
      catch(java.lang.IllegalArgumentException e)
      {
         System.out.print("Overdraft caught: ");
         System.out.println(e.getMessage());
      }
      
      System.out.printf("Actual balance: $%.2f\n", checking.getBalance());
      System.out.println("Expected balance: $1000.00");
   }
}