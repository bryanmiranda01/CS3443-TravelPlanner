package edu.utsa.travelplanner.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.ui.newuser.SignUp;

public class ForgotPassword extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Password Reset View
        setContentView(R.layout.password_reset);

        // Get the EditText widgets for login
        EditText userinput_EditText = findViewById(R.id.userinput);


        // Get the next Button widget
        Button nextButton = findViewById(R.id.next);

        // Set an OnClickListener for the next Button widget
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = userinput_EditText.getText().toString();

                if (user_email.isEmpty()) {
                    Toast.makeText(ForgotPassword.this, "You cannot leave you email empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (user_email.equals("exist@google.com")){
                    Toast.makeText(ForgotPassword.this, "Email Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }
}
