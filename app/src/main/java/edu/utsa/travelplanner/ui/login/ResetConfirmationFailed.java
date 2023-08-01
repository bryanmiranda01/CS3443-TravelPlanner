package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.User_Model;

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
                // Retrieving the user's User_Model from ResetConfirmation Activity
                User_Model user_account = (User_Model) getIntent().getParcelableExtra("user_account");

                Intent intent = new Intent(ResetConfirmationFailed.this, ResetConfirmation.class);

                // Passing the user's User_Model back to ResetConfirmation Activity
                intent.putExtra("user_account", user_account);

                startActivity(intent);
            }
        });

    }
}
