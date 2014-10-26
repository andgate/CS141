import java.util.Scanner;

/**
   Runs a test on a Student object.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 13 October 2014
   @version 1.0
 */
public class StudentTester
{
   public static final String FIRST_STUDENT_SCORES = "0 100 82 91 99 100 100 14 92 93 ";
   public static final String SECOND_STUDENT_SCORES = "-1 15.77 101 ";
   public static final String THIRD_STUDENT_SCORES = "0";
   public static final String INPUT_SCORES = FIRST_STUDENT_SCORES + SECOND_STUDENT_SCORES + THIRD_STUDENT_SCORES;
   
   public static void main(String[] args)
   {
      Scanner input = new Scanner(INPUT_SCORES);
      
      // First student tests valid input
      Student firstStudent = new Student("First Student");
      
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      
      System.out.println("Expected student info:"
                       + "\nName: First Student"
                    + "\nQuiz count: 3"
                    + "\nTotal points: 220"
                    + "\nAverage score: 73.33");
      System.out.println("\nActual student info:" + firstStudent.toString() + "\n");
      
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      firstStudent.inputData(input);
      
      System.out.println("Expected student info:"
                       + "\nName: First Student"
                    + "\nQuiz count: 3"
                    + "\nTotal points: 220"
                    + "\nAverage score: 73.33");
      System.out.println("\nActual student info:" + firstStudent.toString() + "\n");

      
      // Second student tests bad inputs
      Student secondStudent = new Student("Second Student");
      
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      secondStudent.inputData(input);
      
      System.out.println("Expected student info:"
                       + "\nName: Second Student"
                    + "\nQuiz count: 0"
                    + "\nTotal points: 0"
                    + "\nAverage score: 0.0");
      System.out.println("\nActual student info:" + secondStudent.toString() + "\n");
      
      // Issac Newton, the star student.
      Student thirdStudent = new Student("Third Student");
      
      thirdStudent.inputData(input);
      
      System.out.println("Expected student info:"
                       + "\nName: Third Student"
                    + "\nQuiz count: 7"
                    + "\nTotal points: 700"
                    + "\nAverage score: 100.0");
      System.out.println("\nActual student info:" + thirdStudent.toString() + "\n");
   }
}