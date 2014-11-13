public class ReverseElements
{
   private static final String INITIAL_ECHO
      = "Initial: ";
   private static final String EXPECTED_ECHO
      = "Expected: 11 9 4 7 9 16 9 4 1";
   private static final String ACTUAL_ECHO
      = "Actual: ";  
    
   public static void main(String[] args)
   {
      int[] values = { 1, 4, 9, 16, 9, 7, 4, 9, 11 };
      int[] reversed = reverseElements(values);
      
      System.out.println(INITIAL_ECHO + toString(values));
      System.out.println(EXPECTED_ECHO);
      System.out.println(ACTUAL_ECHO + toString(reversed));
   }
   
   private static String toString(int[] values)
   {
      String valuesStr = "";
      for(int value : values)
      {
         valuesStr += value + " ";
      }
      return valuesStr;
   }
   
   private static int[] reverseElements(int[] values)
   {
      int[] tmp = new int[values.length];
      
      for(int i = 0; i < values.length; i++)
      {
         int pos = values.length - i - 1;
         tmp[pos] = values[i];
      }
      
      return tmp;
   }
}