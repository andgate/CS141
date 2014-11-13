import java.util.logging.*;

public class Paycheck
{
   private String name;
   private double salary; // $ per hour
   private double pay;
   private double hours;
   
   private static final double OVERTIME = 1.50; // overtime is 150%
   private static final int MAX_HOURS = 40;
   private static final double RESET_PAY = 0.0;
   
   public Paycheck(String newName, double newSalary)
   {
      name = newName;
      salary = newSalary;
      pay = RESET_PAY;
      
      Logger.getGlobal().info("Employee paycheck created for "
                              + name + " with a salary of $"
                              + String.format("%5.2f", salary) + ".");
   }
   
   public void computePay(double weeksHours)
   {
      hours = weeksHours;
      
      if(hours > MAX_HOURS)
      {
         pay = salary * OVERTIME * hours;
      }
      else
      {
         pay = salary * hours;
      }
      
      Logger.getGlobal().info("Computed pay of $"
                              + String.format("%5.2f", pay)
                              + " for employee " + name
                              + " who worked "
                              + String.format("%5.2f", hours) + " hours.");
   }
   
   public String printPaycheck()
   {
      String paycheckOut = name
                         + " earned $" + String.format("%5.2f", pay)
                         + " for " + String.format("%5.2f", hours)
                         + " hours worked this week.";
      // print string
      Logger.getGlobal().info("Paycheck printed for " + name + ".");
      
      return paycheckOut;
   }
}