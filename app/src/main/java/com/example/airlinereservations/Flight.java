package com.example.airlinereservations;

import com.google.gson.Gson;

public class Flight {
    private String id;
    private String origin;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;
    private String airline;
    private int availableSeats;
    private double price;

    // Constructor
    public Flight(String id, String origin, String destination, String departureDate, String departureTime, String arrivalTime, String airline, int availableSeats, double price) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.availableSeats = availableSeats;
        this.price = price;
        this.id = airline.toUpperCase().substring(0,4)+origin.toUpperCase().substring(0,4)
        +destination.toUpperCase().substring(0,4)+departureDate+departureTime;

    }

    // Default constructor
    public Flight() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Converts this Flight object to a JSON string
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Creates a Flight object from a JSON string
    public static Flight fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Flight.class);
    }
}


