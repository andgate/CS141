/**
   Test a VotingMachine by simulating an election.<br.
   COPYRIGHT &copy; 2014 Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @author Gabriel Anderson, Sarah Brown, Yuk Luen Mui
   @since 13 October 2014
 */

public class VotingMachineTester
{
   public static void main(String[] args)
   {
      VotingMachine machine = new VotingMachine();
      
      machine.democratVote(); 
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.democratVote();
      machine.republicanVote();
      machine.republicanVote();
      machine.republicanVote();
      machine.republicanVote();
      machine.republicanVote();
      machine.republicanVote();
      
      System.out.println("Expected democrat votes: 11");
      System.out.println("Actual democrat votes: " + machine.getDemocratVotes() + "\n");
      
      System.out.println("Expected republican votes: 6");
      System.out.println("Actual republican votes: " + machine.getRepublicanVotes());
   }
}