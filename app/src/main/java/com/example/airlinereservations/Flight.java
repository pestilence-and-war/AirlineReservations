package com.example.airlinereservations;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.Gson;

public class Flight implements Parcelable {
    private String id;
    private String origin;
    private String destination;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;
    private String airline;
    private int availableSeats;
    private double price;
    private List<String> availableSeatsList;
    private List<String> takenSeatsList;

    // Constructor
    public Flight(String id, String origin, String destination, String departureDate, String departureTime,
                  String arrivalTime, String airline, int availableSeats, double price, List<String> availableSeatsList,
                  List<String> takenSeatsList) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airline = airline;
        this.availableSeats = availableSeats;
        this.availableSeatsList = availableSeatsList;
        this.takenSeatsList = takenSeatsList;
        this.price = price;
        this.id = id;

    }

    // Default constructor
    public Flight() {
    }

    protected Flight(Parcel in) {
        id = in.readString();
        origin = in.readString();
        destination = in.readString();
        departureDate = in.readString();
        departureTime = in.readString();
        arrivalTime = in.readString();
        airline = in.readString();
        availableSeats = in.readInt();
        price = in.readDouble();
        availableSeatsList = in.createStringArrayList();
        takenSeatsList = in.createStringArrayList();
    }

    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel in) {
            return new Flight(in);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };

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

    public List<String> getAvailableSeatsList(){
        return availableSeatsList;
    }

    public void setAvailableSeatsList(List<String> availableSeatsList) {
        this.availableSeatsList = availableSeatsList;
    }

    public List<String> getTakenSeatsList() {
        return takenSeatsList;
    }

    public void setTakenSeatsList(List<String> takenSeatsList) {
        this.takenSeatsList = takenSeatsList;
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
    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", airline='" + airline + '\'' +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", availableSeatsList=" + availableSeatsList +
                ", takenSeatsList=" + takenSeatsList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(origin);
        parcel.writeString(destination);
        parcel.writeString(departureDate);
        parcel.writeString(departureTime);
        parcel.writeString(arrivalTime);
        parcel.writeString(airline);
        parcel.writeInt(availableSeats);
        parcel.writeDouble(price);
        parcel.writeStringList(availableSeatsList);
        parcel.writeStringList(takenSeatsList);
    }
}
