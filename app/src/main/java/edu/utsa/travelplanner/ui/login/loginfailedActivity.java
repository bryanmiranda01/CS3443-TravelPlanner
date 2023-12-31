package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;

public class loginfailedActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Login Failed View
        setContentView(R.layout.login_failed);

        // Get the back_to_login_button Button widget
        Button goback = findViewById(R.id.back_to_login_button);

        // Set an OnClickListener for the Create Button widget.
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginfailedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
