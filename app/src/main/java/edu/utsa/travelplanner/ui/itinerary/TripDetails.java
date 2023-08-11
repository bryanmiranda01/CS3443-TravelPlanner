package edu.utsa.travelplanner.ui.itinerary;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.tripdata.TripData;

public class TripDetails extends AppCompatActivity {

    public Button button;
    StringBuilder dest, add, cc, start, end, transp;
    TextView destInput, addInput, ccInput, startInput, endInput, transportInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip_details);
        setupBackButton();

        //Set textviews with database information
        destInput = findViewById(R.id.textDestination);
        addInput = findViewById(R.id.textHotelAddress);
        ccInput = findViewById(R.id.textCitiesWillVisit);
        startInput = findViewById(R.id.textStartDate);
        endInput = findViewById(R.id.textEndDate);
        transportInput = findViewById(R.id.textTransportation);

        TripData tripData = new TripData(this);
        Cursor cursor = tripData.fetchDetails();
        dest = new StringBuilder();
        add = new StringBuilder();
        cc = new StringBuilder();
        start = new StringBuilder();
        end = new StringBuilder();
        transp = new StringBuilder();

        while (cursor.moveToNext()) {
            dest.append(cursor.getString(1));
            add.append(cursor.getString(2));
            cc.append(cursor.getString(3));
            start.append(cursor.getString(4));
            end.append(cursor.getString(5));
            transp.append(cursor.getString(6));
        }

        destInput.setText(dest);
        addInput.setText(add);
        ccInput.setText(cc);
        startInput.setText(start);
        endInput.setText(end);
        transportInput.setText(transp);

    }

        //Button to go back to itinerary view
        private void setupBackButton() {
            button = (Button) findViewById(R.id.buttonBack);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TripDetails.this, ItineraryActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
