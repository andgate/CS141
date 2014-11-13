import java.util.logging.*;

public class PaycheckTester
{
   private static final String name = "John Doe";
   private static final double salary = 10.0;
   
   private static final double HOURS_1 = 40;
   private static final double HOURS_2 = 50;
   
   private static final String EXPECTED_PAYCHECK_1
      = "Expected: John Doe earned $400.00 for 40.00 hours worked this week.";
   private static final String EXPECTED_PAYCHECK_2
      = "Expected: John Doe earned $750.00 for 50.00 hours worked this week.";
      
   public static void main(String[] args)
   {
      Logger.getGlobal().setLevel(Level.ALL);
      Paycheck testPaycheck = new Paycheck(name, salary);
      
      testPaycheck.computePay(HOURS_1);
      System.out.println(EXPECTED_PAYCHECK_1);
      System.out.println("Actual: " + testPaycheck.printPaycheck());
      
      testPaycheck.computePay(HOURS_2);
      System.out.println(EXPECTED_PAYCHECK_2);
      System.out.println("Actual: " + testPaycheck.printPaycheck());
   }
}