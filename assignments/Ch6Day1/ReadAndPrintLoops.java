import java.util.Scanner;

public class ReadAndPrintLoops
{
   public static void main(String[] args)
   {
      System.out.print("Enter numbers, end with a letter: ");
      Scanner console = new Scanner(System.in);
      String input = "";
      while(console.hasNextInt())
      {
         input += console.next() + " ";
      }
      
      // a. print largest and smallest
      Scanner in_a = new Scanner(input);
      
      int largest = in_a.nextInt();
      int smallest = largest;      
    
      while (in_a.hasNextInt())
      {
         int num = in_a.nextInt();
         largest = Math.max(largest, num);
         smallest = Math.min(smallest, num);
      }
      
      in_a.close();
      
      System.out.println("Smallest input: " + smallest);
      System.out.println("Largest input: " + largest);
      
      
      // b. count even and odd inputs
      Scanner in_b = new Scanner(input);
      int oddInputs = 0;
      int evenInputs = 0;
      
      while (in_b.hasNextInt())
      {
         int num = in_b.nextInt();
         
         if(num % 2 == 0)
         {
            evenInputs++;
         }
         else
         {
            oddInputs++;
         }
      }
      
      in_b.close();
      
      System.out.println("Number of odd inputs: " + oddInputs);
      System.out.println("Number of even inputs: " + evenInputs);
      
       
      // c. print cumulative total
      System.out.print("Successive sum: ");
      Scanner in_c = new Scanner(input);
      int total = 0;
      while (in_c.hasNextInt())
      {
         total += in_c.nextInt();
         System.out.print(total + " ");
      }
      
      in_c.close();
      
      // d. print adjacent duplicates
      System.out.print("\nRepeated numbers: ");
      Scanner in_d = new Scanner(input);
      
      int lastNum = in_d.nextInt();
      String duplicates = "";
      
      while (in_d.hasNextInt())
      {
         int currNum = in_d.nextInt();
         
         if(currNum == lastNum
         && !duplicates.endsWith(currNum + " "))
         {
            duplicates += currNum + " ";
         }
         
         lastNum = currNum;
      }
      
      System.out.println(duplicates);
      
      in_d.close();
   }
}