package edu.utsa.travelplanner.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

public class ForgotPassword extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Password Reset View
        setContentView(R.layout.password_reset);

        // Get APP DATABASE
        AppData db = AppData.getInstance(this);

        // GETTING ALL USERS IN APP DATABASE
        List<User_Model> users = db.getUsers();


        // Get the EditText widgets for email address
        EditText userinput_EditText = findViewById(R.id.userinput);

        // Get the next Button widget
        Button nextButton = findViewById(R.id.next);

        // Set an OnClickListener for the next Button widget
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = userinput_EditText.getText().toString();
                boolean user_found = false;

                if (user_email.isEmpty()) {
                    Toast.makeText(ForgotPassword.this, "You cannot leave you email empty.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (users != null ){
                    for (User_Model person : users) {
                        if (user_email.equals(person.getEmail())){
                            Toast.makeText(ForgotPassword.this, "Email Exists", Toast.LENGTH_SHORT).show();

                            user_found = true;

                            Intent intent = new Intent(ForgotPassword.this, ResetConfirmation.class);

                            // Passing the user's User_Model to ResetConfirmation Activity
                            intent.putExtra("user_account", person);

                            startActivity(intent);
                        }
                    }

                    if (!(user_found)){
                        Toast.makeText(ForgotPassword.this, "This email does not match in our records.", Toast.LENGTH_SHORT).show();
                        return;
                    }


                }
            }
        });
    }
}
