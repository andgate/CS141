public class StringDecomposer
{
   public static String getFirstCharacter(String str)
   {
      return str.length() > 1
               ? str.substring(0, 1)
               : str;
   }
   
   public static String getLastCharacter(String str)
   {
      return str.length() > 1
               ? str.substring(str.length() - 1, str.length())
               : str;
   }
   
   public static String deleteFirstCharacter(String str)
   {
      return str.length() > 1
               ? str.substring(1, str.length())
               : "";
   }
   
   public static String deleteLastCharacter(String str)
   {
      return str.length() > 1
               ? str.substring(0, str.length() - 1)
               : "";
   }
}