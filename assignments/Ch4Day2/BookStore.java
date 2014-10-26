import java.util.Scanner;
import java.text.NumberFormat;

public class BookStore
{
   public static final double TAX_RATE = 7.5;
   public static final double PERCENT = 1.0 / 100.0;
   public static final double SHIPPING_CHARGE_PER_BOOK = 2.0;
   
   public static void main(String[] args)
   {
      // Read the total book price and the number of books.
      System.out.print("Enter the total book price: ");
      Scanner console = new Scanner(System.in);
      double totalBookPrice = console.nextDouble();
      
      System.out.print("Enter the number of books: ");
      int bookQuantity = console.nextInt();
      
      // Compute the tax (7.5 percent of the total book price).
      double tax = totalBookPrice * (TAX_RATE * PERCENT);
      
      // Compute the shipping charge ($2 per book).
      double shippingCharge = (double) bookQuantity * SHIPPING_CHARGE_PER_BOOK;
      
      // The price of the order is the sum of the total book price, the tax, and the shipping charge.
      double orderPrice = totalBookPrice + tax + shippingCharge;
      
      // Print the price of the order.
      final NumberFormat currency = NumberFormat.getCurrencyInstance();
      System.out.print("The price of the order is " + currency.format(orderPrice) + ".");
      
   }
}