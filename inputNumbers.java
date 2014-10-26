/** shows how to get numbers and convert them to ints and doubles
    @author R.Shields
    @since 25 Sept 2014
*/
import javax.swing.JOptionPane;

public class inputNumbers {
   public static void main(String[] args)   {
      String name = JOptionPane.showInputDialog("enter a name: ");
      System.out.println("you entered name: " + name);
      
      String strNumber = JOptionPane.showInputDialog("enter an integer: ");
      int myInt = Integer.parseInt(strNumber);  // converts Sting to integer

      System.out.println("\tone less than the integer than you entered: " + (myInt - 1) );
      
      if (myInt == 0) {  // you can use > instead of == here
         System.out.println("must not divide by zero"); 
         myInt = myInt + 1;
      }
      System.out.println("\tcurrent myInt: " + myInt );
      
      String strValue = JOptionPane.showInputDialog("enter a a real number (such as 3.14): ");
      double myValue = Double.parseDouble(strValue);  // converts Sting to double
      System.out.println("\t\thalf the real number you entered: " + (myValue  /2.0) );   
   }
}