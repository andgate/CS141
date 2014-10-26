/**
   Tests an Employee object.
   Creates and employee with a decent salary, and gives them a raise.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class EmployeeTester
{
   public static void main(String[] args)
   {
      Employee harry = new Employee("Hacker, Harry", 50000);
      harry.raiseSalary(10); // Harry gets a 10% raise.
      
      System.out.println("Expected employee name: Hacker, Harry");
      System.out.println("Actual employee name: " + harry.getName() + "\n");
      
      System.out.println("Expected salary: $55000.00");
      System.out.printf("Actual salary: $%.2f\n", harry.getSalary());
   }
}