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
import android.widget.ArrayAdapter;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
import android.widget.EditText;

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
        final Spinner spinnerOrigin = view.findViewById(R.id.spinnerOrigin);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.airports_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrigin.setAdapter(adapter);

        final EditText editTextDepartureDate = view.findViewById(R.id.editTextDepartureDate);

        editTextDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        editTextDepartureDate.setText(selectedDate);
                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
        view.findViewById(R.id.buttonSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String origin = spinnerOrigin.getSelectedItem().toString();
                String destination = "";
                String departureDate = editTextDepartureDate.getText().toString();
                List<Flight> flightSearchResult = FlightSearchActivity.searchFlights(view.getContext(), origin, destination, departureDate);
            }
        });

        }


}
