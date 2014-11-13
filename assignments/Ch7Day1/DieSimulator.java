/**
   This program simulates casting a die twenty times.
   Also, encases that runs in parenthesis.
*/
public class DieSimulator
{
   private static int[] casts = new int[20];
   
   public static void main(String[] args)
   {
      Die d = new Die(6);
      
      for (int i = 0; i < casts.length; i++)
      {  
         casts[i] = d.cast();
      }
      
      printCasts();
   }
   
   public static void printCasts()
   {
      // This way is gross. Like, really gross.
      /*boolean inRun = false;
      
      for (int i = 0; i < casts.length; i++)
      {
         if (inRun)
         {
            if (casts[i] != casts[i-1])
            {
               inRun = false;
               System.out.print(") ");
            }
            else
            {
               System.out.print(" ");
            }
            
            System.out.print(casts[i]);
         }
         
         if(!inRun)
         {
            if (casts[i] == casts[i+1])
            {
               inRun = true;
               System.out.print(" (");
            }
            else if (i != 0)
            {
               System.out.print(" ");
            }
            
            System.out.print(casts[i]);
         }
      }
      
      if(inRun)
      {
         System.out.print(")");
      }*/
      
      // I'm gonna do it in a way that doesn't completely suck.
      for(int i = 0; i < casts.length; i++)
      {
         int distance = i + 1;
         // Thanks to the magic of
         // short-circuit logic,
         // this won't cause an
         // ArrayIndexOutOfBoundsException!
         if( (distance != casts.length)
          && (casts[i] == casts[i+1]) )
         {
            System.out.print("(" + casts[i]);
            
            
            do
            {
               i++;
               distance = i + 1;
               
               System.out.print(" " + casts[i]);
            }
            while( (distance < casts.length)
                && (casts[i] == casts[i+1]) );
            
            System.out.print(")");
         }
         else
         {
            System.out.print(casts[i]);
         }
         
         if(distance != casts.length)
         {
            System.out.print(" ");
         }
      }
      
      //System.out.println();
   }
}
