package io.adityajoshi.tbillcalculatorapi.controller;

import io.adityajoshi.tbillcalculatorapi.dto.InputParams;
import io.adityajoshi.tbillcalculatorapi.service.TBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TBillCalculator {
    @Autowired
    private TBillService tBillService;

    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody InputParams params) {

        double v = tBillService.calculatePurchaseValue(params.getTotalAmount(),
                params.getDiscountYield(), params.getTenor());

        return ResponseEntity.ok(String.valueOf(v));
    }

}
