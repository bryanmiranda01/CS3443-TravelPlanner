package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.R;

public class ResetConfirmation extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Reset Confirmation View
        setContentView(R.layout.reset_confirm);

        // Get the EditText widgets for security code
        EditText userinput_EditText = findViewById(R.id.userinput);

        // Get the next Button widget
        Button nextButton = findViewById(R.id.next);

        // Set an OnClickListener for the next Button widget
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_security_answer = userinput_EditText.getText().toString();

                if (user_security_answer.isEmpty()) {
                    Toast.makeText(ResetConfirmation.this, "You cannot leave you answer empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (user_security_answer.equals("1234")){
                    Toast.makeText(ResetConfirmation.this, "Security Code Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetConfirmation.this, ResetConfirmationSuccess.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ResetConfirmation.this, "Security Code Does Not Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetConfirmation.this, ResetConfirmationFailed.class);
                    startActivity(intent);
                }
            }
        });

    }
}
