import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class InsertLineNumbers
{
   private static String inFilename;
   private static String outFilename;
   
   public static void main(String[] args)
   {
      parseArgs(args);
      
      String content = getFileContents(inFilename);
      String numberedContent = appendLineNumbers(content);
      writeToFile(outFilename, numberedContent);
   }
   
   private static String appendLineNumbers(String content)
   {
      Scanner lines = new Scanner(content);
      
      String output = "";
      int lineNumber = 1;
      while(lines.hasNextLine())
      {
         String line = lines.nextLine();

         output += "/* ";
         output += lineNumber;
         output += " */ " + line + "\n";
         
         
         lineNumber++;
      }
      
      return output;
   }
   
   private static String getFileContents(String filename)
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
   
   private static void writeToFile(String filename, String text)
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
   
   private static void parseArgs(String[] args)
   {
      if(args.length != 2)
      {
         printUsage();
         System.exit(0);
      }
      
      inFilename = args[0];
      outFilename = args[1];
      
      if(inFilename.equals(outFilename))
      {
         printSameFileError();
      }
   }
   
   private static void printUsage()
   {
      System.out.println(
         "Usage: java InsertLineNumbers infile outfile");
   }
   
   private static void printSameFileError()
   {
      System.out.println("Filenames must be different");
   }
}