package edu.utsa.travelplanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.ContentView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.travelplanner.databinding.ActivityMainBinding;
import edu.utsa.travelplanner.ui.home.HomeLanding;
import edu.utsa.travelplanner.ui.login.loginfailedActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // LOGIN LAYOUT
        setContentView(R.layout.sign_in);

        // Get the EditText widgets for login
        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);

        // Get the Button widget
        Button loginButton = findViewById(R.id.signin_button);

        // Set an OnClickListener for the Button widget.
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
    }
}