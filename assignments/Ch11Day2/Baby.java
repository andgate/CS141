public class Baby
{
   private String name;
   private int population;
   private double populationPercent;
   
   public Baby(String name, int population, double populationPercent)
   {
      this.name = name;
      this.population = population;
      this.populationPercent = populationPercent;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getPopulation()
   {
      return population;
   }
   
   public double getPopulationPercent()
   {
      return populationPercent;
   }
}