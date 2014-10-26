import java.text.DecimalFormat;
import java.util.Scanner;

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
   private String scoresEntered;
   private int totalQuizScore;
   private double mean;
   private int sumOfSquares;
   private double variance;
   private double standardDeviation;
   
   private int numberOfAGrades;
   private int numberOfBGrades;
   private int numberOfCGrades;
   private int numberOfDGrades;
   private int numberOfFGrades;
   
   // Constants 
   private static final String BLANK = "";
   private static final String NO_NAME = BLANK;
   private static final String BLANK_DATA = "-";
   private static final String INPUT_DATA_ECHO 
      = "Please enter the grade number, between 0 and 100: ";
   private static final String OUTPUT_NAME_LABEL
      = "\nStudent's full name: ";
   private static final String OUTPUT_NUMBER_OF_QUIZZES_LABEL
      = "\nNumber of quizzes taken: ";
   private static final String OUTPUT_HIGHEST_QUIZ_SCORE_LABEL
      = "\nHighest quiz score: ";
   private static final String OUTPUT_LOWEST_QUIZ_SCORE_LABEL
      = "\nLowest quiz score: ";
   private static final String OUTPUT_SCORES_ENTERED_LABEL
      = "\nScores entered: ";
   private static final String OUTPUT_TOTAL_QUIZ_SCORE_LABEL
      = "\nTotal quiz score: ";
   private static final String OUTPUT_MEAN_LABEL
      = "\nMean: ";
   private static final String OUTPUT_VARIANCE_LABEL
      = "\nVariance: ";
   private static final String OUTPUT_STANDARD_DEVIATION_LABEL
      = "\nStandard deviation: ";
   private static final String OUTPUT_NUMBER_OF_A_GRADES_LABEL
      = "\nNumber of A's: ";
   private static final String OUTPUT_NUMBER_OF_B_GRADES_LABEL
      = "\nNumber of B's: ";
   private static final String OUTPUT_NUMBER_OF_C_GRADES_LABEL
      = "\nNumber of C's: ";
   private static final String OUTPUT_NUMBER_OF_D_GRADES_LABEL
      = "\nNumber of D's: ";
   private static final String OUTPUT_NUMBER_OF_F_GRADES_LABEL
      = "\nNumber of F's: ";
   
   private static final int LOWEST_GRADE = 0;
   private static final int HIGHEST_GRADE = 100;
   
   private static final int INITIAL_NUMBER_OF_QUIZZES = 0;
   private static final int INITIAL_HIGH_VALUE = 0;
   private static final int INITIAL_LOW_VALUE = 0;
   private static final String INITIAL_SCORES_ENTERED = "";
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
   
   private static final DecimalFormat doubleDecimal = new DecimalFormat("0.00");
   private static final DecimalFormat tripleDecimal = new DecimalFormat("0.000");
   
   /**
      Constructs an new student, with no data entered.
    */
   public Student()
   {
      name = NO_NAME;
      numberOfQuizzes = INITIAL_NUMBER_OF_QUIZZES;
      highValue = INITIAL_HIGH_VALUE;
      lowValue = INITIAL_LOW_VALUE;
      String scoresEntered = INITIAL_SCORES_ENTERED;
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
      Constructs an new student.
      @param newName The name of the new student.
    */
   public Student(String newName)
   {
      this();
      setName(newName);
   }
   
   
   public boolean inputData(Scanner in)
   {
      System.out.println(INPUT_DATA_ECHO);
      
      if(!in.hasNextInt())
      {
         return false;
      }
      
      int grade = in.nextInt();
      
      
      
      return addGrade(grade);
   }
   
   /**
      Add a quiz score to the student's record.
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
      
      calculate();
      
      scoresEntered += grade + " ";
      
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
   
   public int getLowestQuizScore()
   {
      return lowValue;
   }
   
   public int getHighestQuizScore()
   {
      return highValue;
   }
   
   public String getScoresEntered()
   {
      return scoresEntered;
   }
   
   /**
      Query a student's record for the student's average score.
      @return The student's Average quiz score.
    */
   public double getMean()
   {
      return mean;
   }
   
   public double getVariance()
   {
      return variance;
   }
   
   public double getStandardDeviation()
   {
      return standardDeviation;
   }
   
   public int getNumberOfAGrades()
   {
      return numberOfAGrades;
   }
   
   public int getNumberOfBGrades()
   {
      return numberOfBGrades;
   }
   
   public int getNumberOfCGrades()
   {
      return numberOfCGrades;
   }
   
   public int getNumberOfDGrades()
   {
      return numberOfDGrades;
   }
   
   public int getNumberOfFGrades()
   {
      return numberOfFGrades;
   }
   
   /**
      Get the student's information in a string format intended for printing.
      <br>The string looks like this:
      <br>Name: <i>&lt;student_name&gt;</i>
      <br>Quiz count: <i>&lt;number_of_quizzes_entered&gt;</i>
      <br>Total score: <i>&lt;total_points&gt;</i>
      <br>Average score: <i>&lt;average_score&gt;</i>
      @return The student's information in a nicely formatted string.
      @todo empty data should print the value as "-"
    */
   @Override
   public String toString()
   {  
      String studentDataStr = studentDataToString();
      String letterGradesStr = letterGradesToString();
      
      String output = studentDataStr + letterGradesStr;
      output += "\n" + scoresEntered;
      
      return output;
   }
   
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
         varianceStr += BLANK_DATA;
         standardDeviationStr += BLANK_DATA;
      }
      else
      {
         numberOfQuizzesStr += getNumberOfQuizzes();
         totalQuizScoreStr += getTotalQuizScore();
         lowValueStr += getLowestQuizScore();
         highValueStr += getHighestQuizScore();
         meanStr += doubleDecimal.format(getMean());
         varianceStr += tripleDecimal.format(getVariance());
         standardDeviationStr += tripleDecimal.format(getStandardDeviation());
      }
      
      String studentDataString = nameStr;
      studentDataString += numberOfQuizzesStr;
      studentDataString += totalQuizScoreStr;
      studentDataString += lowValueStr;
      studentDataString += highValueStr;
      studentDataString += meanStr;
      studentDataString += varianceStr;
      studentDataString += standardDeviationStr;
      
      return studentDataString;
   }
   
   private String letterGradesToString()
   {
      String numberOfAGradesStr = OUTPUT_NUMBER_OF_A_GRADES_LABEL;
      // Use BLANK_DATA to mask 0 entries.
      numberOfAGradesStr += getNumberOfAGrades() == 0
                              ? BLANK_DATA
                              : getNumberOfAGrades();
      
      String numberOfBGradesStr = OUTPUT_NUMBER_OF_B_GRADES_LABEL;
      numberOfBGradesStr += getNumberOfBGrades() == 0
                              ? BLANK_DATA
                              : getNumberOfBGrades();
                                    
      String numberOfCGradesStr = OUTPUT_NUMBER_OF_C_GRADES_LABEL;
      numberOfCGradesStr += getNumberOfCGrades() == 0
                              ? BLANK_DATA
                              : getNumberOfCGrades();
                                    
      String numberOfDGradesStr = OUTPUT_NUMBER_OF_D_GRADES_LABEL;
      numberOfDGradesStr += getNumberOfDGrades() == 0
                              ? BLANK_DATA
                              : getNumberOfDGrades();
                              
      String numberOfFGradesStr = OUTPUT_NUMBER_OF_F_GRADES_LABEL;
      numberOfFGradesStr += getNumberOfFGrades() == 0
                              ? BLANK_DATA
                              : getNumberOfFGrades();
                                    
      String letterGradesStr = numberOfAGradesStr;
      letterGradesStr += numberOfBGradesStr;
      letterGradesStr += numberOfCGradesStr;
      letterGradesStr += numberOfDGradesStr;
      letterGradesStr += numberOfFGradesStr;
      
      return letterGradesStr;
   }
   
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
   
   private boolean inRange(int x, int a, int b)
   {
      if (a < b)
      {
         return ((a <= x) && (x <= b));
      }
      else if (a > b)
      {
         return ((b <= x) && (x <= a));
      }
      else if (a == b)
      {
         return (x == a);
      }
      
      return false;
   }
   
   private void calculate()
   {
      calculateMean();
      calculateVariance();
      calculateStandardDeviation();
   }
   
   private void calculateMean()
   {
      mean = (double)totalQuizScore / (double)numberOfQuizzes;
   }
   
   private void calculateVariance()
   {  
      // Don't calculate if numberOfQuizzes is 1,
      // as that will result in a division by zero.
      if(numberOfQuizzes > 1)
      {
         variance = ( ((double)sumOfSquares) - mean ) / ((double)numberOfQuizzes - 1.0);
      }
      else
      {
         variance = 0.0;
      }
   }
   
   private void calculateStandardDeviation()
   {
      standardDeviation = Math.sqrt(variance);
   }
}