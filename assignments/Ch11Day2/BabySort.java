import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class BabySort
{
   private static final String BABY_TEXT
      = "babynames.txt";
   private static final String BOY_NAMES_TEXT
      = "boynames.txt";
   private static final String GIRL_NAMES_TEXT
      = "girlnames.txt";
   private static final String BABY_LINE_FORMAT
      = "%d  %s  %d  %f\n";
   
   public static void main(String[] args)
   {
      String babyText = getTextFromFile(BABY_TEXT);
      
      ArrayList<Baby> boys = new ArrayList<>();
      ArrayList<Baby> girls = new ArrayList<>();
      
      readBabyText(babyText, boys, girls);
      
      writeBabies(BOY_NAMES_TEXT, boys);
      writeBabies(GIRL_NAMES_TEXT, girls);
   }
   
   private static void writeBabies(String filename, ArrayList<Baby> babies)
   {
      PrintWriter out;
      try
      {
         out = new PrintWriter(filename);
         
         try
         {
            for(int index = 0; index < babies.size(); index++)
            {
               int rank = index + 1;
               writeBaby(out, babies.get(index),  rank);
            }
         }
         finally
         {
            out.close();
         }
      }
      catch(java.io.IOException e)
      {
         System.out.println("Could not write babies");
         System.exit(0);
      }
   }
   
   private static void writeBaby(PrintWriter out, Baby baby, int rank)
   {
      String name = baby.getName();
      int population = baby.getPopulation();
      double populationPercent = baby.getPopulationPercent();
      
      out.printf(BABY_LINE_FORMAT,
         rank,
         name,
         population,
         populationPercent);
   }
   
   /**
      Reads the given baby text, and fills the given arrays.
    */
   private static void readBabyText(
      String text,
      ArrayList<Baby> boys,
      ArrayList<Baby> girls)
   {
      Scanner in = new Scanner(text);
      
      while(in.hasNextLine())
      {
         // skips the name's rank
         in.next();
         
         // grab the name of the boy.
         String boyName = in.next();
         // grab the population with boy's name.
         int boyPopulation = in.nextInt();
         // grab the percent with boy's name.
         double boyPopulationPercent = in.nextDouble();
         
         // grab the name of the boy.
         String girlName = in.next();
         // grab the population with boy's name.
         int girlPopulation = in.nextInt();
         // grab the percent with boy's name.
         double girlPopulationPercent = in.nextDouble();
         
         Baby boy = new Baby(
            boyName,
            boyPopulation,
            boyPopulationPercent);
         
         Baby girl = new Baby(
            girlName,
            girlPopulation,
            girlPopulationPercent);
            
         boys.add(boy);
         girls.add(girl);
      }
   }
   
   private static String getTextFromFile(String filename)
   {
      File textFile = new File(filename);
      Scanner textScanner;
      String text = "";
      try
      {
         textScanner = new Scanner(textFile);
         
         try
         {
            textScanner.useDelimiter("\\Z");
            text = textScanner.next();
         }
         finally
         {
            textScanner.close();
         }
      }
      catch(java.io.FileNotFoundException e)
      {
         System.out.println(e.getMessage());
         System.exit(0);
      }
      
      return text;
   }
}