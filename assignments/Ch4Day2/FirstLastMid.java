import java.util.Scanner;

public class FirstLastMid
{
   public static void main(String[] args)
   {
      String word = "";
      while(word.length() <= 1)
      {
         Scanner console = new Scanner(System.in);
         System.out.print("Please enter a word: ");
         word = console.next();
      }
      
      String first = word.substring(0, 1);
      String last = word.substring(word.length() - 1, word.length());
      String middle = word.substring(1, word.length() - 1);
      
      System.out.println(first + " " + last + " "  + middle);
   }
}