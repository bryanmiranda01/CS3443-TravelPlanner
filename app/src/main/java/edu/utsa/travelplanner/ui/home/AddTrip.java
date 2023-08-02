package edu.utsa.travelplanner.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.TripData;

//Class allows user to input new trip information
public class AddTrip extends AppCompatActivity {

    public ImageButton Imagebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.add_trip);
    TripData db = TripData.getInstance(this);
    setupBackButton();

    //User input for trip details
    EditText destination_input = findViewById(R.id.ans_dest);
    EditText hotel_address_input = findViewById(R.id.ans_hotel);
    EditText city_country_input = findViewById(R.id.ans_cc);
    EditText start_date_input = findViewById(R.id.ans_start);
    EditText end_date_input = findViewById(R.id.ans_end);
    EditText transport_input = findViewById(R.id.ans_transp);

    //Button implementation to verify all fields have been filled
    Button doneButton = findViewById(R.id.done_itin);
    doneButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String dest = destination_input.getText().toString();
            String address = hotel_address_input.getText().toString();
            String cc = city_country_input.getText().toString();
            String start = start_date_input.getText().toString();
            String end = end_date_input.getText().toString();
            String transp = transport_input.getText().toString();

            //Verify if all fields have been filled
            if (dest.isEmpty() || address.isEmpty() || cc.isEmpty()
                    || start.isEmpty() || end.isEmpty() || transp.isEmpty()) {

                Toast.makeText(AddTrip.this, "Please complete all the fields listed", Toast.LENGTH_SHORT).show();

            } else {
                db.insertTripData(dest, address, cc, start, end, transp);
                Intent intent = new Intent(AddTrip.this, HomeLanding.class);
                startActivity(intent);
            }
        }
    });
    }

    //Sends user back to homelanding page
    private void setupBackButton() {
        Imagebutton = (ImageButton) findViewById(R.id.back_itin);

        Imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTrip.this, HomeLanding.class);
                startActivity(intent);
            }
        });
    }
}


