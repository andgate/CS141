import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LineDistanceTester
{
   public static void main(String[] args)
   {
      Line2D.Double line = new Line2D.Double(100, 100, 200, 200); // x1, y1, x2, y2
      
      Point2D.Double point1 = new Point2D.Double(100, 200);
      Point2D.Double point2 = new Point2D.Double(150, 150);
      Point2D.Double point3 = new Point2D.Double(250, 50);
      
      double distance1 = line.ptSegDist(point1);
      double distance2 = line.ptSegDist(point2);
      double distance3 = line.ptSegDist(point3);
      
      assert distance2 == 0.0;
      
      System.out.println("Line is from (100, 100) to (200, 200)");
      
      System.out.println("Distance from (100, 200): " + distance1);
      System.out.println("Expected distance from (100, 200): 70.71");
      
      System.out.println("Distance from (150, 150): " + distance2);
      System.out.println("Expected distance from (150, 150): 0.0");
      
      System.out.println("Distance from (250, 50): " + distance3);
      System.out.println("Expected distance from (250, 50): 141.42");
   }
}