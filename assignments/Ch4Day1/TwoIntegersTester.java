import java.util.Scanner;

public class TwoIntegersTester
{
   public static void main(String[] args)
   {
      TwoIntegers xion = new TwoIntegers();
      
      Scanner in = new Scanner(System.in);
      
      double giveA = in.nextDouble();
      
      double giveX = xion.giveX();
      double giveB = xion.giveY();
      double giveC = xion.giveSum();
      double giveD = xion.giveDifference();
      double giveE = xion.giveProduct();
      
      System.out.println(giveX);
      System.out.println(giveB);
      System.out.println(giveC);
      System.out.println(giveD);
      System.out.println(giveE);
      
      
   }
      
}
      