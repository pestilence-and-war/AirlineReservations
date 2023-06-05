package com.example.airlinereservations;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        SearchFragment searchFragment = SearchFragment.newInstance();
//
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_container, searchFragment)
//                .commit();
//    }
//
public void replaceFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment)
            .commit();
}

//
//
//
}
