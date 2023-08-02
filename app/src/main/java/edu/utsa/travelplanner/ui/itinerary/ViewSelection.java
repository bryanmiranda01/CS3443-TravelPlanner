package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class ViewSelection  extends AppCompatActivity {

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_button);
        setupButton1();
        //setupButton2();
        //setupButton3();

        }
        //User button selection
        //View trip
        private void setupButton1() {
            button = (Button) findViewById(R.id.button_details);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, TripDetails.class);
                    startActivity(intent);
                }
            });
        }
        /* Need to still add classes for these to work
        //View checklist
        private void setupButton2() {
            button = (Button) findViewById(R.id.button_checklist);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, Checklist.class);
                    startActivity(intent);
                }
                });
            }


        //View luggage
        private void setupButton2() {
            button = (Button) findViewById(R.id.button_luggage);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, Luggage.class);
                    startActivity(intent);
                }
            });
        }

         */


}

