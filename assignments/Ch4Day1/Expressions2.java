public class Expressions2
{
   private static final String s = "Hello";
   private static final String t = "World";

   public static void main(String[] args)
   {
      System.out.println("Expected answer for a: 10");
      System.out.println("Actual answer for a: " + giveA() + "\n");
      
      System.out.println("Expected answer for b: e");
      System.out.println("Actual answer for b: " + giveB() + "\n");
      
      System.out.println("Expected answer for c: llo");
      System.out.println("Actual answer for c: " + giveC() + "\n");
      
      System.out.println("Expected answer for d: HelloWorld");
      System.out.println("Actual answer for d: " + giveD() + "\n");
      
      System.out.println("Expected answer for e: WorldHello");
      System.out.println("Actual answer for e: " + giveE() + "\n");
   }
   
   public static int giveA()
   {
      return s.length() + t.length();
   }
   
   public static String giveB()
   {
      return s.substring(1, 2);
   }
   
   public static String giveC()
   {
      return s.substring(s.length()/2, s.length());
   }
   
   public static String giveD()
   {
      return s + t;
   }
   
   public static String giveE()
   {  
      return t + s;
   }
}
