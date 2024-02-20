package io.adityajoshi.tbillcalculatorapi.service;

import io.adityajoshi.tbillcalculatorapi.dto.InputParams;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class TBillService {
    public double calculatePurchaseValue(Double totalAmount, Double discountYield, Integer tenor) {
        double faceValue = totalAmount * discountYield * tenor / 36500;
        return roundToTwoDecimals(faceValue);
    }

    double roundToTwoDecimals(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
