import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TaxReturnTest
{

   private static final int SINGLE_STATUS = TaxReturn.SINGLE;
   private static final int MARRIED_STATUS = TaxReturn.MARRIED;
   private static final double LOW_INCOME = 100;
   private static final double HIGH_INCOME_SINGLE = 32100.0;
   private static final double HIGH_INCOME_MARRIED = 64100.0;
   
   private static final double EXPECTED_SINGLE_LOW_INCOME
      = 10.0;   
   private static final double EXPECTED_SINGLE_HIGH_INCOME
      = 3225.0;
   private static final double EXPECTED_MARRIED_HIGH_INCOME
      = 11225.0;
      
   private static final double EPSILON = 10E-6;

   /** A test that always fails. **/
   @Test public void SingleLowIncome() {
      TaxReturn taxReturn = new TaxReturn(LOW_INCOME, SINGLE_STATUS);
      Assert.assertEquals(EXPECTED_SINGLE_LOW_INCOME, taxReturn.getTax(), EPSILON);
   }
   
   /** A test that always fails. **/
   @Test public void SingleHighIncome() {
      TaxReturn taxReturn = new TaxReturn(HIGH_INCOME_SINGLE, SINGLE_STATUS);
      Assert.assertEquals(EXPECTED_SINGLE_HIGH_INCOME, taxReturn.getTax(), EPSILON);
   }
   
   /** A test that always fails. **/
   @Test public void MarriedHighIncome() {
      TaxReturn taxReturn = new TaxReturn(HIGH_INCOME_MARRIED, SINGLE_STATUS);
      Assert.assertEquals(EXPECTED_MARRIED_HIGH_INCOME, taxReturn.getTax(), EPSILON);
   }
}
