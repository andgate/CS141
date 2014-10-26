/**
   A car that can drive, refuel, and can give odometer and gas tank readings.
   COPYRIGHT (C) 2014 Gabriel Anderson, Victor Erickson
   @author Gabriel Anderson, Victor Erickson
   @since 8 October 2014
 */
public class Car
{
   double mpg;
   double odometer;
   double gasInTank;
   
   /**
      Constructs a car with no gas and no miles driven, that burns gas at the mileage given.
      @param initialMileage The mileage the car gets when driving, in miles per gallon. 
    */
   public Car(double initialMileage)
   {
      mileage = initialMileage;
      odometer = 0;
      gasInTank = 0;
   }
   
   /**
      Add the given amount of gas to the gas tank.
      @param gas Amount of gas to add to the tank, in gallons.
    */
   public void addGas(double gas)
   {
      gasInTank += gas;
   }
   
   /**
      Drives the car a certain distance, burning gas in the process.
      @param distance Distance to drive the car.
    */
   public void drive(double distance)
   {
      odometer += distance;
      gasInTank -= distance / mileage;
   }
   
   /**
      Get the total distance the car has traveled from the odometer.
      @return The total distance the car has traveled, in miles.
    */
   public double getOdometer()
   {
      return odometer;
   }
   
   /**
      Get the mileage of the car.
      @return The mileage of the car, in miles per gallon.
    */
   public double getMileage()
   {
      return mileage;
   }
   
   /**
      Get the volume of gas in the tank.
      @return The gas in the tank, in gallons.
    */
   public double getGasInTank()
   {
      return gasInTank;
   }
}