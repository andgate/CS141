/**
   A bug that can walk and change direction between right and left.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class Bug
{
   private int position;
   private int velocity;
   
   private final static int POSITION_ZERO = 0;
   private final static int RIGHT_DIRECTION = 1; // In units per movement
   private final static int LEFT_DIRECTION = -1; // In units per movement
   private final static int OPPOSITE_DIRECTION_FACTOR = -1; // Changes the sign of the velocity

   /**
      Construct a bug that walks right from a position of zero.
    */
   public Bug()
   {
      this(POSITION_ZERO);
   }

   /**
      Construct a bug that walks right from a given position.
      @param initialPosition The position the bug starts walking from, in generic units.
    */
   public Bug(int initialPosition)
   {
      position = initialPosition;
      velocity = RIGHT_DIRECTION;
   }
   
   /**
      Change the direction of the bug.
      If the bug was moving left, the bug will now move right.
      If the bug was moving right, the bug will now move left.
    */
   public void turn()
   {
      velocity *= OPPOSITE_DIRECTION_FACTOR;
   }
   
   /**
      Move the bug by one generic unit.
    */
   public void move()
   {
      position += velocity;
   }
   
   /**
      Getter for the position of the bug.
      @return The current postion of the bug, in generic units.
    */
   public int getPosition()
   {
      return position;
   }
   
}