public class AppointmentTester
{
   // Case 1: Overlaps
   private static final int CASE_1_START_1 = 10;
   private static final int CASE_1_END_1 = 12;
   private static final int CASE_1_START_2 = 11;
   private static final int CASE_1_END_2 = 13;
   
   // Case 2: Does not overlap
   private static final int CASE_2_START_1 = 10;
   private static final int CASE_2_END_1 = 11;   
   private static final int CASE_2_START_2 = 12;
   private static final int CASE_2_END_2 = 13;

   // Case 3: Same times
   private static final int CASE_3_START_1 = 10;
   private static final int CASE_3_END_1 = 11;
   private static final int CASE_3_START_2 = 10;
   private static final int CASE_3_END_2 = 11;
   
   // Case 4: One right after the other
   private static final int CASE_4_START_1 = 10;
   private static final int CASE_4_END_1 = 11;
   private static final int CASE_4_START_2 = 11;
   private static final int CASE_4_END_2 = 12;
   
   // Case 5: Appointment 2 before appointment 1
   private static final int CASE_5_START_1 = 11;
   private static final int CASE_5_END_1 = 12;
   private static final int CASE_5_START_2 = 10;
   private static final int CASE_5_END_2 = 11;

   public static void main(String[] args)
   {
      // Case 1
      String msgCase_1 = Appointment.isOverlap(CASE_1_START_1, CASE_1_END_1, CASE_1_START_2, CASE_1_END_2); 
      System.out.println("Case 1: Overlap expected");
      System.out.println("Does case one overlap? " + msgCase_1);
      
      // Case 2
      String msgCase_2 = Appointment.isOverlap(CASE_2_START_1, CASE_2_END_1, CASE_2_START_2, CASE_2_END_2); 
      System.out.println("Case 2: Overlap not expected");
      System.out.println("Does case two overlap? " + msgCase_2);
      
      // Case 3
      String msgCase_3 = Appointment.isOverlap(CASE_3_START_1, CASE_3_END_1, CASE_3_START_2, CASE_3_END_2); 
      System.out.println("Case 3: Overlap is expected");
      System.out.println("Does case two overlap? " + msgCase_3);
      
      // Case 4
      String msgCase_4 = Appointment.isOverlap(CASE_4_START_1, CASE_4_END_1, CASE_4_START_2, CASE_4_END_2); 
      System.out.println("Case 4: Overlap is not expected");
      System.out.println("Does case two overlap? " + msgCase_4);
      
      // Case 5
      String msgCase_5 = Appointment.isOverlap(CASE_5_START_1, CASE_5_END_1, CASE_5_START_2, CASE_5_END_2); 
      System.out.println("Case 5: Overlap is not expected");
      System.out.println("Does case two overlap? " + msgCase_5);
   }
}