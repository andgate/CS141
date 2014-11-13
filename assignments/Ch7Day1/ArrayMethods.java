public class ArrayMethods
{
   int[] values;
   
   public ArrayMethods(int[] initialValues)
   {
      setValues(initialValues);
   }
   
   public void setValues(int[] newValues)
   {
      this.values = newValues.clone();
   }
   
   public int[] getValues()
   {
      return values.clone();
   }
   
   public String toString()
   {
      String valuesStr = "";
      for(int value : values)
      {
         valuesStr += value + " ";
      }
      return valuesStr;
   }
   
   // Problem (a)
   public void swapFirstAndLast()
   {
      final int TMP = values[0];
      final int LAST = values.length - 1;
      
      values[0] = values[LAST];
      values[LAST] = TMP;
   }
   
   // Problem (b)
   public void shiftRight()
   {
      final int LAST = values.length - 1;
      final int TMP = values[LAST];
      
      for(int i = LAST; i > 0; i--)
      {
         values[i] = values[i-1];
      }
      
      values[0] = TMP;
   }
   
   // Problem (c)
   public void replaceEvenWithZero()
   {
      for(int i = 0; i < values.length; i++)
      {
         if(values[i] % 2 == 0)
         {
            values[i] = 0;
         }
      }
   }
   
   // Problem (d)
   // Ignores first and last
   public void replaceWithLargestNeighbor()
   {
      int[] tmp = values.clone();
      for(int i = 1; i < values.length - 1; i++)
      {
         if(values[i+1] < values[i-1])
         {
            tmp[i] = values[i-1];
         }
         else 
         {
            tmp[i] = values[i+1];
         }
      }
      
      values = tmp;
   }
   
   // Problem (e)
   public void removeMiddle()
   {
      // Return if no middle
      if(values.length < 3)
      {
         return;
      }
      
      // Initialize as blank to avoid errors.
      // Values will get initialized.
      int[] firstHalf = {};
      int[] secondHalf = {};
      
      // remove two from middle
      int firstHalfStart = 0;
      int firstHalfEnd = values.length / 2;
      int secondHalfStart = firstHalfEnd + 1;
      int secondHalfEnd = values.length;
      
      if(isEven(values.length)) // even
      {
         firstHalfEnd -= 1;
      }
      
      firstHalf = getSection(values, firstHalfStart, firstHalfEnd);
      secondHalf = getSection(values, secondHalfStart, secondHalfEnd);
      
      values = append(firstHalf, secondHalf);
   }
   
   public int[] append(int[] a, int[] b)
   {
      int[] c = new int[a.length + b.length];
      for(int i = 0; i < a.length; i++)
      {
         c[i] = a[i];
      }
      
      final int offset = a.length;
      for(int i = 0; i < b.length; i++)
      {
         c[i + offset] = b[i];
      }
      
      return c;
   }   
   
   public int[] getSection(int[] xs, int start, int end)
   {
      int[] section = new int[end - start];
      
      final int offset = start;
      final int length = end - start;
      for(int i = 0; i < length; i++)
      {
         section[i] = xs[i + offset];
      }
      
      return section;
   }
   
   // Problem (f)
   public void moveEvenToFront()
   {
      // Return if no even or odd numbers
      if(countEven() == 0 || countOdd() == 0)
      {
         return;
      }
      
      int[] evenValues = new int[countEven()];
      int[] oddValues = new int[countOdd()];
      
      
      int even_i = 0;
      int odd_i = 0;
      for(int i = 0; i < values.length; i++)
      {
         if(isEven(values[i]))
         {
            evenValues[even_i] = values[i];
            even_i++;
         }
         else
         {
            oddValues[odd_i] = values[i];
            odd_i++;
         }
      }
      
      values = append(evenValues, oddValues);
   }
   
   public boolean isEven(int x)
   {
      return ((x % 2) == 0);
   }
   
   public int countEven()
   {
      int counter = 0;
      for(int i = 0; i < values.length; i++)
      {
         if(isEven(values[i]))
         {
            counter++;
         }
      }
      
      return counter;
   }
   
   public int countOdd()
   {
      return (values.length - countEven());
   }
   
   // Problem (g)
   public  int secondLargest()
   {
      // If there is no second largest, just return zero.
      if(values.length <= 1)
      {
         return 0;
      }
      
      int largest = Math.max(values[0], values[1]);
      int secondLargest = Math.min(values[0], values[1]);
      
      // starting on the third element
      for(int i = 2; i < values.length; i++)
      {
         if(values[i] > largest)
         {
            secondLargest = largest;
            largest = values[i];
         }
      }
      
      return secondLargest;
   }
   
   // At this point, I've drank so much coffee
   // that I have to write detailed comments.
   
   // Problem (h)
   public boolean isIncreasingOrder()
   {
      // Return true if list is
      // one or no elements.
      if(values.length <= 1)
      {
         return true;
      }
      
      // save the first element
      int last = values[0];
      // start from the second
      for(int i = 1; i < values.length; i++)
      {
         // return false is the current element
         // is less than the last.
         if(values[i] < last)
         {
            return false;
         }
         
         // Save the new last element
         last = values[i];
      }
      
      // If survives the loop,
      // elements are in increasing order.
      return true;
   }
   
   // Problem (i)
   public boolean hasAdjecentDuplicates()
   {
      // Return false if list is
      // one or no elements.
      if(values.length <= 1)
      {
         return false;
      }
      
      // save the first element
      int last = values[0];
      // start from the second
      for(int i = 1; i < values.length; i++)
      {
         // return true is the current element
         // equals the last
         if(values[i] == last)
         {
            return true;
         }
         
         // Save the new last element
         last = values[i];
      }
      
      // If the loops completes without returning,
      // then there were no adjecent elements.
      return false;
   }
   
   // Problem (j)
   public boolean hasDuplicates()
   {
      // When there is one or no
      // elements, there won't be any matches.
      if(values.length <= 1)
      {
         return false;
      }
      
      // This one requires comparing every element
      // in the array against every other element,
      // and returning true when a match is found.
      
      // Go up to the second to last value,
      // as there is no point in comparing
      // the last value to itself
      for(int i = 0; i < values.length-1; i++)
      {
         // j needs start off as the position
         // right after i, to avoid j == i,
         // and to avoid checking values that have
         // already been compared to everything else.
         for(int j = i + 1; j < values.length; j++)
         {
            // When a match is found,
            // return true.
            if(values[i] == values[j])
            {
               return true;
            }
         }
      }
      
      // When all the elements were compared
      // and no match was found.
      return false;
   }
}