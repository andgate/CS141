import java.util.Scanner;

/**
   A class representing a Student's record, that is, the student's name, and
   detailed statistics regarding their grade.<br>
   v2.0 Changes<br>
   <ul>
      <li>Default constructor added</li>
      <li>inputData(Scanner in) method added, for making it easier to enter grades.</li>
      <li>addScore(int score) method changed to addGrade(int grade).</li>
      <li>addGrade method only works with grades from 0 to 100.</li>
      <li>toString method include much more information than before.</li>
      <li>getAverage() method changed to getMean().</li>
      <li>getSumOfSquares(), getVariance(), getStandardDeviation().</li>
      <li>Different methods to get the number of quizzes earning a specific letter grade</li>
      <li>getTotalScore() was renamed to getTotalQuizScore().</li>
      <li>getQuizCount() was renamed to getNumberOfQuizzes().</li>
      <li>setName(String newName) method introduced.</li>
      <li>getScores() method introduced, so the scores entered are kept track of.</li>
   </ul>
   All of these changes were backed up by a thorough testing procedure.</br>
   <p>COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 13 October 2014
   @version 2.0
 */
public class Student
{
   /**
      The letter grades a student can earn from a quiz.
    */
   static enum LetterGrade
   {
      A, B, C, D, F
   }
   
   // Instance variables
   private String name;
   private int numberOfQuizzes;
   private int highValue;
   private int lowValue;
   private int totalQuizScore;
   private double mean;
   private int sumOfSquares;
   private double variance;
   private double standardDeviation;
   private String scoresEntered;
   
   private int numberOfAGrades;
   private int numberOfBGrades;
   private int numberOfCGrades;
   private int numberOfDGrades;
   private int numberOfFGrades;
   
   // Constants 
   private static final String BLANK = "";
   private static final String NO_NAME = BLANK;
   private static final String COMMA_SPACE = ", ";
   private static final String PERIOD = ".";
   private static final String BLANK_DATA = String.format("%5c", '-');
   private static final String INPUT_DATA_ECHO 
      = "Please enter the grade number, from 0 and 100: ";
   private static final String OUTPUT_NAME_LABEL
      = "\nStudent's full name:     ";
   private static final String OUTPUT_NUMBER_OF_QUIZZES_LABEL
      = "\nNumber of quizzes taken: ";
   private static final String OUTPUT_HIGHEST_QUIZ_SCORE_LABEL
      = "\nHighest quiz score:      ";
   private static final String OUTPUT_LOWEST_QUIZ_SCORE_LABEL
      = "\nLowest quiz score:       ";
   private static final String OUTPUT_TOTAL_QUIZ_SCORE_LABEL
      = "\nTotal quiz score:        ";
   private static final String OUTPUT_MEAN_LABEL
      = "\nMean:                    ";
   private static final String OUTPUT_SUM_OF_SQUARES_LABEL
      = "\nSum of squares:          ";
   private static final String OUTPUT_VARIANCE_LABEL
      = "\nVariance:                ";
   private static final String OUTPUT_STANDARD_DEVIATION_LABEL
      = "\nStandard deviation:      ";
   private static final String OUTPUT_NUMBER_OF_A_GRADES_LABEL
      = "\nNumber of A's:           ";
   private static final String OUTPUT_NUMBER_OF_B_GRADES_LABEL
      = "\nNumber of B's:           ";
   private static final String OUTPUT_NUMBER_OF_C_GRADES_LABEL
      = "\nNumber of C's:           ";
   private static final String OUTPUT_NUMBER_OF_D_GRADES_LABEL
      = "\nNumber of D's:           ";
   private static final String OUTPUT_NUMBER_OF_F_GRADES_LABEL
      = "\nNumber of F's:           ";
   private static final String OUTPUT_SCORES_ENTERED_LABEL
      = "\nScores entered: ";
   
   private static final int LOWEST_GRADE = 0;
   private static final int HIGHEST_GRADE = 100;
   
   private static final int INITIAL_NUMBER_OF_QUIZZES = 0;
   private static final int INITIAL_HIGH_VALUE = 0;
   private static final int INITIAL_LOW_VALUE = 0;
   private static final String INITIAL_SCORES_ENTERED = BLANK;
   private static final int INITIAL_TOTAL_QUIZ_SCORE = 0;
   private static final double INITIAL_MEAN = 0.0;
   private static final int INITIAL_SUM_OF_SQUARES = 0;
   private static final double INITIAL_VARIANCE = 0.0;
   private static final double INITIAL_STANDARD_DEVIATION = 0.0;
   
