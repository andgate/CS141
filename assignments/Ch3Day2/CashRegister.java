import java.text.NumberFormat;

/**
   Cash register that totals up sales and determines the change due.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class CashRegister
{
   private double purchase;
   private double payment;
   private String receipt;
   private int itemCount;
   private double tax;
   
   private final static double NO_PURCHASES = 0.0;
   private final static double NO_PAYMENTS = 0.0;
   private final static double NO_TAX_RATE = 0.0;
   private final static int NO_ITEMS = 0;
   private final static String BLANK_RECEIPT = "";
   
   private final static NumberFormat currency = NumberFormat.getCurrencyInstance(); 
   
   /**
      Constructs a CashRegister with no purchases and no payments,
      that applies a given tax rate to purchases.
      @param currentTaxRate The tax rate to apply to purchases.
    */
   public CashRegister(double currentTaxRate)
   {
      purchase = NO_PURCHASES;
      payment = NO_PAYMENTS;
      itemCount = NO_ITEMS;
      receipt = BLANK_RECEIPT;
      tax =  currentTaxRate;
   }
   
   /**
      Constructs a cash register with no purchases, no payments, and does
      not apply tax.
    */
   public CashRegister()
   {
      this(NO_TAX_RATE);
   }
   
   /**
      Processes the purchase of an item.
      @param amount Cost of the purchase, in dollars.
    */
   public void recordPurchase(double amount)
   {
      purchase += amount;
      receipt += currency.format(amount)  + " item purchased.\n";
      itemCount++;
   }
   
   public void recordTaxablePurchase(double amount)
   {
      purchase += amount * (1.0 + (tax / 100.0));
      receipt += currency.format(amount) + " item purchased with a " + tax + "% tax.\n";
      itemCount++;
   }
   
   /**
      Processes the payment of an item.
      @param amount The amount of the payment, in dollars.
    */
   public void receivePayment(double amount)
   {
      payment += amount;
      receipt += currency.format(amount) +  " paid.\n";
   }
   
   /**
      Determines the amount of change due and resets the cash register for the next customer.
      @return The change due to the customer.
    */
   public double giveChange()
   {
      double change = payment - purchase;
      
      receipt += "\nItem count: " + itemCount + "\n";
      receipt += "Total cost: " + currency.format(purchase) + "\n";
      receipt += "Total paid: " + currency.format(payment) + "\n";
      receipt += "Change due: " + currency.format(change) + "\n";
      
      purchase = NO_PURCHASES;
      payment = NO_PAYMENTS;
      itemCount = NO_ITEMS;
      
      return change;
   }
   
   /**
      Prints the current receipt to the command line and starts a new one for the next customer.
    */
   public void printReceipt()
   {
      System.out.println(receipt);
      receipt = BLANK_RECEIPT;
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