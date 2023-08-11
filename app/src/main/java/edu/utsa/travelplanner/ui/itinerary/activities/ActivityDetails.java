package edu.utsa.travelplanner.ui.itinerary.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.activitydata.ActivityData;

public class ActivityDetails extends AppCompatActivity {

    public ImageButton imageButton;
    public Cursor c1;
    public StringBuilder bAct1, bAct2, bAct3, bAct4, bAct5, bAct6;
    public TextView act1_txt, act2_txt, act3_txt, act4_txt, act5_txt, act6_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setupBackButton();

        act1_txt = (TextView) findViewById(R.id.name_input);
        act2_txt = (TextView) findViewById(R.id.loc_input);
        act3_txt = (TextView) findViewById(R.id.startdate_input);
        act4_txt = (TextView) findViewById(R.id.starttime_input);
        act5_txt = (TextView) findViewById(R.id.enddate_input);
        act6_txt = (TextView) findViewById(R.id.endtime_input);

        ActivityData actData = new ActivityData(this);
        c1 = actData.fetchActivity1();

        bAct1 = new StringBuilder();
        bAct2 = new StringBuilder();
        bAct3 = new StringBuilder();
        bAct4 = new StringBuilder();
        bAct5 = new StringBuilder();
        bAct6 = new StringBuilder();

        while(c1.moveToNext()) {
            bAct1.append(c1.getString(1));
            bAct2.append(c1.getString(2));
            bAct3.append(c1.getString(3));
            bAct4.append(c1.getString(4));
            bAct5.append(c1.getString(5));
            bAct6.append(c1.getString(6));
        }

            act1_txt.setText(bAct1);
            act2_txt.setText(bAct2);
            act3_txt.setText(bAct3);
            act4_txt.setText(bAct4);
            act5_txt.setText(bAct5);
            act6_txt.setText(bAct6);
    }

    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_view_activity);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}



