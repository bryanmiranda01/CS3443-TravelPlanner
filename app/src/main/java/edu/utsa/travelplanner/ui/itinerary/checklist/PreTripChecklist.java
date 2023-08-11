package edu.utsa.travelplanner.ui.itinerary.checklist;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class PreTripChecklist extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pre_trip_checklist);
        setupBackButton();

    }
        //Button to go back
        private void setupBackButton() {
            button = (Button) findViewById(R.id.buttonBack);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
}

