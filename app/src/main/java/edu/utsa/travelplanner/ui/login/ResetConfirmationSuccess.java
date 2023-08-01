package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.utsa.travelplanner.MainActivity;
import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.AppData;
import edu.utsa.travelplanner.data.User_Model;
import edu.utsa.travelplanner.ui.newuser.SignUp;

public class ResetConfirmationSuccess extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Reset Confirmation Success View
        setContentView(R.layout.password_reset_success);

        // Get the EditText widgets for new password and new password
        EditText userinput_EditText = findViewById(R.id.userinput);
        EditText confirm_userinput_EditText = findViewById(R.id.confirm_userinput);

        // Get the Done Button widget
        Button done = findViewById(R.id.done);

        // Get APP DATABASE
        AppData db = AppData.getInstance(this);

        // Set an OnClickListener for the Done Button widget.
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_pass = userinput_EditText.getText().toString();
                String confirm_pass = confirm_userinput_EditText.getText().toString();

                // Retrieving the user's User_Model from ForgotPassword Activity
                User_Model user_account = (User_Model) getIntent().getParcelableExtra("user_account");

                if (new_pass.isEmpty() || confirm_pass.isEmpty() )  {
                    Toast.makeText(ResetConfirmationSuccess.this, "Your new password cannot be empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!(new_pass.equals(confirm_pass))){
                    Toast.makeText(ResetConfirmationSuccess.this, "New Password Does NOT Match", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // UPDATE User account in the database
                    db.updateUser(user_account.getEmail(), new_pass, user_account.getSecurityCode());

                    Toast.makeText(ResetConfirmationSuccess.this, "Password reset was successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetConfirmationSuccess.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

}
