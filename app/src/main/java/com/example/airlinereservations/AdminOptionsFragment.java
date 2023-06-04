package com.example.airlinereservations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airlinereservations.databinding.FragmentAdminOptionsBinding;

//                      Needed for fragments to work
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
public class AdminOptionsFragment extends Fragment {


    private FragmentAdminOptionsBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAdminOptionsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// Button paths here
        binding.bAgent2.setOnClickListener(view1 -> NavHostFragment.findNavController(AdminOptionsFragment.this)
                .navigate(R.id.action_adminOptionsFragment_to_agentFragment));

        binding.bFlyer2.setOnClickListener(view1 -> NavHostFragment.findNavController(AdminOptionsFragment.this)
                .navigate(R.id.action_adminOptionsFragment_to_flyerFragment));

        binding.bReservation2.setOnClickListener(view1 -> NavHostFragment.findNavController(AdminOptionsFragment.this)
                .navigate(R.id.action_adminOptionsFragment_to_reservationFragment));

        binding.bUser2.setOnClickListener(view1 -> NavHostFragment.findNavController(AdminOptionsFragment.this)
                .navigate(R.id.action_adminOptionsFragment_to_userFragment));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
//                      ADD CONTENT BELOW HERE
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////