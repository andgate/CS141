/**
   Cash register that totals up sales and determines the change due.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class CashRegister
{
   private double purchase;
   private double payment;
   private String receipt;
   private int itemCount;
   
   /**
      Constructs a CashRegister with no purchases and no payments.
    */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
      itemCount = 0;
      receipt = "";
   }
   
   /**
      Processes the purchase of an item.
      @param amount Cost of the purchase, in dollars.
    */
   public void recordPurchase(double amount)
   {
      purchase += amount;
      receipt = receipt.concat("$" + amount  + " item purchased.\n");
      itemCount += 1;
   }
   
   /**
      Processes the payment of an item.
      @param amount The amount of the payment, in dollars.
    */
   public void receivePayment(double amount)
   {
      payment += amount;
      receipt = receipt.concat("$" + amount + " paid.\n");
   }
   
   /**
      Determines the amount of change due and resets the cash register for the next customer.
      @return The change due to the customer.
    */
   public double giveChange()
   {
      double change = payment - purchase;
      
      receipt = receipt.concat("\nItem count: " + itemCount + "\n")
                       .concat("Total cost: $" + purchase + "\n")
                       .concat("Total paid: $" + payment + "\n")
                       .concat("Change due: $" + change + "\n");
      
      payment = 0;
      purchase = 0;
      itemCount = 0;
      
      return change;
   }
   
   /**
      Prints the current receipt to the command line and starts a new one for the next customer.
    */
   public void printReceipt()
   {
      System.out.println(receipt);
      receipt = "";
   }
   
   /**
      Gives the number of items purchased in this order.
      @return The item count.
    */
   public int getItemCount()
   {
      return itemCount;
   }
}