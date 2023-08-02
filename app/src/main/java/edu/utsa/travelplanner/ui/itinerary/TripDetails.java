package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class TripDetails extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip_details);
        setupBackButton();
    }

    /*
    TextView txtDest = (TextView) findViewById(R.id.textDestination);
    TextView txtAddress = (TextView) findViewById(R.id.textHotelAddress);
    TextView txtVisit = (TextView) findViewById(R.id.textCitiesWillVisit);
    TextView txtStart = (TextView) findViewById(R.id.textStartDate);
    TextView txtEnd = (TextView) findViewById(R.id.textEndDate);
    TextView txtTransp = (TextView) findViewById(R.id.textTransportation);


     */


/*
    // Update information, add this function to trip details screen

        update_itin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ans_destTXT = ans_dest.getText().toString();
            String ans_hotelTXT = ans_hotel.getText().toString();
            String ans_ccTXT = ans_cc.getText().toString();
            String ans_startTXT = ans_start.getText().toString();
            String ans_endTXT = ans_end.getText().toString();
            String ans_transpTXT = ans_transp.getText().toString();

            Boolean checkupdatedata = db.updateuserdata(ans_destTXT, ans_hotelTXT, ans_ccTXT, ans_startTXT, ans_endTXT, ans_transpTXT);

            if(checkupdatedata==true)
                Toast.makeText(HomeLanding.this,"Trip information updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(HomeLanding.this,"Trip information was not updated", Toast.LENGTH_SHORT).show();
        }
    });

    // Delete information, add this function to trip details screen

        delete_itin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ans_destTXT = ans_dest.getText().toString();

            Boolean checkdeletedata = db.deletedata(ans_destTXT);

            if(checkdeletedata==true)
                Toast.makeText(HomeLanding.this,"Trip deleted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(HomeLanding.this,"Trip was not deleted", Toast.LENGTH_SHORT).show();
        }
    });
     */

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
