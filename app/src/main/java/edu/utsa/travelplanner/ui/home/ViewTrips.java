package edu.utsa.travelplanner.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.tripdata.TripData;

//Class needs overhaul
public class ViewTrips extends AppCompatActivity {

    public ImageButton imageButton;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_trips);
        TripData db = TripData.getInstance(this);
        setupBackButton();
        setupItinButton();

        }

    private void setupItinButton() {
        button = (Button) findViewById(R.id.itinerary1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

        //Sends user backs to homelanding page
        private void setupBackButton() {
            imageButton = (ImageButton) findViewById(R.id.back_btn_view);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View v) {
                     finish();
            }
        });
    }
}
