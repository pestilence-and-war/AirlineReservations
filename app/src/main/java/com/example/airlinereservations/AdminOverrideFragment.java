package com.example.airlinereservations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.airlinereservations.databinding.FragmentAdminOverrideBinding;


//                      Needed for fragments to work
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
public class AdminOverrideFragment extends Fragment {
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    private FragmentAdminOverrideBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

//button



        binding = FragmentAdminOverrideBinding.inflate(inflater, container, false);
        return binding.getRoot();}


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// Create Middle element
        binding.bEntAdmin.setOnClickListener(view1 -> NavHostFragment.findNavController(AdminOverrideFragment.this)
                .navigate(R.id.action_adminOverrideFragment_to_adminOptionsFragment));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


//                      ADD CONTENT BELOW HERE
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////



//enter
//password



    }
