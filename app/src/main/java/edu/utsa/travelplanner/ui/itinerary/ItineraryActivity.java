package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.tripdata.TripData;
import edu.utsa.travelplanner.ui.add.AddSelection;

import edu.utsa.travelplanner.ui.home.HomeLanding;


public class ItineraryActivity extends AppCompatActivity {

    public ImageButton button;
    public FloatingActionButton floatButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.itinerary_view);
        setupBackButton();

        TextView dest_text = (TextView) findViewById(R.id.itin_location);
        TextView start_text = (TextView) findViewById(R.id.date_placeholder);

        //Fetch and set textviews
        TripData tripData = new TripData(this);
        Cursor cursor = tripData.fetchDetails();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        while (cursor.moveToNext()) {
             builder1.append(cursor.getString(1));
             builder2.append(cursor.getString(4));
        }

        dest_text.setText(builder1);
        start_text.setText(builder2);

        //Select what details to view
        floatButton = (FloatingActionButton) findViewById(R.id.fab2);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ItineraryActivity.this, ViewSelection.class);
                startActivity(intent);
            }

        });

        //Select what to add
        floatButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ItineraryActivity.this, AddSelection.class);
                startActivity(intent);
            }

        });
    }

    //Back button
    private void setupBackButton() {
        ImageButton button = (ImageButton) findViewById(R.id.back_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItineraryActivity.this, HomeLanding.class);
                startActivity(intent);
            }
        });
    }

}