   private static final int INITIAL_NUMBER_OF_A_GRADES = 0;
   private static final int INITIAL_NUMBER_OF_B_GRADES = 0;
   private static final int INITIAL_NUMBER_OF_C_GRADES = 0;
   private static final int INITIAL_NUMBER_OF_D_GRADES = 0;
   private static final int INITIAL_NUMBER_OF_F_GRADES = 0;

   private static final int HIGHEST_A_GRADE = 100;   
   private static final int LOWEST_A_GRADE = 90;
   private static final int HIGHEST_B_GRADE = 89;   
   private static final int LOWEST_B_GRADE = 80;
   private static final int HIGHEST_C_GRADE = 79;   
   private static final int LOWEST_C_GRADE = 70;
   private static final int HIGHEST_D_GRADE = 69;   
   private static final int LOWEST_D_GRADE = 60;
   private static final int HIGHEST_F_GRADE = 59;   
   private static final int LOWEST_F_GRADE = 0;
   
   /**
      Constructs an student with a name, with no quizzes taken.
    */
   public Student()
   {
      name = NO_NAME;
      numberOfQuizzes = INITIAL_NUMBER_OF_QUIZZES;
      highValue = INITIAL_HIGH_VALUE;
      lowValue = INITIAL_LOW_VALUE;
      scoresEntered = INITIAL_SCORES_ENTERED;
      totalQuizScore = INITIAL_TOTAL_QUIZ_SCORE;
      mean = INITIAL_MEAN;
      sumOfSquares = INITIAL_SUM_OF_SQUARES;
      variance = INITIAL_VARIANCE;
      standardDeviation = INITIAL_STANDARD_DEVIATION;
      
      numberOfAGrades = INITIAL_NUMBER_OF_A_GRADES;
      numberOfBGrades = INITIAL_NUMBER_OF_B_GRADES;
      numberOfCGrades = INITIAL_NUMBER_OF_C_GRADES;
      numberOfDGrades = INITIAL_NUMBER_OF_D_GRADES;
      numberOfFGrades = INITIAL_NUMBER_OF_F_GRADES;
   }
   
      
   /**
      Constructs an student with a name, with no quizzes taken.
      @param newName The name of the new student.
    */
   public Student(String newName)
   {
      this();
      setName(newName);
   }
   
   /**
      Reads the next input for the given scanner, throwing away invalid input.
      Valid input is an integer ranging from 0 to 100.
      @param in The Scanner object to use for input.
      @return True if score was entered, false if input was invalid.
    */
   public boolean inputData(Scanner in)
   {
      System.out.println(INPUT_DATA_ECHO);
      
      if(in.hasNextInt())
      {
         int grade = in.nextInt();
         return addGrade(grade);
      }
      
      // discard the current input
      in.next();
      
      return false;
   }
   
