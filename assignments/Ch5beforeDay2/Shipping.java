import java.util.Scanner;

public class Shipping
{
   private static final double SHIPPING_COST_OUTSIDE_US = 10.0;
   private static final double SHIPPING_COST_US_OUTSIDE_CONTIENTAL_US = 10.0;
   private static final double SHIPPING_COST_CONTIENTAL_US = 5.0;
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      
      System.out.print("Inside US? [Y/N]: ");
      boolean isInsideUS = yesOrNo(console.next());
      
      double shippingCost;
      
      if(isInsideUS)
      {
         System.out.print("Continental US? [Y/N]: ");
         boolean isContinentalUS = yesOrNo(console.next());
         
         if(isContinentalUS)
         {
            shippingCost = SHIPPING_COST_CONTIENTAL_US;
         }
         else
         {
            shippingCost = SHIPPING_COST_US_OUTSIDE_CONTIENTAL_US;
         }
      }
      else
      {
         shippingCost = SHIPPING_COST_OUTSIDE_US;
      }
      
      System.out.println("Shipping cost is " + shippingCost);
   }
   
   /**
      @return True if yes, false if no.
    */
   private static boolean yesOrNo(String answer)
   {
      String firstLetter = answer.trim().toUpperCase().substring(0, 1);
      
      if(firstLetter.equals("Y"))
      {
         return true;
      }
      
      return false;
   }
}