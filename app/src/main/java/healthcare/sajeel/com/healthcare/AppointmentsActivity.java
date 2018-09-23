package healthcare.sajeel.com.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import healthcare.sajeel.com.healthcare.Fragments.AppointmentsFragment;
import healthcare.sajeel.com.healthcare.adapter.AppointmentsAdapter;
import healthcare.sajeel.com.healthcare.model.Appointments;

public class AppointmentsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        GridView gridView = findViewById(R.id.gridView);
        final AppointmentsAdapter appointmentsAdapter = new AppointmentsAdapter(this, appointments);
        gridView.setAdapter(appointmentsAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(AppointmentsActivity.this, DashboardActivity.class));
        } else if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(AppointmentsActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(AppointmentsActivity.this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Appointments[] appointments = {
            new Appointments("1", "Dr. Tariq Zahid", "Gulshan-e-Iqbal Block 13 D Karachi, Pakistan",
                    "13:00 - 13:30", R.drawable.club_04, R.drawable.club_logo_01),
            new Appointments("1", "Dr. Faisal Shahzad", "Gulshan-e-Iqbal Block 13 D Karachi, Pakistan",
                    "09:00 - 10:30", R.drawable.club_04, R.drawable.club_logo_01),
            new Appointments("1", "Dr. Ismail Khan", "Gulshan-e-Iqbal Block 13 D Karachi, Pakistan",
                    "17:00 - 18:00", R.drawable.club_04, R.drawable.club_logo_01),
            new Appointments("1", "Dr. Farzana Shahrukh", "Gulshan-e-Iqbal Block 13 D Karachi, Pakistan",
                    "12:00 - 13:30", R.drawable.club_04, R.drawable.club_logo_01),
            new Appointments("1", "Dr. Kamal Hasan", "Gulshan-e-Iqbal Block 13 D Karachi, Pakistan",
                    "10:00 - 10:30", R.drawable.club_04, R.drawable.club_logo_01),
    };
}