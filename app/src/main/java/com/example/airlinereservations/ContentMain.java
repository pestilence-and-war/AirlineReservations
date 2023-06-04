package com.example.airlinereservations;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.airlinereservations.databinding.FragmentContentBinding;


public class ContentMain extends Fragment {

    private FragmentContentBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentContentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.bSearch.setOnClickListener(view1 -> NavHostFragment.findNavController(ContentMain.this)
                .navigate(R.id.action_contentMain_to_searchFragment));
        binding.bAgent.setOnClickListener(view1 -> NavHostFragment.findNavController(ContentMain.this)
                .navigate(R.id.action_contentMain_to_loginFragment));
        binding.bLogin.setOnClickListener(view1 -> NavHostFragment.findNavController(ContentMain.this)
                .navigate(R.id.action_contentMain_to_loginFragment));
        binding.bViewCart2.setOnClickListener(view1 -> NavHostFragment.findNavController(ContentMain.this)
                .navigate(R.id.action_contentMain_to_loginFragment));
        binding.bMyflights.setOnClickListener(view1 -> NavHostFragment.findNavController(ContentMain.this)
                .navigate(R.id.action_contentMain_to_loginFragment));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}