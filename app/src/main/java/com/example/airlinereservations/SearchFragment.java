package com.example.airlinereservations;

import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.widget.Spinner;

public class SearchFragment extends Fragment {

    private SearchViewModel mViewModel;


    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        // actions within the view
        Spinner spinnerOrigin = view.findViewById(R.id.spinnerOrigin);

        view.findViewById(R.id.buttonSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String origin = spinnerOrigin.getSelectedItem().toString();
                String destination = "";
                String departureDate = "";
                List<Flight> flightSearchResult = FlightSearchActivity.searchFlights(view.getContext(), origin, destination, departureDate);
            }
        });

        }


}
