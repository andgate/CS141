import java.util.Scanner;

/**
   This program simulates a vending machine that gives change.
*/
public class VendingMachine
{
   public static void main(String[] args)
   {
      final int PENNIES_PER_DOLLAR = 100;
      final int PENNIES_PER_QUARTER = 25;
      
      Scanner in = new Scanner(System.in);

      int billValue = askBillValue(in);
      int quarterQuantity = askQuarterQuantity(in);
      int itemPrice = askItemPrice(in);

      // Compute change due
      int valueOfBills = PENNIES_PER_DOLLAR * billValue;
      int valueOfQuarters = PENNIES_PER_QUARTER * quarterQuantity;
      int changeDue = valueOfBills + valueOfQuarters - itemPrice;
      
      int dollarCoins = changeDue / PENNIES_PER_DOLLAR;
      changeDue = changeDue % PENNIES_PER_DOLLAR;
      int quarters = changeDue / PENNIES_PER_QUARTER;

      // Print change due
      System.out.printf("Dollar coins: %6d", dollarCoins);
      System.out.println();
      System.out.printf("Quarters:     %6d", quarters);
      System.out.println();
   }
   
   private static int askItemPrice(Scanner in)
   {
      System.out.print("Enter item price in pennies: ");
      return in.nextInt();
   }
   
   private static int askQuarterQuantity(Scanner in)
   {
      System.out.print("Enter quarter quantity: ");
      return in.nextInt();
   }
   
      private static int askBillValue(Scanner in)
   {
      System.out.print("Enter quarter value (1 = $1 bill, 5 = $5 bill, etc.): ");
      return in.nextInt();
   }
}
