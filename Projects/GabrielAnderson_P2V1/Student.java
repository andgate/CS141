import java.text.DecimalFormat;

/**
   A class representing a Student's record, that is, the student's name,
   total score of all their quizzes, and the amount of quizzes they've taken.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 13 October 2014
   @version 1.0
 */
public class Student
{
   private String name;
   private int quizCount;
   private int totalScore;
   
   private static int INITIAL_TOTAL_SCORE = 0;
   private static int INITIAL_QUIZ_COUNT = 0;
   
   private static final DecimalFormat doubleDecimal = new DecimalFormat("0.00");
   
   /**
      Constructs an new student.
      @param newName The name of the new student.
    */
   public Student(String newName)
   {
      name = newName;
      totalScore = INITIAL_TOTAL_SCORE;
      quizCount = INITIAL_QUIZ_COUNT;
   }
   
   /**
      Query the name of a student.
      @return Name of this student.
    */
   public String getName()
   {
      return name;
   }
   
   /**
      Add a quiz score to the student's record.
      @param score The score to add to the student's record, out of a hundred.
    */
   public void addQuiz(int score)
   {
      quizCount++;
      totalScore += score;
   }
   
   /**
      Query the student's record for the number of quizzes recorded.
      @return The number of quizzes the student has taken.
    */
   public int getQuizCount()
   {
      return quizCount;
   }
   
   /**
      Query a student's record for the total score of all the quizzes added for a student.
      @return Total score of all the quizzes added for a student.
    */
   public int getTotalScore()
   {
      return totalScore;
   }
   
   /**
      Query a student's record for the student's average score.
      @return The student's Average quiz score.
    */
   public double getAverageScore()
   {
      if(quizCount == 0)
         return 0;
      else
         return (double)totalScore / (double)quizCount;
   }
   
   /**
      Get the student's information in a string format intended for printing.
      <br>The string looks like this:
      <br>Name: <i>&lt;student_name&gt;</i>
      <br>Quiz count: <i>&lt;number_of_quizzes_entered&gt;</i>
      <br>Total score: <i>&lt;total_points&gt;</i>
      <br>Average score: <i>&lt;average_score&gt;</i>
      @return The student's information in a nicely formatted string.
    */
   @Override
   public String toString()
   {
      return "\nName: " + getName()
             + "\nQuiz count: " + getQuizCount()
             + "\nTotal score: " + getTotalScore()
             + "\nAverage score: " + doubleDecimal.format(getAverageScore());
   }
}