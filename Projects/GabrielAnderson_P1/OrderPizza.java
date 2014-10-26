import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
   The user can order a pizza, given a size and an amount of toppings.<br>
   Sizes are Small(8"), Medium(13"), Large(21"), and Huge(34").<br>
   The amount of toppings can range from 0 to 5 toppings.<br>
   The price for each pizza is:<br>
   Small $5<br>
   Medium $8<br>
   Large $13<br>
   Huge $21<br>
   Each topping is $0.89 <br>
   Tax is 9.5% <br>
   @author Gabriel Anderson
   @since 05 October 2014
 */
public class OrderPizza
{
   final private static double TOPPING_PRICE = 0.89;
   final private static double TAX = 0.095;
   
   final private static int SMALL_DIAMETER = 8;
   final private static int MEDIUM_DIAMETER = 13;
   final private static int LARGE_DIAMETER = 21;
   final private static int HUGE_DIAMETER = 34;
   
   final private static int SMALL_PRICE = 5;
   final private static int MEDIUM_PRICE = 8;
   final private static int LARGE_PRICE = 13;
   final private static int HUGE_PRICE = 21;
   
   public static void main(String[] args)
   {
      String size = askPizzaSize();
      printPizzaSize(size);
      
      int toppingQuantity = askToppingQuantity();
      printToppingQuantity(toppingQuantity);
      
      System.out.println("");
      
      int pizzaDiameter = getPizzaDiameter(size);
      printPizzaDiameter(pizzaDiameter);
      
      int basePrice = getBasePrice(size);
      printBasePrice(basePrice);
      
      double pizzaArea = getPizzaArea(pizzaDiameter);
      printPizzaArea(pizzaArea);
      
      double totalPrice = getTotalPrice(basePrice, toppingQuantity);
      printTotalPrice(totalPrice);
      
      printPricePerArea(totalPrice, pizzaArea);
      printTax();
      printTotalPriceWithTax(totalPrice);

   }
   
   /**
      Asks the user for the pizza size. Default size is small.
      @return Size of the pizza. Can be a "S", "M", "L", or "H". Default is "S".
    */
   public static String askPizzaSize()
   {
      String size = "S"; // small pizza size is the default
      try
      {
         size = JOptionPane.showInputDialog("Please enter a size. Your choices are small, medium, large, or huge. (Default is small)");
         // sanitize the size input to the first letter
         size = size.trim().substring(0,1).toUpperCase();
      }
      catch(StringIndexOutOfBoundsException e) // when the user enters nothing into the dialog box
      {
         size = "S"; // default to size small
      }
      catch(NullPointerException e) // When the user tries to close the dialog box
      {
         size = "S"; // default to size small
      }
      
      
      if (size.equals("M") || size.equals("L") || size.equals("H"))
      {
         return size;
      }
      else
      {
         size = "S"; // default to small
         return size;
      }
   }
   
   /**
      Prints the given size of a pizza to the command line.
      @param size The size of the pizza, given as a "S", "M", "L", or "H".
    */
   public static void printPizzaSize(String size)
   {
      if (size.equals("M"))
      {
         System.out.println("Medium pizza size selected.");
      }
      else if (size.equals("L"))
      {
         System.out.println("Large pizza size selected.");
      }
      else if (size.equals("H"))
      {
         System.out.println("Huge pizza size selected.");
      }
      else // Small pizza is the default
      {
         System.out.println("Small pizza size selected.");
      }
   }
   
   /**
      Ask the user for the amount of pizza topping. Can be between 0-5 toppings.
      0 pizza toppings is the default value.
      @return The given quantity of pizza toppings, which can range from 0 to 5.
    */
   public static int askToppingQuantity()
   {
      int toppingQuantity = 0; // default topping quantity is 0
      
      try
      {
         toppingQuantity = Integer.parseInt(
               JOptionPane.showInputDialog("Please enter the number of toppings. (Default is 0)")
               );
      }
      catch(NumberFormatException e)
      {
         toppingQuantity = 0; // invalid input, default to 0
      }
      
      // Keep topping quantity within the bounds of 0-5 pizza topping.
      toppingQuantity = Math.max(0, toppingQuantity);
      toppingQuantity = Math.min(5, toppingQuantity);
      
      return toppingQuantity;
   }
   
   /**
      Prints a message to the command line about the amount of pizza topping.
      @param toppingQuantity The amount of pizza topping to report.
    */
   public static void printToppingQuantity(int toppingQuantity)
   {
      System.out.print("Pizza will have " + toppingQuantity);
      
      if (toppingQuantity == 1)
      {
         System.out.println(" topping.");
      }
      else
      {
         System.out.println(" toppings.");
      }
   }
   
