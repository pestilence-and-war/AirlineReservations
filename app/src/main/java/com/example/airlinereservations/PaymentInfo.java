package com.example.airlinereservations;

import com.google.gson.Gson;

public class PaymentInfo {
    private String paymentId;
    private String cardHolderName;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardSecurityCode;

    // Constructor
    public PaymentInfo(String paymentId, String cardHolderName, String cardNumber, String cardExpirationDate, String cardSecurityCode) {
        this.paymentId = paymentId;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardSecurityCode = cardSecurityCode;
    }

    // Default constructor
    public PaymentInfo() {
    }

    // Getters and setters
    public String getPaymentId(){
        return paymentId;
    }

    public void setPaymentId(String paymentId){
        this.paymentId = paymentId;
    }

    public String getCardHolderName(){
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate(){
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate){
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardSecurityCode(){
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode){
        this.cardSecurityCode = cardSecurityCode;
    }

    // Converts this PaymentInfo object to a JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Creates a PaymentInfo object from a JSON string
    public static PaymentInfo fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, PaymentInfo.class);
    }
}