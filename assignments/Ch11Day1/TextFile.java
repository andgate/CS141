import java.util.Scanner;
import java.io.File;

public class TextFile
{
   public String filename;
   public String text;
   
   public TextFile(String filename)
   {
      this.filename = filename;
      
      text = readTextFile(filename);
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