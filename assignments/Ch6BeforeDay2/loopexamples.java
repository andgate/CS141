// Prints 3 rows of 4
// astericks each.
for(int i = 1; i <= 3; i++)
{
   for(int j = 1; j <= 4; j++)
   {
      System.out.println("*");
   }
   System.out.println("");
}

// Prints 4 rows of 3
// astericks each.
for(int i = 1; i <= 4; i++)
{
   for(int j = 1; j <= 3; j++)
   {
      System.out.println("*");
   }
   System.out.println("");
}

// Prints 4 rows of
// lengths 1, 2, 3, and 4.
for(int i = 1; i <= 4; i++)
{
   for(int j = 1; j <= i; j++)
   {
      System.out.println("*");
   }
   System.out.println("");
}

// Prints astericks in even columns,
// dashes in odd columns.
for(int i = 1; i <= 3; i++)
{
   for(int j = 1; j <= 5; j++)
   {
      if (j % 2 == 0)
      {
         System.out.println("*");
      }
      else
      {
         System.out.println("_");
      }
   }
   System.out.println("");
}

// Prints a checkerboard pattern.
for(int i = 1; i <= 3; i++)
{
   for(int j = 1; j <= 5; j++)
   {
      if (i % 2 == j % 2)
      {
         System.out.println("*");
      }
      else
      {
         System.out.println(" ");
      }
   }
   System.out.println("");
}
