package edu.utsa.travelplanner.ui.itinerary.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.activitydata.ActivityData;
import edu.utsa.travelplanner.ui.itinerary.ViewSelection;

public class SelectActivity extends AppCompatActivity {

    public Cursor c1, c2, c3, c4, c5;
    public TextView act1_txt, act2_txt, act3_txt, act4_txt, act5_txt;
    public StringBuilder bAct1, bAct2, bAct3, bAct4, bAct5;
    public Button button;
    public ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_activities);
        setupBackButton();
        setupAct1();
        setupAct2();
        setupAct3();
        setupAct4();
        setupAct5();

        act1_txt = (TextView) findViewById(R.id.button_act1);
        act2_txt = (TextView) findViewById(R.id.button_act2);
        act3_txt = (TextView) findViewById(R.id.button_act3);
        act4_txt = (TextView) findViewById(R.id.button_act4);
        act5_txt = (TextView) findViewById(R.id.button_act5);

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
    }

    //Sends user back to activity
    private void setupAct1() {
        button = (Button) findViewById(R.id.button_act1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, ActivityDetails.class);
                startActivity(intent);
            }
        });
    }

    //Sends user back to activity
    private void setupAct2() {
        button = (Button) findViewById(R.id.button_act2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, ActivityDetails.class);
                startActivity(intent);
            }
        });
    }
    //Sends user back to activity
    private void setupAct3() {
        button = (Button) findViewById(R.id.button_act3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, ActivityDetails.class);
                startActivity(intent);
            }
        });
    }
    //Sends user back to activity
    private void setupAct4() {
        button = (Button) findViewById(R.id.button_act4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, ActivityDetails.class);
                startActivity(intent);
            }
        });
    }
        //Sends user back to activity
        private void setupAct5() {
            button = (Button) findViewById(R.id.button_act5);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SelectActivity.this, ActivityDetails.class);
                    startActivity(intent);
                }
            });
        }
    //Sends user back to itinerary screen
    private void setupBackButton() {
        ImageButton button = (ImageButton) findViewById(R.id.back_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, ViewSelection.class);
                startActivity(intent);
            }
        });
    }
}


