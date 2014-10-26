import java.util.Scanner;

public class SaleDiscount
{
   private static final double LOWER_DISCOUNT_MAX = 128; // dollars
   private static final double PERCENT = 1.0 / 100.0;
   private static final double LOWER_DISCOUNT = 8.0 * PERCENT;
   private static final double UPPER_DISCOUNT = 16.0 * PERCENT;
   
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      
      System.out.print("Please enter the orignal price: ");
      double originalPrice = console.nextDouble();
      
      double discountedPrice;
      if(originalPrice < LOWER_DISCOUNT_MAX)
      {
         discountedPrice = originalPrice * (1 - LOWER_DISCOUNT);
      }
      else
      {
         discountedPrice = originalPrice * (1 - UPPER_DISCOUNT);
      }
      
      System.out.println("The discounted price is $" + discountedPrice + "."); 
   }
}