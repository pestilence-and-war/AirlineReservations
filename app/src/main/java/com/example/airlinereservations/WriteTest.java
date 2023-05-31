package com.example.airlinereservations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WriteTest {
    public void testReadFile(Context context) {
        try {
            InputStream is = context.getAssets().open("Flight Information.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("TestFileReading", line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
