import java.util.Scanner;

class TuneAntenna
{
   // A typical input is..
   // frequency: 16.7 MHz or 16700000 hertz
   // capacitance min: 14pF or .000000000014 F
   // capacitance max: 365pF or .000000000365 F
   public static void main(String[] args)
   {
      // Read in f(in Hz)m, C_min, and C_max
      Scanner console = new Scanner(System.in);
      System.out.print("Enter the frequency(in Hz): ");
      double frequency = console.nextDouble();
      
      System.out.print("Enter the minimum capacitance(in F): ");
      double capacitance_min = console.nextDouble();
      
      System.out.print("Enter the maximum capacitance(in F): ");
      double capacitance_max = console.nextDouble();
      
      // Calculate capacitance
      double capacitance = Math.sqrt(capacitance_min * capacitance_max);
      
      // Calculate Inductance
      double inductance = computeInductance(frequency, capacitance);
      
      // Calculate Min frequency
      double frequency_min = computeFrequency(capacitance_min, inductance);
      
      // Calculate max frequency
      double frequency_max = computeFrequency(capacitance_max, inductance);;
      
      // Print the required inductance value and range of frequencies
      // to which the cicuit can be tuned by varing the capacitance.
      System.out.println("The required inductance is " + inductance + " H.");
      System.out.println("The minimum frequency is " + frequency_min + " Hz.");
      System.out.println("The maximum frequency is " + frequency_max + " Hz.");
   }
   /**
      From the given formula:
      f = 2pi/sqrt(L*C)
      where f is frequency, L is inductance, and C is capacitance.
    */
   private static double computeFrequency(double capacitance, double inductance)
   {
      return 2.0 * Math.PI / Math.sqrt(inductance * capacitance);
   }
   
   /**
      The formula for inductance* is:
      <br>L = 4pi^2 / (C * f^2)
      <br>where L is inductance, C is capacitance, and f is frequency.
      <br>
      <br>*Found by solving the formula of frequency for inductance.
    */
   private static double computeInductance(double frequency, double capacitance)
   {
      return 4.0 * Math.PI * Math.PI / (capacitance * (frequency * frequency));
   }
}