package edu.utsa.travelplanner.ui.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.luggagedata.LuggageData;


//Class allows user to input new luggage information
public class AddLuggage extends AppCompatActivity {

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_luggage);
        LuggageData db = LuggageData.getInstance(this);
        setupBackButton();

        //Declaring variables for userinputt
        EditText owner_input = findViewById(R.id.ans_owner);
        EditText brand_input = findViewById(R.id.ans_brand);
        EditText weight_input = findViewById(R.id.ans_weight);
        EditText dimen_input = findViewById(R.id.ans_dimen);
        EditText color_input = findViewById(R.id.ans_color);

        //Button implementation to verify all fields have been filled
        Button doneButton = findViewById(R.id.done_add_luggage);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String owner = owner_input.getText().toString();

                String brand = brand_input.getText().toString();

                String weight = weight_input.getText().toString();

                String dimen = dimen_input.getText().toString();

                String color = color_input.getText().toString();

                //Verify if all fields have been filled
                if (owner.isEmpty() || brand.isEmpty() || weight.isEmpty()
                        || dimen.isEmpty() || color.isEmpty()) {

                    Toast.makeText(AddLuggage.this, "Please complete all the fields listed", Toast.LENGTH_SHORT).show();

                } else {
                    db.addLuggageData(owner, brand, weight,dimen, color);
                    finish();
                }
            }
        });
    }

    //Back button to add screen
    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_add_luggage);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}