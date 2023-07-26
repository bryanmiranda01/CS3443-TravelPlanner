package edu.utsa.travelplanner.ui.newuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;


public class AccountCreationSuccess extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Account Creation Success View
        setContentView(R.layout.account_creation_success);

        // Get the Signin Button widget
        Button login = findViewById(R.id.signin_button);

        // Set an OnClickListener for the Login Button widget.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountCreationSuccess.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
