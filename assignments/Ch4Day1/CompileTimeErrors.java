import java.util.Scanner;

public class CompileTimeErrors
{
   /**
      Five compile time errors we notice:
         - Semi-colon next to the method signature main(), line 1.
         - Missing quotations around the string in the first print statement, line 2.
         - Missing declaration for in Scanner object, line 3 and 4.
         - missing double declaration for x and y values, line 3 and 4.
         - Missing parenthesis for the method call readDouble, line 3 and 4.
    */
   // 1. public static void main();
   public static void main(String[] args)
   {
      // 2. System.out.print(Please enter two numbers:)
      System.out.print("Please enter two numbers: ");
      Scanner in = new Scanner(System.in);
      // 3. x = in.readDouble;
      double x = in.nextDouble();
      // 4. y = in.readDouble;
      double y = in.nextDouble();
      // 5. System.out.printline("The sum is " + x + y);
      System.out.println("The sum is " + (x + y));
   }
}