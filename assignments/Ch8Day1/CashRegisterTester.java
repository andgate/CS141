/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      final Coin DOLLAR = new Coin(1.0, "Dollar");
      final Coin QUARTER = new Coin(0.25, "Quarter");
      final Coin EUROS = new Coin(1.15, "Euro");

      CashRegister register = new CashRegister();

      register.recordPurchase(1.95);
      register.recordPurchase(1.40);
      register.receivePayment(3, DOLLAR);
      register.receivePayment(2, QUARTER);

      double change = register.giveChange();

      System.out.println("Actual: " + String.format("%.2f", change));      
      System.out.println("Expected: 0.15");          
   }
}