   /**
      Gives the diameter of the pizza size
      @param size The size of the pizza, given as a "S", "M", "L", or "H".
      @return The diameter, in inches, for the given size.
    */
   public static int getPizzaDiameter(String size)
   {
      int pizzaDiameter = SMALL_DIAMETER; // small size is default
   
      if (size.equals("M"))
      {
         pizzaDiameter = MEDIUM_DIAMETER;
      }
      else if (size.equals("L"))
      {
         pizzaDiameter = LARGE_DIAMETER;
      }
      else if (size.equals("H"))
      {
         pizzaDiameter = HUGE_DIAMETER;
      }
      
      return pizzaDiameter;
   }
   
   /**
      Prints a message to the command line about the pizza diameter.
      @param pizzaDiameter The diameter, in inches, to report.
    */
   public static void printPizzaDiameter(int pizzaDiameter)
   {
      System.out.println("Pizza diameter: " + pizzaDiameter + "\"");
   }
   
   /**
      Calculate the base price of the pizza. The base price of the pizza does
      not include toppings or tax.
      @param size The size of the pizza, given as a "S", "M", "L", or "H".
      @return Base price, in dollars, for the given size.
    */
   public static int getBasePrice(String size)
   {  
      int basePrice = SMALL_PRICE; // Small($5) is default base price
      
      if (size.equals("M"))
      {
         basePrice = MEDIUM_PRICE;
      }
      else if (size.equals("L"))
      {
         basePrice = LARGE_PRICE;
      }
      else if (size.equals("H"))
      {
         basePrice = HUGE_PRICE;
      }
      
      return basePrice;
   }
   
   /**
      Prints a message about the base price to the command line.
      @param basePrice The price of the pizza, in dollars, without toppings or tax.
    */
   public static void printBasePrice(int basePrice)
   {
      System.out.println("Base price: $" + basePrice);
   }
   
   /**
      Calculates the pizza's area, in square inches, given the diameter.
      @param pizzaDiameter The pizza's diameter, in inches.
      @return The pizza's area, in square inches.
    */
   public static double getPizzaArea(int pizzaDiameter)
   {
      // area of a circle = (pi/4) * diameter * diameter
      return (Math.PI / 4) * (pizzaDiameter * pizzaDiameter);
   }
   
   /**
      Prints a message to the command line about the pizza's area.
      @param pizzaArea The pizza's area, in square inches, to report.
    */
   public static void printPizzaArea(double pizzaArea)
   {
      DecimalFormat formatter = new DecimalFormat("#0.00");
      System.out.println("Pizza area: " + formatter.format(pizzaArea) + " sq. in.");
   }
   
   /**
      Calculate the total price of the pizza. The total price include toppings.
      Tax not included.
      @param basePrice The base price of the pizza, in dollars.
      @param toppingQuantity The amount of toppings on the pizza.
      @return The total price of the pizza, not including tax.
    */
   public static double getTotalPrice(int basePrice, int toppingQuantity)
   {
      double totalPrice = basePrice + (toppingQuantity * TOPPING_PRICE);
      return totalPrice;
   }
   
   /**
      Prints a message to the command line about the total price of the pizza.
      @param totalPrice The total price of the pizza, in dollars, to report.
    */
   public static void printTotalPrice(double totalPrice)
   {
      DecimalFormat formatter = new DecimalFormat("#0.00");
      System.out.println("Total price: $" + formatter.format(totalPrice));
   }
   
   /**
      Prints a message to the command line about the price per square inch of pizza.
      @param totalPrice Total price of the pizza, in dollars, without tax.
      @param pizzaArea Area of pizza, in square inches.
    */
   public static void printPricePerArea(double totalPrice, double pizzaArea)
   {
      double pricePerArea = totalPrice / pizzaArea;
      DecimalFormat formatter = new DecimalFormat("#0.00");
      System.out.println("Price per sq. in.: $" + formatter.format(pricePerArea));
   }
   
   /**
      Prints a message to the command line about the tax for the pizza.
    */
   public static void printTax()
   {
      System.out.println("Tax: " + (TAX*100) + "%");
   }
   
   /**
      Prints a message to the command line about the total price, tax included.
      @param totalPrice Price of the pizza with toppings, in dollars.
    */
   public static void printTotalPriceWithTax(double totalPrice)
   {
      double totalPriceWithTax = totalPrice + (totalPrice * TAX);
      DecimalFormat formatter = new DecimalFormat("#0.00");
      System.out.println("Total price: $" + formatter.format(totalPriceWithTax));
   }
}