/**
   A voting machine that tracks the number of republican and democrat votes.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */
public class VotingMachine
{
   private int democratVotes;
   private int republicanVotes;
   
   private final static int NO_VOTES = 0;
   
   /**
      Construct a voting machine with no votes for either side, hopefully.
    */
   public VotingMachine()
   {
      this.clearVotes();
   }
   
   /**
      Tally a vote for democrat.
    */
   public void democratVote()
   {
      democratVotes++;
   }
   
   /**
      Get the number of votes that were democrat.
      @return Tally of democrat votes.
    */
   public int getDemocratVotes()
   {
      return democratVotes;
   }
   
   /**
      Tally a vote for republican.
    */
   public void republicanVote()
   {
      republicanVotes++;
   }
   
   /**
      Get the number of votes that were republican.
      @return Tally of republican votes.
    */
   public int getRepublicanVotes()
   {
      return republicanVotes;
   }
   
   /**
      Reset both voting tallies, so each candidate will have no votes.
    */
   public void clearVotes()
   {
      democratVotes = NO_VOTES;
      republicanVotes = NO_VOTES;      
   }
}      
