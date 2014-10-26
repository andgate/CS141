/**
   Create a bug object, and test it's walking and turning ability.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class BugTester
{
   public static void main(String[] args)
   {
      Bug bugsy = new Bug(10);
      bugsy.move();
      bugsy.turn();
      bugsy.move();
      bugsy.move();
      bugsy.move();
      
      System.out.println("Expected position: 8");
      System.out.println("Actual position: " + bugsy.getPosition());
   }
}