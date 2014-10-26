public class TaxesTester
{   
   private static final Taxes.FilingStatus CASE_1_STATUS = Taxes.FilingStatus.MARRIED;
   private static final double CASE_1_INCOME = 100;
   
   private static final Taxes.FilingStatus CASE_2_STATUS = Taxes.FilingStatus.MARRIED;
   private static final double CASE_2_INCOME = 16100;
   
   private static final Taxes.FilingStatus CASE_3_STATUS = Taxes.FilingStatus.MARRIED;
   private static final double CASE_3_INCOME = 64100;
   
   private static final Taxes.FilingStatus CASE_4_STATUS = Taxes.FilingStatus.MARRIED;
   private static final double CASE_4_INCOME = -1;

   private static final Taxes.FilingStatus CASE_5_STATUS = Taxes.FilingStatus.SINGLE;
   private static final double CASE_5_INCOME = 100;
   
   private static final Taxes.FilingStatus CASE_6_STATUS = Taxes.FilingStatus.SINGLE;
   private static final double CASE_6_INCOME = 8100;
   
   private static final Taxes.FilingStatus CASE_7_STATUS = Taxes.FilingStatus.SINGLE;
   private static final double CASE_7_INCOME = 32100;
   
   private static final Taxes.FilingStatus CASE_8_STATUS = Taxes.FilingStatus.SINGLE;
   private static final double CASE_8_INCOME = -1;
   
   
   
   public static void main(String[] args)
   {
      double taxCase_1 = Taxes.getTax(CASE_1_STATUS, CASE_1_INCOME);
      System.out.println("Case 1 expected tax: $10.0");
      System.out.println("Case 1 actual tax: $" + taxCase_1);
      
      double taxCase_2 = Taxes.getTax(CASE_2_STATUS, CASE_2_INCOME);
      System.out.println("Case 2 expected tax: $1615.0");
      System.out.println("Case 2 actual tax: $" + taxCase_2);
   
      double taxCase_3 = Taxes.getTax(CASE_3_STATUS, CASE_3_INCOME);
      System.out.println("Case 3 expected tax: $8825.0");
      System.out.println("Case 3 actual tax: $" + taxCase_3);
      
      double taxCase_4 = Taxes.getTax(CASE_4_STATUS, CASE_4_INCOME);
      System.out.println("Case 4 expected tax: $0.0");
      System.out.println("Case 4 actual tax: $" + taxCase_4);
      
      double taxCase_5 = Taxes.getTax(CASE_5_STATUS, CASE_5_INCOME);
      System.out.println("Case 5 expected tax: $10.0");
      System.out.println("Case 5 actual tax: $" + taxCase_5);
      
      double taxCase_6 = Taxes.getTax(CASE_6_STATUS, CASE_6_INCOME);
      System.out.println("Case 6 expected tax: $815.0");
      System.out.println("Case 6 actual tax: $" + taxCase_6);
      
      double taxCase_7 = Taxes.getTax(CASE_7_STATUS, CASE_7_INCOME);
      System.out.println("Case 7 expected tax: $4425.0");
      System.out.println("Case 7 actual tax: $" + taxCase_7);
      
      double taxCase_8 = Taxes.getTax(CASE_8_STATUS, CASE_8_INCOME);
      System.out.println("Case 8 expected tax: $0.0");
      System.out.println("Case 8 actual tax: $" + taxCase_8);
   }
}