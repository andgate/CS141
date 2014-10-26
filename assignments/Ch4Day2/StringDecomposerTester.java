public class StringDecomposerTester
{
   public static void main(String[] args)
   {
      String str = "My String";
      
      System.out.println("Expected first character: M");
      System.out.println("Actual first character: " + StringDecomposer.getFirstCharacter(str));
      
      System.out.println("Expected last character: g");
      System.out.println("Actual last character: " + StringDecomposer.getLastCharacter(str));
      
      System.out.println("Expected first character deleted: y String");
      System.out.println("Actual first character deleted:" + StringDecomposer.deleteFirstCharacter(str));
      
      System.out.println("Expected last character deleted: My Strin");
      System.out.println("Actual last character deleted: " + StringDecomposer.deleteLastCharacter(str));
   }
}