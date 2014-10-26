import java.util.Scanner;

public class ElevatorSimulator
{
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      System.out.print("Floor: ");
      int floor = console.nextInt();
      
      int actualFloor;
      if(floor >= 14)
      {
         actualFloor = floor - 2;
      }
      else
      {
         actualFloor = floor;
      }
      
      System.out.println("The elevator will travel to the actual floor " + actualFloor + ".");
   }
}