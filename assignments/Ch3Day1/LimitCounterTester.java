/**
   Tests the setLimit method of a LimitCounter object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class LimitCounterTester
{
   public static void main(String[] args)
   {

      LimitCounter counter = new LimitCounter(4); // this constructors calls setLimit(4)
      
      counter.click();
      counter.click();
      counter.click();
      counter.click();
      counter.click();
      
      System.out.println("Expected value: 4");
      System.out.println("Actual value: " + counter.getValue());
   }
}