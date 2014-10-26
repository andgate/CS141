/**
   A counter that records the number of clicks.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class Counter
{
   private int value;
   
   /**
      Constructs a counter with an intial value of 0.
    */
   public Counter()
   {
      value = 0;
   }
   
   /**
      Retrieve the counters value.
      @return The value of the counter, in number of clicks.
    */
   public int getValue()
   {
      return value;
   }
   
   /**
      Increase the counter by one click.
    */
   public void click()
   {
      value += 1;
   }
   
   /**
      Undoes a click.
    */
   public void undo()
   {
      value = Math.max(--value, 0);
   }
}