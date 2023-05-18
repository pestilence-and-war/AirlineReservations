package com.example.airlinereservations;

import java.util.Date;
import org.bson.Document;

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

    public Document toDocument() {
        Document document = new Document()
                .append("userId", getUserId())
                .append("firstName", getFirstName())
                .append("lastName", getLastName())
                .append("password", getPassword())
                .append("birthdate", getBirthdate())
                .append("email", getEmail())
                .append("address", getAddress())
                .append("phoneNumber", getPhoneNumber())
                .append("notificationPreference", getNotificationPreference())
                .append("agentId", getAgentId())
                .append("paymentInfo", paymentInfo.toDocument())
                .append("reservation", reservation.toDocument());


        return document;
    }

}

