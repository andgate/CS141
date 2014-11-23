import java.util.Scanner;
import java.io.File;

public class TextFileAnalyzer
{
   public static void main(String[] args)
   {
      String text = readTextFile(askFilename());
      
      int lineCount = getLineCount(text);
      int wordCount = getWordCount(text);
      int charCount = getCharCount(text);
      
      System.out.println("Lines:      " + lineCount);
      System.out.println("Words:      " + wordCount);
      System.out.println("Characters: " + charCount);
   }
   
   private static String askFilename()
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the name of the file: ");
      return in.next();
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
   
   private static int getLineCount(String text)
   {
      Scanner lines = new Scanner(text);
      
      int lineCount = 0;
      while(lines.hasNextLine())
      {
         lineCount++;
         lines.nextLine();
      }
      
      return lineCount;
   }
   
   private static int getWordCount(String text)
   {
      Scanner words = new Scanner(text);
      
      int wordCount = 0;
      while(words.hasNext())
      {
         wordCount++;
         words.next();
      }
      
      return wordCount;
   }
   
   private static int getCharCount(String text)
   {
      Scanner chars = new Scanner(text);
      chars.useDelimiter("");
      
      int charCount = 0;
      while(chars.hasNext())
      {
         charCount++;
         chars.next();
      }
      
      return charCount;
   }
}