package edu.utsa.travelplanner.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class CreateTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.add_trip);

    //User input for trip details
    EditText destination = findViewById(R.id.ans_dest);
    EditText hotel_address = findViewById(R.id.ans_hotel);
    EditText city_country = findViewById(R.id.ans_cc);
    EditText start_date = findViewById(R.id.ans_start);
    EditText end_date = findViewById(R.id.ans_end);
    EditText transport = findViewById(R.id.ans_transp);

    //Button implementation
    Button doneButton = findViewById(R.id.done_itin);
    doneButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String dest = destination.getText().toString();
            String address = hotel_address.getText().toString();
            String cc = city_country.getText().toString();
            String start = start_date.getText().toString();
            String end = end_date.getText().toString();
            String transp = transport.getText().toString();

            //Verify if all fields have been filled
            if (dest.isEmpty() || address.isEmpty() || cc.isEmpty()
                    || start.isEmpty() || end.isEmpty() || transp.isEmpty()) {

                Toast.makeText(CreateTrip.this, "Please complete all the fields listed", Toast.LENGTH_SHORT).show();
            }
        }
        });
    }
}


