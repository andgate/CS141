/**
   Tests withdrawing and depositing of a BankAccount object
   with a transaction fee.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class BankAccountTester
{
   public static void main(String[] args)
   {
      BankAccount checking = new BankAccount(1000.00, 3.00, 3);
      
      checking.deposit(1000);
      checking.deposit(100);
      checking.withdraw(100);
      checking.deposit(100);
      checking.deductMonthlyCharge();
      System.out.printf("Actual balance: %.2f\n", checking.getBalance());
      System.out.println("Expected balance: 2097.00");
      
      checking.deposit(1000);
      checking.deposit(100);
      checking.withdraw(100);
      checking.deposit(100);
      checking.deductMonthlyCharge();
      
      System.out.printf("Actual balance: %.2f\n", checking.getBalance());
      System.out.println("Expected balance: 3194.00");
      
      checking.deposit(1000);
      checking.deposit(100);
      checking.withdraw(100);
      checking.deposit(100);
      checking.deductMonthlyCharge();
      
      System.out.printf("Actual balance: %.2f\n", checking.getBalance());
      System.out.println("Expected balance: 4291.00");
   }
}