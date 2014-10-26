/**
   Tests the click and undo methods of a Counter object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class CounterTester
{
   public static void main(String[] args)
   {
      Counter counter = new Counter();
      
      counter.click();
      counter.click();
      
      System.out.println("Expected value: 2");
      System.out.println("Actual value: " + counter.getValue());
      
      counter.undo();
      counter.undo();
      counter.undo();
      counter.undo();
      
      System.out.println("Expected value: 0");
      System.out.println("Actual value: " + counter.getValue());
   }
}