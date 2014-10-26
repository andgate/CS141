import java.util.Scanner;

public class RunTimeErrors
{   
   /**
      Three run-time errors we noticed:
         - line 8 should be y = ... not x = ..., line 8.
         - readInt() is the wrong method, should use nextInt(), lines 6 and 8.
         - x + y is missing parenthesis on line 9, giving the wrong result.
         - The end of the string on line 5 is missing a space,
           so inputting a number won't look neat.
    */
   // 1. public static void main(String[] args)
   public static void main(String[] args)
   {      
      // 2. int x = 0;
      int x = 0;
      // 3. int y = 0;
      int y = 0;
      // 4. Scanner in = new Scanner("System.in");
      Scanner in = new Scanner(System.in);
      // 5. System.out.print("Please enter an integer:");
      System.out.print("Please enter an integer: ");   
      // 6. x = in.readInt();
      x = in.nextInt();
      // 7. System.out.print("Please enter another integer: ");
      System.out.print("Please enter another integer: ");
      // 8. x = in.readInt();
      y = in.nextInt();   
      // 9. System.out.println("The sum is " + x + y);
      System.out.println("The sum is " + (x + y));
   }
}