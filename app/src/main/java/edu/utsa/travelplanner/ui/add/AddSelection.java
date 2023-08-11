package edu.utsa.travelplanner.ui.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.ui.itinerary.ItineraryActivity;

public class AddSelection extends AppCompatActivity {
    public ImageButton imageButton;
    public Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_info);

        setupCheckButton();
        setupActivityButton();
        setupLuggageButton();
        setupBackButton();
    }

    private void setupCheckButton() {
        b1 = (Button) findViewById(R.id.addChecklist1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, AddChecklist.class);
                startActivity(intent);
            }
        });
    }

    private void setupLuggageButton() {
        b2 = (Button) findViewById(R.id.addLuggage1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, AddLuggage.class);
                startActivity(intent);
            }
        });
    }

    private void setupActivityButton() {
        b3 = (Button) findViewById(R.id.addActivity1);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_add_info);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, ItineraryActivity.class);
                startActivity(intent);
            }
        });
    }
}
