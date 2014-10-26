/**
   Test drives a Car object.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class CarTester
{
   public static void main(String[] args)
   {
      Car myHybrid = new Car(50);
      
      myHybrid.addGas(20);
      myHybrid.drive(100);
      double gasLeft = myHybrid.getGasInTank();
      
      System.out.println("Expected gas left: 18.00");
      System.out.printf("Actual gas left: %.2f\n", gasLeft);
      
      System.out.println("Expected odometer reading: 100.00");
      System.out.printf("Actual odometer reading: %.2f\n", myHybrid.getOdometer());
   }
}