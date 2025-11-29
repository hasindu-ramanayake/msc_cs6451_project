package org.example.payment;

public class PaymentContent {
    private String userId;
    private float amount;
    private String currency;
    private String cardNumber;

    public PaymentContent(String userId, float fee, String currency, String cardNumber) {
        this.amount = fee;
        this.userId = userId;
        this.currency = currency;
        this.cardNumber = cardNumber;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId;}
    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount;}
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency;}
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber;}
}
