package edu.utsa.travelplanner.ui.home;


import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageButton;



import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.utsa.travelplanner.R;

import edu.utsa.travelplanner.databinding.ActivityMainBinding;
import edu.utsa.travelplanner.ui.itinerary.ItineraryActivity;

import edu.utsa.travelplanner.ui.map.MapActivity;
import edu.utsa.travelplanner.ui.settings.SettingsActivity;


public class HomeLanding extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        edu.utsa.travelplanner.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.app_bar_main);
        //setSupportActionBar(binding.appBarMain.toolbar);
        setupItinButton();
        setupSetButton();
        setupMapButton();

        // Delete database tripdata
        //Context context = getApplicationContext();
        //context.deleteDatabase("travelplanner.db");
        //context.deleteDatabase("tripdetails.db");
        //context.deleteDatabase("luggagedetails.db");
       // context.deleteDatabase("activitydetails.db");

//      FAB to add trip details--------------------------------------------
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeLanding.this, AddTrip.class);
                startActivity(intent);
            }
        });

        /*
        //Navigation bar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener((new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.nav_home) {
                    Toast.makeText(HomeLanding.this, "Home",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.nav_itinerary) {
                    Toast.makeText(HomeLanding.this, "Itinerary",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.nav_calendar) {
                    Toast.makeText(HomeLanding.this, "Calendar",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.nav_settings) {
                    Toast.makeText(HomeLanding.this, "Settings",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        }));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

         */

    }
//  Bottom navigation bar buttons
        private void setupSetButton () {
            ImageButton buttonSet = (ImageButton) findViewById(R.id.settingsButton3);
            buttonSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeLanding.this, SettingsActivity.class);
                    startActivity(intent);
                }
            });
        }

        private void setupItinButton () {
            ImageButton buttonItin = (ImageButton) findViewById(R.id.itineraryButton);

            buttonItin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeLanding.this, ItineraryActivity.class);
                    startActivity(intent);
                }
            });
        }
        private void setupMapButton () {
            ImageButton buttonMap = (ImageButton) findViewById(R.id.mapButton2);

            buttonMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeLanding.this, MapActivity.class);
                    startActivity(intent);
                }
            });
        }
}


/*
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_itinerary, R.id.nav_calendar)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        Toast.makeText(AddTrip.this, "Trip has been added", Toast.LENGTH_SHORT).show();
    }

     */

        /*
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
        */


