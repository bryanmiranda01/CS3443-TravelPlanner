package edu.utsa.travelplanner.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;


public class SettingsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        setupBackButton();

//       Button to go to account info
        Button buttonAccount =  findViewById(R.id.account);
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SettingsActivity.this, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

//      Button to go to reminders screen
        Button buttonRemindersNotifs =  findViewById(R.id.remindersNotifs);
        buttonRemindersNotifs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SettingsActivity.this, RemindersNotifications.class);
                startActivity(intent1);
            }
        });

//       Log out button
        Button buttonlogOut = findViewById(R.id.logOut);
        buttonlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(SettingsActivity.this, LogOut.class);
                startActivity(intent2);
            }
        });

    }

//   Sends user back to home screen
    private void setupBackButton() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.back_btn_set);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}