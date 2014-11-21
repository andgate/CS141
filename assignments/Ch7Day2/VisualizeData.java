import java.util.ArrayList;
import java.util.Scanner;

public class VisualizeData
{
   private static final int MAX_BAR_SIZE = 40;
   private static final String ASTERISK = "*";
   
   private static final String NAME_ECHO
      = "Enter name: ";
      
   private static final String VALUE_ECHO
      = "Enter value: ";
   
   public static void main (String[] args)
   {
      ArrayList<String> labels = new ArrayList<>();
      ArrayList<Double> values = new ArrayList<>();
      
      Scanner in = new Scanner(System.in);
      askInput(in, labels, values);
      
      String[] bars = generateBars(values);
      
      int elements = labels.size();
      for(int i = 0; i < elements; i++)
      {
         System.out.printf("%15s ", labels.get(i));
         System.out.println(bars[i]);
      }
   }
   
   private static void askInput(
      Scanner in,
      ArrayList<String> labels,
      ArrayList<Double> values)
   {
      boolean valid = true;
      do
      {
         String name = "";
         double value = 0.0;
         
         try
         {
            System.out.print("Enter name: ");
            name = in.next();
            
            System.out.print("Enter value: ");
            value = in.nextDouble();
         }
         catch(java.util.InputMismatchException e)
         {
            valid = false;
         }
         catch(java.lang.IllegalStateException e)
         {
            valid = false;
         }
         catch(java.util.NoSuchElementException e)
         {
            valid = false;
         }
         
         if(valid)
         {
            labels.add(name);
            values.add(value);
         }
      } while (valid);
      
      System.out.println();
   }
      
   private static String[] generateBars(ArrayList<Double> values)
   {
      double largest = getLargest(values);
      double scaleFactor = (double) MAX_BAR_SIZE / largest;
      
      String[] bars = new String[values.size()];
      for(int i = 0; i < bars.length; i++)
      {
         int barSize = (int) (values.get(i) * scaleFactor);
         bars[i] = stringFill(ASTERISK, barSize);
      }
      
      return bars;
   }
   
   private static double getLargest(ArrayList<Double> values)
   {
      double largest = values.get(0);
      for(double value : values)
      {
         largest = Math.max(largest, value);
      }
      return largest;
   }
   
   private static String stringFill(String str, int amount)
   {
      String filledStr = "";
      
      for(int i = 0; i < amount; i++)
      {
         filledStr += str;
      }
   
      return filledStr;
   }
}