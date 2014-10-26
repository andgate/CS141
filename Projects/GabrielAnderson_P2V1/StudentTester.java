/**
   Runs a test on a Student object.<br>
   COPYRIGHT &copy; 2014 Gabriel Anderson. All Rights Reserved.
   @author Gabriel Anderson
   @since 13 October 2014
   @version 1.0
 */
public class StudentTester
{
   public static void main(String[] args)
   {
      // An average student. They have their ups and downs.
      // Also, they test the decimal formatter in toString.
      // So that's good.
      Student gabe = new Student("Gabriel Anderson");
      
      gabe.addQuiz(81);
      gabe.addQuiz(57);
      gabe.addQuiz(82);
      
      System.out.println("Expected student info:"
                       + "\nName: Gabriel Anderson"
                    + "\nQuiz count: 3"
                    + "\nTotal points: 220"
                    + "\nAverage score: 73.33");
      System.out.println("\nActual student info:" + gabe.toString() + "\n");
      
      // Little Bobby is a new student, and hasn't taken any quizzes.
      Student bob = new Student("Bobby Bobertson");
      
      System.out.println("Expected student info:"
                       + "\nName: Bobby Bobertson"
                    + "\nQuiz count: 0"
                    + "\nTotal points: 0"
                    + "\nAverage score: 0.0");
      System.out.println("\nActual student info:" + bob.toString() + "\n");
      
      // Issac Newton, the star student.
      Student newton = new Student("Issac Newton");
      
      newton.addQuiz(100);
      newton.addQuiz(100);
      newton.addQuiz(100);
      newton.addQuiz(100);
      newton.addQuiz(100);
      newton.addQuiz(100);
      newton.addQuiz(100);
      
      System.out.println("Expected student info:"
                       + "\nName: Issac Newton"
                    + "\nQuiz count: 7"
                    + "\nTotal points: 700"
                    + "\nAverage score: 100.0");
      System.out.println("\nActual student info:" + newton.toString() + "\n");
   }
}