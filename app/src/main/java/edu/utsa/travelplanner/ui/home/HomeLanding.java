package edu.utsa.travelplanner.ui.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import edu.utsa.travelplanner.TripData;
import edu.utsa.travelplanner.R;
import edu.utsa.travelplanner.databinding.ActivityMainBinding;


public class HomeLanding extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);


        

//        Editing fab function for adding trips--------------------------------------------
        FloatingActionButton fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Selected add trip", Snackbar.LENGTH_LONG)
                        .setAction("Trip", null).show();
            }
        });



/*        Working on travel details database------------------------------------------------------




        EditText ans_dest, ans_hotel, ans_cc, ans_start, ans_end, ans_transp;
        Button done_itin;
        //update_itin, delete_itin, view_itin;
        TripData DB;

        ans_dest = findViewById(R.id.ans_dest);
        ans_hotel = findViewById(R.id.ans_hotel);
        ans_cc = findViewById(R.id.ans_cc);
        ans_start = findViewById(R.id.ans_start);
        ans_end = findViewById(R.id.ans_end);
        ans_transp = findViewById(R.id.ans_transp);

        //Adds information to create new trip
        done_itin = findViewById(R.id.done_itin);

        DB = new TripData(this);

        done_itin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String ans_destTXT = ans_dest.getText().toString();
               String ans_hotelTXT = ans_hotel.getText().toString();
               String ans_ccTXT = ans_cc.getText().toString();
               String ans_startTXT = ans_start.getText().toString();
               String ans_endTXT = ans_end.getText().toString();
               String ans_transpTXT = ans_transp.getText().toString();

               if(checkinsertdata==true)
                   Toast.makeText(HomeLanding.this,"New trip added", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText(HomeLanding.this,"New trip was not added", Toast.LENGTH_SHORT).show();
            }
        });

        // Update information, add this function to trip details screen


        update_itin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans_destTXT = ans_dest.getText().toString();
                String ans_hotelTXT = ans_hotel.getText().toString();
                String ans_ccTXT = ans_cc.getText().toString();
                String ans_startTXT = ans_start.getText().toString();
                String ans_endTXT = ans_end.getText().toString();
                String ans_transpTXT = ans_transp.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(ans_destTXT, ans_hotelTXT, ans_ccTXT, ans_startTXT, ans_endTXT, ans_transpTXT);

                if(checkupdatedata==true)
                    Toast.makeText(HomeLanding.this,"Trip information updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeLanding.this,"Trip information was not updated", Toast.LENGTH_SHORT).show();
            }
        });


        // Move this to add trips file, add a button to delete from that screen

        delete_itin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans_destTXT = ans_dest.getText().toString();

                Boolean checkdeletedata = DB.deletedata(ans_destTXT);

                if(checkdeletedata==true)
                    Toast.makeText(HomeLanding.this,"Trip deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(HomeLanding.this,"Trip was not deleted", Toast.LENGTH_SHORT).show();
            }
        });
        //


        // Move this file to view trips class

        view_itin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Cursor res = DB.getdata();
                if(res.getCount()==0) {
                    Toast.makeText(HomeLanding.this,"No entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Destination :" + res.getString(0)+"\n");
                    buffer.append("Hotel address :" + res.getString(1)+"\n\n");
                    buffer.append("City/Country :" + res.getString(2)+"\n\n\n");
                    buffer.append("Start date :" + res.getString(3)+"\n\n\n\n");
                    buffer.append("End date :" + res.getString(4)+"\n\n\n\n\n");
                    buffer.append("Mode of transportation :" + res.getString(5)+"\n\n\n\n\n\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeLanding.this);
                builder.setCancelable(true);
                builder.setTitle("Trips details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        */

//        -------------------------------------------------------------------------------------



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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
