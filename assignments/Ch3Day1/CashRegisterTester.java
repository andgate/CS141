/**
   Tests a CashRegister object with an imaginary customer.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();
      
      register.recordPurchase(29.50);
      register.recordPurchase(9.25);
      register.receivePayment(50.00);
      
      System.out.println("Expected item count: 2 items");
      System.out.println("Actual item count: " + register.getItemCount() + " items");
      
      double change = register.giveChange();
      
      System.out.println("Expected receipt:");
      System.out.println("$29.5 item purchased.");
      System.out.println("$9.25 item purchased.");
      System.out.println("$50 paid.");
      System.out.println("\nItem count 2");
      System.out.println("Total cost: $38.75");
      System.out.println("Total paid: $50.0");
      System.out.println("Change due: $11.25");


      System.out.println("\nActual receipt:");
      register.printReceipt();
      
      System.out.println("Expected Change: $11.25");
      System.out.println("Actual Change: $" + change);
   }
}