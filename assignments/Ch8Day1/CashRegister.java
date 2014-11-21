public class CashRegister
{
   private double purchase;
   private double payment;

   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
   public void receivePayment(int coinCount, Coin coinType)
   {
      payment = payment + coinCount * coinType.getValue();
   }
   
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
}
