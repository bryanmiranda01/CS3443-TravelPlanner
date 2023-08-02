package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        /* View ALL trip information, add this function to the trips details screen

        view_itin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if(res.getCount()==0) {
                    Toast.makeText(HomeLanding.this,"No entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Destination :" + res.getString(0)+"\n");


                }
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeLanding.this);
                builder.setCancelable(true);
                builder.setTitle("Trips details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });


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

            Boolean checkupdatedata = DB.updateuserdata(ans_destTXT, ans_hotelTXT, ans_ccTXT, ans_startTXT, ans_endTXT, ans_transpTXT);

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

            Boolean checkdeletedata = DB.deletedata(ans_destTXT);

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
