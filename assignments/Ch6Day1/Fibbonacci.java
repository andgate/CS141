import java.util.Scanner;

public class Fibbonacci
{
   public static void main(String[] args)
   {
      System.out.print("Enter the index of the fibbonacci number: ");
      Scanner console = new Scanner(System.in);
      int fibNum = console.nextInt();
      
      // This is how the books wants it
      // But the real fibonacci sequence is
      // 0 1 1 2 3 5 8 13 21 etc
      // instead, this sequence is
      // 1 1 2 3 5 8 13 21 34 etc
      // Since the first new fold formed is 2,
      // this sequence is off by 3.
      // So, start the for-loop at 3
      int fold1 = 1;
      int fold2 = 1;
      int newFold = fold1 + fold2;
      
      for(int i = 3; i < fibNum; i++)
      {
         fold2 = fold1;
         fold1 = newFold;
         newFold = fold1 + fold2;
      }
      
      // Correct if at the beginning
      switch(fibNum)
      {
         case 0: newFold = 0; break;
         case 1: newFold = 1; break;
         case 2: newFold = 1; break;
      }
      
      System.out.println("That fibbonacci number is " + newFold + ".");
   }
}