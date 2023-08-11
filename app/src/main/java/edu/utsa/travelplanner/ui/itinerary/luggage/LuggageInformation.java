package edu.utsa.travelplanner.ui.itinerary.luggage;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.luggagedata.LuggageData;

public class LuggageInformation extends AppCompatActivity {

    public Button button;
    public Cursor c1;
    public StringBuilder bAct1, bAct2, bAct3, bAct4, bAct5;
    public TextView lug1_txt, lug2_txt, lug3_txt, lug4_txt, lug5_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luggage_information);
        setupBackButton();

        lug1_txt = (TextView) findViewById(R.id.luggage_bag_owner);
        lug2_txt = (TextView) findViewById(R.id.brand);
        lug3_txt = (TextView) findViewById(R.id.weight);
        lug4_txt = (TextView) findViewById(R.id.dimensions);
        lug5_txt = (TextView) findViewById(R.id.color);

        LuggageData lug = new LuggageData(this);
        c1 = lug.fetchLuggage1();

        bAct1 = new StringBuilder();
        bAct2 = new StringBuilder();
        bAct3 = new StringBuilder();
        bAct4 = new StringBuilder();
        bAct5 = new StringBuilder();

        while (c1.moveToNext()) {
            lug1_txt.append(c1.getString(1));
            lug2_txt.append(c1.getString(2));
            lug3_txt.append(c1.getString(3));
            lug4_txt.append(c1.getString(4));
            lug5_txt.append(c1.getString(5));
        }
    }

    //Button to go back
    private void setupBackButton() {
        button = (Button) findViewById(R.id.button_back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
