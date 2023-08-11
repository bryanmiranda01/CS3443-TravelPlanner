package edu.utsa.travelplanner.ui.itinerary.luggage;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.luggagedata.LuggageData;

public class ViewLuggage extends AppCompatActivity {
    Button button;
    Cursor c1, c2, c3;
    TextView bag1, bag2, bag3;
    StringBuilder b1, b2 ,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_luggage);
        setupBackButton();
        setupLuggageButton();

        bag1 = (TextView) findViewById(R.id.buttonBag1);
        bag2 = (TextView) findViewById(R.id.buttonBag2);
        bag3 = (TextView) findViewById(R.id.buttonBag3);

        LuggageData lug = new LuggageData(this);
        c1 = lug.fetchLuggage1();
        c2 = lug.fetchLuggage2();
        c3 = lug.fetchLuggage3();

        b1 = new StringBuilder();
        b2 = new StringBuilder();
        b3 = new StringBuilder();

        while (c1.moveToNext()) {
            b1.append(c1.getString(1));
            c1.close();
        }
        while (c2.moveToNext()) {
            b2.append(c2.getString(1));
            c2.close();
        }
        while (c3.moveToNext()) {
            b3.append(c3.getString(1));
            c3.close();
        }

        bag1.setText(b1);
        bag2.setText(b2);
        bag3.setText(b3);
    }

    //Button to go to luggage details
    private void setupLuggageButton() {
        button = (Button) findViewById(R.id.buttonBag1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLuggage.this, LuggageInformation.class);
                startActivity(intent);
            }
        });
    }

    //Button to go back to itinerary view
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