   /**
      Add a grade to the student's record, rejecting invalid grades.
      A valid grade lies in the range of 0 to 100.
      @param grade The score to add to the student's record, out of a hundred.
      @return False if the grade is rejected, true if the grade is accepted.
    */
   public boolean addGrade(int grade)
   {
      if(!inRange(grade, LOWEST_GRADE, HIGHEST_GRADE))
      {
         return false;
      }
      
      numberOfQuizzes++;
      
      if(numberOfQuizzes == 1)
      {
         lowValue = grade;
         highValue = grade;
      }
      else
      {
         highValue = Math.max(highValue, grade);
         lowValue = Math.min(lowValue, grade);
      }
      
      totalQuizScore += grade;
      sumOfSquares += grade * grade;
      
      LetterGrade letterGrade = getLetterGrade(grade);
      addLetterGrade(letterGrade);
      
      // Because the student's information has changed
      // a call to calulcate is needed.
      // This is better than calling calculate when the
      // mean or standard deviation is requested,
      // because this way caches the information for later.
      calculate();
      
      scoresEntered += grade + COMMA_SPACE;
      
      return true;
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
      Sets the student's name.
      @param newName The name of the student.
    */
   public void setName(String newName)
   {
      name = newName;
   }
   
   /**
      Query the student's record for the number of quizzes recorded.
      @return The number of quizzes the student has taken.
    */
   public int getNumberOfQuizzes()
   {
      return numberOfQuizzes;
   }
   
   /**
      Query a student's record for the total score of all the quizzes added for a student.
      @return Total score of all the quizzes added for a student.
    */
   public int getTotalQuizScore()
   {
      return totalQuizScore;
   }
   
   /**
      Query a student's record for the lowest quiz score inputed.
      @return Lowest quiz score on record.
    */
   public int getLowestQuizScore()
   {
      return lowValue;
   }
   
   /**
      Query a student's record for the highest quiz score inputed.
      @return Highest quiz score on record.
    */
   public int getHighestQuizScore()
   {
      return highValue;
   }
   
   /**
      Query a student's record for all the scores entered.
      @return All the scores entered on a student's record, seperated by spaces.
    */
   public String getScoresEntered()
   {
      int start = 0;
      int end = scoresEntered.length() - COMMA_SPACE.length();
      return scoresEntered.substring(start, end) + PERIOD;
   }
   
   /**
      Query a student's record for the student's average score.
      @return The student's average quiz score.
    */
   public double getMean()
   {
      return mean;
   }
   
   /**
      Query a student's record for the sum of every quiz score squared.
      This data is used to calculate the standard deviation.
      @return The sum of each quiz score squared.
    */
   public int getSumOfSquares()
   {
      return sumOfSquares;
   }
   
   /**
      Query a student's record for the variance between all the quiz scores.
      This data is used to calculate the standard deviation.
      @return The variance between all the scores on record.
    */
   public double getVariance()
   {
      return variance;
   }
   
   
   /**
      Query a student's record for the standard deviation of their quiz scores.
      @return The standard deviation of the quiz scores on record.
    */
   public double getStandardDeviation()
   {
      return standardDeviation;
   }
   
   /**
      Query the student's records for the number of quizzes they've earned A's on.
      @return The number of quizzes that scored an A letter grade.
    */
   public int getNumberOfAGrades()
   {
      return numberOfAGrades;
   }
   
   /**
      Query the student's records for the number of quizzes they've earned B's on.
      @return The number of quizzes that scored an B letter grade.
    */
   public int getNumberOfBGrades()
   {
      return numberOfBGrades;
   }
   
   /**
      Query the student's records for the number of quizzes they've earned C's on.
      @return The number of quizzes that scored an C letter grade.
    */
   public int getNumberOfCGrades()
   {
      return numberOfCGrades;
   }
   
   /**
      Query the student's records for the number of quizzes they've earned D's on.
      @return The number of quizzes that scored an D letter grade.
    */
   public int getNumberOfDGrades()
   {
      return numberOfDGrades;
   }
   
   /**
      Query the student's records for the number of quizzes they've earned F's on.
      @return The number of quizzes that scored an F letter grade.
    */
   public int getNumberOfFGrades()
   {
      return numberOfFGrades;
   }
   
   /**
      Return's a string containing the student's data on record.
      Formatted for System.out.print.
      <br>The string looks like this:
      <br>Student's full name:     <i>&lt;student's name&gt;</i>
      <br>Number of quizzes taken: <i>&lt;number of&gt;</i>
      <br>Total quiz score:        <i>&lt;total score&gt;</i>
      <br>Lowest quiz score:       <i>&lt;lowest score&gt;</i>
      <br>Highest quiz score:      <i>&lt;highest score&gt;</i>
      <br>Mean:                    <i>&lt;mean&gt;</i>
      <br>Sum of Squares:          <i>&lt;sum of squares&gt;</i>
      <br>Variance:                <i>&lt;variance&gt;</i>
      <br>Standard deviation:      <i>&lt;standard deviation&gt;</i>
      <br>Scores entered:          <i>&lt;list of scores&gt;</i>
      <br>Number of A's:           <i>&lt;number of&gt;</i>
      <br>Number of B's:           <i>&lt;number of&gt;</i>
      <br>Number of C's:           <i>&lt;number of&gt;</i>
      <br>Number of D's:           <i>&lt;number of&gt;</i>
      <br>Number of F's:           <i>&lt;number of&gt;</i>
      <br>Also, a "-" takes the place of missing data.
      @return The formatted string for showing the student's data. 
    */
   @Override
   public String toString()
   {  
      String studentDataStr = studentDataToString();
      String letterGradesStr = letterGradesToString();
      
      // "Scores entered" is a little list at the end.
      // Decided against formatting this, as the list of numbers
      // doesn't look nice lined up with the rest of the data.
      String scoresEnteredStr = OUTPUT_SCORES_ENTERED_LABEL;
      if(getNumberOfQuizzes() == 0)
      {
         scoresEnteredStr += String.format("%14s", BLANK_DATA);
      }
      else
      {
         scoresEnteredStr += getScoresEntered();
      }
      
      String output = studentDataStr + letterGradesStr + scoresEnteredStr;
      
      return output;
   }
   
   /**
      Return's a string containing the student's data on record.
      Formatted for System.out.print.
      <br>The string looks like this:
      <br>Student's full name:     <i>&lt;student's name&gt;</i>
      <br>Number of quizzes taken: <i>&lt;number of&gt;</i>
      <br>Total quiz score:        <i>&lt;total score&gt;</i>
      <br>Lowest quiz score:       <i>&lt;lowest score&gt;</i>
      <br>Highest quiz score:      <i>&lt;highest score&gt;</i>
      <br>Mean:                    <i>&lt;mean&gt;</i>
      <br>Sum of Squares:          <i>&lt;sum of squares&gt;</i>
      <br>Variance:                <i>&lt;variance&gt;</i>
      <br>Standard deviation:      <i>&lt;standard deviation&gt;</i>
      <br>Scores entered:          <i>&lt;list of scores&gt;</i>
      <br>Also, a "-" takes the place of missing data.
      @return The formatted string for showing the student's data. 
    */
   private String studentDataToString()
   {
      String nameStr = OUTPUT_NAME_LABEL;
      // If no name, mask the name with BLANK_DATA
      nameStr += getName().equals(NO_NAME)
                  ? BLANK_DATA
                  : getName();
                     
      String numberOfQuizzesStr = OUTPUT_NUMBER_OF_QUIZZES_LABEL;
      String totalQuizScoreStr = OUTPUT_TOTAL_QUIZ_SCORE_LABEL;
      String lowValueStr = OUTPUT_LOWEST_QUIZ_SCORE_LABEL;
      String highValueStr = OUTPUT_HIGHEST_QUIZ_SCORE_LABEL;
      String meanStr = OUTPUT_MEAN_LABEL;
      String sumOfSquaresStr = OUTPUT_SUM_OF_SQUARES_LABEL;
      String varianceStr = OUTPUT_VARIANCE_LABEL;
      String standardDeviationStr = OUTPUT_STANDARD_DEVIATION_LABEL;
      
      // if no quizzes, mask the strings
      if(getNumberOfQuizzes() == 0)
      {
         numberOfQuizzesStr += BLANK_DATA;
         totalQuizScoreStr += BLANK_DATA;
         lowValueStr += BLANK_DATA;
         highValueStr += BLANK_DATA;
         meanStr += BLANK_DATA;
         sumOfSquaresStr += BLANK_DATA;
         varianceStr += BLANK_DATA;
         standardDeviationStr += BLANK_DATA;
      }
      else
      {
         numberOfQuizzesStr += String.format("%5d", getNumberOfQuizzes());
         totalQuizScoreStr += String.format("%5d", getTotalQuizScore());
         lowValueStr += String.format("%5d", getLowestQuizScore());
         highValueStr += String.format("%5d", getHighestQuizScore());
         meanStr += String.format("%8.2f", getMean());
         sumOfSquaresStr += String.format("%5d", getSumOfSquares());
         varianceStr += String.format("%9.3f", getVariance());
         standardDeviationStr += String.format("%9.3f", getStandardDeviation());
      }
      
      String studentDataString = nameStr;
      studentDataString += numberOfQuizzesStr;
      studentDataString += totalQuizScoreStr;
      studentDataString += lowValueStr;
      studentDataString += highValueStr;
      studentDataString += meanStr;
      studentDataString += sumOfSquaresStr;
      studentDataString += varianceStr;
      studentDataString += standardDeviationStr;
      
      return studentDataString;
   }
   
   /**
      Return's a string containing the student's data on record.
      Formatted for System.out.print.
      <br>The string looks like this:
      <br>Number of A's:           <i>&lt;number of&gt;</i>
      <br>Number of B's:           <i>&lt;number of&gt;</i>
      <br>Number of C's:           <i>&lt;number of&gt;</i>
      <br>Number of D's:           <i>&lt;number of&gt;</i>
      <br>Number of F's:           <i>&lt;number of&gt;</i>
      <br>Also, a "-" takes the place of missing data.
      @return The formatted string for showing the student's data. 
    */
   private String letterGradesToString()
   {
      String numberOfAGradesStr = OUTPUT_NUMBER_OF_A_GRADES_LABEL;
      // Use BLANK_DATA to mask 0 entries.
      numberOfAGradesStr += getNumberOfAGrades() == 0
                              ? BLANK_DATA
                              : String.format("%5d", getNumberOfAGrades());
      
      String numberOfBGradesStr = OUTPUT_NUMBER_OF_B_GRADES_LABEL;
      numberOfBGradesStr += getNumberOfBGrades() == 0
                              ? BLANK_DATA
                              : String.format("%5d", getNumberOfBGrades());
                                    
      String numberOfCGradesStr = OUTPUT_NUMBER_OF_C_GRADES_LABEL;
      numberOfCGradesStr += getNumberOfCGrades() == 0
                              ? BLANK_DATA
                              : String.format("%5d", getNumberOfCGrades());
                                    
      String numberOfDGradesStr = OUTPUT_NUMBER_OF_D_GRADES_LABEL;
      numberOfDGradesStr += getNumberOfDGrades() == 0
                              ? BLANK_DATA
                              : String.format("%5d", getNumberOfDGrades());
                              
      String numberOfFGradesStr = OUTPUT_NUMBER_OF_F_GRADES_LABEL;
      numberOfFGradesStr += getNumberOfFGrades() == 0
                              ? BLANK_DATA
                              : String.format("%5d", getNumberOfFGrades());
                                    
      String letterGradesStr = numberOfAGradesStr;
      letterGradesStr += numberOfBGradesStr;
      letterGradesStr += numberOfCGradesStr;
      letterGradesStr += numberOfDGradesStr;
      letterGradesStr += numberOfFGradesStr;
      
      return letterGradesStr;
   }
   
   /**
      Get the letter grade corresponding to the grade given.
      @param grade The grade that needs a letter grade.
      @return The letter grade corresponding to the given grade.
    */
   private LetterGrade getLetterGrade(int grade)
   {
      if(inRange(grade, LOWEST_A_GRADE, HIGHEST_A_GRADE))
      {
         return LetterGrade.A;
      }
      else if(inRange(grade, LOWEST_B_GRADE, HIGHEST_B_GRADE))
      {
         return LetterGrade.B;
      }
      else if(inRange(grade, LOWEST_C_GRADE, HIGHEST_C_GRADE))
      {
         return LetterGrade.C;
      }
      else if(inRange(grade, LOWEST_D_GRADE, HIGHEST_D_GRADE))
      {
         return LetterGrade.D;
      }
      
      // Otherwise, the grade is an F.
      return LetterGrade.F;
   }
   
   /**
      Increments the count for the given letter grade.
      @param grade The letter grade that is being added to record.
    */
   private void addLetterGrade(LetterGrade grade)
   {
      switch(grade)
      {
         case A:
           numberOfAGrades++;
           break;
         case B:
           numberOfBGrades++;
           break;
         case C:
           numberOfCGrades++;
           break;
         case D:
           numberOfDGrades++;
           break;    
         case F:
           numberOfFGrades++;
           break;
      }
   }
   
   /**
      Determines whether a value lies on the given range.</br>
      Range can be from a to b, or b to a.
      @param x The value to test.
      @param a One end of the range.
      @param b Other end of the range.
      @return True if the values lies on range, otherwise false.
    */
   private boolean inRange(int x, int a, int b)
   {
      if (a <= b)
      {
         return ((a <= x) && (x <= b));
      }
      else if (a > b)
      {
         return ((b <= x) && (x <= a));
      }
      
      return false;
   }
   
   /**
      Calculates the mean, variance, and standard deviation.
      Updates the corresponding instance variables.
    */
   private void calculate()
   {
      calculateMean();
      calculateVariance();
      calculateStandardDeviation();
   }
   
   /**
      Calculates the mean and updates the instance variable.
      <p>mean = totalQuizScore / numberOfQuizzes
    */
   private void calculateMean()
   {
      mean = (double)totalQuizScore / (double)numberOfQuizzes;
   }
   
   /**
      Calculates the variance and updates the instance variable.
      If the number of quizzes is one, just sets the variance
      to 0.0.
      <p>mean = (sumOfSquares - (mean^2 * numberOfQuizzes) ) / (numberOfQuizzes - 1)
    */
   private void calculateVariance()
   {  
      // Don't calculate if numberOfQuizzes is 1,
      // as that will result in a division by zero.
      if(numberOfQuizzes > 1)
      {
         variance = ( ((double)sumOfSquares) - (mean*mean*numberOfQuizzes) )
                  / ((double)numberOfQuizzes - 1.0);
      }
      else
      {
         variance = 0.0;
      }
   }
   
   /**
      Calculates the standard deviation and updats the instance variable.
      <p>standardDeviation = sqrt(variance)
    */
   private void calculateStandardDeviation()
   {
      standardDeviation = Math.sqrt(variance);
   }
}