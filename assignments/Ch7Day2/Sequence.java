import java.util.ArrayList;

public class Sequence
{
   private ArrayList<Integer> values;
   
   public Sequence()
   {
      values = new ArrayList<Integer>();
   }
   
   public void add(int n)
   {
      values.add(n);
   }
   
   public int get(int i)
   {
      return values.get(i);
   }
   
   public int size()
   {
      return values.size();
   }
   
   public Sequence append(Sequence other)
   {
      Sequence newValues = new Sequence();
      
      for(int i = 0; i < this.size(); i++)
      {
         newValues.add(this.get(i));
      }
      
      for(int i = 0; i < other.size(); i++)
      {
         newValues.add(other.get(i));
      }
      
      return newValues;
   }
   
   public Sequence merge(Sequence other)
   {
      Sequence newValues = new Sequence();
      
      final int longest = Math.max(this.size(), other.size());
      
      for(int i = 0; i < longest; i++)
      {
         if(i < this.size())
         {
            newValues.add(this.get(i));
         }
         
         if(i < other.size())
         {
            newValues.add(other.get(i));
         }
      }
      
      return newValues;
   }
   
   @Override
   public String toString()
   {
      return values.toString();
   }
}