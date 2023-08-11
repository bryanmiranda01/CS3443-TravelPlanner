package edu.utsa.travelplanner.ui.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.activitydata.ActivityData;

public class AddActivity extends AppCompatActivity {
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_activity);
        ActivityData db = ActivityData.getInstance(this);
        setupBackButton();

        //Declaring variables for user input
        EditText actname_input = findViewById(R.id.ans_actname);
        EditText location_input = findViewById(R.id.ans_location);
        EditText startd_input = findViewById(R.id.ans_startdate);
        EditText startt_input = findViewById(R.id.ans_starttime);
        EditText endd_input = findViewById(R.id.ans_enddate);
        EditText endt_input = findViewById(R.id.ans_endtime);

        //Button implementation to verify all fields have been filled
        Button doneButton = findViewById(R.id.done_act);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = actname_input.getText().toString();

                String loc = location_input.getText().toString();

                String startd = startd_input.getText().toString();

                String startt = startt_input.getText().toString();

                String endd = endd_input.getText().toString();

                String endt = endt_input.getText().toString();

                //Verify if all fields have been filled
                if (name.isEmpty() || loc.isEmpty() || startd.isEmpty()
                        || startt.isEmpty() || endd.isEmpty() || endt.isEmpty()) {

                    Toast.makeText(AddActivity.this, "Please complete all the fields listed", Toast.LENGTH_SHORT).show();

                } else {
                    db.addActivityData(name, loc, startd, startt, endd, endt);
                    finish();
                }
            }
        });
    }

    //Sends user back to home screen
    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_add_activity);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
