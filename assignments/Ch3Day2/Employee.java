/**
   An employee record with a name and salary.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class Employee
{
   private String name;
   private double salary;
   
   private final static double HUNDREDS_PLACE = 100.0; // Used to convert from percent
   
   /**
      Construct an employee record with the given name and salary.
      @param currentName The name of the employee.
      @param currentSalary The salaray the employee works for.
    */
   public Employee(String currentName, double currentSalary)
   {
      name = currentName;
      salary = currentSalary;
   }
   
   /**
      Getter for the name of the employee.
      @return The name of the employee.
    */
   public String getName()
   {
      return name;
   }
   
   /**
      Getter for the salary of the employee.
      @return The salary of the employee.
    */
   public double getSalary()
   {
      return salary;
   }
   
   /**
      Raise the employee's salary by a given percent.
      @param byPercent The percent to raise the employee's salary by.
    */
   public void raiseSalary(double byPercent)
   {
      salary += salary * (byPercent / 100.0);
   }
}