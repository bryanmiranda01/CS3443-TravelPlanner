package edu.utsa.travelplanner;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


import edu.utsa.travelplanner.data.AppData;
import edu.utsa.travelplanner.data.User_Model;
import edu.utsa.travelplanner.ui.home.HomeLanding;
import edu.utsa.travelplanner.ui.login.ForgotPassword;
import edu.utsa.travelplanner.ui.login.loginfailedActivity;
import edu.utsa.travelplanner.ui.newuser.SignUp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LOGIN LAYOUT
        setContentView(R.layout.sign_in);




//=================================== TESTING DATABASE ==========================================================
        // Get the AppData database instance
        AppData db = AppData.getInstance(this);

        // Adding some test data to the database
        db.addUser("user1@email.com", "pw123");
        db.addUser("user2@gmail.com", "h@ck3rs");

        // Retrieve all of the items from the database.
        List<User_Model> users = db.getUsers();

        // Print the items to the logcat.
        for (User_Model person : users) {
            Log.d("MainActivity", person.toString());
        }

        // Update items in the database
        //db.updateUser(1, "GOAT@email.com", "pw123");
        //db.updateUser(2, "user2@gmail.com", "p@wn3d");

        // Delete items from the database.
        db.deleteUser(1);
        db.deleteUser(2);

        // Print the items to the logcat.
        users.clear();
        users = db.getUsers();
        if (users == null)
        {
            Log.d("MainActivity", "There are no users in the database.");
        } else {
            for (User_Model person : users) {
                Log.d("MainActivity", person.toString());
            }
        }


//=====^^^^^^^^^^^^^^^^^^^^^^^^^=========== TESTING DATABASE ========^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^===============




        // Get the EditText widgets for login
        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);

        // Get the Button widget
        Button loginButton = findViewById(R.id.signin_button);

        // Set an OnClickListener for the Login Button widget.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the username and password from the EditText widgets.
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if the username and password are valid.
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a username and password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if the username and password match the stored values.
                if (username.equals("user") && password.equals("1234")) {
                    // Login successful.
                    // Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeLanding.class);
                    startActivity(intent);
                } else {
                    // Login failed.
                    //Toast.makeText(MainActivity.this, "Login failed.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, loginfailedActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Set an OnClickListener for the New User? TextView
        TextView newuser_textview = findViewById(R.id.newuser);
        newuser_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener for the Forgot Password TextView
        TextView forgotPW_textview = findViewById(R.id.forgotpw);
        forgotPW_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
    }
}