package edu.utsa.travelplanner.ui.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.ui.itinerary.ViewSelection;

public class AddChecklist extends AppCompatActivity {

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_pre_trip);
        setupBackButton();

        Button doneButton = findViewById(R.id.done_add_pretrip);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddChecklist.this, ViewSelection.class);
                startActivity(intent);

            }
        });
    }
    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_add_pretrip);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
