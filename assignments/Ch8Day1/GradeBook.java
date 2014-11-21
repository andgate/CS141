import java.util.Scanner;
import java.util.ArrayList;

public class GradeBook
{
   private static ArrayList<Student> students;
   
   public static void main(String[] args)
   {
      students = new ArrayList<Student>();
      
      Scanner console = new Scanner(System.in);
      askStudentInfo(console);
      
      printTotalScores();
   }
   
   private static void printTotalScores()
   {
      System.out.printf("%15s %s\n", "Name", "Total Score");
      
      for(Student student : students)
      {
         String name = student.getName();
         double totalScore = student.getTotalScore();
         
         System.out.printf("%15s %.2f", name, totalScore);
         System.out.println();    
      }
   }
   
   private static void askStudentInfo(Scanner in)
   {
      while(true)
      {
         System.out.println("Please input the student name. (q to stop)");
         String name = in.next();
         if (name.equals("q"))
         {
            // when told q, stop input
            return;
         }
         
         System.out.println("Please input the list of score.");
         ArrayList<Double> scores = new ArrayList<>();
         
         while(in.hasNextDouble())
         {
            double score = in.nextDouble();
            scores.add(score);
         }
         
         // when a letter is entered to end the input
         // the letter is the next input. Skip it.
         in.next();
         
         // Create the student with the information given
         Student student = new Student(name);
         for(Double score : scores)
         {
            student.addScore(score);
         }
         
         // Add that student to the list of students
         students.add(student);
      }
   }
}