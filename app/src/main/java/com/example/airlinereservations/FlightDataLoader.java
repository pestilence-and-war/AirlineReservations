package com.example.airlinereservations;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class FlightDataLoader {

    public static List<Flight> loadFlights(Context context) {
        String jsonString = loadJSONFromAsset(context);
        if (jsonString != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Flight>>() {}.getType();
            return gson.fromJson(jsonString, type);
        }
        return null;
    }

    private static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Flight Information.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
