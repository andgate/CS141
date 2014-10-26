public class Taxes
{
   private static final double SINGLE_LOWER_INCOME = 0.0;
   private static final double SINGLE_MIDDLE_INCOME = 8000.0;
   private static final double SINGLE_UPPER_INCOME = 32000.0;
   
   private static final double MARRIED_LOWER_INCOME = 0.0;
   private static final double MARRIED_MIDDLE_INCOME = 16000.0;
   private static final double MARRIED_UPPER_INCOME = 64000.0;
   
   private static final double PERCENT = 1.0 / 100.0;
   private static final double LOWER_TAX = 10 * PERCENT;
   private static final double MIDDLE_TAX = 15 * PERCENT;
   private static final double UPPER_TAX = 25 * PERCENT;
   
   public enum FilingStatus
   {
      MARRIED, SINGLE
   }
   
   public static double getTax(FilingStatus status, double income)
   {
      double totalTax = 0.0;
      double taxableIncome = 0.0;
      
      if (status == FilingStatus.MARRIED)
      {
         if ((income >= MARRIED_LOWER_INCOME) && (income < MARRIED_MIDDLE_INCOME))
         {
            totalTax = income * LOWER_TAX;
         }
         else if ((income >= MARRIED_MIDDLE_INCOME) && (income < MARRIED_UPPER_INCOME))
         {
            taxableIncome = income - MARRIED_MIDDLE_INCOME;
            totalTax = MARRIED_MIDDLE_INCOME * LOWER_TAX + taxableIncome * MIDDLE_TAX;
         }
         else if (income >= MARRIED_UPPER_INCOME)
         {
            taxableIncome = income - MARRIED_UPPER_INCOME;
            totalTax = MARRIED_UPPER_INCOME * MIDDLE_TAX
                        - MARRIED_MIDDLE_INCOME * LOWER_TAX / 2.0
                        + taxableIncome * UPPER_TAX;
         }
      }
      // otherwise, is single
      else
      {
         if ((income >= SINGLE_LOWER_INCOME) && (income < SINGLE_MIDDLE_INCOME))
         {
            totalTax = income * LOWER_TAX;
         }
         else if ((income >= SINGLE_MIDDLE_INCOME) && (income < SINGLE_UPPER_INCOME))
         {
            taxableIncome = income - SINGLE_MIDDLE_INCOME;
            totalTax = SINGLE_MIDDLE_INCOME * LOWER_TAX + taxableIncome * MIDDLE_TAX;
         }
         else if (income >= SINGLE_UPPER_INCOME)
         {
            taxableIncome = income - SINGLE_UPPER_INCOME;
            totalTax = SINGLE_UPPER_INCOME * MIDDLE_TAX
                        - SINGLE_MIDDLE_INCOME * LOWER_TAX / 2.0
                        + taxableIncome * UPPER_TAX;
         }
      }
      
      return totalTax;
   }
}