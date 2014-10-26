public class SwapLetters
{
   public static void main(String[] args)
   {
      String str = "Gateway";
      int i = 2;
      int j = 4;
      
      
      System.out.println("Expected output: Gawetay");
      System.out.println("Actual output: " + swapLetters(str, i, j));
   }
   
   private static String swapLetters(String str, int i, int j)
   {
      String first = str.substring(0, i);
      String middle = str.substring(i+1, j);
      String last = str.substring(j+1, str.length());
      
      String iStr = str.substring(i, i+1);
      String jStr = str.substring(j, j+1);
      
      return first + jStr + middle + iStr + last;
   }
}