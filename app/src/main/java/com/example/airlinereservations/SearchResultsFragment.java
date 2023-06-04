package com.example.airlinereservations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsFragment extends Fragment {

    private List<Flight> flightSearchResult;

    private static final String ARG_FLIGHT_SEARCH_RESULT = "flightSearchResults";

    public SearchResultsFragment() {
        // Required empty public constructor
    }

    public static SearchResultsFragment newInstance(ArrayList<Flight> flightSearchResults) {
        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_FLIGHT_SEARCH_RESULT, flightSearchResults);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            flightSearchResult = getArguments().getParcelableArrayList(ARG_FLIGHT_SEARCH_RESULT);
            System.out.println(flightSearchResult.size());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        //initialize the RecyclerView
        RecyclerView recyclerViewSearchResults = view.findViewById(R.id.recyclerViewSearchResults);
        recyclerViewSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));

        //Initialize the adapter and set it to the RecyclerView
        FlightsAdapter flightsAdapter = new FlightsAdapter(flightSearchResult);
        recyclerViewSearchResults.setAdapter(flightsAdapter);

        if (flightSearchResult != null) {
            System.out.println("Search result size: " + flightSearchResult.size()); // Debugging line
        }

        return view;
    }
}