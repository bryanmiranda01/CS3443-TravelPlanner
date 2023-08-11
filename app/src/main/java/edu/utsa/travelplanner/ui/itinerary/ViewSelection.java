package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.ui.itinerary.activities.SelectActivity;
import edu.utsa.travelplanner.ui.itinerary.checklist.PreTripChecklist;
import edu.utsa.travelplanner.ui.itinerary.luggage.ViewLuggage;

public class ViewSelection  extends AppCompatActivity {

    public ImageButton imageButton;
    public Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_button);
        setupButton1();
        setupButton2();
        setupButton3();
        setupButton4();
        setupBackButton();
        }

        //User button selection
        //View trip details
        private void setupButton1() {
            b1 = (Button) findViewById(R.id.button_details);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, TripDetails.class);
                    startActivity(intent);
                }
            });
        }

        //View checklist
        private void setupButton2() {
            b2 = (Button) findViewById(R.id.button_checklist);

            b2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Intent intent = new Intent(ViewSelection.this, PreTripChecklist.class);
                        startActivity(intent);
                }
                });
            }


        //View luggage
        private void setupButton3() {
            b3 = (Button) findViewById(R.id.button_luggage);

            b3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, ViewLuggage.class);
                    startActivity(intent);
                }
            });
        }

        //View activities button
        private void setupButton4() {
            b4 = (Button) findViewById(R.id.button_activities);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, SelectActivity.class);
                    startActivity(intent);
            }
        });
    }

    //View back button
    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_btn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}


