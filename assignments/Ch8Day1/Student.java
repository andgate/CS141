import java.util.ArrayList;

public class Student
{
   String name;
   ArrayList<Double> scores;
   
   public Student(String name)
   {
      this.name = name;
      scores = new ArrayList<Double>();
   }
   
   public void addScore(double score)
   {
      scores.add(score);
   }
   
   public Double[] getScores()
   {
      return scores.toArray(new Double[scores.size()]);
   }
   
   public String getName()
   {
      return name;
   }
   
   public double getAverageScore()
   {
      double totalScore = getTotalScore();
      // elements is one less than total
      // because lowest score is dropped
      double elements = scores.size() - 1;
      
      return totalScore / (elements - 1);
   }
   
   // Drops the lowest score
   public double getTotalScore()
   {
      double sum = getSumOfScores();
      double min = getLowestScore();
      
      return (sum - min);
   }
   
   private double getLowestScore()
   {
      if(scores.size() == 0)
      {
         return 0.0;
      }
      
      double min = scores.get(0);
      
      for(int i = 1; i < scores.size(); i++)
      {
         if(scores.get(i) < min)
         {
            min = scores.get(i);
         }
      }
      
      return min;
   }
   
   private double getSumOfScores()
   {
      double sum = 0.0;
      
      if(scores.size() == 0)
      {
         return sum;
      }
      
      for(int i = 0; i < scores.size(); i++)
      {
         sum += scores.get(i);
      }
      
      return sum;
   }
}