package edu.utsa.travelplanner.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.TripData;


public class ViewTrips extends AppCompatActivity {

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_trips);
        setupBackButton();

        TripData DB = TripData.getInstance(this);
        List<Trip>  details = DB.getDetails();

        /*View trip destination , add this to view trips screen

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
            });

        */

    }
        //Sends user backs to homelanding page
        private void setupBackButton() {
            button = (Button) findViewById(R.id.buttonBack);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(ViewTrips.this, HomeLanding.class);
                     startActivity(intent);
            }
        });
    }
}
