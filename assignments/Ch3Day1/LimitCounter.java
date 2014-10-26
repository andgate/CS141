/**
   A counter that records the number of clicks up to a limit.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class LimitCounter
{
   private int value;
   private int limit;
   
   /**
      Constructs a counter with an intial value of 0 and no limit.
    */
   public LimitCounter()
   {
      value = 0;
      limit = 0;
   }
   
   /**
      Constructs a counter with an intial value of 0 and the given limit.
      @param initialLimit The number of clicks this counter can perform. 0 means no limit.
    */
   public LimitCounter(int initialLimit)
   {
      this();
      setLimit(initialLimit);
   }
   
   /**
      Set a new limit for the counter.
      @param newLimit The number of clicks this counter can perform. 0 means no limit.
    */
   public void setLimit(int newLimit)
   {
      limit = newLimit;
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
      Increase the counter by one click, without exceding the limit.
    */
   public void click()
   {
      if(limit > 0)
      {
         value = Math.min(++value, limit);
      }
   }
   
   /**
      Undoes a click.
    */
   public void undo()
   {
      value = Math.max(--value, 0);
   }
}