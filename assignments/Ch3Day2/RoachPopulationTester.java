/**
   Test a RoachPopulation object by breeding and spraying the population
   a couple of times.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class RoachPopulationTester
{
   public static void main(String[] args)
   {
      RoachPopulation pop = new RoachPopulation(10);
      
      pop.breed();
      pop.spray(10);
      pop.breed();
      pop.spray(10);
      pop.breed();
      pop.spray(10);
      
      System.out.println("Expected roach population: 58 roaches.");
      System.out.println("Actual roach population: " + pop.getRoaches() + " roaches.");
   }
}