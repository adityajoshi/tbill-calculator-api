package io.adityajoshi.tbillcalculatorapi.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class TBillServiceTest {

    TBillService tBillService = new TBillService();

    @Test
    public void testRoundToTwoDecimals() {
        double originalValue = 12.3456;
        double expectedRoundedValue = 12.35; // Rounded to two decimals

        double actualRoundedValue = tBillService.roundToTwoDecimals(originalValue);

        // Assert that the actual rounded value is equal to the expected rounded value
        assertEquals(expectedRoundedValue, actualRoundedValue, 0.001); // 0.001 is the delta for double comparison
    }

    @Test
    public void testCalculatePurchaseValue(){
        double totalAmount = 50000; // Replace with your total amount
        double discountYield = 7;   // Replace with your discount yield percentage
        int tenor = 91;               // Replace with your tenor (91 or 182 or 364)

        double purchaseValue = tBillService.calculatePurchaseValue(totalAmount, discountYield, tenor);
        assertEquals(872.60, purchaseValue);
    }

}