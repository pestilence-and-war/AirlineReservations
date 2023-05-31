package com.example.airlinereservations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SearchResultsFragment extends Fragment {

    private List<Flight> flightSearchResult;
    private RecyclerView recyclerViewSearchResults;
    private FlightsAdapter flightsAdapter;

    private static final String ARG_FLIGHT_SEARCH_RESULT = "searchResult";

    public SearchResultsFragment() {
        // Required empty public constructor
    }

    public static SearchResultsFragment newInstance(String flightSearchResultJson) {
        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FLIGHT_SEARCH_RESULT, flightSearchResultJson);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Flight>>() {}.getType();
            String flightSearchResultJson = getArguments().getString(ARG_FLIGHT_SEARCH_RESULT);
            flightSearchResult = gson.fromJson(flightSearchResultJson, type);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        //initialize the RecyclerView
        recyclerViewSearchResults = view.findViewById(R.id.recyclerViewSearchResults);
        recyclerViewSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));

        //Initialize the adapter and set it to the RecyclerView
        flightsAdapter = new FlightsAdapter(flightSearchResult);
        recyclerViewSearchResults.setAdapter(flightsAdapter);
        return view;
    }
}
