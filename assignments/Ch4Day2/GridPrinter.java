public class GridPrinter
{
   private static final String TOP_LINE = "+--+--+--+";
   private static final String BOTTOM_LINE = TOP_LINE;
   private static final String COMB_LINE = "|  |  |  |";
   
   public static void main(String[] args)
   {
      System.out.println("With seven print statements:");
      SevenPrintStatements();
      
      System.out.println("\nWith a top line and upward pointing combs:");
      printTopLineThenUpCombs();
      
      System.out.println("\nWith downward pointing combs and a bottom line:");
      printDownCombsThenBottomLine();
      
   }
   
   public static void SevenPrintStatements()
   {
      System.out.println("+--+--+--+");
      System.out.println("|  |  |  |");
      System.out.println("+--+--+--+");
      System.out.println("|  |  |  |");
      System.out.println("+--+--+--+");
      System.out.println("|  |  |  |");
      System.out.println("+--+--+--+");
   }
   
         
   public static void printTopLineThenUpCombs()
   {
      printTopLine();
      printUpComb();
      printUpComb();
      printUpComb();
   }
   
   public static void printDownCombsThenBottomLine()
   {
      printDownComb();
      printDownComb();
      printDownComb();
      printBottomLine();
   }
   
   public static void printDownComb()
   {
      printTopLine();
      printCombLine();
   }
   
   public static void printUpComb()
   {
      printCombLine();
      printBottomLine();
   }
   
   public static void printTopLine()
   {
      System.out.println(TOP_LINE);
   }
   
   public static void printBottomLine()
   {
      System.out.println(BOTTOM_LINE);
   }
      
   public static void printCombLine()
   {
      System.out.println(COMB_LINE);
   }
}