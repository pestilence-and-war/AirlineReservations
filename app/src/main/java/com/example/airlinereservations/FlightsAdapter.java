package com.example.airlinereservations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.FlightViewHolder> {
    private List<Flight> flightsList;

    public FlightsAdapter(List<Flight> flightsList) {
        this.flightsList = flightsList;
    }

    @NonNull
    @Override
    public FlightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item, parent, false);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightViewHolder holder, int position) {
        System.out.println("Binding data to view holder: " + position);// Debugging line
        Flight flight = flightsList.get(position);
        holder.textViewFlightId.setText("Flight ID: " + flight.getId());
        holder.textViewDepartureDate.setText("Departure Date: " + flight.getDepartureDate().toString());
        holder.textViewPrice.setText("Price: " + flight.getPrice());
        // Bind flight data to views here
        // For example: holder.airlineTextView.setText(flight.getAirline());
    }


    @Override
    public int getItemCount() {
        if (flightsList != null) {
            return flightsList.size();
        } else {
            return 0;
        }
    }

    static class FlightViewHolder extends RecyclerView.ViewHolder {
        // Define view items here
        TextView textViewFlightId;
        TextView textViewDepartureDate;
        TextView textViewPrice;
        // For example: TextView airlineTextView;

        public FlightViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize view items here
            textViewFlightId = itemView.findViewById(R.id.textViewFlightId);
            textViewDepartureDate = itemView.findViewById(R.id.textViewDepartureDate);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);

            // For example: airlineTextView = view.findViewById(R.id.airlineTextView);
        }
    }
}
