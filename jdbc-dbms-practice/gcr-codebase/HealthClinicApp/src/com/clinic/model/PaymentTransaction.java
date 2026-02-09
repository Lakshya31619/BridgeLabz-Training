package com.clinic.model;

public class PaymentTransaction {
    private int transactionId;
    private int billId;
    private String paymentDate;
    private String paymentMode;
    private double amount;

    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }
    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
