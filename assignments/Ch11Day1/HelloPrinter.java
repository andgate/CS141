import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

/**
   @version 2
 */
public class HelloPrinter
{
   private static final String HELLO_FILENAME = "hello.txt";
   private static final String HELLO_TEXT = "Hello World!";
   
   public static void main(String[] args)
   {
      writeTextFile(HELLO_FILENAME, HELLO_TEXT);
      String text = readTextFile(HELLO_FILENAME);
      
      System.out.println(text);
   }
   
   private static void writeTextFile(String filename, String text)
   {
      try
      {
         PrintWriter out = new PrintWriter(filename);;
         
         try
         {
            out.print(text);
         }
         finally
         {
            out.close();
         }
      }
      catch(java.io.FileNotFoundException e)
      {
         System.out.println("ERROR: " + filename + " not found.");
         System.out.println("Could not write file.");
         System.exit(0);
      }
   }
   
   private static String readTextFile(String filename)
   {
      String contents = "";
      try
      {
         File file = new File(filename);
         Scanner in = new Scanner(file);
         
         try
         {
            in.useDelimiter("\\Z");
            contents = in.next();
         }
         finally
         {
            in.close();
         }
      }
      catch(java.io.FileNotFoundException e)
      {
         System.out.println("ERROR: " + filename + " not found.");
         System.out.println("Could not read file.");
         System.exit(0);
      }
      
      return contents;
   }
}