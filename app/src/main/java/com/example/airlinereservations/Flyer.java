package com.example.airlinereservations;

import java.util.Date;
import com.google.gson.Gson;

public class Flyer extends User {
    private Reservation reservation;
    private String notificationPreference;
    private PaymentInfo paymentInfo;
    private String agentId;

    // Constructor
    public Flyer(String userId, String firstName, String lastName, String password, Date birthdate, String email, String address, String phoneNumber, Reservation reservation, String notificationPreference, PaymentInfo paymentInfo, String agentId) {
        super(userId, firstName, lastName, password, birthdate, email, address, phoneNumber);
        this.reservation = reservation;
        this.notificationPreference = notificationPreference;
        this.paymentInfo = paymentInfo;
        this.agentId = agentId;
    }

    // Default constructor
    public Flyer() {
    }

    // Getters and setters

    // Getter for agentId
    public String getAgentId() {
        return agentId;
    }

    // Setter for agentId
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    // Converts this Flyer object to a JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Creates a Flyer object from a JSON string
    public static Flyer fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Flyer.class);
    }
}