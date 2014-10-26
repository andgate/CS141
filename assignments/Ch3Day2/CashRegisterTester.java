/**
   Tests a CashRegister  object that applies tax.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister(15);
      
      register.recordPurchase(29.50);
      register.recordPurchase(9.25);
      register.receivePayment(50.00);
      register.recordTaxablePurchase(3.25);
      
      System.out.println("Expected item count: 3 items");
      System.out.println("Actual item count: " + register.getItemCount() + " items");
      
      double change = register.giveChange();
      
      System.out.println("Expected receipt:");
      System.out.println("$29.50 item purchased.");
      System.out.println("$9.25 item purchased.");
      System.out.println("$50.0 paid.");
      System.out.println("$3.25 item purchased with 15.0% tax.");
      System.out.println("\nItem count 3");
      System.out.println("Total cost: $42.49");
      System.out.println("Total paid: $50.0");
      System.out.println("Change due: $7.51");


      System.out.println("\nActual receipt:");
      register.printReceipt();
      
      System.out.println("Expected Change: $7.51");
      System.out.printf("Actual Change: $%.2f\n", change);
   }
}