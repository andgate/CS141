import java.util.Scanner;

/**
   Runs tests on different Student objects.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 13 October 2014
   @version 1.0
 */
public class StudentTester
{
   // Data taken from excel spreadsheet.
   // For actual values, check out the spread sheet.
   public static final String FIRST_STUDENT_SCORES
      = "0 100 82 91 99 100 100 14 92 93 ";
   public static final String SECOND_STUDENT_SCORES
      = "-1 15.77 101 qwerty $54sfd ";
   public static final String THIRD_STUDENT_SCORES
      = "0";
   public static final String INPUT_SCORES
      = FIRST_STUDENT_SCORES + SECOND_STUDENT_SCORES + THIRD_STUDENT_SCORES;
   
   public static final String EXPECTED_OUTPUT_LABEL
      = "\nExpected student info: ";
   public static final String ACTUAL_OUTPUT_LABEL
      = "\nActual student info: "; 
   
   public static final String FIRST_STUDENT_NAME = "First Student";
   public static final String SECOND_STUDENT_NAME = "Second Student";
   public static final String THIRD_STUDENT_NAME = "First Student";
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(INPUT_SCORES);
      
      // First student tests valid input.
      // Twice with 5 scores each.
      Student firstStudent = new Student(FIRST_STUDENT_NAME);
      
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      
      System.out.println(ACTUAL_OUTPUT_LABEL + firstStudent.toString() + "\n");
      
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      
      System.out.println(ACTUAL_OUTPUT_LABEL + firstStudent.toString() + "\n");

      
      // Second student tests bad inputs.
      // Bad input is rejected, so tests no inputted test scores as well.
      Student secondStudent = new Student(SECOND_STUDENT_NAME);
      
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      
      System.out.println(ACTUAL_OUTPUT_LABEL + secondStudent.toString() + "\n");
      
      // Third student, tests input when only one quiz score.
      Student thirdStudent = new Student(THIRD_STUDENT_NAME);
      thirdStudent.inputData(input);
      System.out.println(ACTUAL_OUTPUT_LABEL + thirdStudent.toString() + "\n");
   }
}