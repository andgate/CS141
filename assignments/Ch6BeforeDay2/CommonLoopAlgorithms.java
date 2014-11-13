import java.util.Scanner;

public class CommonLoopAlgorithms
{
   public double sum(Scanner in)
   {
      double total = 0.0;
      
      while(in.hasNextDouble())
      {
         double input = in.nextDouble();
         total += input;
      }
      
      return total;
   }
   
   public double average(Scanner in)
   {
      double total = 0.0;
      int count = 0;
      
      while(in.hasNextDouble())
      {
         double input = in.nextDouble();
         total += input;
         count++;
      }
      
      double average = 0.0;
      if (count > 0)
      {
         average = total/count;
      }
      
      return average;
   }
   
   public int countMatches(String str, char match)
   {
      int matches = 0;
      for(int i = 0; i < str.length(); i++)
      {
         char ch = str.charAt(i);
         if(ch == match)
         {
            matches++;
         }
      }
      
      return matches;
   }
   
   public int countWords(String str, int wordLength)
   {
      Scanner in = new Scanner(str);
      int words = 0;
      
      while(in.hasNext())
      {
         String input = in.next();
         if(input.length() <= wordLength)
         {
            words++;
         }
      }
      
      return words;
   }
   
   public int findFirstMatch(String str, char ch)
   {
      int position = 0;
      boolean found = false;
      
      while(!found && position < str.length())
      {
         if(ch == str.charAt(position))
         {
            found = true;
         }
         else
         {
            position++;
         }
      } 
      
      return position;
   }
   
   public double promptUntilMatch(Scanner in, double lowest, double highest)
   {
      boolean valid = false;
      double input = 0.0;
      
      while(valid)
      {
         System.out.print("Please enter a value from " + lowest + " to " + highest + ": ");
         input = in.nextDouble();
         if(lowest <= input && input <= highest)
         {
            valid = true;
         }
         else
         {
            System.out.println("Invalid input.");
         }
      }
      
      return input;
   }
   
   public double max(Scanner in)
   {
      double value = in.nextDouble();
      
      while(in.hasNextDouble())
      {
         double input = in.nextDouble();
         if(input > value)
         {
            value = input;
         }
      }
      
      return value;
   }
   
   public double min(Scanner in)
   {
      double value = in.nextDouble();
      
      while(in.hasNextDouble())
      {
         double input = in.nextDouble();
         if(input < value)
         {
            value = input;
         }
      }
      
      return value;
   }
   
   public boolean hasDuplicates(Scanner in)
   {
      double input = in.nextDouble();
      
      while(in.hasNextDouble())
      {
         double previous = input;
         input = in.nextDouble();
         if (input == previous)
         {
            return true;
         }
      }
      
      return false;
   }
}