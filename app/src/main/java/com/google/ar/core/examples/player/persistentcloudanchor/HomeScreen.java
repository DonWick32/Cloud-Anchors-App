package com.google.ar.core.examples.player.persistentcloudanchor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public class HomeScreen extends AppCompatActivity {

    ArrayList<String> anchorList = new ArrayList<>(Arrays.asList("ua-9cb883b301359269ce7bb628212aa181", "ua-9cb883b301359269ce7bb628212aa181"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ImageButton btnOpenCamera = (ImageButton) findViewById(R.id.btnOpenCamera);
        TextView txtCheckpoints = (TextView) findViewById(R.id.txtCheckPoints);
        btnOpenCamera.setOnClickListener((view) -> onResolveButtonPress());

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref3",MODE_PRIVATE);
        int index = sharedPreferences.getInt("index", 0);

        Log.d("HI1", String.valueOf(index) + ":" + anchorList.size());

        if (index < anchorList.size()){
            txtCheckpoints.setText("Checkpoints Reached = " + (index));
        }
        else {
            txtCheckpoints.setText("Congratulations!");
        }
    }

    private void onResolveButtonPress() {

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref3",MODE_PRIVATE);
        int index = sharedPreferences.getInt("index", 0);

        Log.d("HI2", String.valueOf(index) + ":" + anchorList.size());

        if (index < anchorList.size()){

            ArrayList<String> list = new ArrayList<>(Collections.singletonList(anchorList.get(index)));

            Intent intent = CloudAnchorActivity.newResolvingIntent(this, list);
            startActivity(intent);
        }
    }
}