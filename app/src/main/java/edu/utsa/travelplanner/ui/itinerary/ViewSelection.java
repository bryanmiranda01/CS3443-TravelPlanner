package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.checklistdata.Checklist;
import edu.utsa.travelplanner.data.luggagedata.Luggage;

public class ViewSelection  extends AppCompatActivity {

    public ImageButton imageButton;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_button);
        setupButton1();
        setupButton2();
        setupButton3();
        setupBackButton();
        }

        //User button selection
        //View trip details
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
        private void setupButton3() {
            button = (Button) findViewById(R.id.button_luggage);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(ViewSelection.this, Luggage.class);
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


