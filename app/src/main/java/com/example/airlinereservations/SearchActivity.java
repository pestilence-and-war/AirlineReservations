package com.example.airlinereservations;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchFragment searchFragment = SearchFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, searchFragment)
                .commit();
    }
    public static List<Flight> searchFlights(Context context, String origin, String destination, String departureDate) {
        List<Flight> flights = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("Flight Information.txt"))))
        {
            String line;
            while ((line = br.readLine()) != null) {
                JSONObject flightObj = new JSONObject(line);
                if (flightObj.getString("origin").equals(origin) && flightObj.getString("destination").equals(destination) && flightObj.getString("departureDate").equals(departureDate)) {
                    Flight flight = new Flight();
                    flight.setId(flightObj.getString("id"));
                    flight.setOrigin(flightObj.getString("origin"));
                    flight.setDestination(flightObj.getString("destination"));
                    flight.setDepartureDate(flightObj.getString("departureDate"));
                    flight.setDepartureTime(flightObj.getString("departureTime"));
                    flight.setArrivalTime(flightObj.getString("arrivalTime"));
                    flight.setAirline(flightObj.getString("airline"));
                    // Check for NULL available seats
                    String availableSeats = flightObj.getString("availableSeats");
                    flight.setAvailableSeats("NULL".equals(availableSeats) ? -1 : Integer.parseInt(availableSeats));
                    // Remove '$' from price
                    String price = flightObj.getString("price");
                    flight.setPrice(Double.parseDouble(price.replace("$", "")));
                    flights.add(flight);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        new WriteTest().testReadFile(context);

        return flights;
    }
}
