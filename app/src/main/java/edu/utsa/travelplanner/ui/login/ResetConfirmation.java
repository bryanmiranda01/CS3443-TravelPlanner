package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.data.User_Model;

public class ResetConfirmation extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Reset Confirmation View
        setContentView(R.layout.reset_confirm);

        // Get the EditText widgets for security code
        EditText userinput_EditText = findViewById(R.id.userinput);

        // Get the next Button widget
        Button nextButton = findViewById(R.id.next);

        //


        // Set an OnClickListener for the next Button widget
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_security_answer = userinput_EditText.getText().toString();

                if (user_security_answer.isEmpty()) {
                    Toast.makeText(ResetConfirmation.this, "You cannot leave you answer empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Retrieving the user's User_Model from ForgotPassword Activity
                User_Model user_account = (User_Model) getIntent().getParcelableExtra("user_account");

                if (user_security_answer.equals(user_account.getSecurityCode())){
                    Toast.makeText(ResetConfirmation.this, "Security Code Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetConfirmation.this, ResetConfirmationSuccess.class);

                    // Passing the user's User_Model to ResetConfirmationSuccess Activity
                    intent.putExtra("user_account", user_account);

                    startActivity(intent);
                } else {
                    Toast.makeText(ResetConfirmation.this, "Security Code Does Not Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetConfirmation.this, ResetConfirmationFailed.class);

                    // Passing the user's User_Model to ResetConfirmationFailed Activity
                    intent.putExtra("user_account", user_account);

                    startActivity(intent);
                }
            }
        });

    }
}
