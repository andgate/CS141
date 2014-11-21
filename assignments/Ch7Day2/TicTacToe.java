import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TicTacToe
{
   private static String[][] board = new String[3][3];
   
   private static int turn;
   private static final int PLAYER_1_TURN = 0;
   private static final int PLAYER_2_TURN = 1;
   
   private static final String PLAYER_1_MARK = "O";
   private static final String PLAYER_2_MARK = "X";
   private static final String UNMARKED = " ";
   
   private static final String COLUMN_HEADER
      = "  1   2   3  ";
   
   private static final String CEILING
      = " _1_ _2_ _3_ ";
      
   private static final String EMPTY_ROW
      = "|   |   |   |";
   private static final String FLOOR
      = "|___|___|___|";
   private static final String LEFT_WALL
      = "|";
   private static final String SPACE = " ";
   private static final String RIGHT_WALL
      = " |";
   
   private static final String CURRENT_TURN_ECHO
      = "Current turn: Player ";
   
   private static final String ENTER_ROW_ECHO
      = "Enter Row (1-3): ";
   private static final String ENTER_COLUMN_ECHO
      = "Enter Column (1-3) : ";
      
   private static final String ALREADY_MARKED_ECHO
      = "That location is already marked.";
      
   private static final String COMPUTER_CHOSE_ROW_ECHO
      = "Computer marked row: ";
   private static final String COMPUTER_CHOSE_COLUMN_ECHO
      = "Computer marked column: ";
      
   private static final String GAME_TIED_ECHO
      = "The game has ended in a tie!";
   private static final String PLAYER_PREFIX
      = "Player #";
   private static final String HAS_WON_ECHO
      = " has won the game!";
      
   private static final String GOOD_BYE_ECHO
      = "\nGoodbye.";
      
   private static final String INVALID_INPUT_ECHO
      = "Invalid input. Please enter 1, 2, or 3.";
   
   public static void main(String[] args)
   {
      initializeBoard();
      // player 1 goes first
      turn = PLAYER_1_TURN;
      
      Scanner console = new Scanner(System.in);
      gameLoop(console);
   }
   
   private static void initializeBoard()
   {
      for(int i = 0; i < board.length; i++)
      {
         for(int j = 0; j < board.length; j++)
         {
            board[i][j] = UNMARKED;
         }
      }
   }
   
   private static void gameLoop(Scanner in)
   {
      boolean isGameOver = false;
      while(!isGameOver)
      {
         drawBoard();
         // Do the next turn
         turn(in);
      
         if(isThreeInARow())
         {
            win();
            isGameOver = true;
         }
         else if(isBoardFull())
         {
            tie();
            isGameOver = true;
         }
         else
         {
            nextTurn();
         }
      }
   }
   
   private static void tie()
   {
      drawBoard();
      System.out.println(GAME_TIED_ECHO);
   }
   
   private static void win()
   {
      drawBoard();
      int winner = turn + 1;
      System.out.println(PLAYER_PREFIX + winner + HAS_WON_ECHO);
   }
   
   private static void drawBoard()
   {
      System.out.println(CEILING);
      
      for(int i = 0; i < board.length; i++)
      {
         
         System.out.println(EMPTY_ROW);
         System.out.print(i + 1);
         for(int j = 0; j < board[i].length; j++)
         {
            System.out.print(SPACE + board[i][j] + RIGHT_WALL);
         }
         
         System.out.println();
         System.out.println(FLOOR);
      }
   }
   
   private static void turn(Scanner in)
   {
      sayTurn();
      
      if(turn == PLAYER_1_TURN)
      {
         humanTurn(in);
      }
      else if (turn == PLAYER_2_TURN)
      {
         computerTurn();
      }
   }
   
   private static void humanTurn(Scanner in)
   {
      boolean isTurnOver = false;
      while(!isTurnOver)
      {
         System.out.print(ENTER_ROW_ECHO);
         int row = ask(in);
         System.out.print(ENTER_COLUMN_ECHO);
         int column = ask(in);
         String mark = getCurrentMark();
         
         if(isMarked(row, column))
         {
            System.out.println(ALREADY_MARKED_ECHO);
         }
         else
         {
            isTurnOver = markBoard(mark, row, column);
         }
      }
   }
   
   private static void computerTurn()
   {
      Random gen = new Random();
      int row = 0;
      int column = 0;
      
      boolean valid = false;
      while(!valid)
      {
         row = gen.nextInt(3);
         column = gen.nextInt(3);
         
         valid = !isMarked(row, column);
      }
      
      String mark = getCurrentMark();
      markBoard(mark, row, column);
      
      System.out.println(COMPUTER_CHOSE_ROW_ECHO + row);
      System.out.println(COMPUTER_CHOSE_COLUMN_ECHO + column);
   }
      
   private static void sayTurn()
   {
      int playerNum = turn + 1;
      System.out.println(CURRENT_TURN_ECHO + playerNum);
   }
   
   private static int ask(Scanner in)
   {
      while(true)
      {
         int pos = 0;
         
         try
         {
            pos = in.nextInt();
         }
         catch(InputMismatchException e)
         {
            // let the loop take care of it
         }
         catch(NoSuchElementException e)
         {
            forceQuit();
         }
         catch(IllegalStateException e)
         {
            forceQuit();
         }
         
         pos -= 1;
         if(0 <= pos && pos < board.length)
         {
            return pos;
         }
         
         // No valid input was found,
         // so let the loop repeat.
         System.out.println(INVALID_INPUT_ECHO);
      }
   }
   
   private static void nextTurn()
   {
      if(turn == PLAYER_1_TURN)
      {
         turn = PLAYER_2_TURN;
      }
      else
      {
         turn = PLAYER_1_TURN;
      }
   }
   
   private static String getCurrentMark()
   {
      if(turn == PLAYER_1_TURN)
      {
         return PLAYER_1_MARK;
      }
      
      return PLAYER_2_MARK;
   }
   
   private static boolean markBoard(String mark, int row, int column)
   {
      if(row >= board.length || row < 0)
      {
         return false;
      }
      
      if(column >= board[row].length || column < 0)
      {
         return false;
      }
      
      board[row][column] = mark;
      return true;
   }
   
   private static boolean isMarked(int row, int column)
   {
      return !board[row][column].equals(UNMARKED);
   }
   
   private static boolean isBoardFull()
   {
      for(int i = 0; i < board.length; i++)
      {
         for(int j = 0; j < board[i].length; j++)
         {
            if(!isMarked(i, j))
            {
               return false;
            }
         }
      }
      
      return true;
   }
   
   private static boolean isThreeInARow()
   {  
      return checkDownwardDiagonal()
               || checkUpwardDiagonal()
               || checkRows()
               || checkColumns();
   }
   
   private static boolean checkDownwardDiagonal()
   {
      String first = board[0][0];
      String second = board[1][1];
      String third = board[2][2];
   
      if(first.equals(PLAYER_1_MARK) || first.equals(PLAYER_2_MARK))
      {
         return first.equals(second) && second.equals(third);
      }
      
      return false;
   }
   
   private static boolean checkUpwardDiagonal()
   {
      String first = board[0][2];
      String second = board[1][1];
      String third = board[2][0];
   
      if(first.equals(PLAYER_1_MARK) || first.equals(PLAYER_2_MARK))
      {
         return first.equals(second) && second.equals(third);
      }
      
      return false;
   }
   
   private static boolean checkRows()
   {
      boolean found = false;
      
      for(int i = 0; i < board.length && !found; i++)
      {
         String first = board[i][0];
         String second = board[i][1];
         String third = board[i][2];
   
         if(first.equals(PLAYER_1_MARK) || first.equals(PLAYER_2_MARK))
         {
            if(first.equals(second) && second.equals(third))
            {
               found = true;
            }
         }
      }
      
      return found;
   }
   
   private static boolean checkColumns()
   {
      boolean found = false;
      
      for(int i = 0; i < board.length && !found; i++)
      {
         String first = board[0][i];
         String second = board[1][i];
         String third = board[2][i];
   
         if(first.equals(PLAYER_1_MARK) || first.equals(PLAYER_2_MARK))
         {
            if(first.equals(second) && second.equals(third))
            {
               found = true;
            }
         }
      }
      
      return found;
   }
   
   private static void forceQuit()
   {
      System.out.println(GOOD_BYE_ECHO);
      System.exit(0);
   }
}