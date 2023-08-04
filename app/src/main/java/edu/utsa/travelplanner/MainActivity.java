package edu.utsa.travelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

        // Delete Old Database (USE WHEN YOU CHANGED THE DATABASE SCHEMA)
        // Context context = getApplicationContext();
        // context.deleteDatabase("travelplanner.db");

        // Getting APP DATABASE
        AppData db = AppData.getInstance(this);


        // GETTING ALL USERS IN APP DATABASE
        List<User_Model> users = db.getUsers();

        // Adding some test data to the database in case there are no user data
        if (users == null) {
            db.addUser("test", "test", "1234");
        }

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
                boolean authenticated = false;

                // Check if the username and password are valid.
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a username and password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // GETTING ALL USERS IN APP DATABASE
                List<User_Model> users = db.getUsers();
                User_Model authenticated_user = null;

                // Check if the username and password match the stored values.
                if (users == null)
                {
                    Log.d("MainActivity", "There are no users in the database.");
                } else {
                    for (User_Model person : users) {
                        if (username.equals(person.getEmail()) && password.equals(person.getPassword())) {
                            // Login successful.
                            // Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                            authenticated = true;
                            authenticated_user = person;
                            break;
                        }
                    }

                    if (authenticated){
                        Intent intent = new Intent(MainActivity.this, HomeLanding.class);
                        intent.putExtra("authenticated_user", (Parcelable) authenticated_user);
                        startActivity(intent);
                    } else {
                        // Login failed.
                        //Toast.makeText(MainActivity.this, "Login failed.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, loginfailedActivity.class);
                        startActivity(intent);
                    }
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