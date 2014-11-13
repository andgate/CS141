public class BankAccount
{
   public enum AccountType
   {
      CHECKING,
      SAVINGS,
      INVALID
   }
   
   private double balance;
   private AccountType type;
   
   public BankAccount(double initialBalance, AccountType initialType)
   {
      balance = initialBalance;
      type = initialType;
   }
   
   private static AccountType getType(int typeNum)
   {
      if(typeNum == 1)
      {
         return AccountType.CHECKING;
      }
      else if (typeNum == 2)
      {
         return AccountType.SAVINGS;
      }
      
      return AccountType.INVALID;
   }
}