public class Appointment
{
   private static final String OVERLAP_MSG = "The appointments overlap.";
   private static final String NONOVERLAP_MSG = "The appointments don't overlap.";
      
   public static String isOverlap(int startTime_1, int endTime_1, int startTime_2, int endtime_2)
   {
      int latestStartTime;
      int earliestEndTime;
      
      if (startTime_1 > startTime_2)
      {
         latestStartTime = startTime_1;
      }
      else 
      {
         latestStartTime = startTime_2;
      }
   
      if (endTime_1 < endtime_2)
      {
         earliestEndTime = endTime_1;
      }
      else 
      {
         earliestEndTime = endtime_2;
      }
            
      if (latestStartTime < earliestEndTime)
      {
         return OVERLAP_MSG;
      }
      else 
      {
         return NONOVERLAP_MSG;
      }
   }   
      
}