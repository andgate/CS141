public class Scratch
{
   public static void main(String[] args)
   {
      int[][] board = new int[8][8];
      
      for(int i = 0; i < board.length; i++)
      {
         for(int j = 0; j < board[i].length; j++)
         {
            if(((i + j + 1) % 2) == 0)
            {
               board[i][j] = 1;
               System.out.print("1");
            }
         }
      }
   }
}

for(int i = 0; i < board.length; i++)
{
   for(int j = 0; j < board[i].length; j++)
   {
      if(((i + j + 1) % 2) == 0)
      {
         board[i][j] = 1;
         System.out.print("1");
      }
   }
}