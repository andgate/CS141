/**
   Tests the addInterest method of a SavingsAccount object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class SavingsAccountTester
{
   public static void main(String[] args)
   {
      SavingsAccount savings = new SavingsAccount(1000, 10);
      
      savings.addInterest();
      
      System.out.println("Actual balance: " + savings.getBalance());
      System.out.println("Expected balance: 1100.0");
   }
}