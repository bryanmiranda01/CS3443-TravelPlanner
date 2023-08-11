package edu.utsa.travelplanner.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;

public class LogOut extends AppCompatActivity {

    public ImageButton imageButton;
    public Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupBackButton();
        setupLogOutButton();
    }

    //Sends user back to login screen
    private void setupLogOutButton() {
        button = (Button) findViewById(R.id.logoutbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogOut.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //Sends user back to settings
    private void setupBackButton() {
        imageButton = (ImageButton) findViewById(R.id.back_btn_log);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
