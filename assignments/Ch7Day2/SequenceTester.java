public class SequenceTester
{
   private static final int[] a_values
      = { 1, 4, 9, 16 };
   private static final int[] b_values
      = { 9, 7, 4, 9, 11 };
      
   private static final String INITIAL_A_ECHO
      = "Initial Sequence A: ";
   private static final String INITIAL_B_ECHO
      = "Initial Sequence B: ";
   private static final String FINAL_A_ECHO
      = "Final Sequence A: ";
   private static final String FINAL_B_ECHO
      = "Final Sequence B: ";
   
   private static final String APPEND_EXPECTED_C_ECHO
      = "Expected Squence C: [1, 4, 9, 16, 9, 7, 4, 9, 11]";   
   private static final String MERGE_EXPECTED_C_ECHO
      = "Expected Squence C: [1, 9, 4, 7, 9, 4, 16, 9, 11]";
   private static final String ACTUAL_C_ECHO
      = "Actual Squence C: ";
      
   private static final String APPEND_TEST_ECHO
      = "Append Test";
   private static final String MERGE_TEST_ECHO
      = "Merge Test";
      
   public static void main(String[] args)
   {
      Sequence a = new Sequence();
      for(int i = 0; i < a_values.length; i++)
      {
         a.add(a_values[i]);
      }
      
      Sequence b = new Sequence();
      for(int i = 0; i < b_values.length; i++)
      {
         b.add(b_values[i]);
      }
      
      
      System.out.println(INITIAL_A_ECHO + a.toString());
      System.out.println(INITIAL_B_ECHO + b.toString());
      System.out.println();
      
      System.out.println(APPEND_TEST_ECHO);
      Sequence c = a.append(b);
      System.out.println(FINAL_A_ECHO + a.toString());
      System.out.println(FINAL_B_ECHO + b.toString());
      System.out.println(APPEND_EXPECTED_C_ECHO);
      System.out.println(ACTUAL_C_ECHO + c.toString());
      
      System.out.println();
      
      c = a.merge(b);
      System.out.println(MERGE_TEST_ECHO);
      System.out.println(FINAL_A_ECHO + a.toString());
      System.out.println(FINAL_B_ECHO + b.toString());
      System.out.println(MERGE_EXPECTED_C_ECHO);
      System.out.println(ACTUAL_C_ECHO + c.toString());
   }
}