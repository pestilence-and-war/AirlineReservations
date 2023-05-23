package com.example.airlinereservations;
import com.google.gson.Gson;

public class Reservation {
    private String reservationId;
    private String flightId;
    private String userId;
    private int numberOfPassengers;

    // Constructor
    public Reservation(String reservationId, String flightId, String userId, int numberOfPassengers) {
        this.reservationId = reservationId;
        this.flightId = flightId;
        this.userId = userId;
        this.numberOfPassengers = numberOfPassengers;
    }

    // Default constructor
    public Reservation() {
    }

    // Getters and setters

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId){
        this.reservationId = reservationId;
    }

    public String getFlightId(){
        return reservationId;
    }

    public void setFlightId(String flightId){
        this.flightId = flightId;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public int getNumberOfPassengers(){
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers){
        this.numberOfPassengers = numberOfPassengers;
    }

    // Converts this Reservation object to a JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Creates a Reservation object from a JSON string
    public static Reservation fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Reservation.class);
    }
}