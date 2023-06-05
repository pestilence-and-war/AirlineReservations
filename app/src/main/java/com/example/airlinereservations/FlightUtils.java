package com.example.airlinereservations;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class FlightUtils {

    public static List<Flight> searchFlights(Context context, String origin, String destination) {
        List<Flight> flights = new ArrayList<>();
        StringBuilder jsonContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("Flight Information.txt"))))
        {
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }

            JSONArray flightArr = new JSONArray(jsonContent.toString());
            for (int i = 0; i < flightArr.length(); i++) {
                JSONObject flightObj = flightArr.getJSONObject(i);
                if (flightObj.getString("origin").equals(origin)
                        && flightObj.getString("destination").equals(destination)
                    //&& flightObj.getString("departureDate").equals(departureDate))
                ){
                    Flight flight = new Flight();

                    flight.setId(flightObj.getString("id"));
                    flight.setOrigin(flightObj.getString("origin"));
                    flight.setDestination(flightObj.getString("destination"));
                    flight.setDepartureDate(flightObj.getString("departureDate"));
                    flight.setDepartureTime(flightObj.getString("departureTime"));
                    flight.setArrivalTime(flightObj.getString("arrivalTime"));
                    flight.setAirline(flightObj.getString("airline"));
                    flight.setAvailableSeats(flightObj.getInt("availableSeats"));
                    flight.setPrice(flightObj.getDouble("price"));

                    JSONArray availableSeatsListArray = flightObj.getJSONArray("availableSeatsList");
                    List<String> availableSeatsList = new ArrayList<>();
                    for (int j = 0; j < availableSeatsListArray.length(); j++) {
                        availableSeatsList.add(availableSeatsListArray.getString(j));
                    }
                    flight.setAvailableSeatsList(availableSeatsList);

                    JSONArray takenSeatsListArray = flightObj.getJSONArray("takenSeatsList");
                    List<String> takenSeatsList = new ArrayList<>();
                    for (int k = 0; k < takenSeatsListArray.length(); k++) {
                        takenSeatsList.add(takenSeatsListArray.getString(k));
                    }
                    flight.setTakenSeatsList(takenSeatsList);

                    flights.add(flight);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return flights;
    }
}
