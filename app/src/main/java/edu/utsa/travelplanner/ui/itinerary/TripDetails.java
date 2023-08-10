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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip_details);
        setupBackButton();

        TextView destinationInput = findViewById(R.id.textDestination);
        TextView addressInput = findViewById(R.id.textHotelAddress);
        TextView ccInput = findViewById(R.id.textCitiesWillVisit);
        TextView startInput = findViewById(R.id.textStartDate);
        TextView endInput = findViewById(R.id.textEndDate);
        TextView transportInput = findViewById(R.id.textTransportation);

        TripData tripData = new TripData(this);
        Cursor cursor = tripData.fetchDetails();
        StringBuilder dest = new StringBuilder();
        StringBuilder add = new StringBuilder();
        StringBuilder cc = new StringBuilder();
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        StringBuilder transp = new StringBuilder();

        while (cursor.moveToNext()) {
            dest.append(cursor.getString(1));
            add.append(cursor.getString(2));
            cc.append(cursor.getString(3));
            start.append(cursor.getString(4));
            end.append(cursor.getString(5));
            transp.append(cursor.getString(6));


        }

        destinationInput.setText(dest);
        addressInput.setText(add);
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
