package edu.utsa.travelplanner.ui.settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class LogOut extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
