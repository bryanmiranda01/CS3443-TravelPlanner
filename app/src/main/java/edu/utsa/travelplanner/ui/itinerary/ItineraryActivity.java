package edu.utsa.travelplanner.ui.itinerary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.activitydata.ActivityData;
import edu.utsa.travelplanner.data.tripdata.TripData;
import edu.utsa.travelplanner.ui.add.AddSelection;

import edu.utsa.travelplanner.ui.home.HomeLanding;


public class ItineraryActivity extends AppCompatActivity {

    public ImageButton button;
    public FloatingActionButton floatButton;
    public Cursor cursor1,c1, c2, c3, c4, c5;
    public TextView dest_text, start_text, act1_txt, act2_txt, act3_txt, act4_txt, act5_txt;
    public StringBuilder builderDest, builderDate, bAct1, bAct2, bAct3, bAct4, bAct5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.itinerary_view);
        setupBackButton();

        //Fetch and set textviews with trip info
        dest_text = (TextView) findViewById(R.id.itin_location);
        start_text = (TextView) findViewById(R.id.date_placeholder);

        TripData tripData = new TripData(this);
        cursor1 = tripData.fetchDetails();
        builderDest = new StringBuilder();
        builderDate = new StringBuilder();

        while (cursor1.moveToNext()) {
             builderDest.append(cursor1.getString(1));
             builderDate.append(cursor1.getString(4));
        }

        dest_text.setText(builderDest);
        start_text.setText(builderDate);

        //Fetch and set textviews for activities **CAN HOLD UP TO FIVE
        act1_txt = (TextView) findViewById(R.id.act_placeholder1);
        act2_txt = (TextView) findViewById(R.id.act_placeholder2);
        act3_txt = (TextView) findViewById(R.id.act_placeholder3);
        act4_txt = (TextView) findViewById(R.id.act_placeholder4);
        act5_txt = (TextView) findViewById(R.id.act_placeholder5);

        ActivityData actData = new ActivityData(this);
        c1 = actData.fetchActivity1();
        c2 = actData.fetchActivity2();
        c3 = actData.fetchActivity3();
        c4 = actData.fetchActivity4();
        c5 = actData.fetchActivity5();

        bAct1 = new StringBuilder();
        bAct2 = new StringBuilder();
        bAct3 = new StringBuilder();
        bAct4 = new StringBuilder();
        bAct5 = new StringBuilder();

        while (c1.moveToNext()) {
            bAct1.append(c1.getString(1));
            c1.close();
        }
        while (c2.moveToNext()) {
            bAct2.append(c2.getString(1));
            c2.close();
        }
        while (c3.moveToNext()) {
            bAct3.append(c3.getString(1));
            c3.close();
        }
        while (c4.moveToNext()) {
            bAct4.append(c4.getString(1));
            c4.close();
        }
        while (c5.moveToNext()) {
            bAct5.append(c5.getString(1));
            c5.close();
        }

        act1_txt.setText(bAct1);
        act2_txt.setText(bAct2);
        act3_txt.setText(bAct3);
        act4_txt.setText(bAct4);
        act5_txt.setText(bAct5);


        //Select what details to view
        floatButton = (FloatingActionButton) findViewById(R.id.fab2);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ItineraryActivity.this, ViewSelection.class);
                startActivity(intent);
            }

        });

        //Select what to add
        floatButton = (FloatingActionButton) findViewById(R.id.fab1);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ItineraryActivity.this, AddSelection.class);
                startActivity(intent);
            }

        });
    }

    //Sends user back to home screen
    private void setupBackButton() {
        ImageButton button = (ImageButton) findViewById(R.id.back_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItineraryActivity.this, HomeLanding.class);
                startActivity(intent);
            }
        });
    }

}

