/**
   Test drives a Car object.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class CarTester
{
   public static void main(String[] args)
   {
      Car myHybrid = new Car(50);
      
      myHybrid.addGas(20);
      myHybrid.drive(100);
      double gasLeft = myHybrid.getGasInTank();
      
      System.out.println("Expected gas left: 18");
      System.out.println("Actual gas left: " + gasLeft);
      
      System.out.println("Expected odometer reading: 100");
      System.out.println("Actual odometer reading: " + myHybrid.getOdometer());
   }
}