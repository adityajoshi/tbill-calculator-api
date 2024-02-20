package io.adityajoshi.tbillcalculatorapi.dto;

public class InputParams {
    private Double totalAmount;
    private Double discountYield;
    private Integer tenor;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscountYield() {
        return discountYield;
    }

    public void setDiscountYield(Double discountYield) {
        this.discountYield = discountYield;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }
}
