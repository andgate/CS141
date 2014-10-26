import java.util.Scanner;

public class InOrder
{
   private static final String INTRO_PROMPT = "Please enter three integers, in descending or ascending order: ";
   private static final String ORDERED_MSG = "in order";
   private static final String UNORDERED_MSG = "not in order";
   
   public static void main(String[] args)
   {
      System.out.print(INTRO_PROMPT);
      
      Scanner console = new Scanner(System.in);
      int a = console.nextInt();
      int b = console.nextInt();
      int c = console.nextInt();
      
      String order_msg;
      // check for ascending order
      if (a <= b && b <= c)
      {
         order_msg = ORDERED_MSG;
      }
      // otherwise, check for descending order
      else if (a >= b && b >= c)
      {
         order_msg = ORDERED_MSG;
      }
      //otherwise, not ordered
      else
      {
         order_msg = UNORDERED_MSG;
      }
      
      System.out.println(order_msg);
   }
}