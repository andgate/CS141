import javax.swing.JOptionPane;

public class pickAsize{
   public static void main(String[] args){
      String size = JOptionPane.showInputDialog("pick a size: small or large: ");
      System.out.print("you picked, ");
      //System.out.println(size.substring(0,1));   
      System.out.print(size);
      
      if (size.substring(0,1).equals("s" )
          || size.substring(0,1).equals("l") ){
         System.out.print(", good pick");
      } else {
         System.out.print(", a bad pick"); 
      }      
      System.out.println("!");
   }
}
