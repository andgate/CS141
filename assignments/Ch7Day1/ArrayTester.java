public class ArrayTester
{
   private static final String ECHO_A
      = "A. Swap first and last";
   private static final int[] INITIAL_VALUES_A = { 1, 2, 3, 4, 5};
   private static final String EXPECTED_VALUES_A = "5 2 3 4 1";
   
   private static final String ECHO_B
      = "B. Shift right";
   private static final int[] INITIAL_VALUES_B = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_B = "5 1 2 3 4";
   
   private static final String ECHO_C
      = "C. Replace even values with zero";
   private static final int[] INITIAL_VALUES_C = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_C = "1 0 3 0 5";
   
   private static final String ECHO_D
      = "D. Replace with largest neighbor";
   private static final int[] INITIAL_VALUES_D = { 1, 2, 3, 2, 1 };
   private static final String EXPECTED_VALUES_D = "1 3 2 3 1";
   
   private static final String ECHO_E
      = "E. Remove middle";
   private static final int[] INITIAL_VALUES_E_1 = { 1, 2, 3, 4, 5 };
   private static final int[] INITIAL_VALUES_E_2 = { 1, 2, 3, 4, 5, 6 };
   private static final String EXPECTED_VALUES_E_1 = "1 2 4 5";
   private static final String EXPECTED_VALUES_E_2 = "1 2 5 6";
   
   private static final String ECHO_F
      = "F. Move even elements to front";
   private static final int[] INITIAL_VALUES_F = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_F = "2 4 1 3 5";
   
   private static final String ECHO_G
      = "G. Second largest element in the array";
   private static final int[] INITIAL_VALUES_G = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_G = "4";
   
   private static final String ECHO_H
      = "H. Is in increasing order?";
   private static final int[] INITIAL_VALUES_H_1 = { 1, 2, 3, 4, 5 };
   private static final int[] INITIAL_VALUES_H_2 = { 1, 2, 3, 4, 1 };
   private static final String EXPECTED_VALUES_H_1 = "true";
   private static final String EXPECTED_VALUES_H_2 = "false";
   
   private static final String ECHO_I
      = "I. Does array have adjecent duplicates?";
   private static final int[] INITIAL_VALUES_I_1 = { 1, 2, 3, 4, 4 };
   private static final int[] INITIAL_VALUES_I_2 = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_I_1 = "true";
   private static final String EXPECTED_VALUES_I_2 = "false";
   
   private static final String ECHO_J
      = "J. Does the array have duplicates?";
   private static final int[] INITIAL_VALUES_J_1 = { 1, 2, 3, 2, 5 };
   private static final int[] INITIAL_VALUES_J_2 = { 1, 2, 3, 4, 5 };
   private static final String EXPECTED_VALUES_J_1 = "true";
   private static final String EXPECTED_VALUES_J_2 = "false";
   
   
   public static void main(String[] args)
   {
      System.out.println(ECHO_A);
      
      ArrayMethods arrayMethods = new ArrayMethods(INITIAL_VALUES_A);
      printInitialValues(arrayMethods.toString());
      arrayMethods.swapFirstAndLast();
      printExpectedValues(EXPECTED_VALUES_A);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_B);
      
      arrayMethods.setValues(INITIAL_VALUES_B);
      printInitialValues(arrayMethods.toString());
      arrayMethods.shiftRight();
      printExpectedValues(EXPECTED_VALUES_B);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_C);
      
      arrayMethods.setValues(INITIAL_VALUES_C);
      printInitialValues(arrayMethods.toString());
      arrayMethods.replaceEvenWithZero();
      printExpectedValues(EXPECTED_VALUES_C);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_D);
      
      arrayMethods.setValues(INITIAL_VALUES_D);
      printInitialValues(arrayMethods.toString());
      arrayMethods.replaceWithLargestNeighbor();
      printExpectedValues(EXPECTED_VALUES_D);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_E);
      
      arrayMethods.setValues(INITIAL_VALUES_E_1);
      printInitialValues(arrayMethods.toString());
      arrayMethods.removeMiddle();
      printExpectedValues(EXPECTED_VALUES_E_1);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
       
      arrayMethods.setValues(INITIAL_VALUES_E_2);
      printInitialValues(arrayMethods.toString());
      arrayMethods.removeMiddle();
      printExpectedValues(EXPECTED_VALUES_E_2);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_F);
      
      arrayMethods.setValues(INITIAL_VALUES_F);
      printInitialValues(arrayMethods.toString());
      arrayMethods.moveEvenToFront();
      printExpectedValues(EXPECTED_VALUES_F);
      printActualValues(arrayMethods.toString());
      
      System.out.println();
      System.out.println(ECHO_G);
      
      arrayMethods.setValues(INITIAL_VALUES_G);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_G);
      printActualValue(arrayMethods.secondLargest());
      
      System.out.println();
      System.out.println(ECHO_H);
      
      arrayMethods.setValues(INITIAL_VALUES_H_1);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_H_1);
      printActualValue(arrayMethods.isIncreasingOrder());
      
      System.out.println();
      
      arrayMethods.setValues(INITIAL_VALUES_H_2);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_H_2);
      printActualValue(arrayMethods.isIncreasingOrder());
      
      System.out.println();
      System.out.println(ECHO_I);
      
      arrayMethods.setValues(INITIAL_VALUES_I_1);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_I_1);
      printActualValue(arrayMethods.hasAdjecentDuplicates());
      
      System.out.println();
      
      arrayMethods.setValues(INITIAL_VALUES_I_2);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_I_2);
      printActualValue(arrayMethods.hasAdjecentDuplicates());
      
      System.out.println();
      System.out.println(ECHO_J);
      
      arrayMethods.setValues(INITIAL_VALUES_J_1);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_J_1);
      printActualValue(arrayMethods.hasDuplicates());
      
      System.out.println();
      
      arrayMethods.setValues(INITIAL_VALUES_J_2);
      printInitialValues(arrayMethods.toString());
      printExpectedValues(EXPECTED_VALUES_J_2);
      printActualValue(arrayMethods.hasDuplicates());
   }
   
   public static void printExpectedValues(String expectedValues)
   {
      System.out.println("Expected values: " + expectedValues);
   }
   
   public static void printExpectedValue(String expectedValue)
   {
      System.out.println("Expected value: " + expectedValue);
   }
   
   public static void printActualValues(String values)
   {
      System.out.println("Actual values: " + values);
   }
   
   public static void printActualValue(int value)
   {
      System.out.println("Actual value: " + value);
   }
   
   public static void printActualValue(boolean value)
   {
      System.out.println("Actual value: " + value);
   }
   
   public static void printInitialValues(String initialValues)
   {
      System.out.println("Initial values: " + initialValues);
   }
}