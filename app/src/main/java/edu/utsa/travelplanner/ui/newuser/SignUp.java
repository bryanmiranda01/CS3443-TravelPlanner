package edu.utsa.travelplanner.ui.newuser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;

public class SignUp extends AppCompatActivity {

        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            // Account Creation View
            setContentView(R.layout.account_creation);

            // Get the EditText widgets for login
            EditText user_email_EditText = findViewById(R.id.userinput_email);
            EditText user_pass_EditText = findViewById(R.id.userinput_password);
            EditText confirm_pass_EditText = findViewById(R.id.confirm_userinput_password);

            // Get the Create Button widget
            Button createButton = findViewById(R.id.create_button);

            // Set an OnClickListener for the Create Button widget.
            createButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user_email = user_email_EditText.getText().toString();
                    String user_pass = user_pass_EditText.getText().toString();
                    String confirm_pass = confirm_pass_EditText.getText().toString();

                    if (user_email.isEmpty() || user_pass.isEmpty() || confirm_pass.isEmpty()) {
                        Toast.makeText(SignUp.this, "You cannot leave any field empty.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!(user_pass.equals(confirm_pass))){
                        Toast.makeText(SignUp.this, "Password Does Not Math", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });

        }
}


