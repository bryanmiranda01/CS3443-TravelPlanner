package edu.utsa.travelplanner.ui.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class AddSelection extends AppCompatActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setupCheckButton();
        setupActivityButton();
        setupLuggageButton();
        setupBackButton();

        setContentView(R.layout.add_info);
    }

    private void setupCheckButton() {
        Button button1 = (Button) findViewById(R.id.addChecklist1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, AddChecklist.class);
                startActivity(intent);
            }
        });
    }

    private void setupLuggageButton() {
        Button button2 = (Button) findViewById(R.id.addLuggage1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelection.this, AddLuggage.class);
                startActivity(intent);
            }
        });
    }

    private void setupActivityButton() {
        Button button3 = (Button) findViewById(R.id.addActivity1);
        button3.setOnClickListener(new View.OnClickListener() {
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
                finish();
            }
        });
    }
}
