import java.util.ArrayList;
import java.util.Scanner;

public class Find
{
   private static String targetWord;
   private static ArrayList<TextFile> files;
   
   public static void main(String[] args)
   {
      parseArgs(args);
      searchFiles();
   }
   
   private static void searchFiles()
   {
      for(TextFile file : files)
      { 
         Scanner lines = new Scanner(file.text);
         while(lines.hasNextLine())
         {
            String currentLine = lines.nextLine();
            if(doesLineContain(targetWord, currentLine))
            {
               System.out.println(file.filename
                  + ": " + currentLine);
            }
         }
      }
   }
   
   private static boolean doesLineContain(String word, String line)
   {
      Scanner words = new Scanner(line);
      
      while(words.hasNext())
      {
         String currentWord = words.next();
         
         if(currentWord.equals(word))
         {
            return true;
         }
      }
      
      return false;
   }
   
   private static void parseArgs(String[] args)
   {
      if(args.length < 2)
      {
         printUsage();
         System.exit(0);
      }
      
      targetWord = args[0];
      files = new ArrayList<>();
      
      for(int argIndex = 1; argIndex < args.length; argIndex++)
      {
         TextFile newFile = new TextFile(args[argIndex]);
         files.add(newFile);
      }
   }
   
   private static void printUsage()
   {
      System.out.println(
         "Usage: java Find word file1 file2 file3..."
         );
   }
   
   
}