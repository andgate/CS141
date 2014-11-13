import java.util.Scanner;

public class LoopComputer
{
   public static void main(String[] args)
   {
      // a.
      int sum = 0;
      for(int i = 2; i <=100; i += 2)
      {
         sum += i;
      }
      System.out.println("a. Sum of even numbers from 2 to 100: "
                         + sum);
      
      // b.
      sum = 0;
      for(int i = 1, j = i; j <= 100; i++, j = i*i)
      {
         sum += j;
      }
      System.out.println("b. Sum of squares from 1 to 100: "
                          + sum);
      
      // c.
      System.out.print("c. Powers of 2 from 2^0 to 2^20: ");
      for(int i = 0; i <= 20; i++)
      {
         System.out.print(((int)Math.pow(2.0, (double)i)) + " ");
      }
      System.out.print("\n");
      
      // d.
      Scanner console = new Scanner(System.in);
      
      System.out.print("d. Enter integer for a: ");
      int a = console.nextInt();
      
      System.out.print("Enter integer for b: ");
      int b = console.nextInt();
      
      sum = 0;
      for(int i = Math.min(a, b); i <= Math.max(a, b); i++)
      {
         if(i % 2 != 0)
         {
            sum += i;
         }
      }
      
      System.out.println("Sum of integers from "
                         + a + " to " + b + ": " + sum);
      
      // e.
      /final int ASCII_CODE_0 = 48;
      final int ASCII_CODE_9 = 57;
      System.out.print("e. Enter an integer: ");
      int num = console.nextInt();
      final int digits = num;
      sum = 0;
      while(num != 0)
      {
         int digit = num % 10;
         
         if(digit % 2 == 1)
         {
            sum += digit;
         }
         
         num /= 10;
      }
      
      System.out.println("Sum of the odd digits in "
                         + digits + ": " + sum);
   }
}