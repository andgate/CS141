public class BankTransaction
{
   public enum TransactionType
   {
      WITHDRAW,
      DEPOSIT,
      TRANSFER,
      INVALID
   }
   
   public static void main(String[] args)
   {
      
      BankAccount debit = new BankAccount();
      BankAccount savings = new BankAccount();
   }
   
   public TransactionType getTransaction(int transactionNum)
   {
      if(transactionNum == 1)
      {
         return TransactionType.WITHDRAW;
      }
      else if(transactionNum == 2)
      {
         return TransactionType.DEPOSIT;
      }
      else if(transactionNum == 3)
      {
         return TransactionType.TRANSFER;
      }
      
      return TransactionType.INVALID;
   }
}