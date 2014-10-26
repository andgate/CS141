/**
   Tests addInterest method of a BankAccount object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class BankAccountInterestTester
{
   public static void main(String[] args)
   {
      BankAccount checking = new BankAccount(1000);
      
      checking.addInterest(10);
      
      System.out.println("Actual balance: " + checking.getBalance());
      System.out.println("Expected balance: 1100.0");
   }
}