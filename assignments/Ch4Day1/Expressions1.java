public class Expressions1
{
   private static final double x = 2.5;
   private static final double y = -1.5;
   private static final int m = 18;
   private static final int n = 4;

   public static void main(String[] args)
   {
      System.out.println("Expected answer for a: 6.25");
      System.out.println("Actual answer for a: " + giveA() + "\n");
      
      System.out.println("Expected answer for b: 6");
      System.out.println("Actual answer for b: " + giveB() + "\n");
      
      System.out.println("Expected answer for c: 12.5");
      System.out.println("Actual answer for c: " + giveC() + "\n");
      
      System.out.println("Expected answer for d: -3");
      System.out.println("Actual answer for d: " + giveD() + "\n");
      
      System.out.println("Expected answer for e: 1.4142135623730951");
      System.out.println("Actual answer for e: " + giveE() + "\n");
   }
   
   public static double giveA()
   {
      return x + n * y - (x + n) * y;
   }
   
   public static int giveB()
   {
      return m / n + m % n;
   }
   
   public static double giveC()
   {
      return 5 * x - n / 5;
   }
   
   public static int giveD()
   {
      return 1 - (1 - (1 - (1 - (1 - n))));
   }
   
   public static double giveE()
   {  
      return Math.sqrt(Math.sqrt(n));
   }
}
