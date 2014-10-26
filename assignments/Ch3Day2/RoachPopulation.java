/**
   A roach population that grows by a factor of 2, and can be reduced with spray.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class RoachPopulation
{
   int population;
   
   private final static int GROWTH_FACTOR = 2;
   private final static int NO_ROACHES = 0;
   
   /**
      Construct a roch population with no roaches.
    */
   public RoachPopulation(int initialPopulation)
   {
      this(NO_ROACHES);
   }
   
   /**
      Construct a roach population with the given number of roaches.
      @param initialPopulation The number of roaches the population starts with.
    */
   public RoachPopulation(int initialPopulation)
   {
      population = initialPopulation;
   }
   
   /**
      Breeds the roach population,increasing the number
      of roaches by a growth factor of 2.
    */
   public void breed()
   {
      population *= GROWTH_FACTOR;
   }
   
   /**
      Treat the roach population with a spray to reduce the number of roaches.
      @param percent The percent of the roach population to apply the spray to.
    */
   public void spray(double percent)
   {
      population -= Math.round(population * (percent / 100.0));
   }
   
   /**
      Get the amount of roaches alive in the population.
      @return The amount of roaches inhabiting this population.
    */
   public int getRoaches()
   {
      return population;
   }
}