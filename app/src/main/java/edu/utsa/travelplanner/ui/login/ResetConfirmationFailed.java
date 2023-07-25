package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;

public class ResetConfirmationFailed extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Reset Confirmation Failed View
        setContentView(R.layout.password_reset_fail);

        // Get the back_to_login_button Button widget
        Button goback = findViewById(R.id.return_button);

        // Set an OnClickListener for the Return Button widget.
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetConfirmationFailed.this, ResetConfirmation.class);
                startActivity(intent);
            }
        });

    }
}
